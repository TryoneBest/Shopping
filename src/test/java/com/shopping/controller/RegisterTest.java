package com.shopping.controller;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
public class RegisterTest {
    @Autowired
    private WebApplicationContext userController;
    private MockMvc mockmvc;
    @Before
    public void setUp() throws Exception {
        mockmvc=MockMvcBuilders.webAppContextSetup(userController).build();
    }
    @Test
    @Transactional
    public void doRegisterTest() throws Exception {
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/doRegister");
        requestBuilder.param("userName","111111111111111111111111111111")
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
        System.out.println(content);
    }
}