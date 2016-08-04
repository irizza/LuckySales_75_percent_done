package com.lyashuk;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 19.07.2016.
 */
/*@WebServlet("/registration")*/
public class Registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Registration.jsp");
        rd.forward( request, response);*/
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Registration.jsp");
        rd.forward( request, response);

    }
}