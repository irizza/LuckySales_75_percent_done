package com.lyashuk;

import com.lyashuk.dao.api.UserDao;
import com.lyashuk.dao.impl.UserDaoImpl;
import com.lyashuk.entity.Product;
import com.lyashuk.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
/*import javax.servlet.annotation.WebServlet;*/
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by User on 19.07.2016.
 */
/*@WebServlet("/home")*/
public class HomePage extends HttpServlet {

    User user = new User();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*User user = new User();
        user.setId(0l);
        user.setFirstName(request.getParameter("name"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        UserDao userDao = UserDaoImpl.getInstance();
        userDao.create(user);*/
        /**/

        request.setAttribute("hello", "Hello, " + request.getParameter("login")) ;
        HttpSession session = request.getSession();
        request.setAttribute("sessionid",session.getId());

        UserDao userDao = UserDaoImpl.getInstance();


        String username = request.getParameter("login");
        String password = request.getParameter("password");


       /* userDao.findByLoginANDPassword(username,password);
        user.getLogin();
        user.getPassword();
           HttpSession session = request.getSession();
           session.setAttribute("user", user);
           request.getRequestDispatcher("/WEB-INF/HomePage.jsp").forward(request, response);
           userDao.findByLoginANDPassword(username, password);*/


        if(userDao.findByLoginANDPassword(username,password).getId() != null)
         {
            /*HttpSession session = request.getSession();*/
            session.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/HomePage.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("/WEB-INF/Authorization.jsp").forward(request, response);
        }


        super.doPost(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        HttpSession session = request.getSession(false);

        String oldSessionValue = null;
        String newSessionValue = null;

        if (session != null) {
            newSessionValue = (String) session.getAttribute("newSession");
            oldSessionValue = (String) session.getAttribute("oldSession");
        }




        /**/
        response.setContentType("text/html");

        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        request.getSession().setAttribute("user", user);
//
        List<Product> products;
        Product product = new Product();
       /*if(request.getParameter("addBtn")== true)){
           product.setId(request.getParameter("id")):
       }
*/
           RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/HomePage.jsp");
        rd.forward( request, response);

    }
}
