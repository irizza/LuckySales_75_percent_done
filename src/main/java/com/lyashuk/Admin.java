package com.lyashuk;

import com.lyashuk.dao.api.ProductDao;
import com.lyashuk.dao.impl.ProductDaoImpl;
import com.lyashuk.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by User on 27.07.2016.
 */
public class Admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao productDao = ProductDaoImpl.getInstance();
        List<Product> products = productDao.findAll();
        request.setAttribute("products", products);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/AdminPage.jsp");
        rd.forward(request, response);


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Product product = new Product();
        product.setId(0l);
        product.setName(request.getParameter("name"));
        product.setPrice(Double.parseDouble(request.getParameter("price")));
        product.setCount(Integer.parseInt(request.getParameter("count")));
        product.setDescription(request.getParameter("description"));
        ProductDao productDao = ProductDaoImpl.getInstance();
        productDao.create(product);



        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/AdminPage.jsp");
        rd.forward(request, response);

    }
}
