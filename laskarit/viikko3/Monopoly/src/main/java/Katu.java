/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirsi
 */
public class Katu {
    String nimi;
    Pelaaja pelaaja;
    Ruutu ruutu;
    int taloja;
    int hotelleja;
    
    public void Katu(String nimi, Pelaaja pelaaja, Ruutu ruutu){
        this.nimi = nimi;
        this.pelaaja = pelaaja;
        this.ruutu = ruutu;
    }
    
    public void setHotelli(){
        this.hotelleja = 1;
    }
    
    public void setTaloja(){
        if(taloja < 4){
            this.taloja++;
        }
    }
    
    public Integer getHotels(){
        return this.hotelleja;
    }
    
    public Integer getHouses(){
        return this.taloja;
    }
    
    public String getName(){
        return this.nimi;
    }
    
    public Pelaaja getPlayer(){
        return this.pelaaja;
    }
    
    public Ruutu getSpace(){
        return this.ruutu;
    }
}
