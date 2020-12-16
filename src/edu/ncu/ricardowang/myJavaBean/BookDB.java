package edu.ncu.ricardowang.myJavaBean;

import edu.ncu.ricardowang.myPracticalClass.BookDetails;
import edu.ncu.ricardowang.myPracticalClass.ShoppingCartItem;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;

public class BookDB {
//    private String databaseUser = "root";
//    private String databasePassword = "123456789";
//    //jdbc驱动
//    private String driver = "com.mysql.cj.jdbc.Driver";
//    private String url = "jdbc:mysql://47.116.142.55:3306/BookDB?&useSSL=false&serverTimezone=UTC";
    private PreparedStatement stat;
    private DataSource ds;
    public BookDB() {
        //注册JDBC驱动程序
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/BookDB");
//            Class.forName(driver);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    private Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public LinkedHashSet<BookDetails> getBooks() {
        LinkedHashSet<BookDetails> books = new LinkedHashSet<>();
        Connection con=null;
        PreparedStatement stat=null;
        ResultSet rs=null;
        try {

            //建立连接

             con = getConnection();
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            String sql = "select * from BOOKS";
             stat = con.prepareStatement(sql);

             rs = stat.executeQuery();
            while (rs.next()) {
                BookDetails bookDetails = new BookDetails();
                bookDetails.set(rs);
                books.add(bookDetails);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        } finally {
            closeConnection(con);
            closePrepStmt(stat);
            closeResultSet(rs);
        }
        return books;
    }
    public BookDetails getBookDetails(String bookID) {
        BookDetails book = new BookDetails();
        Connection con=null;
        PreparedStatement stat=null;
        ResultSet rs=null;
        try {
            //建立连接

             con = getConnection();
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            String sql = "select * from BOOKS where ID=?";
             stat = con.prepareStatement(sql);
            stat.setString(1, bookID);
             rs = stat.executeQuery();
            if (rs.next()) {
                book.set(rs);
                return book;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        } finally {
            closeConnection(con);
            closePrepStmt(stat);
            closeResultSet(rs);

        }
        return null;
    }
    public boolean buyBooks(ShoppingCart shoppingCart) {
        Connection con=null;
        try {

            con = getConnection();
            con.setAutoCommit(false);
            for (ShoppingCartItem item : shoppingCart) {
                if (!buyBook(item, con)) {
                    con.rollback();
                    return false;
                }
            }
            con.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            closeConnection(con);
        }


        return true;

    }
    public boolean buyBook(ShoppingCartItem item, Connection con) throws SQLException {
        String selectStatment = "select * from BOOKS where ID=?";
        PreparedStatement preparedStatement = con.prepareStatement(selectStatment);
        preparedStatement.setString(1, item.ID);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            preparedStatement.close();
            String updateStatment = "update BOOKS set SALES=SALES +? where ID=?";
            preparedStatement = con.prepareStatement(updateStatment);
            preparedStatement.setInt(1, item.ammount);
            preparedStatement.setString(2, item.ID);
            if (preparedStatement.executeUpdate() == 0) {
                return false;
            }
        }
        preparedStatement.close();
        return true;
    }
    public void closeConnection(Connection con){
        try{
            if(con!=null) con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void closePrepStmt(PreparedStatement prepStmt){
        try{
            if(prepStmt!=null) prepStmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void closeResultSet(ResultSet rs){
        try{
            if(rs!=null) rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
