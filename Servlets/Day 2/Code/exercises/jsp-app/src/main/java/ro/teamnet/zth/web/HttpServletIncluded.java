package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nicolescu on 13.07.2016.
 */
public class HttpServletIncluded extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String val= (String) req.getAttribute("val");

        String deTrimis=val+" procesata";
        req.setAttribute("val1",deTrimis);


    }
}
