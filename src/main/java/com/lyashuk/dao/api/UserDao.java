package com.lyashuk.dao.api;

import com.lyashuk.entity.User;

import java.util.List;

/**
 * Created by Kovantonlenko on 7/14/2016.
 */
public interface UserDao {
    List<User> findAll();

    User findById(long id);

    void delete(long id);

    boolean create(User user);

    User findByLoginANDPassword(String login, String password);

    User findUserByLogin(String login);
}
