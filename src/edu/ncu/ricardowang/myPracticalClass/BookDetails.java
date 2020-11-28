package edu.ncu.ricardowang.myPracticalClass;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDetails {
    public String ID;
    public String NAME;
    public String TITLE;
    public float PRICE;
    public String YR;
    public String DESCRIPTION;
    public int SALES;

    public BookDetails() {

    }
    public void set(ResultSet rs){
        try{
            ID=rs.getString("ID");
            NAME=rs.getString("NAME");
            TITLE=rs.getString("TITLE");
            YR=rs.getString("YR");
            DESCRIPTION=rs.getString("DESCRIPTION");
            SALES=rs.getInt("SALES");
            PRICE=rs.getFloat("PRICE");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
//    public void println(PrintWriter out){
//        out.println("书名："+TITLE);
//        out.println("作者："+NAME+"  ("+YR+") ");
//        out.println("价格(元)："+PRICE);
//        out.println("销售数量(本)："+SALES);
//        out.println("评论："+DESCRIPTION);
//    }
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("书名："+TITLE);
        sb.append("<br>");
        sb.append("作者："+NAME+"  ("+YR+") ");
        sb.append("<br>");
        sb.append("价格(元)："+PRICE);
        sb.append("<br>");
        sb.append("销售数量(本)："+SALES);
        sb.append("<br>");
        sb.append("评论："+DESCRIPTION);
        sb.append("<br>");

        return sb.toString();
    }


    public boolean equals(BookDetails obj) {
        return ID.equals(obj.ID);
    }
    public boolean equals(String ID) {
        return this.ID.equals(ID);
    }
}
