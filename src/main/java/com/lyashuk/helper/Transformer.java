package com.lyashuk.helper;

import com.lyashuk.dto.ProductDto;
import com.lyashuk.dto.UserDto;
import com.lyashuk.entity.Product;
import com.lyashuk.entity.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kovantonlenko on 7/14/2016.
 */
public class Transformer {

    public static UserDto transformUserToUserDTO(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setAge(user.getAge());
        return userDto;
    }



    public static List<UserDto> transformListUserToUserDTO(List<User> users) {
        List<UserDto> userDtos = new LinkedList<>();
        for (User user : users) {
            UserDto userDto = transformUserToUserDTO(user);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    public static User transformUserDTOToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setAge(userDto.getAge());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public static Product transformProductDTOToProduct(ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCount(productDto.getCount());
        product.setPrice(productDto.getPrice());
        return product;


    }


    public static List<ProductDto> transformLisProductsToProductDto(List<Product> products) {
        List<ProductDto> productDtos = new LinkedList<>();
        for (Product product : products) {
            ProductDto productDto = transformProductToProductDto(product);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    public static ProductDto transformProductToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setCount(product.getCount());
        productDto.setPrice(product.getPrice());
        return productDto;
    }
}
