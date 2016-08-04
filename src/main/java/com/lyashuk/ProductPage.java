package com.lyashuk;

import com.lyashuk.dao.api.ProductDao;
import com.lyashuk.dao.api.UserDao;
import com.lyashuk.dao.impl.ProductDaoImpl;
import com.lyashuk.dto.UserDto;
import com.lyashuk.entity.Product;
import com.lyashuk.service.api.ProductService;
import com.lyashuk.service.api.UserService;
import com.lyashuk.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by User on 19.07.2016.
 */


/*@WebServlet("/products")*/
public class ProductPage extends HttpServlet {
    private ProductService productService;
    private UserService userService;
    private UserDao userDao;
    private UserDto userDto;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDao productDao = ProductDaoImpl.getInstance();
        ProductService productService1 = ProductServiceImpl.getInstance();
        Product product = new Product();
//        product.setName("raboaet");
//        product.setName(productDao.findById(2).getName());
        productDao.findAll();
        productService1.getAllProducts();

        List<Product> products = productDao.findAll();
        request.setAttribute("products", products);






//        User user = new User();
//        user.setFirstName(userDao.findById(2).getFirstName());
//


        request.setAttribute("product", product);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/ProductPage.jsp");
        rd.forward( request, response);


    }
}
