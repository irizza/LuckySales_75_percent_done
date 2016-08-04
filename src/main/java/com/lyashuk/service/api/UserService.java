package com.lyashuk.service.api;

import com.lyashuk.dto.UserDto;

import java.util.List;

/**
 * Created by Kovantonlenko on 6/16/2016.
 */
public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(long id);

    void createUser(UserDto userDto);

    boolean deleteUser(long id);

    UserDto getUserByLoginANDPassord(long id);

    UserDto getUserByLogin(String login);
}
