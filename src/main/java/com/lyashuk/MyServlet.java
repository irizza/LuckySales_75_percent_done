package com.lyashuk;







import com.lyashuk.dao.api.UserDao;
import com.lyashuk.dao.impl.UserDaoImpl;
import com.lyashuk.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/*@WebServlet("/main")*/
public class MyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = new User();
        user.setId(0l);
        user.setFirstName(request.getParameter("firstName"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        UserDao userDao = UserDaoImpl.getInstance();


        if( user.getLogin().equals(userDao.findUserByLogin(request.getParameter("login")).getLogin())){

            request.setAttribute("invalidLorP","Invalid LOGIN or PASSWORD");
            request.setAttribute("invalidLorP"," login alrady exist");

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Registration.jsp");
            rd.forward( request, response);

        }else {
            userDao.create(user);
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/HomePage.jsp");
        rd.forward( request, response);

        super.doPost(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Authorization.jsp");
        rd.forward( request, response);

        out.println("Hello Word");
    }
}