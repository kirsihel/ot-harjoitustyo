/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import rabbitry.Rabbit;
import user.User;

/**
 *
 * @author Kirsi
 */
public interface DaoRabbit {
    Rabbit create(Rabbit rabbit) throws Exception;
    
    Rabbit find(String name) throws Exception;
    
    List<Rabbit> getRabbits();
}
