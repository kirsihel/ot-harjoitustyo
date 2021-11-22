/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirsi
 */
public class Ruutu {
    int numero;
    int seuraava_ruutu;
    Pelilauta pelilauta;
    Toiminto toiminto;
    
    public void Ruutu(int numero, int seuraava, Pelilauta pelilauta, Toiminto toiminto){
        this.numero = numero;
        this.seuraava_ruutu = seuraava;
        this.pelilauta = pelilauta;
        this.toiminto = toiminto;
    }
    
    public int getNumber() {
        return this.numero;
    }
    
    public int getNext() {
        return this.seuraava_ruutu;
    }
    
    public Pelilauta getBoard() {
        return this.pelilauta;
    }
    
    public Toiminto getAction() {
        return this.toiminto;
    }
}
