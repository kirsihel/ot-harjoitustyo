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
    SattumaJaYhteismaa sjy;
    
    public void Kortti(Toiminto toiminto, String tyyppi, SattumaJaYhteismaa sjy){
        this.toiminto = toiminto;
        this.tyyppi = tyyppi;
        this.sjy = sjy;         
    }
    
    public Toiminto getAction(){
        return this.toiminto;
    }
    
    public String getType(){
        return this.tyyppi;
    }
    
    public SattumaJaYhteismaa getChanceAndCommunityChest(){
        return this.sjy;
    }
       
}
