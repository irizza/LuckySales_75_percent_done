package com.lyashuk;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by User on 27.07.2016.
 */
public class BuyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(req.getParameter("ADD") != null /*&& session.getId() != null*/){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/HomePage.jsp");
            rd.forward(req,res);

        }else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Authorization.jsp");
            rd.forward(req,res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.getAttribute("name");
        /*todo*/
        if(/*req.getParameter("add") != null && */!session.isNew()){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/HomePage.jsp");
            rd.forward(req,res);

        }else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Authorization.jsp");
            rd.forward(req,res);

        }

    }
}
