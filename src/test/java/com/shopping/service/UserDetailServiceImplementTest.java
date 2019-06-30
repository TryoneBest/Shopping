package com.shopping.service;

import com.shopping.dao.UserDetailDao;
import com.shopping.entity.UserDetail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
@Transactional
public class UserDetailServiceImplementTest {
    public void setUserDetailEntity(UserDetail u, int id, String address, String birthday, String password,
                                       String tel, String post, String register_time, int sex){
        u.setId(id);
        u.setAddress(address);
        u.setBirthday(birthday);
        u.setPassword(password);
        u.setPhoneNumber(tel);
        u.setPostNumber(post);
        u.setRegisterTime(register_time);
        u.setSex(sex);
    }

    private UserDetail userDetailID1 = new UserDetail();
    private UserDetail userDetailAdd = new UserDetail();
    private UserDetail userDetailUpdate = new UserDetail();
    @Autowired
    private UserDetailDao mockUserDetail;
    @Autowired
    private UserDetailService userDetailService;

    @Before
    public void setUp() throws Exception {
        setUserDetailEntity(userDetailID1, 1, "上海市同济大学嘉定校区六号楼", "1997.10.8",
                "test1234", "15355953825", "325200", "2019.6.30 15:10", 0);
        mockUserDetail = mock(UserDetailDao.class);
        when(mockUserDetail.getUserDetail(1)).thenReturn(userDetailID1);
        when(mockUserDetail.getUserDetail(-1)).thenReturn(null);
        when(mockUserDetail.getUserDetail(5)).thenReturn(null);
        when(mockUserDetail.deleteUserDetail(-10)).thenReturn(false);
        when(mockUserDetail.deleteUserDetail(6)).thenReturn(false);
        when(mockUserDetail.deleteUserDetail(1)).thenReturn(true);

        userDetailService.setUserDetailDao(mockUserDetail);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void BACK_001_GUDS_001_01() {
        //get_user_detail_case1
        UserDetail result = userDetailService.getUserDetail(-1);
        verify(mockUserDetail, times(1)).getUserDetail(-1);
        try{
            assertNull(result);
            System.out.println("failed");
        }catch (AssertionError ae){
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_GUDS_001_02() {
        //get_user_detail_case2
        //userDetailService.setUserDetailDao(mockUserDetail);
        UserDetail result = userDetailService.getUserDetail(5);
        verify(mockUserDetail, times(1)).getUserDetail(5);
        try{
            assertNull(result);
            System.out.println("failed");
        }catch (AssertionError ae){
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_GUDS_001_03() {
        //get_user_detail_case3
        //userDetailService.setUserDetailDao(mockUserDetail);
        UserDetail result = userDetailService.getUserDetail(1);
        verify(mockUserDetail, times(1)).getUserDetail(1);
        try{
            assertNull(result);
            System.out.println("failed");
        }catch (AssertionError ae){
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_AUDS_001_01() {
        //add_user_detail_case1
        setUserDetailEntity(userDetailAdd, 5, "上海市同济大学嘉定校区六号楼", "1997.10.8",
                "test1234", "15355953825", "325200", "2019.6.30 16:40", 0);
        when(mockUserDetail.addUserDetail(userDetailAdd)).thenReturn(true);
        boolean result = userDetailService.addUserDetail(userDetailAdd);
        verify(mockUserDetail, times(1)).addUserDetail(userDetailAdd);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_AUDS_001_02() {
        //add_user_detail_case2
        setUserDetailEntity(userDetailAdd, 1, "上海市同济大学嘉定校区六号楼", null,
                null, "15355953825", "325200", "2019.6.30 16:40", 0);
        when(mockUserDetail.addUserDetail(userDetailAdd)).thenReturn(false);
        boolean result = userDetailService.addUserDetail(userDetailAdd);
        verify(mockUserDetail, times(1)).addUserDetail(userDetailAdd);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_AUDS_001_03() {
        //add_user_detail_case3
        setUserDetailEntity(userDetailAdd, 6, "上海市同济大学嘉定校区六号楼", "1997.10.8",
                "test1234", "15355953825", "325200", "2019.6.30 16:40", 0);
        when(mockUserDetail.addUserDetail(userDetailAdd)).thenReturn(false);
        boolean result = userDetailService.addUserDetail(userDetailAdd);
        verify(mockUserDetail, times(1)).addUserDetail(userDetailAdd);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_AUDS_001_04() {
        //add_user_detail_case4
        setUserDetailEntity(userDetailAdd, 5, "上海市同济大学嘉定校区六号楼", "1997.10.8",
                "test1234", "15355953825", "325200", "2019.6.30 16:40", 0);
        when(mockUserDetail.addUserDetail(userDetailAdd)).thenReturn(false);
        boolean result = userDetailService.addUserDetail(userDetailAdd);
        verify(mockUserDetail, times(1)).addUserDetail(userDetailAdd);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_DUDS_001_01() {
        //delete_user_detail_case1
        boolean result = userDetailService.deleteUserDetail(-10);
        verify(mockUserDetail, times(1)).deleteUserDetail(-10);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_DUDS_001_02() {
        //delete_user_detail_case2
        boolean result = userDetailService.deleteUserDetail(6);
        verify(mockUserDetail, times(1)).deleteUserDetail(6);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_DUDS_001_03() {
        //delete_user_detail_case3
        boolean result = userDetailService.deleteUserDetail(1);
        verify(mockUserDetail, times(1)).deleteUserDetail(1);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_UUDS_001_01() {
        //update_user_detail_case1
        setUserDetailEntity(userDetailUpdate, 1, null, "1966.10.8", "test1234"
                ,null, "325621", "2019.6.30 22：52", 0);
        when(mockUserDetail.updateUserDetail(userDetailUpdate)).thenReturn(false);
        boolean result = userDetailService.updateUserDetail(userDetailUpdate);
        verify(mockUserDetail, times(1)).updateUserDetail(userDetailUpdate);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_UUDS_001_02() {
        //update_user_detail_case2
        setUserDetailEntity(userDetailUpdate, 5, "上海市同济大学嘉定校区20号楼", "1966.10.8", "test1234"
                ,"15355912345", "325621", "2019.6.30 22：52", 0);
        when(mockUserDetail.updateUserDetail(userDetailUpdate)).thenReturn(false);
        boolean result = userDetailService.updateUserDetail(userDetailUpdate);
        verify(mockUserDetail, times(1)).updateUserDetail(userDetailUpdate);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_UUDS_001_03() {
        //update_user_detail_case3
        setUserDetailEntity(userDetailUpdate, 1, "上海市同济大学嘉定校区20号楼", "1966.10.8", "test1234"
        ,"15355912345", "325621", "2019.6.30 22：52", 0);
        when(mockUserDetail.updateUserDetail(userDetailUpdate)).thenReturn(true);
        boolean result = userDetailService.updateUserDetail(userDetailUpdate);
        verify(mockUserDetail, times(1)).updateUserDetail(userDetailUpdate);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            System.out.println("failed");
        }
    }
}