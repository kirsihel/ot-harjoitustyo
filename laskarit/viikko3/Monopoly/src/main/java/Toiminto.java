/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirsi
 */
public class Toiminto {
    String nimi;
    
    public void Toiminto(String nimi){
        this.nimi = nimi;
    }
    
    public String getName(){
        return this.nimi;
    }
}
