package com.shopping.service;

import com.shopping.dao.UserDetailDao;
import com.shopping.entity.UserDetail;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by 14437 on 2017/3/1.
 */
@Service
public class UserDetailServiceImplement implements UserDetailService {
    @Autowired
    private UserDetailDao userDetailDao;

    public void setUserDetailDao(UserDetailDao userDetailDao){
        this.userDetailDao = userDetailDao;
    }

    @Override
    public UserDetail getUserDetail(int id) {
        return userDetailDao.getUserDetail(id);
    }

    @Override
    public boolean addUserDetail(UserDetail userDetail) {
        return userDetailDao.addUserDetail(userDetail);
    }

    @Override
    public boolean deleteUserDetail(int id) {
        return userDetailDao.deleteUserDetail(id);
    }

    @Override
    public boolean updateUserDetail(UserDetail userDetail) {
        return userDetailDao.updateUserDetail(userDetail);
    }

    @Override
    public List<UserDetail> getAllUserDetail() {
        return userDetailDao.getAllUserDetail();
    }
}
