package com.lyashuk;

import com.lyashuk.dao.api.ProductDao;
import com.lyashuk.dao.api.UserDao;
import com.lyashuk.dao.impl.ProductDaoImpl;
import com.lyashuk.dao.impl.UserDaoImpl;
import com.lyashuk.entity.Product;


public class Main {
    public static void main(String[] args) {
       /* UserService userService = UserServiceImpl.getInstance();
        List<UserDto> allUsers = userService.getAllUsers();
        System.out.println(allUsers);*/

     /*   User user = new User();
        user.setId(0l);
        user.setFirstName("rr");
        user.setAge(11);
        user.setLogin("dwada");
        user.setPassword("wadaw");
        UserDao userDao = UserDaoImpl.getInstance();
        userDao.create(user);
        System.out.println(user);
        Product product = new Product();
        product.setId(0l);
        product.setName("dwada");
        product.setDescription("dhrh");
        product.setCount(111);
        product.setPrice(1337);
        ProductDao productDao = ProductDaoImpl.getInstance();
        productDao.create(product);
        System.out.println(product);*/

     /*todo*/

   /*  User user = new User();
     user.setId(1l);*/
     UserDao userDao = UserDaoImpl.getInstance();
     userDao.delete(6l);

     System.out.println(userDao.findAll());
     System.out.println(userDao.findById(2l));
        System.out.println(userDao.findByLoginANDPassword("dasdacsz","czsczcz"));
     ProductDao productDao = ProductDaoImpl.getInstance();
     productDao.delete(1l);
     System.out.println(productDao.findAll());
        System.out.println(productDao.findById(2l));
        System.out.println(userDao.findUserByLogin("razdpl"));
        System.out.println(userDao.findUserByLogin("43242352"));
        Product product = new Product();
        product.setId(0l);
        product.setName("razzaraz");
        product.setDescription("dwada");
        product.setPrice(14.88);
        product.setCount(23);
        productDao.create(product);
        System.out.println(productDao.findAll());
    }
}
