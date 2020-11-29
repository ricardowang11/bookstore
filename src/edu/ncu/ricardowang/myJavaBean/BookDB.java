package edu.ncu.ricardowang.myJavaBean;

import edu.ncu.ricardowang.myPracticalClass.BookDetails;
import edu.ncu.ricardowang.myPracticalClass.ShoppingCartItem;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class BookDB {
    private String databaseUser = "root";
    private String databasePassword = "123456789";
    //jdbc驱动
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url="jdbc:mysql://47.116.142.55:3306/BookDB?&useSSL=false&serverTimezone=UTC";
    private Connection con;
    private PreparedStatement stat;
    private ResultSet rs;

    public BookDB() {
        //注册JDBC驱动程序
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public  LinkedHashSet<BookDetails> getBooks(){
        LinkedHashSet<BookDetails> books=new LinkedHashSet<>();
        try {

            //建立连接
            Context ctx=new InitialContext();
            DataSource ds= (DataSource) ctx.lookup("java:comp/env/jdbc/BookDB");
            Connection con=ds.getConnection();
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            String sql="select * from BOOKS";
            stat=con.prepareStatement(sql);

            ResultSet rs= stat.executeQuery();
            while (rs.next()){
                BookDetails bookDetails=new BookDetails();
                bookDetails.set(rs);
                books.add(bookDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                closeConnection(con);
                closeStatement(stat);
               // rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return books;
    }
    public BookDetails getBookDetails(String bookID){
        BookDetails book=new BookDetails();
        try {
            //建立连接
            Context ctx=new InitialContext();
            DataSource ds= (DataSource) ctx.lookup("java:comp/env/jdbc/BookDB");
            Connection con=ds.getConnection();
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            String sql="select * from BOOKS where ID=?";
            stat=con.prepareStatement(sql);
            stat.setString(1,bookID);
            ResultSet rs= stat.executeQuery();
            if (rs.next()){
                book.set(rs);
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                closeConnection(con);
                closeStatement(stat);
//                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return null;
    }
    private void closeConnection(Connection con) throws SQLException {
        if (con!=null){
            con.close();
        }
    }
    private void closeStatement(PreparedStatement stat) throws SQLException {
        if (stat!=null){
            stat.close();
        }
    }
    private void closeResultSet(ResultSet rs) throws SQLException {
        if (rs!=null){
            rs.close();
        }
    }
    public boolean buyBooks(ShoppingCart shoppingCart){
        try{
            Context ctx=new InitialContext();
            DataSource ds= (DataSource) ctx.lookup("java:comp/env/jdbc/BookDB");
            Connection con=ds.getConnection();
            con.setAutoCommit(false);
            for (ShoppingCartItem item:shoppingCart){
                if (!buyBook(item,con)){
                    con.rollback();
                    return false;
                }
            }
            con.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                closeConnection(con);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return true;

    }
    public boolean buyBook(ShoppingCartItem item,Connection con) throws SQLException {
        String selectStatment="select * from BOOKS where ID=?";
        PreparedStatement preparedStatement=con.prepareStatement(selectStatment);
        preparedStatement.setString(1,item.ID);
        ResultSet rs= preparedStatement.executeQuery();
        if (rs.next()){
            preparedStatement.close();
            String updateStatment="update BOOKS set SALES=SALES +? where ID=?";
            preparedStatement=con.prepareStatement(updateStatment);
            preparedStatement.setInt(1,item.ammount);
            preparedStatement.setString(2,item.ID);
            if (preparedStatement.executeUpdate()==0){
                return false;
            }
        }
        preparedStatement.close();
        return true;
    }


}
