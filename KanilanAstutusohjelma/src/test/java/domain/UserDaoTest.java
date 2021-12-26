/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dao.UserDao;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import service.Service;
import user.User;

/**
 *
 * @author Kirsi
 */
public class UserDaoTest {
    UserDao userdao;
    
    @Before
    public void init() throws Exception {
        userdao = new UserDao("userfiletest.txt");
    }
    
    @Test
    public void findUser() throws Exception {
        User user = new User("kirsihel","Mystical","F131");
        userdao.create(user);
        assertEquals(userdao.find("kirsihel").getUsername(),user.getUsername());
    }
    
    @Test
    public void getUsers() throws Exception {
        User user = new User("kirsihel","Mystical","F131");
        List<User> users = userdao.getUsers();
        assertEquals(users.get(0).getUsername(),user.getUsername());
    }    
}
