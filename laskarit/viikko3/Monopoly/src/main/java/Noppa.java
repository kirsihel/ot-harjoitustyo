
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirsi
 */
public class Noppa {
    int id;
    Pelilauta pelilauta;
    
    public void Noppa(int id, Pelilauta pelilauta){
        this.id = id;
        this.pelilauta = pelilauta;
    }
    
    public int getId(){
        return this.id;
    }
    
    public Pelilauta getBoard() {
        return this.pelilauta;
    }
    
    public int throwTheDice() {
        Random random = new Random();
        int dice = random.nextInt(6);
        return dice+1;
    }
}
