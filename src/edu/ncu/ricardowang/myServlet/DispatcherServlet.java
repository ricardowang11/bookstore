package edu.ncu.ricardowang.myServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: wangqin
 * @Date: 2020/12/8 0008 - 12 -08 -19:31
 * @Description: edu.ncu.ricardowang.myServlet
 * @version: 1.0
 */
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri=req.getServletPath();
        int x=uri.indexOf("?");
        if (x==-1){
            req.setAttribute("selectedScreen",uri.substring(1));
        }else {
            String s=uri.substring(1,x);
            req.setAttribute("selectedScreen",s);
        }

        req.getRequestDispatcher("/template.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
