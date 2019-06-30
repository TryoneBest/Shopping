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
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
public class DeleteControllerTest {
    @Autowired
    private WebApplicationContext userController;
    private MockMvc mockmvc;

    @Before
    public void setUp() throws Exception {
        mockmvc=MockMvcBuilders.webAppContextSetup(userController).build();
    }

    @Test
    public void deleteUser() {
        try{
            MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/deleteUser");
            requestBuilder.param("id", "2");
            MvcResult result=mockmvc.perform(requestBuilder).andReturn();
            String content=result.getResponse().getContentAsString();
            System.out.println(content);
        }catch (Exception e) {
            System.out.println("Delete failed!");
        }
    }
}