package com.lyashuk.dao.impl;

import com.lyashuk.dao.api.UserDao;
import com.lyashuk.db_util.DataSource;
import com.lyashuk.entity.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kovantonlenko on 7/14/2016.
 */
public class UserDaoImpl implements UserDao {

    private static UserDao userDao;
    private static final String SELECT_ALL_USERS = "select * from user";
    private static final String FIND_BY_ID = "select * from user where idUser = ?";
    private static final String DELETE_USER_BY_ID = "delete  from user where idUser = ?";
    private static final String CREATE_USER = "insert into user (idUser, firstNameUser, ageUser, loginUser, passwordUser) VALUES (?,?,?,?,?)";
    private static final String FIND_BY_LOGIN_AND_PASSWORD = "select * from user where loginUser= ? and passwordUser = ?";
    private static final String FIND_BY_LOGIN = "select * from user where loginUser= ?" ;


    PreparedStatement preparedStatement = null;


    private DataSource dataSource;

    private UserDaoImpl() {
        dataSource = DataSource.getInstance();
    }

    public static UserDao getInstance() {
        if (userDao == null) {
            synchronized (UserDaoImpl.class) {
                if (userDao == null) {
                    userDao = new UserDaoImpl();
                }
            }
        }
        return userDao;
    }

    @Override
    public List<User> findAll() {
        Connection connection = dataSource.getConnection();
        List<User> users = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("idUser"));
                user.setFirstName(resultSet.getString("firstNameUser"));
                user.setAge(resultSet.getInt("ageUser"));
                user.setLogin(resultSet.getString("loginUser"));
                users.add(user);
            }
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    @Override
    public User findById(long id) {

        Connection connection = dataSource.getConnection();
        User user = new User();
        user.setId(id);


        try {
            PreparedStatement ps = connection.prepareStatement(FIND_BY_ID);
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {

                user.setId(resultSet.getLong("idUser"));
                user.setFirstName(resultSet.getString("firstNameUser"));
                user.setAge(resultSet.getInt("ageUser"));
                user.setLogin(resultSet.getString("loginUser"));

            }
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return  user;
    }

    @Override
    public void delete(long id) {
        Connection connection = dataSource.getConnection();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public boolean create(User user) {
        Connection connection = dataSource.getConnection();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER);
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2,user.getFirstName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.executeUpdate();

// execute insert SQL stetement



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public User findByLoginANDPassword(String login, String password) {
        Connection connection = dataSource.getConnection();
        User user = new User();
        /*user.setLogin(login);
        user.setPassword(password);*/

        try {
            PreparedStatement ps = connection.prepareStatement(FIND_BY_LOGIN_AND_PASSWORD);
            ps.setString(1, login);
            ps.setString(2, password);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {

                user.setId(resultSet.getLong("idUser"));
                user.setFirstName(resultSet.getString("firstNameUser"));
                user.setAge(resultSet.getInt("ageUser"));
                user.setLogin(resultSet.getString("loginUser"));

            }
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return  user;
    }

    @Override
    public User findUserByLogin(String login) {

        Connection connection = dataSource.getConnection();
        User user = new User();
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_BY_LOGIN);
            ps.setString(1,login);


            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {

                user.setId(resultSet.getLong("idUser"));
                user.setFirstName(resultSet.getString("firstNameUser"));
                user.setAge(resultSet.getInt("ageUser"));
                user.setLogin(resultSet.getString("loginUser"));

            }
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
