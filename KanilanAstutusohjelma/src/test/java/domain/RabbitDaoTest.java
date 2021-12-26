/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dao.RabbitDao;
import dao.UserDao;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rabbitry.Rabbit;
import user.User;

/**
 *
 * @author Kirsi
 */
public class RabbitDaoTest {
    RabbitDao rabbitdao;
    UserDao userdao;
    
    @Before
    public void init() throws Exception {
        userdao = new UserDao("userfiletest.txt");
        rabbitdao = new RabbitDao("rabbitfiletest.txt",userdao);
    }
    
    @Test
    public void findRabbit() throws Exception {
        User user = new User("kirsihel","Mystical","F131");
        Rabbit rabbit = new Rabbit("Mystical Jolteon", "kääpiöluppa", "uros",
                LocalDate.of(2021, 4, 13), "Norbergs Viggo", "Mystical Snapchat", 
                "5441/1225", "Norbergs Belladonna", "Hiekkarinteen Ässä",
                "Harhakuvan Lumo", user);
        rabbitdao.create(rabbit);
        assertEquals(rabbitdao.find("Mystical Jolteon").getName(),rabbit.getName());
    }
    
    @Test
    public void getRabbits() throws Exception {
        User user = new User("kirsihel","Mystical","F131");
        Rabbit rabbit = new Rabbit("Mystical Jolteon", "kääpiöluppa", "uros",
                LocalDate.of(2021, 4, 13), "Norbergs Viggo", "Mystical Snapchat", 
                "5441/1225", "Norbergs Belladonna", "Hiekkarinteen Ässä",
                "Harhakuvan Lumo", user);
        List<Rabbit> rabbits = rabbitdao.getRabbits();
        assertEquals(rabbits.get(0).getName(),rabbit.getName());
    }  
}
