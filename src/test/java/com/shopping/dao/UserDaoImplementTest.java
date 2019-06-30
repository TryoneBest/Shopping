package com.shopping.dao;

import com.shopping.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.*;
import org.junit.runner.RunWith;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.log.LogInputStream;

import javax.crypto.SealedObject;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
@Transactional
public class UserDaoImplementTest {
    private User u = new User();
    private String nameOrEmail;
    @Autowired
    private UserDaoImplement userDao;

    @Before
    public  void init(){
        u.setRole(2);u.setNickName("fler");u.setEmail("16@q.com");u.setName("tiai");u.setId(23);

    }

    @Test
    public void getUser() {

        try{
            User user=userDao.getUser(u.getId());
            if(user!=null)
                System.out.println(1);
            else
                System.out.println(-1);
        }catch (Exception e){
            System.out.println(-2);
        }

    }

    @Test
    public void getUser1() {

        try {
            User  user = userDao.getUser(nameOrEmail);
            if(user!=null){
                System.out .println(1);
            }else
                System.out.println(-1);
        }catch (Exception E){
            System.out.println(-1);
        }
    }

    @Test
    public void addUser() {
        try {
            userDao.addUser(u);
            System.out.println(1);
        }catch (Exception E){
            System.out.println(-1);
        }

    }

    @Test
    public void deleteUser() {
        try {
            if(userDao.deleteUser(u.getId()))
                System.out.println(1);
            else
                System.out.println(-1);
        }catch (Exception e){
            System.out.println(-1);
        }


    }

    @Test
    public void updateUser() {
        try {
            if(userDao.updateUser(u))
                System.out.println(1);
            else
                System.out.println(-1);
        }catch (Exception e){
            System.out.println(-1);
        }


    }

    @Test
    public void getAllUser() {
        try {
            if(userDao.getAllUser()!=null)
                System.out.println(1);
            else
                System.out.println(-1);
        }catch (Exception e){
            System.out.println(-1);
        }


    }
}