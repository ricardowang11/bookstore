package edu.ncu.ricardowang.myListener;

import edu.ncu.ricardowang.myJavaBean.BookDB;
import edu.ncu.ricardowang.myJavaBean.ShoppingCart;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class mySessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ShoppingCart shoppingCart=new ShoppingCart();
        se.getSession().setAttribute("SHOPPINGCART",shoppingCart);
        BookDB books=new BookDB();
        se.getSession().setAttribute("BOOKS",books);


    }
}
