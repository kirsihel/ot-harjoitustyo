/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.BreedingDao;
import dao.RabbitDao;
import dao.UserDao;
import user.User;

/**
 *
 * @author Kirsi
 */
public class Service {
    private UserDao userdao;
    private User loggedin;
    
    public Service(UserDao userdao) {
        this.userdao = userdao;
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
    
}
