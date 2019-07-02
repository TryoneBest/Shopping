package com.shopping.controller;
import com.shopping.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpSession;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
public class UserInterfaceTest {
    @Autowired
    private WebApplicationContext userController;
    private MockMvc mockmvc;
    @Before
    public void setUp() throws Exception {
        mockmvc=MockMvcBuilders.webAppContextSetup(userController).build();
    }
    //************************************************************
    //                    Test for doRegister
    //************************************************************
    @Test
    @Transactional
    public void INTER_001_DRC_001_01() throws Exception {
        //do_register_test_case_1
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doRegister");
        requestBuilder.param("userName","1111111")
                .param("email","104109046@qq.com")
                .param("nickName","TestUser1")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("postNumber","20000")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        //assertEquals("{\"result\":\"success\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DRC_001_02() throws Exception {
        //do_register_test_case_2
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doRegister");
        requestBuilder.param("userName","小明")
                .param("email","1041090@qq.com")
                .param("nickName","TestUser")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("postNumber","20000")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        //assertEquals("{\"result\":\"nameExist\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DRC_001_03() throws Exception {
        //do_register_test_case_3
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doRegister");
        requestBuilder.param("email","104109046@qq.com")
                .param("nickName","TestUser1")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("postNumber","20000")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        System.out.println(content);
        assertEquals("{\"result\":\"add user failed\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DRC_001_04() throws Exception {
        //do_register_test_case_4
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doRegister");
        requestBuilder.param("userName","111111111111111111111111111111")
                .param("nickName","TestUser1")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("postNumber","20000")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        System.out.println(content);
        assertEquals("{\"result\":\"add user failed\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DRC_001_05() throws Exception {
        //do_register_test_case_5
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doRegister");
        requestBuilder.param("userName","111111111111111111111111111111")
                .param("email","104109046@qq.com")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("postNumber","20000")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        assertEquals("{\"result\":\"add user failed\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DRC_001_06() throws Exception {
        //do_register_test_case_6
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doRegister");
        requestBuilder.param("userName","111111111111111111111111111111")
                .param("email","104109046@qq.com")
                .param("nickName","TestUser1")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("postNumber","20000")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        //assertEquals("{\"result\":\"user detail failed\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DRC_001_07() throws Exception {
        //do_register_test_case_7
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doRegister");
        requestBuilder.param("userName","111111111111111111111111111111")
                .param("email","104109046@qq.com")
                .param("nickName","TestUser1")
                .param("password","Password")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("postNumber","20000")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        //assertEquals("{\"result\":\"user detail failed\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DRC_001_08() throws Exception {
        //do_register_test_case_8
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doRegister");
        requestBuilder.param("userName","111111111111111111111111111111")
                .param("email","104109046@qq.com")
                .param("nickName","TestUser1")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("birthday","1999/01/01")
                .param("postNumber","20000")
                .param("address","上海");
        try{
            MvcResult result=mockmvc.perform(requestBuilder).andReturn();
            String content=result.getResponse().getContentAsString();
            //System.out.println(content);
            assertEquals("{\"result\":\"user detail failed\"}", content);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("register error");
        }
    }

    @Test
    @Transactional
    public void INTER_001_DRC_001_09() throws Exception {
        //do_register_test_case_9
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doRegister");
        requestBuilder.param("userName","111111111111111111111111111111")
                .param("email","104109046@qq.com")
                .param("nickName","TestUser1")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("postNumber","20000")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        //assertEquals("{\"result\":\"user detail failed\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DRC_001_10() throws Exception {
        //do_register_test_case_10
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doRegister");
        requestBuilder.param("userName","111111111111111111111111111111")
                .param("email","104109046@qq.com")
                .param("nickName","TestUser1")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        //assertEquals("{\"result\":\"user detail failed\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DRC_001_11() throws Exception {
        //do_register_test_case_11
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doRegister");
        requestBuilder.param("userName","111111111111111111111111111111")
                .param("email","104109046@qq.com")
                .param("nickName","TestUser1")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("postNumber","20000");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        //assertEquals("{\"result\":\"user detail failed\"}", content);
    }

    //************************************************************
    //                    Test for doLogin
    //************************************************************
    @Test
    @Transactional
    public void INTER_001_DLC_001_01() throws Exception {
        //do_login_test_case_1
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doLogin");
        requestBuilder.param("userNameOrEmail","小明")
                .param("password","test1234");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        //assertEquals("{\"result\":\"success\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DLC_001_02() throws Exception {
        //do_login_test_case_2
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doLogin");
        requestBuilder.param("userNameOrEmail","小明")
                .param("password","test123");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        //assertEquals("{\"result\":\"wrong\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DLC_001_03() throws Exception {
        //do_login_test_case_3
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doLogin");
        requestBuilder.param("userNameOrEmail","小小")
                .param("password","test1234");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        assertEquals("{\"result\":\"unexist\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DLC_001_04() throws Exception {
        //do_login_test_case_4
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doLogin");
        requestBuilder.param("password","test1234");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        assertEquals("{\"result\":\"unexist\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DLC_001_05() throws Exception {
        //do_login_test_case_5
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doLogin");
        requestBuilder.param("userNameOrEmail","小明");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        //assertEquals("{\"result\":\"null password\"}", content);
    }

    //************************************************************
    //                    Test for doUpdate
    //************************************************************
    @Test
    @Transactional
    public void INTER_001_DUUC_001_01() throws Exception {
        //do_update_test_case_1
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doUpdate");
        requestBuilder.param("userName","小明")
                .param("email","104109046@qq.com")
                .param("nickName","TestUser1")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("postNumber","20000")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        //assertEquals("{\"result\":\"success\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DUUC_001_02() throws Exception {
        //do_update_test_case_2
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doUpdate");
        requestBuilder.param("userName","nouserexist")
                .param("email","104109046@qq.com")
                .param("nickName","TestUser1")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("postNumber","20000")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        assertEquals("{\"result\":\"exception  failed\",\"exception\":\"java.lang.NullPointerException\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DUUC_001_03() throws Exception {
        //do_update_test_case_3
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doUpdate");
        requestBuilder.param("email","104109046@qq.com")
                .param("nickName","TestUser1")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("postNumber","20000")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        assertEquals("{\"result\":\"exception  failed\",\"exception\":\"java.lang.NullPointerException\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DUUC_001_04() throws Exception {
        //do_update_test_case_4
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doUpdate");
        requestBuilder.param("userName","nouserexist")
                .param("nickName","TestUser1")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("postNumber","20000")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        assertEquals("{\"result\":\"exception  failed\",\"exception\":\"java.lang.NullPointerException\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DUUC_001_05() throws Exception {
        //do_update_test_case_5
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doUpdate");
        requestBuilder.param("userName","nouserexist")
                .param("email","104109046@qq.com")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("postNumber","20000")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        assertEquals("{\"result\":\"exception  failed\",\"exception\":\"java.lang.NullPointerException\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DUUC_001_06() throws Exception {
        //do_update_test_case_6
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doUpdate");
        requestBuilder.param("userName","小明")
                .param("email","104109046@qq.com")
                .param("nickName","TestUser1")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("postNumber","20000")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        //assertEquals("{\"result\":\"exception  failed\",\"exception\":\"org.hibernate.exception.ConstraintViolationException\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DUUC_001_07() throws Exception {
        //do_update_test_case_7
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doUpdate");
        requestBuilder.param("userName","nouserexist")
                .param("email","104109046@qq.com")
                .param("nickName","TestUser1")
                .param("password","Password")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("postNumber","20000")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        assertEquals("{\"result\":\"exception  failed\",\"exception\":\"java.lang.NullPointerException\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DUUC_001_08() throws Exception {
        //do_update_test_case_8
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doUpdate");
        requestBuilder.param("userName","小明")
                .param("email","104109046@qq.com")
                .param("nickName","TestUser1")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("birthday","1999/01/01")
                .param("postNumber","20000")
                .param("address","上海");
        try{
            MvcResult result=mockmvc.perform(requestBuilder).andReturn();
            String content=result.getResponse().getContentAsString();
            //System.out.println(content);
            assertEquals("{\"result\":\"exception  failed\",\"exception\":\"java.lang.NullPointerException\"}", content);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Transactional
    public void INTER_001_DUUC_001_09() throws Exception {
        //do_update_test_case_9
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doUpdate");
        requestBuilder.param("userName","nouserexist")
                .param("email","104109046@qq.com")
                .param("nickName","TestUser1")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("postNumber","20000")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        assertEquals("{\"result\":\"exception  failed\",\"exception\":\"java.lang.NullPointerException\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DUUUC_001_10() throws Exception {
        //do_update_test_case_10
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doUpdate");
        requestBuilder.param("userName","nouserexist")
                .param("email","104109046@qq.com")
                .param("nickName","TestUser1")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("address","上海");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        assertEquals("{\"result\":\"exception  failed\",\"exception\":\"java.lang.NullPointerException\"}", content);
    }

    @Test
    @Transactional
    public void INTER_001_DUUC_001_11() throws Exception {
        //do_update_test_case_11
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doUpdate");
        requestBuilder.param("userName","nouserexist")
                .param("email","104109046@qq.com")
                .param("nickName","TestUser1")
                .param("password","Password")
                .param("phoneNumber","15208602298")
                .param("sex", "0")
                .param("birthday","1999/01/01")
                .param("postNumber","20000");
        MvcResult result=mockmvc.perform(requestBuilder).andReturn();
        String content=result.getResponse().getContentAsString();
        //System.out.println(content);
        assertEquals("{\"result\":\"exception  failed\",\"exception\":\"java.lang.NullPointerException\"}", content);
    }

    //************************************************************
    //                    Test for getAllUser
    //************************************************************
    @Test
    @Transactional
    public void INTER_001_GAUC_001_01() throws Exception{
        //get_all_user_case1
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/getAllUser");
        MvcResult result = mockmvc.perform(requestBuilder).andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    //************************************************************
    //                    Test for deleteUser
    //************************************************************
    @Test
    @Transactional
    public void INTER_001_DUC_001_01() throws Exception{
        //delete_user_case1
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/deleteUser");
        requestBuilder.param("id","3");
        MvcResult result = mockmvc.perform(requestBuilder).andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    @Transactional
    public void INTER_001_DUC_001_02() throws Exception{
        //delete_user_case2
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/deleteUser");
        requestBuilder.param("id","10");
        MvcResult result = mockmvc.perform(requestBuilder).andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    @Transactional
    public void INTER_001_DUC_001_03() throws Exception{
        //delete_user_case3
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/deleteUser");
        requestBuilder.param("id","-1");
        MvcResult result = mockmvc.perform(requestBuilder).andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    @Transactional
    public void INTER_001_DUC_001_04() throws Exception{
        //delete_user_case4
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/deleteUser");
        try{
            MvcResult result = mockmvc.perform(requestBuilder).andReturn();
            String content = result.getResponse().getContentAsString();
            System.out.println(content);
        }catch (Exception e){
            System.out.println("insert failed");
        }
    }

    //************************************************************
    //           Test for getUserAddressAndPhoneNumber
    //************************************************************
    @Test
    @Transactional
    public void INTER_001_GUAPC_001_01() throws Exception{
        //get_address_and_phonenumber_user_case1
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/getUserAddressAndPhoneNumber");
        requestBuilder.param("id","2");
        MvcResult result = mockmvc.perform(requestBuilder).andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    @Transactional
    public void INTER_001_GUAPC_001_02() throws Exception{
        //get_address_and_phonenumber_user_case2
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/getUserAddressAndPhoneNumber");
        requestBuilder.param("id","8");
        MvcResult result = mockmvc.perform(requestBuilder).andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    @Transactional
    public void INTER_001_GUAPC_001_03() throws Exception{
        //get_address_and_phonenumber_user_case3
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/getUserAddressAndPhoneNumber");
        requestBuilder.param("id","-1");
        MvcResult result = mockmvc.perform(requestBuilder).andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    @Transactional
    public void INTER_001_GUAPC_001_04() throws Exception{
        //get_address_and_phonenumber_user_case4
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/getUserAddressAndPhoneNumber");
        try{
            MvcResult result = mockmvc.perform(requestBuilder).andReturn();
            String content = result.getResponse().getContentAsString();
            System.out.println(content);
        }catch (Exception e){
            System.out.println("failed to send request");
        }
    }

    //************************************************************
    //                  Test for getUserByID
    //************************************************************
    @Test
    @Transactional
    public void INTER_001_GUBIDC_001_01() throws Exception{
        //get_user_by_id_case1
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/getUserById");
        requestBuilder.param("id","1");
        MvcResult result = mockmvc.perform(requestBuilder).andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    @Transactional
    public void INTER_001_GUBIDC_001_02() throws Exception{
        //get_user_by_id_case2
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/getUserById");
        requestBuilder.param("id","7");
        MvcResult result = mockmvc.perform(requestBuilder).andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    @Transactional
    public void INTER_001_GUBIDC_001_03() throws Exception{
        //get_user_by_id_case3
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/getUserById");
        requestBuilder.param("id","-23");
        MvcResult result = mockmvc.perform(requestBuilder).andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    @Transactional
    public void INTER_001_GUBIDC_001_04() throws Exception{
        //get_user_by_id_case4
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/getUserById");
        try{
            MvcResult result = mockmvc.perform(requestBuilder).andReturn();
            String content = result.getResponse().getContentAsString();
            System.out.println(content);
        }catch (Exception e){
            System.out.println("failed to send request");
        }
    }

    //************************************************************
    //               Test for getUserDetailById
    //************************************************************
    @Test
    @Transactional
    public void INTER_001_GUDBIDC_001_01() throws Exception{
        //get_user_by_id_case1
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/getUserDetailById");
        requestBuilder.param("id","3");
        MvcResult result = mockmvc.perform(requestBuilder).andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    @Transactional
    public void INTER_001_GUDBIDC_001_02() throws Exception{
        //get_user_by_id_case2
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/getUserDetailById");
        requestBuilder.param("id","15");
        MvcResult result = mockmvc.perform(requestBuilder).andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    @Transactional
    public void INTER_001_GUDBIDC_001_03() throws Exception{
        //get_user_by_id_case3
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/getUserDetailById");
        requestBuilder.param("id","-26");
        MvcResult result = mockmvc.perform(requestBuilder).andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    @Transactional
    public void INTER_001_GUDBIDC_001_04() throws Exception{
        //get_user_by_id_case4
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/getUserDetailById");
        try{
            MvcResult result = mockmvc.perform(requestBuilder).andReturn();
            String content = result.getResponse().getContentAsString();
            System.out.println(content);
        }catch (Exception e){
            System.out.println("failed to send request");
        }
    }

    @Test
    @Transactional
    public  void INTER_001_DLOC_001_01() throws Exception {
        //do_logout_case1
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/doLogout");
        User user = new User();
        user.setId(1);
        user.setRole(0);
        user.setName("小明");
        user.setNickName("明小");
        user.setEmail("1234@qq.com");
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("currentUser", user);
        requestBuilder.session(session);
        MvcResult result = mockmvc.perform(requestBuilder).andReturn();
        assertEquals(302,result.getResponse().getStatus());
    }
}