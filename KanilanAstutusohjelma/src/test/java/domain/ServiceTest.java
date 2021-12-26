/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dao.BreedingDao;
import dao.RabbitDao;
import dao.UserDao;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rabbitry.Breeding;
import rabbitry.Rabbit;
import service.Service;
import user.User;

/**
 *
 * @author Kirsi
 */
public class ServiceTest {
    RabbitDao rabbitdao;
    UserDao userdao;
    BreedingDao breedingdao;
    User user;
    Rabbit buck;
    Rabbit doe;
    LocalDate date;
    Breeding breeding;
    Service service;
    
    @Before
    public void setUp() throws Exception {
    userdao = new UserDao("userfiletest.txt");
    rabbitdao = new RabbitDao("rabbitfiletest.txt",userdao);
    breedingdao = new BreedingDao("breedingdaotest.txt", userdao, rabbitdao);
    user = new User("kirsihel","Mystical","F131");
        
    buck = new Rabbit("Mystical Jolteon", "kääpiöluppa", "uros",
            LocalDate.of(2021, 4, 13), "Norbergs Viggo", "Mystical Snapchat", 
            "5441/1225", "Norbergs Belladonna", "Hiekkarinteen Ässä",
            "Harhakuvan Lumo", user);

    doe = new Rabbit("Hiekkarinteen Dora", "kääpiöluppa", "naaras",
            LocalDate.of(2021, 4, 29), "Kolartorpets Cumulus", 
            "Hiekkarinteen DominiQue", "Hans-Jürgen", "Kolartorpets Cornelia", 
            "Hiekkarinteen OsQ","Hiekkarinteen Dana", user);

    date = LocalDate.of(2020, 12, 6);

    breeding = new Breeding(1, buck, doe, date, false, user);
    rabbitdao.create(buck);
    rabbitdao.create(doe);
    userdao.create(user);
    breedingdao.create(breeding);
    service = new Service(userdao, rabbitdao, breedingdao);
    }
    
    @Test
    public void getRabbits() {
        assertEquals(service.createRabbit("Mystical Jolteon", "kääpiöluppa", "uros",
            LocalDate.of(2021, 4, 13), "Norbergs Viggo", "Mystical Snapchat", 
            "5441/1225", "Norbergs Belladonna", "Hiekkarinteen Ässä",
            "Harhakuvan Lumo", user),false);
        assertEquals(service.getRabbits().get(0).getName(), "Mystical Jolteon");
        assertEquals(service.getRabbit("Mystical Jolteon").getName(), "Mystical Jolteon");
    }
    
    @Test
    public void getUsers() {
        service.createUser("kirsihel","Mystical","F131");
        assertEquals(service.getUser("kirsihel").getUsername(), "kirsihel");
    }
    
    @Test
    public void loggedIn() {
        assertEquals(service.logIn("kirsihel"),true);
        assertEquals(service.logIn("abc"),false);
    }
    
    @Test
    public void createBreeding() {
        assertEquals(breeding.getDoe().getName() + ";" + breeding.getBuck().getName() + ";" + breeding.getDate().toString(), "Hiekkarinteen Dora;Mystical Jolteon;2020-12-06");
    }
}
