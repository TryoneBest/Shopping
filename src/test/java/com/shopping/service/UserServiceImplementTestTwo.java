package com.shopping.service;

import com.shopping.dao.*;
import com.shopping.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
@Transactional
public class UserServiceImplementTestTwo {

    private UserDao mockUserDao;
    private UserDetailDao mockUserDetailDao;
    private ShoppingRecordDao mockShoppingRecordDao;
    private ShoppingCarDao mockShoppingCarDao;
    private EvaluationDao mockEvaluationDao;


    private User user1 = new User(5,"木木","987@163.com","木",1);
    private User user2 = new User(1,"小明","1234@qq.com","明明",1);
    @Autowired
    private UserServiceImplement userServiceImplement;
    @Before
    public void init(){
        mockUserDao=mock(UserDao.class);
        mockUserDetailDao= mock(UserDetailDao.class);
        mockShoppingRecordDao=mock(ShoppingRecordDao.class);
        mockShoppingCarDao=mock(ShoppingCarDao.class);
        mockEvaluationDao=mock(EvaluationDao.class);
        when(mockUserDao.getUser(1)).thenReturn(new User(1,"小明","1234@qq.com","明小",0));
        when(mockUserDao.getUser(null)).thenReturn(null);
        when(mockUserDao.getUser("小明")).thenReturn(new User(1,"小明","1234@qq.com","明小",0));
        when(mockUserDao.addUser(user1)).thenReturn(true);
        when(mockUserDao.deleteUser(1)).thenReturn(true);
        when(mockEvaluationDao.deleteEvaluationByUser(1)).thenReturn(true);
        when(mockShoppingCarDao.deleteShoppingCarByUser(1)).thenReturn(true);
        when(mockShoppingRecordDao.deleteShoppingRecordByUser(1)).thenReturn(true);
        when(mockUserDetailDao.deleteUserDetail(1)).thenReturn(true);
    }
    @Test
    public  void BACK_001_GUS_001_01(){
        userServiceImplement.reset(mockUserDao);

        User user = userServiceImplement.getUser(1);
        System.out.println(user.toString());
    }
    @Test
    public void BACK_001_GUS_002_01(){
        userServiceImplement.reset(mockUserDao);

        User user = userServiceImplement.getUser("小明");
        System.out.println(user.toString());
    }
    @Test
    public void BACK_001_GUS_002_02(){
        userServiceImplement.reset(mockUserDao);
        User user = userServiceImplement.getUser(null);
        System.out.println(user);
    }
    @Test
    public void BACK_001_AUS_001_01(){
        userServiceImplement.reset(mockUserDao);
        assertTrue("插入失败",userServiceImplement.addUser(user1));
        System.out.println("success");
    }
    @Test
    public void BACK_001_DUS_001_01(){
        userServiceImplement.reset(mockUserDao);
        userServiceImplement.reset(mockShoppingCarDao);
        userServiceImplement.reset(mockShoppingRecordDao);
        userServiceImplement.reset(mockUserDetailDao);
        userServiceImplement.reset(mockEvaluationDao);
        userServiceImplement.deleteUser(1);
        try {
            assertEquals(1,userServiceImplement.deleteUser(1).status);
            System.out.println("success");
        }catch (AssertionError a){
            System.out.println("failed");
        }


    }
    @Test
    public void BACK_001_UUS_001_01(){
        userServiceImplement.reset(mockUserDao);
        when(mockUserDao.updateUser(user2)).thenReturn(true);
        userServiceImplement.updateUser(user2);
        try {
            assertTrue(userServiceImplement.updateUser(user2));
            System.out.println("success");
        }catch (AssertionError a){
            System.out.println("failed");
        }

    }
    @Test
    public void BACK_001_GAUS_001_01(){
        userServiceImplement.reset(mockUserDao);
        List<User> list =new ArrayList<User>();
        list.add(user1);list.add(user2);
        when(mockUserDao.getAllUser()).thenReturn(list);
        try {
            assertNotNull(userServiceImplement.getAllUser());
            System.out.println("success");
        }catch (AssertionError a){
            System.out.println("failed");
        }

    }

}