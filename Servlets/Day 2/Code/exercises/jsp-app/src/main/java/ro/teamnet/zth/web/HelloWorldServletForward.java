package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nicolescu on 13.07.2016.
 */
public class HelloWorldServletForward extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String testAttribute= (String) req.getAttribute("testAttribute");
        resp.getWriter().write("<h3>Hello <b>"+req.getParameter("user")+"</b> from the Forward Servlet"+testAttribute+"</h3>");
    }
}
