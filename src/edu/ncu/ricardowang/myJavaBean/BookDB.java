package edu.ncu.ricardowang.myJavaBean;

import edu.ncu.ricardowang.myPracticalClass.BookDetails;

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
            con = DriverManager.getConnection(url, databaseUser, databasePassword);
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
        }finally {
            try {
                con.close();
                stat.close();
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
            con = DriverManager.getConnection(url, databaseUser, databasePassword);
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
        }finally {
            try {
                con.close();
                stat.close();
//                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return null;
    }



}
