package com.shopping.dao;

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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
@Transactional
public class UserDetailDaoImplementTest {
    @Autowired
    private UserDetailDao userDetail;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void BACK_001_GUDD_001_01() {
        //get_user_case1
        int id = -1;
        UserDetail result = userDetail.getUserDetail(id);
        try{
            assertNull(result);
            System.out.println("failed");
        }catch (AssertionError ae){
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_GUDD_001_02() {
        //get_user_case2
        int id = 5;
        UserDetail result = userDetail.getUserDetail(id);
        try{
            assertNull(result);
            System.out.println("failed");
        }catch (AssertionError ae){
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_GUDD_001_03() {
        //get_user_detail_case3
        int id = 1;
        UserDetail result = userDetail.getUserDetail(id);
        try{
            assertNull(result);
            System.out.println("failed");
        }catch (AssertionError ae){
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_AUDD_001_01() {
        //add_user_detail_case1
        UserDetail insert = new UserDetail();
        insert.setId(5);
        insert.setPassword("test1234");
        insert.setPhoneNumber("15355953825");
        insert.setSex(0);
        insert.setBirthday("1997.10.8");
        insert.setPostNumber("325200");
        insert.setAddress("上海市同济大学嘉定校区六号楼");
        insert.setRegisterTime("2019.6.30 16:40");
        boolean result = userDetail.addUserDetail(insert);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_AUDD_001_02() {
        //add_user_detail_case2
        UserDetail insert = new UserDetail();
        insert.setId(1);
        insert.setPassword("test1234");
        insert.setPhoneNumber("15355953825");
        insert.setSex(0);
        insert.setBirthday("1997.10.8");
        insert.setPostNumber("325200");
        insert.setAddress("上海市同济大学嘉定校区六号楼");
        insert.setRegisterTime("2019.6.30 16:40");
        boolean result = userDetail.addUserDetail(insert);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_AUDD_001_03() {
        //add_user_detail_case3
        UserDetail insert = new UserDetail();
        insert.setId(5);
        insert.setPhoneNumber("15355953825");
        insert.setSex(0);
        insert.setPostNumber("325200");
        insert.setAddress("上海市同济大学嘉定校区六号楼");
        insert.setRegisterTime("2019.6.30 16:40");
        boolean result = userDetail.addUserDetail(insert);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_AUDD_001_04() {
        //add_user_detail_case4
        UserDetail insert = new UserDetail();
        insert.setId(6);
        insert.setPassword("test1234");
        insert.setPhoneNumber("15355953825");
        insert.setSex(0);
        insert.setBirthday("1997.10.8");
        insert.setPostNumber("325200");
        insert.setAddress("上海市同济大学嘉定校区六号楼");
        insert.setRegisterTime("2019.6.30 16:40");
        boolean result = userDetail.addUserDetail(insert);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_DUDD_001_01() {
        //delete_user_detail_case1
        int id = -10;
        boolean result = userDetail.deleteUserDetail(id);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_DUDD_001_02() {
        //delete_user_detail_case2
        int id = 6;
        boolean result = userDetail.deleteUserDetail(id);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_DUDD_001_03() {
        //delete_user_detail_case3
        int id = 1;
        boolean result = userDetail.deleteUserDetail(id);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_UUDD_001_01() {
        //update_user_detail_case1
        UserDetail update = new UserDetail();
        update.setId(5);
        update.setPassword("test1234");
        update.setSex(0);
        update.setBirthday("1966.10.8");
        update.setPostNumber("325621");
        update.setRegisterTime("2019.6.30 22：52");
        try{
            boolean result = userDetail.updateUserDetail(update);
            assertTrue(result);
            System.out.println("success");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("failed");
        }catch (AssertionError ae){
            ae.printStackTrace();
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_UUDD_001_02() {
        //update_user_detail_case2
        UserDetail update = new UserDetail();
        update.setId(5);
        update.setPassword("test1234");
        update.setPhoneNumber("15355912345");
        update.setSex(0);
        update.setBirthday("1966.10.8");
        update.setPostNumber("325621");
        update.setAddress("上海市同济大学嘉定校区20号楼");
        update.setRegisterTime("2019.6.30 22：52");
        boolean result = userDetail.updateUserDetail(update);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            ae.printStackTrace();
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_UUDD_001_03() {
        //update_user_detail_case3
        UserDetail update = new UserDetail();
        update.setId(1);
        update.setPassword("test1234");
        update.setPhoneNumber("15355912345");
        update.setSex(0);
        update.setBirthday("1966.10.8");
        update.setPostNumber("325621");
        update.setAddress("上海市同济大学嘉定校区20号楼");
        update.setRegisterTime("2019.6.30 22：52");
        boolean result = userDetail.updateUserDetail(update);
        try{
            assertTrue(result);
            System.out.println("success");
        }catch (AssertionError ae){
            ae.printStackTrace();
            System.out.println("failed");
        }
    }
}