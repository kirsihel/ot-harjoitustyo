/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.BreedingDao;
import dao.RabbitDao;
import dao.UserDao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import rabbitry.Breeding;
import rabbitry.Rabbit;
import user.User;

/**
 *
 * @author Kirsi
 */
public class Service {
    private UserDao userdao;
    private RabbitDao rabbitdao;
    private BreedingDao breedingdao;
    private User loggedin;
    
    public Service(UserDao userdao, RabbitDao rabbitdao, BreedingDao breedingdao) {
        this.userdao = userdao;
        this.rabbitdao = rabbitdao;
        this.breedingdao = breedingdao;
    }
    
    public boolean createUser(String username, String rabbitryname, String breederid) {
        if (userdao.find(username) != null) {
            return false;
        }
        User user = new User(username, rabbitryname, breederid);
        try {
            userdao.create(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean logIn(String username) {
        User user = userdao.find(username);
        if (user == null) {
            return false;
        }
        loggedin = user;
        return true;
    }
    
    public void markDone(int id) {
        try {
            breedingdao.setDone(id);
        } catch (Exception ex) {
        }
    }
    
    public List<Breeding> getUndone() {
        if (loggedin == null) {
            return new ArrayList<>();
        }
          
        return breedingdao.getBreedings()
            .stream()
            .filter(breeding-> breeding.getUser().equals(loggedin))
            .filter(breeding->!breeding.getDone())
            .collect(Collectors.toList());
    }
    
    public boolean createBreeding(String info) {
        String[] words = info.split(";");
        Rabbit buck = rabbitdao.getRabbits().stream().filter(r->r.getName().equals(words[0])).findFirst().orElse(null);
        Rabbit doe = rabbitdao.getRabbits().stream().filter(r->r.getName().equals(words[1])).findFirst().orElse(null);
        Breeding breeding = new Breeding(buck, doe, LocalDate.parse(words[2]), loggedin);
        try {   
            breedingdao.create(breeding);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    
    public boolean createRabbit(String name, String breed, String sex, LocalDate birthdate, 
            String father, String mother, String fathersfather, 
            String fathersmother, String mothersfather, String mothersmother, 
            User user) {
        if (rabbitdao.find(name) != null) {
            return false;
        }
        Rabbit rabbit = new Rabbit(name, breed, sex, birthdate, father, mother, 
                fathersfather, fathersmother, mothersfather, mothersmother, user);
        try {
            rabbitdao.create(rabbit);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public User getUser(String username) {
        return userdao.find(username);
    }
    
    public Rabbit getRabbit(String name) {
        return rabbitdao.find(name);
    }
    
    public List<Rabbit> getRabbits() {
        return rabbitdao.getRabbits();
    }
    
}
