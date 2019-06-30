package com.shopping.service;

import com.shopping.dao.UserDaoImplement;
import com.shopping.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
@Transactional
public class UserServiceImplementTest {

    private User u = new User();
    private String nameOrEmail;
    @Autowired
    private UserServiceImplement userServiceImplement;

    @Before
    public  void init(){
        u.setRole(2);u.setNickName("fler");u.setEmail("16@q.com");u.setName("tiai");u.setId(23);
    }

    @Test
    public void getUser() {

    }

    @Test
    public void getUser1() {

    }

    @Test
    public void addUser() {

    }

    @Test
    public void deleteUser() {

    }

    @Test
    public void updateUser() {

    }

    @Test
    public void getAllUser() {

    }
}