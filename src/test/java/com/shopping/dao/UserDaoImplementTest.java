package com.shopping.dao;

import com.shopping.entity.User;
import org.junit.*;
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
public class UserDaoImplementTest {

    @Autowired
    private UserDaoImplement userDao;

    @Before
    public  void init(){

    }

    @Test
    public void BACK_001_GUD_001_01() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        int  id=-3;
        try {
            assertNull(userDao.getUser(id));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GUD_001_02(){
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        int id=44;
        try {
            assertNull(userDao.getUser(id));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GUD_001_03(){
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        int id=1;
        try {
            assertNull(userDao.getUser(id));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GUD_002_01(){
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        String nameOrEmail = "Tom";
        try {
            assertNull(userDao.getUser(nameOrEmail));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GUD_002_02(){
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        String nameOrEmail = "lalala";
        try {
            assertNull(userDao.getUser(nameOrEmail));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GUD_002_03(){
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        String nameOrEmail=null;
        try {
            assertNull(userDao.getUser(nameOrEmail));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_AUD_001_01(){
        UserDaoImplement userDaoImplement =   new UserDaoImplement();
        User user = new User();
        user.setId(2);user.setName("Anny");user.setEmail("166.163.com");user.setNickName("flow");user.setRole(4);
        userDaoImplement.addUser(user);
    }
    @Test
    public void BACK_001_AUD_001_02(){
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        User user = new User();
        user.setId(3);user.setName("lili");
        userDaoImplement.addUser(user);
    }
    @Test
    public void BACK_001_DUD_001_01(){
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        int  id=-3;
        try {
            assertFalse(userDao.deleteUser(id));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_DUD_001_02(){
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        int id=33;
        try {
            assertFalse(userDao.deleteUser(id));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_DUD_001_03(){
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        int id=23;
        try {
            assertFalse(userDao.deleteUser(id));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_UUD_001_01(){
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        User user = new User();
        user.setId(5);user.setName("xurenhe");user.setEmail("163.com");
        try {
            assertFalse(userDao.updateUser(user));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_UUD_001_02(){
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        User user = new User();
        user.setId(-3);user.setName("aiyu");user.setEmail("1.com");user.setNickName("bi");user.setRole(-4);
        try {
            assertFalse(userDao.updateUser(user));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_UUD_001_03(){
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        User user = new User();
        user.setId(1);user.setName("Tom");user.setEmail("3.com");user.setNickName("link");user.setRole(4);
        try {
            assertFalse(userDao.updateUser(user));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_UUD_001_04(){
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        User user = new User();
        user.setId(1);user.setName("xu");user.setEmail("4.com");user.setNickName("didi");user.setRole(4);
        try {
            assertFalse(userDao.updateUser(user));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GAUD_001_01(){
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        try{
            assertNull(userDao.getAllUser());
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GAUD_001_02(){
        UserDaoImplement userDaoImplement =new UserDaoImplement();
        try{
            assertNull(userDao.getAllUser());
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }














/*

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
    */
}