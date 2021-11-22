/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirsi
 */
public class Pelaaja {
    String nimi;
    Pelinappula pelinappula;
    int rahaa;
    
    public void Pelaaja(String nimi, Pelinappula nappula, int rahaa){
        this.nimi = nimi;
        this.pelinappula = nappula;
        this.rahaa = rahaa;
    }
    
    public String getName(){
        return this.nimi;
    }
    
    public Pelinappula getToken(){
        return this.pelinappula;
    }
    
    public void setMoney(int sum) {
        this.rahaa = sum;
    }
}
