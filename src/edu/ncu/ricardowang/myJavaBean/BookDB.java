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
    private Statement stat;
    private LinkedHashSet<BookDetails> books=new LinkedHashSet<>();

    public BookDetails findBook(String bookID){

        Iterator<BookDetails> iterator=books.iterator();
        while (iterator.hasNext()){
            BookDetails book=iterator.next();
            if (book.equals(bookID)){
                return book;
            }
        }
        return null;
    }
    public void init(){
        try {
            //注册JDBC驱动程序
            Class.forName(driver);
            //建立连接
            con = DriverManager.getConnection(url, databaseUser, databasePassword);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            stat=con.createStatement();
            String sql="select * from BOOKS";
            ResultSet rs= stat.executeQuery(sql);
            while (rs.next()){
                BookDetails bookDetails=new BookDetails();
                bookDetails.set(rs);
                books.add(bookDetails);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }

    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("<a href=\"showcart.jsp\">查看购物车</a>&nbsp;&nbsp;&nbsp;<a href=\"cashier.jsp\">付账</a>");
        sb.append("<br>");
        sb.append("<p style=\"size: 20px\"><b>请选择想购买的书:</b></p>");

        sb.append("<table>");
        Iterator<BookDetails> iterator=books.iterator();
        while (iterator.hasNext()){
            BookDetails bookDetails=iterator.next();
            sb.append("<tr align=\"left\">");
            sb.append("<td><a href=\"bookdetails.jsp?bookID="+bookDetails.ID+"\">"+bookDetails.TITLE+"</a> </td>");
            sb.append("<td>"+bookDetails.NAME+"</td>");
            sb.append("<td><a href=\"add.jsp?bookID="+bookDetails.ID+"\">加入购物车</a></td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }
}
