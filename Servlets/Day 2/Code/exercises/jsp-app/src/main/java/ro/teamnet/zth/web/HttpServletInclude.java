package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Nicolescu on 13.07.2016.
 */
public class HttpServletInclude extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String val="valoare";
        req.setAttribute("val",val);

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/included");
        requestDispatcher.include(req,resp);

        PrintWriter printWriter=resp.getWriter();
        printWriter.write((String) req.getAttribute("val1")+" ....");

    }
}
