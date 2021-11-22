/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirsi
 */
public class Kortti {
    Toiminto toiminto;
    String tyyppi;
    
    public void Kortti(Toiminto toiminto, String tyyppi){
        this.toiminto = toiminto;
        this.tyyppi = tyyppi;       
    }
    
    public Toiminto getAction(){
        return this.toiminto;
    }
    
    public String getType(){
        return this.tyyppi;
    }      
}
