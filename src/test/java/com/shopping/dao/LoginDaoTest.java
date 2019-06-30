package com.shopping.dao;

import org.junit.Test;
import com.shopping.entity.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
@Transactional
public class LoginDaoTest {
    @Autowired
    private UserDao daotest;

    @Test
    public void getUser() {
        User result=daotest.getUser("111");
        try {
            System.out.println(result.getName());
            System.out.println(result.getEmail());
            System.out.println(result.getNickName());
            if(result.getRole()==0)
                System.out.println("man");
            else
                System.out.println("woman");
        }catch (Exception e){
            System.out.println("Account is unexist!");
        }

    }
}