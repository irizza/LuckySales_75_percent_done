package com.lyashuk;

import javax.mail.Session;
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
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if(req.getParameter("logout") != null){
            HttpSession session = req.getSession();
            session.invalidate();
        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher("");
        rd.forward(req, res);
    }
}
