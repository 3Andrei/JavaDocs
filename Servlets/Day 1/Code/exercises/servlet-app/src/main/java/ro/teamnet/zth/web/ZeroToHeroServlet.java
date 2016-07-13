package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Nicolescu on 12.07.2016.
 */
public class ZeroToHeroServlet extends HttpServlet {

    public String handleRequest(HttpServletRequest req){
        String firstName=req.getParameter("firstName");
        String lastName=req.getParameter("lastName");
        String response="Hello <b>["+firstName+"] ["+lastName+"]</b>! Enjoy Zero To Hero!!!";
        return  response;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter=resp.getWriter();
        printWriter.write(handleRequest(req));
    }
}
