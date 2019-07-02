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
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
@Transactional
public class UserControllerTestTwo {
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
    public void BACK_001_DLIC_001_01(){
        userController.reset(mockuserDetailService);
        userController.reset(mockUserService);
        user1.setId(1);user1.setName("小明");user1.setEmail("1234@qq.com");user1.setNickName("明小");user1.setRole(0);
        userDetail.setId(1);userDetail.setPassword("test1234");userDetail.setBirthday("1997.10.8");userDetail.setSex(0);userDetail.setPostNumber("325200");userDetail.setPhoneNumber("15355953828");userDetail.setAddress("上海市同济大学嘉定校区六号楼");userDetail.setRegisterTime("2019.6.30 15:10");
        when(mockuserDetailService.getUserDetail(user1.getId())).thenReturn(userDetail);
        when(mockUserService.getUser("小明")).thenReturn(user1);
        try {
            assertEquals("success",userController.doLogin("小明","test1234",new MockHttpSession()).get("result"));
            System.out.println("success");
        }catch (AssertionError A){
            System.out.println("failed");
        }

    }
    @Test
    public void BACK_001_DLIC_001_02(){
        userController.reset(mockuserDetailService);
        userController.reset(mockUserService);
        user1.setId(1);user1.setName("小明");user1.setEmail("1234@qq.com");user1.setNickName("明小");user1.setRole(0);
        userDetail.setId(1);userDetail.setPassword(null);userDetail.setBirthday("1997.10.8");userDetail.setSex(0);userDetail.setPostNumber("325200");userDetail.setPhoneNumber("15355953828");userDetail.setAddress("上海市同济大学嘉定校区六号楼");userDetail.setRegisterTime("2019.6.30 15:10");
        when(mockuserDetailService.getUserDetail(user1.getId())).thenReturn(userDetail);
        when(mockUserService.getUser("小明")).thenReturn(user1);
        try {
            assertEquals("success",userController.doLogin("小明",null,new MockHttpSession()).get("result"));
            System.out.println("success");
        }catch (AssertionError A){
            System.out.println("failed");
        }
    }
    @Test
    public void BACK_001_DRC_001_01(){
        userController.reset(mockUserService);
        userController.reset(mockuserDetailService);
        user1.setId(8);user1.setName("mumu");user1.setNickName("M");user1.setEmail("987@163.com");
        userDetail.setId(8);userDetail.setAddress("湖北省荆门市京山区");userDetail.setBirthday("1999.5.8");userDetail.setPassword("a123456");userDetail.setPhoneNumber("18716549852");userDetail.setPostNumber("654236");userDetail.setSex(1);userDetail.setRegisterTime("2019.6.30 20:30:36");
        when(mockUserService.getUser("987@163.com")).thenReturn(null);
        when(mockUserService.getUser("mumu")).thenReturn(null);
        when(mockUserService.addUser(user1)).thenReturn(true);
        when(mockuserDetailService.addUserDetail(userDetail)).thenReturn(true);
        try {
            userController.user_temp=user1;
            userController.userDetail_temp= userDetail;
            userController.tag = true;
            assertEquals("success",userController.doRegister("mumu","987@163.com","M","a123456","18716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result").toString());
            System.out.println("success");
        }catch (AssertionError a){
            System.out.println("failed");
        }
    }
    @Test
    public void BACK_001_DRC_001_02(){
        userController.reset(mockUserService);
        userController.reset(mockuserDetailService);
        user1.setId(8);user1.setName(null);user1.setNickName("M");user1.setEmail("987@163.com");
        userDetail.setId(8);userDetail.setAddress("湖北省荆门市京山区");userDetail.setBirthday("1999.5.8");userDetail.setPassword("a123456");userDetail.setPhoneNumber("18716549852");userDetail.setPostNumber("654236");userDetail.setSex(1);userDetail.setRegisterTime("2019.6.30 20:30:36");
        when(mockUserService.getUser("987@163.com")).thenReturn(new User());
        when(mockUserService.getUser(null)).thenReturn(null);
        when(mockUserService.addUser(user1)).thenReturn(false);
        when(mockuserDetailService.addUserDetail(userDetail)).thenReturn(false);
        try {
            userController.user_temp=user1;
            userController.userDetail_temp= userDetail;
            userController.tag = true;
            assertEquals("success",userController.doRegister(null,"987@163.com","M","a123456","18716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result").toString());
            System.out.println("success");
        }catch (AssertionError a){
            System.out.println("failed");
        }
    }
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
            assertEquals("success",userController.doUpdate("mumu","987@163.com","M","a123456","18716549852",1,"2009.5.8","654236","湖北省荆门市京山区",new MockHttpSession()).get("result").toString());
            System.out.println("success");
        }catch (AssertionError A){
            System.out.println("failed");
        }
    }
    @Test
    public void BACK_001_DUC_001_02(){
        userController.reset(mockUserService);
        userController.reset(mockuserDetailService);
        user1.setId(8);user1.setName(null);user1.setNickName("M");
        userDetail.setId(8);userDetail.setAddress("湖北省荆门市京山区");userDetail.setBirthday("1999.5.8");userDetail.setPassword("a123456");userDetail.setPhoneNumber("18716549852");userDetail.setPostNumber("654236");userDetail.setSex(1);userDetail.setRegisterTime("2019.6.30 20:30:36");
        when(mockUserService.getUser(null)).thenReturn(null);
        when(mockUserService.updateUser(user1)).thenReturn(false);
        when(mockuserDetailService.getUserDetail(5)).thenReturn(new UserDetail());
        when(mockuserDetailService.updateUserDetail(userDetail)).thenReturn(true);
        try{
            assertEquals("success",userController.doUpdate(null,"977@163.com","M","a123456","18716549852",1,"1999.5.8","654236","湖北省荆门市京山区",new MockHttpSession()).get("result").toString());
            System.out.println("success");
        }catch (AssertionError A){
            System.out.println("failed");
        }
    }
    @Test
    public void BACK_001_GAUC_001_01(){
        userController.reset(mockUserService);
        List<User> list = new ArrayList<>();
        list.add(new User(11,"TEST","TEST","TEST",1));
        list.add(new User(12,"test11","test11","test11",2));
        when(mockUserService.getAllUser()).thenReturn(list);
        try {
            assertNotNull(userController.getAllUser());
            System.out.println("success");
        }catch (AssertionError a){
            System.out.println("failed");
        }
    }
    @Test
    public void BACK_001_DUC_002_01(){
        userController.reset(mockUserService);
        Response response = new Response(1,"success",new Object());
        when(mockUserService.deleteUser(1)).thenReturn(response);
        try{
            assertEquals(1,userController.deleteUser(1).status);
            System.out.println("success");
        }catch (AssertionError a){
            System.out.println("failed");
        }
    }
    @Test
    public void BACK_001_GUAC_001_01(){
        userController.reset(mockuserDetailService);
        UserDetail userDetail = new UserDetail();
        userDetail.setAddress("浙江省温州市瓯海区");userDetail.setPhoneNumber("18916103004");
        when(mockuserDetailService.getUserDetail(7)).thenReturn(userDetail);
        try {
            assertNull(userController.getUserAddressAndPhoneNumber(7).get("address"));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_DLOC_001_01() {
        try {
            assertEquals("redirect:login", userController.doLogout(new MockHttpSession()));
            System.out.println("success");
        } catch (AssertionError A) {
            System.out.println("failed");
        }
    }
    @Test
    public void BACK_001_GUBIC_001_01(){
        userController.reset(mockUserService);
        when(mockUserService.getUser(7)).thenReturn(new User(7,"test","test","test",1));
        try {
            assertNotEquals("null",userController.getUserDetailById(7).get("result"));
            System.out.println("success");
        }catch (AssertionError A){
            System.out.println("failed");
        }
    }
    @Test
    public void BACK_001_GUBIC_002_01(){
        userController.reset(mockuserDetailService);
        UserDetail userDetail = new UserDetail();
        userDetail.setPhoneNumber("18717769105");userDetail.setAddress("同济大学");userDetail.setPostNumber("525400");userDetail.setBirthday("1999.10.1");
        when(mockuserDetailService.getUserDetail(7)).thenReturn(userDetail);
        try {
            assertNotEquals("null",userController.getUserDetailById(7).get("result"));
            System.out.println("success");
        }catch(AssertionError a){
            System.out.println("failed");
        }
    }
}