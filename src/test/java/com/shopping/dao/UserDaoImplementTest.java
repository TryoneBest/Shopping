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
    public void init() {

    }

    @Test
    public void BACK_001_GUD_001_01() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        int id = -3;
        try {
            assertNull(userDao.getUser(id));
            System.out.println("failed");
        } catch (AssertionError a) {
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_GUD_001_02() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        int id = 44;
        try {
            assertNull(userDao.getUser(id));
            System.out.println("failed");
        } catch (AssertionError a) {
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_GUD_001_03() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        int id = 1;
        try {
            assertNull(userDao.getUser(id));
            System.out.println("failed");
        } catch (AssertionError a) {
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_GUD_002_01() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        String nameOrEmail = "小明";
        try {
            assertNull(userDao.getUser(nameOrEmail));
            System.out.println("failed");
        } catch (AssertionError a) {
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_GUD_002_02() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        String nameOrEmail = "李老";
        try {
            assertNull(userDao.getUser(nameOrEmail));
            System.out.println("failed");
        } catch (AssertionError a) {
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_GUD_002_03() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        String nameOrEmail = null;
        try {
            assertNull(userDao.getUser(nameOrEmail));
            System.out.println("failed");
        } catch (AssertionError a) {
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_AUD_001_01() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        User user = new User(7, "Anny", "166.163.com", "flow", 4);
        try {
            assertFalse(userDao.addUser(user));
            System.out.println("failed");
        } catch (AssertionError a) {
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_AUD_001_02() {
        User user = new User(9, "小明", "1234@163.com", "明小", 4);
        try {
            assertFalse(userDao.addUser(user));
            System.out.println("failed");
        } catch (AssertionError a) {
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_AUD_001_03() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        User user = new User(8, null, null, "bido", 3);
        try {
            assertFalse(userDao.addUser(user));
            System.out.println("failed");
        } catch (AssertionError a) {
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_DUD_001_01() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        int id = -3;
        try {
            assertFalse(userDao.deleteUser(id));
            System.out.println("failed");
        } catch (AssertionError a) {
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_DUD_001_02() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        int id = 33;
        try {
            assertFalse(userDao.deleteUser(id));
            System.out.println("failed");
        } catch (AssertionError a) {
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_DUD_001_03() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        int id = 6;
        try {
            assertTrue(userDao.deleteUser(id));
            System.out.println("success");
        } catch (Exception a) {
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_DUD_001_04() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        int id = 5;
        try {
            assertTrue(userDao.deleteUser(id));
            System.out.println("success");
        } catch (Exception a) {
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_UUD_001_01() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        User user = new User(5, null, "163.com", "nick", 4);
        try {
            assertTrue(userDao.updateUser(user));
            System.out.println("success");
        } catch (Exception a) {
            System.out.println("failed");
        }
    }

    @Test
    public void BACK_001_UUD_001_02() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        User user = new User(-3, "aiyu", "1.com", "bi", -4);
        try {
            assertFalse(userDao.updateUser(user));
            System.out.println("failed");
        } catch (AssertionError a) {
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_UUD_001_03() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        User user = new User(1, "小明", "3.com", "link", 4);
        try {
            assertFalse(userDao.updateUser(user));
            System.out.println("failed");
        } catch (AssertionError a) {
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_UUD_001_04() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        User user = new User(1, "小刚", "4321@qq.com", "徐小", 4);
        try {
            assertFalse(userDao.updateUser(user));
            System.out.println("failed");
        } catch (AssertionError a) {
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_GAUD_001_01() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        try {
            assertNull(userDao.getAllUser());
            System.out.println("failed");
        } catch (AssertionError a) {
            System.out.println("success");
        }
    }

    @Test
    public void BACK_001_GAUD_001_02() {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        try {
            assertNull(userDao.getAllUser());
            System.out.println("failed");
        } catch (AssertionError a) {
            System.out.println("success");
        }
    }
}