package com.shopping.controller;

import com.shopping.entity.User;
import com.shopping.entity.UserDetail;
import com.shopping.service.UserDetailService;
import com.shopping.service.UserService;
import com.shopping.utils.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
@Transactional
public class UserControllerTest {
    private UserService mockUserService;
    private UserDetailService mockuserDetailService;
    private User user1 = new User();
    private UserDetail userDetail = new UserDetail();
    @Autowired
    UserController userController;

    @Before
    public void init(){
        mockUserService = mock(UserService.class);
        mockuserDetailService = mock(UserDetailService.class);
    }


    @Test
    public void BACK_001_DRC_001_01() {
        userController.reset(mockUserService);
        userController.reset(mockuserDetailService);
        user1.setId(5);user1.setName("mumu");user1.setNickName("M");user1.setEmail("987@163.com");
        userDetail.setId(5);userDetail.setAddress("湖北省荆门市京山区");userDetail.setBirthday("1999.5.8");userDetail.setPassword("a123456");userDetail.setPhoneNumber("18716549852");userDetail.setPostNumber("654236");userDetail.setSex(1);userDetail.setRegisterTime("2019.6.30 20:30:36");
        when(mockUserService.getUser("987@163.com")).thenReturn(null);
        when(mockUserService.getUser("mumu")).thenReturn(null);
        when(mockUserService.addUser(user1)).thenReturn(true);
        when(mockuserDetailService.addUserDetail(userDetail)).thenReturn(true);  //修改
        try{
            assertEquals("success",userController.doRegister("mumu","987@163.com","M","a123456","18716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result").toString());
            System.out.println("success");
        }catch (AssertionError A){
            System.out.println("failed");
        }
    }
    @Test
    public void BACK_001_DRC_001_02(){
        userController.reset(mockUserService);
        userController.reset(mockuserDetailService);
        user1.setId(5);user1.setName("nunu");user1.setEmail("987@163.com");user1.setNickName("M");
        userDetail.setId(5);userDetail.setPassword("a123456");userDetail.setPhoneNumber("18716549852");userDetail.setSex(1);userDetail.setBirthday("1999.5.8");userDetail.setPostNumber("654236");userDetail.setAddress("湖北省荆门市京山区");userDetail.setRegisterTime("2019.6.30 20:30:36");
        when(mockUserService.getUser("nunu")).thenReturn(new User());
        when(mockUserService.getUser("987@163.com")).thenReturn(null);
        when(mockUserService.addUser(user1)).thenReturn(false);
        when(mockuserDetailService.addUserDetail(userDetail)).thenReturn(false);  //修改
        try{
            assertEquals("success",userController.doRegister("nunu","987@163.com","M","a123456","18716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result").toString());
            System.out.println("success");
        }catch (AssertionError A){
            System.out.println("failed");
        }
    }
    @Test
    public void BACK_001_DRC_001_03(){
        userController.reset(mockUserService);
        userController.reset(mockuserDetailService);
        user1.setId(5);user1.setName("mumu");user1.setNickName("M");user1.setEmail("977@163.com");
        userDetail.setId(5);userDetail.setPassword("a123456");userDetail.setPhoneNumber("18716549852");userDetail.setSex(1);userDetail.setBirthday("1999.5.8");userDetail.setPostNumber("654236");userDetail.setAddress("湖北省荆门市京山区");userDetail.setRegisterTime("2019.6.30 20:30:36");
        when(mockUserService.getUser("mumu")).thenReturn(null);
        when(mockUserService.getUser("977@163.com")).thenReturn(new User());
        when(mockUserService.addUser(user1)).thenReturn(false);
        when(mockuserDetailService.addUserDetail(userDetail)).thenReturn(false);  //修改
        try{
            assertEquals("success",userController.doRegister("mumu","977@163.com","M","a123456","18716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result").toString());
            System.out.println("success");
        }catch (AssertionError A){
            System.out.println("failed");
        }
    }
    /*
    @Test
    public void BACK_001_DRC_001_04(){
        userController.reset(mockUserService);
        userController.reset(mockuserDetailService);
        user1.setId(5);user1.setName("mumu");user1.setNickName("M");user1.setEmail("977@163.com");
        userDetail.setId(5);userDetail.setPassword("a123456");userDetail.setPhoneNumber("18716549852");userDetail.setSex(1);userDetail.setBirthday("1999.5.8");userDetail.setPostNumber("654236");userDetail.setAddress("湖北省荆门市京山区");userDetail.setRegisterTime("2019.6.30 20:30:36");
        when(mockUserService.getUser("mumu")).thenReturn(null);
        when(mockUserService.getUser(null)).thenReturn(null);
        when(mockUserService.addUser(user1)).thenReturn(false);
        when(mockuserDetailService.addUserDetail(userDetail)).thenReturn(false);  //修改
        try{
            assertEquals("success",userController.doRegister("mumu",null,"M","a123456","18716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result").toString());
            System.out.println("success");
        }catch (AssertionError A){
            System.out.println("failed");
        }
    }*/

    @Test
    public void BACK_001_DUC_001_01(){
        userController.reset(mockUserService);
        userController.reset(mockuserDetailService);
        user1.setNickName("M");user1.setName("mumu");user1.setId(1);user1.setEmail("987@163.com");
        userDetail.setId(1);userDetail.setAddress("湖北省荆门市京山区");userDetail.setBirthday("1999.5.8");userDetail.setPassword("a123456");userDetail.setPhoneNumber("18716549852");userDetail.setPostNumber("654236");userDetail.setSex(1);userDetail.setRegisterTime("2019.6.30 20:30:36");
        when(mockUserService.updateUser(user1)).thenReturn(true);
        when(mockUserService.getUser("mumu")).thenReturn(user1);
        when(mockuserDetailService.getUserDetail(1)).thenReturn(userDetail);
        when(mockuserDetailService.updateUserDetail(userDetail)).thenReturn(true);
        try{
            assertEquals("success",userController.doUpdate("mumu","987@163.com","M","a123456","18716549852",1,"2009.5.8","654236","湖北省荆门市京山区").get("result").toString());
            System.out.println("success");
        }catch (AssertionError A){
            System.out.println("failed");
        }
    }
    @Test
    public void BACK_001_DUC_001_02(){
        userController.reset(mockUserService);
        userController.reset(mockuserDetailService);
        user1.setNickName("M");user1.setName("nunu");user1.setId(5);
        userDetail.setId(5);userDetail.setAddress("湖北省荆门市京山区");userDetail.setBirthday("1999.5.8");userDetail.setPassword("a123456");userDetail.setPhoneNumber("18716549852");userDetail.setPostNumber("654236");userDetail.setSex(1);userDetail.setRegisterTime("2019.6.30 20:30:36");
        when(mockUserService.getUser("nunu")).thenReturn(user1);
        when(mockUserService.updateUser(user1)).thenReturn(false);
        when(mockuserDetailService.getUserDetail(5)).thenReturn(new UserDetail());
        when(mockuserDetailService.updateUserDetail(userDetail)).thenReturn(false);
        try{
            assertEquals("success",userController.doUpdate("nunu","987@163.com","M","a123456","18716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result").toString());
            System.out.println("success");
        }catch (AssertionError A){
            System.out.println("failed");
        }
    }
    @Test
    public void BACK_001_DUC_001_03(){
        userController.reset(mockUserService);
        userController.reset(mockuserDetailService);
        user1.setId(5);user1.setName("mumu");user1.setNickName("M");
        userDetail.setId(5);userDetail.setAddress("湖北省荆门市京山区");userDetail.setBirthday("1999.5.8");userDetail.setPassword("a123456");userDetail.setPhoneNumber("18716549852");userDetail.setPostNumber("654236");userDetail.setSex(1);userDetail.setRegisterTime("2019.6.30 20:30:36");
        when(mockUserService.getUser("mumu")).thenReturn(user1);
        when(mockUserService.updateUser(user1)).thenReturn(false);
        when(mockuserDetailService.getUserDetail(5)).thenReturn(new UserDetail());
        when(mockuserDetailService.updateUserDetail(userDetail)).thenReturn(true);
        try{
            assertEquals("success",userController.doUpdate("mumu","977@163.com","M","a123456","18716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result").toString());
            System.out.println("success");
        }catch (AssertionError A){
            System.out.println("failed");
        }
    }
    @Test
    public void BACK_001_DUC_001_04(){
        userController.reset(mockUserService);
        userController.reset(mockuserDetailService);
        user1.setId(5);user1.setName("mumu");user1.setNickName("M");
        userDetail.setId(5);userDetail.setAddress("湖北省荆门市京山区");userDetail.setBirthday("1999.5.8");userDetail.setPassword("a123456");userDetail.setPhoneNumber("18716549852");userDetail.setPostNumber("654236");userDetail.setSex(1);userDetail.setRegisterTime("2019.6.30 20:30:36");
        when(mockUserService.getUser("mumu")).thenReturn(new User(5,"test","test","test",1));
        when(mockUserService.updateUser(user1)).thenReturn(false);
        when(mockuserDetailService.getUserDetail(5)).thenReturn(new UserDetail());
        when(mockuserDetailService.updateUserDetail(userDetail)).thenReturn(true);
        try{
            assertEquals("success",userController.doUpdate("mumu",null,"M","a123456","18716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result").toString());
            System.out.println("success");
        }catch (AssertionError A){
            System.out.println("failed");
        }
    }
    @Test
    public void BACK_001_GAUS_001_01(){
        userController.reset(mockUserService);
        when(mockUserService.getAllUser()).thenReturn(null);
        try{
            assertEquals("null",userController.getAllUser().get("allUsers"));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public  void  BACK_001_GAUS_001_02(){
        userController.reset(mockUserService);
        ArrayList<User> arrayList = new ArrayList<User>();
        arrayList.add(new User(88,"hello","kugou","yoyo",4));
        when(mockUserService.getAllUser()).thenReturn(arrayList);
        try {
            assertEquals("null",userController.getAllUser().get("allUsers"));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_DUC_002_01(){
        userController.reset(mockUserService);
        Response response = new Response(-1,"failed",new Object());
        when(mockUserService.deleteUser(-1)).thenReturn(response);
        try{
            assertEquals(-1,userController.deleteUser(-1).status);
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_DUC_002_02(){
        userController.reset(mockUserService);
        Response response = new Response(-1,"failed",new Object());
        when(mockUserService.deleteUser(100)).thenReturn(response);
        try{
            assertEquals(-1,userController.deleteUser(100).status);
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_DUC_002_03(){
        userController.reset(mockUserService);
        Response response = new Response(1,"failed",new Object());
        when(mockUserService.deleteUser(1)).thenReturn(response);
        try{
            assertEquals(-1,userController.deleteUser(1).status);
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GAUC_001_01(){
        userController.reset(mockuserDetailService);
        UserDetail userDetail1 = new UserDetail();
        userDetail1.setPhoneNumber(null);userDetail1.setAddress(null);
        when(mockuserDetailService.getUserDetail(-1)).thenReturn(userDetail1);
        try {
            assertNull(userController.getUserAddressAndPhoneNumber(-1).get("address"));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }

    }
    @Test
    public void BACK_001_GAUC_001_02(){
        userController.reset(mockuserDetailService);
        UserDetail userDetail1 = new UserDetail();
        userDetail1.setPhoneNumber(null);userDetail1.setAddress(null);
        when(mockuserDetailService.getUserDetail(1000)).thenReturn(userDetail1);
        try {
            assertNull(userController.getUserAddressAndPhoneNumber(1000).get("address"));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public  void BACK_001_GAUC_001_03(){
        userController.reset(mockuserDetailService);
        UserDetail userDetail1 = new UserDetail();
        userDetail1.setPhoneNumber("18717769105");userDetail1.setAddress("同济大学四平路校区");
        when(mockuserDetailService.getUserDetail(1)).thenReturn(userDetail1);
        try {
            assertNull(userController.getUserAddressAndPhoneNumber(1).get("address"));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GUBIC_001_01(){
        userController.reset(mockUserService);
        when(mockUserService.getUser(-1)).thenReturn(null);
        try {
            assertEquals("null",userController.getUserById(-1).get("result"));
            System.out.println("failed");
        }catch (AssertionError A){

            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GUBIC_001_02(){
        userController.reset(mockUserService);
        when(mockUserService.getUser(1000)).thenReturn(null);
        try {
            assertEquals("null",userController.getUserById(-1).get("result"));
            System.out.println("failed");
        }catch (AssertionError A){
            System.out.println("success");
        }
    }
    @Test
    public  void BACK_001_GUBIC_001_03(){
        userController.reset(mockUserService);
        when(mockUserService.getUser(1)).thenReturn(new User(5,"xurenhe","xu","renhe",4));
        try {
            assertNotEquals("null",userController.getUserById(-1).get("result"));
            System.out.println("failed");
        }catch (AssertionError A){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GUBIC_002_01(){
        userController.reset(mockuserDetailService);
        when(mockuserDetailService.getUserDetail(-1)).thenReturn(null);
        try {
            assertEquals("null",userController.getUserDetailById(-1).get("result"));

            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GUBIC_002_02(){
        userController.reset(mockuserDetailService);
        when(mockuserDetailService.getUserDetail(1000)).thenReturn(null);
        try {
            assertEquals("null",userController.getUserDetailById(-1).get("result"));

            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GUBIC_002_03(){
        UserDetail userDetail = new UserDetail();
        userDetail.setId(5);userDetail.setPassword("a123456");userDetail.setPhoneNumber("18716549852");userDetail.setSex(1);userDetail.setBirthday("1999.5.8");userDetail.setPostNumber("654236");userDetail.setAddress("湖北省荆门市京山区");userDetail.setRegisterTime("2019.6.30 20:30:36");
        userController.reset(mockuserDetailService);
        when(mockuserDetailService.getUserDetail(1)).thenReturn(userDetail);
        try {
            assertNotEquals("null",userController.getUserDetailById(-1).get("result"));

            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
}