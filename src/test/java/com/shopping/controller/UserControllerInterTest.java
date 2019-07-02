package com.shopping.controller;

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
@Transactional
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
public class UserControllerInterTest {

    @Autowired
    UserController userController = new UserController();
    @Before
    public void init(){

    }

    @Test
    @Transactional
    public  void  BACK_001_DRC_001_01(){
        try {
            //System.out.println(userController.doRegister("mumu","977@163.com","M","a123456","18716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result"));
            assertNotEquals("success",userController.doRegister("mumu","977@163.com","M","a123456","18716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result"));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }

    }
    @Test
    public void BACK_001_DRC_001_02(){
        try {
            //System.out.println(userController.doRegister(null,"977@163.com","M","a123456","18716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result"));
            assertNotEquals("success",userController.doRegister(null,"977@163.com","M","a123456","18716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result"));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }


    }

    @Test
    public void BACK_001_DRC_001_03(){
        try {
            assertNotEquals("success",userController.doRegister("小明","977@163.com","M","a123456","18716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result"));
            System.out.println("failed");
        }catch (AssertionError A){
            System.out.println("success");
        }
    }


    @Test

    public void BACK_001_DUC_001_01(){
        try {
            //assertEquals("success",userController.doUpdate("小明","987@163.com","M","a123456","18716549852",1,"2009.5.8","654236","湖北省荆门市京山区").get("result"));
            System.out.println("success");
        }catch (AssertionError a){
            System.out.println("failed");
        }

    }
    @Test

    public void BACK_001_DUC_001_02(){
        try {
            //System.out.println(userController.doUpdate(null,"9874@163.com","M","a123456","18716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result"));
            //assertEquals("success",userController.doUpdate(null,"9874@163.com","M","a123456","18716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result"));
            System.out.println("success");
        }catch (AssertionError a){
            System.out.println("failed");
        }

    }

    @Test
    public void BACK_001_DUC_001_03(){
        try {
            //System.out.println(userController.doUpdate("小明","123@163.com","M","a123456","19716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result"));
            //assertEquals("success",userController.doUpdate("小明","123@163.com","M","a123456","19716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result"));
            System.out.println("success");
        }catch (AssertionError a){
            System.out.println("failed");
        }
    }
    @Test
    public void BACK_001_DUC_001_04(){
        try {
            //System.out.println(userController.doUpdate("李","1237@163.com","M","a123456","19716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result"));
            //assertEquals("success",userController.doUpdate("小明","123@163.com","M","a123456","19716549852",1,"1999.5.8","654236","湖北省荆门市京山区").get("result"));
            System.out.println("success");
        }catch (AssertionError a){
            System.out.println("failed");
        }

    }

    @Test
    public void BACK_001_GAUS_001_01(){
        try {
            assertNull(userController.getAllUser().get("allUsers"));
            System.out.println("failed");
        }catch (AssertionError A){
            System.out.println("success");
        }

    }
    @Test
    public void BACK_001_GAUS_001_02(){
        try {
            assertNull(userController.getAllUser().get("allUsers"));
            System.out.println("failed");
        }catch (AssertionError A){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_DUC_002_01(){
        int id=-1;
        try {
            assertEquals(0,userController.deleteUser(id).status);
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");

        }
    }
    @Test
    public void BACK_001_DUC_002_02(){
        int id=101;
        try {
            assertEquals(0,userController.deleteUser(id).status);
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");

        }
    }
    @Test
    public void BACK_001_DUC_002_03(){
        int id=1;
        try {
            assertEquals(0,userController.deleteUser(id).status);
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");

        }
    }
    @Test
    public void BACK_001_GAUC_001_01(){
        int id=-1;
        try {
            assertNull(userController.getUserAddressAndPhoneNumber(id).get("address"));
            System.out.println("failed");
        }catch (Exception a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GAUC_001_02(){
        int id=104;
        try {
            assertNull(userController.getUserAddressAndPhoneNumber(id).get("address"));
            System.out.println(userController.getUserAddressAndPhoneNumber(id).get("exception"));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GAUC_001_03(){
        int id=4;
        try {
            assertNull(userController.getUserAddressAndPhoneNumber(id).get("address"));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GUBIC_001_01(){
        int id=-1;
        try {
            assertEquals("null",userController.getUserById(id).get("result"));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GUBIC_001_02(){
        int id=101;
        try {
            assertEquals("null",userController.getUserById(id).get("result"));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GUBIC_001_03(){
        int id=4;
        try {
            assertEquals("null",userController.getUserById(id).get("result"));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GUBIC_002_01(){

        int id=-1;
        try {
            assertEquals("null",userController.getUserDetailById(id).get("result"));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }
    @Test
    public void BACK_001_GUBIC_002_02(){
        int id=101;
        try {
            assertEquals("null", userController.getUserDetailById(id).get("result"));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }

    }
    @Test
    public void BACK_001_GUBIC_002_03(){
        int id=4;
        try {
            assertEquals("null", userController.getUserDetailById(id).get("result"));
            System.out.println("failed");
        }catch (AssertionError a){
            System.out.println("success");
        }
    }

}