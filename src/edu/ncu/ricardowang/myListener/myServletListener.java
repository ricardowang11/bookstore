package edu.ncu.ricardowang.myListener;

import edu.ncu.ricardowang.myJavaBean.BookDB;
import edu.ncu.ricardowang.myJavaBean.ShoppingCart;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class myServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        BookDB books=new BookDB();
        ShoppingCart shoppingCart=new ShoppingCart();
//        sce.getServletContext().setAttribute("BOOKS",books);
        sce.getServletContext().setAttribute("SHOPPINGCART",shoppingCart);


    }
}
