/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import user.User;

/**
 *
 * @author Kirsi
 */
public interface DaoUser {
    
    User create(User user) throws Exception;
    
    User find(String username) throws Exception;
    
    List<User> getUsers();
        
}
