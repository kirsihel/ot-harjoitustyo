/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirsi
 */
public class Vankila {
    Ruutu ruutu;
    Integer sijainti;
    
    public void Vankila(int sijainti, Ruutu ruutu){
        this.sijainti = sijainti;
        this.ruutu = ruutu;
    }
    
    public Ruutu getSpace(){
        return this.ruutu;
    }
    
    public int getLocation(){
        return this.sijainti;
    }
}
