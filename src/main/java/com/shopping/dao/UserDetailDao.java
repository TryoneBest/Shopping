package com.shopping.dao;

import com.shopping.entity.UserDetail;

import java.util.List;

/**
 * Created by 14437 on 2017/3/1.
 */
public interface UserDetailDao {

    UserDetail getUserDetail(int id);

    boolean addUserDetail(UserDetail userDetail);

    boolean deleteUserDetail(int id);

    boolean updateUserDetail(UserDetail userDetail);

    List<UserDetail> getAllUserDetail();
}
