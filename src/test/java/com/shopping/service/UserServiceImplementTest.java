package com.shopping.service;

<<<<<<< HEAD
import com.shopping.dao.UserDaoImplement;
=======
>>>>>>> b72418745802f68bbe1bb8fceabee37c186abac9
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

<<<<<<< HEAD
    private User u = new User();
    private String nameOrEmail;
    @Autowired
    private UserServiceImplement userServiceImplement;
=======

    private User u = new User();
    private String nameOrEmail;
    @Autowired
    private UserServiceImplement UserService;
>>>>>>> b72418745802f68bbe1bb8fceabee37c186abac9

    @Before
    public  void init(){
        u.setRole(2);u.setNickName("fler");u.setEmail("16@q.com");u.setName("tiai");u.setId(23);
<<<<<<< HEAD
=======

>>>>>>> b72418745802f68bbe1bb8fceabee37c186abac9
    }

    @Test
    public void getUser() {
<<<<<<< HEAD

=======
        try{
            User user=UserService.getUser(u.getId());
            if(user!=null)
                System.out.println(1);
            else
                System.out.println(-1);
        }catch (Exception e){
            System.out.println(-1);
        }
>>>>>>> b72418745802f68bbe1bb8fceabee37c186abac9
    }

    @Test
    public void getUser1() {
<<<<<<< HEAD
=======
        try {
            User  user = UserService.getUser(nameOrEmail);
            if(user!=null){
                System.out .println(1);
            }else
                System.out.println(-1);
        }catch (Exception E){
            System.out.println(-1);
        }
>>>>>>> b72418745802f68bbe1bb8fceabee37c186abac9

    }

    @Test
    public void addUser() {
<<<<<<< HEAD

=======
        try {
            UserService.addUser(u);
            System.out.println(1);
        }catch (Exception E){
            System.out.println(-1);
        }
>>>>>>> b72418745802f68bbe1bb8fceabee37c186abac9
    }

    @Test
    public void deleteUser() {
<<<<<<< HEAD

=======
        try {
            if(UserService.deleteUser(u.getId()).status==1)
                System.out.println(1);
            else
                System.out.println(-1);
        }catch (Exception e){
            System.out.println(-1);
        }
>>>>>>> b72418745802f68bbe1bb8fceabee37c186abac9
    }

    @Test
    public void updateUser() {
<<<<<<< HEAD
=======
        try {
            if(UserService.updateUser(u))
                System.out.println(1);
            else
                System.out.println(-1);
        }catch (Exception e){
            System.out.println(-1);
        }
>>>>>>> b72418745802f68bbe1bb8fceabee37c186abac9

    }

    @Test
    public void getAllUser() {
<<<<<<< HEAD

=======
        try {
            if(UserService.getAllUser()!=null)
                System.out.println(1);
            else
                System.out.println(-1);
        }catch (Exception e){
            System.out.println(-1);
        }
>>>>>>> b72418745802f68bbe1bb8fceabee37c186abac9
    }
}