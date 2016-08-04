package com.lyashuk.service.impl;

import com.lyashuk.helper.Transformer;
import com.lyashuk.dao.api.UserDao;
import com.lyashuk.dao.impl.UserDaoImpl;
import com.lyashuk.dto.UserDto;
import com.lyashuk.entity.User;
import com.lyashuk.service.api.UserService;

import java.util.List;

/**
 * Created by Kovantonlenko on 6/16/2016.
 */
public class UserServiceImpl implements UserService {

    private static UserService userService;
    private UserDao userDao;

    private UserServiceImpl() {
        userDao = UserDaoImpl.getInstance();
    }

    public static UserService getInstance() {
        if (userService == null) {
            synchronized (UserServiceImpl.class) {
                if (userService == null) {
                    userService = new UserServiceImpl();
                }
            }
        }
        return userService;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userDao.findAll();
        List<UserDto> userDtos = Transformer.transformListUserToUserDTO(users);
        return userDtos;
    }

    @Override
    public UserDto getUserById(long id) {
        //todo add implementation
        UserDto userDto = new UserDto();
       User user = Transformer.transformUserDTOToUser( userDto);
        userDao.findById(id);
        return userDto;
    }

    @Override
    public void createUser(UserDto userDto) {
        User user = Transformer.transformUserDTOToUser(userDto);
        userDao.create(user);
    }

    @Override
    public boolean deleteUser(long id) {
        //todo add implementation
        UserDto userDto = new UserDto();
        User user = Transformer.transformUserDTOToUser(userDto);
        userDao.delete(id);
        /*userDto.*/
        return true;
    }

    @Override
    public UserDto getUserByLoginANDPassord(long id) {

        UserDto userDto = new UserDto();
        User user = Transformer.transformUserDTOToUser( userDto);
        userDao.findById(id);
        return userDto;
    }

    @Override
    public UserDto getUserByLogin(String login) {
        UserDto userDto = new UserDto();
        User user = Transformer.transformUserDTOToUser( userDto);
        userDao.findUserByLogin(login);

        return userDto;
    }
}
