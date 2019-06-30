package com.shopping.service;

import com.shopping.dao.UserDetailDao;
import com.shopping.entity.UserDetail;

import java.util.List;

/**
 * Created by 14437 on 2017/3/1.
 */
public interface UserDetailService {
    public  void setUserDetailDao(UserDetailDao userDetailDao);

    public UserDetail getUserDetail(int id);

    public boolean addUserDetail(UserDetail userDetail);

    public boolean deleteUserDetail(int id);

    public boolean updateUserDetail(UserDetail userDetail);

    public List<UserDetail> getAllUserDetail();
}
