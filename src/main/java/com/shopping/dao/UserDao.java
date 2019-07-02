package com.shopping.dao;

import com.shopping.entity.User;

import java.util.List;

/**
 * Created by 14437 on 2017/3/1.
 */
public interface UserDao {

    User getUser(int id);

    User getUser(String nameOrEmail);

    boolean addUser(User user);

    boolean deleteUser(int id);

    boolean updateUser(User user);

    List<User> getAllUser();
}
