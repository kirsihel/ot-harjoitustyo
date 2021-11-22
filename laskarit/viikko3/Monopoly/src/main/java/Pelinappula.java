/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirsi
 */
public class Pelinappula {
    String nimi;
    Ruutu ruutu;
    Pelilauta pelilauta;
    Pelaaja pelaaja;
    
    public void Ruutu(String nimi, Ruutu ruutu, Pelilauta lauta, Pelaaja pelaaja) {
        this.nimi = nimi;
        this.ruutu = ruutu;
        this.pelilauta = lauta;
        this.pelaaja = pelaaja;
    }
    
    public String getName() {
        return this.nimi;
    }
    
    public Ruutu getSpace() {
        return this.ruutu;
    }
    
    public void setSpace(Ruutu ruutu) {
        this.ruutu = ruutu;
    }
    
    public Pelilauta getPelilauta(){
        return this.pelilauta;
    }
    
    public Pelaaja getPlayer(){
        return this.pelaaja;
    }
}
