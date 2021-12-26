/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.time.LocalDate;
import java.util.List;
import rabbitry.Breeding;
import user.User;

/**
 *
 * @author Kirsi
 */
public interface DaoBreeding {
    
    Breeding create(Breeding breeding) throws Exception;
    
    void setDone(int id) throws Exception;
    
    List<Breeding> getBreedings();
}
