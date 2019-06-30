package com.shopping.service;

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
public class RegisterServiceTest {
    @Autowired
    private UserService testservice;
    @Test
    public void addUser() {
        User usertest=new User();
        usertest.setName("1414");
        usertest.setEmail("101010@qq.com");
        usertest.setNickName("DaoTest");
        usertest.setRole(0);
        testservice.addUser(usertest);

        User result=testservice.getUser("1414");
        System.out.println(result.getName());
        System.out.println(result.getEmail());
        System.out.println(result.getNickName());
        if(result.getRole()==0)
            System.out.println("man");
        else
            System.out.println("woman");
    }
}