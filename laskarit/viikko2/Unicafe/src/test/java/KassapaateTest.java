package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kirsi
 */
public class KassapaateTest {
    Kassapaate kassapaate;
    Maksukortti maksukortti;
    
    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        maksukortti = new Maksukortti(1000);
    }
    
    @Test
    public void rahatJaMyydytOikein() {
        assertTrue(kassapaate.kassassaRahaa()==100000);
        assertTrue(kassapaate.edullisiaLounaitaMyyty()==0);
        assertTrue(kassapaate.maukkaitaLounaitaMyyty()==0);
    }
    
    @Test
    public void rahamaaraKasvaaOikein() {
        kassapaate.syoEdullisesti(300);
        assertTrue(kassapaate.kassassaRahaa()==100240);
        kassapaate.syoMaukkaasti(500);
        assertTrue(kassapaate.kassassaRahaa()==100640);     
    }
    
    @Test
    public void myytyjenLounaidenMaaraKasvaa() {
        kassapaate.syoEdullisesti(300);
        assertTrue(kassapaate.edullisiaLounaitaMyyty()==1);
        kassapaate.syoMaukkaasti(500);
        assertTrue(kassapaate.maukkaitaLounaitaMyyty()==1); 
    }
    
    @Test
    public void josMaksuEiRiitä() {
        kassapaate.syoEdullisesti(200);
        assertTrue(kassapaate.kassassaRahaa()==100000);
        assertTrue(kassapaate.edullisiaLounaitaMyyty()==0);
        kassapaate.syoMaukkaasti(100);
        assertTrue(kassapaate.kassassaRahaa()==100000);
        assertTrue(kassapaate.maukkaitaLounaitaMyyty()==0);
    }
    
    @Test
    public void maksuToimii() {
        assertTrue(kassapaate.syoEdullisesti(maksukortti)==true);
        assertTrue(maksukortti.saldo()==760);
        assertTrue(kassapaate.syoMaukkaasti(maksukortti)==true);
        assertTrue(maksukortti.saldo()==360);
    }  
    
    @Test
    public void lounaidenMaaraKasvaa() {
        kassapaate.syoEdullisesti(maksukortti);
        assertTrue(kassapaate.edullisiaLounaitaMyyty()==1);
        kassapaate.syoMaukkaasti(maksukortti);
        assertTrue(kassapaate.maukkaitaLounaitaMyyty()==1);
    }
    
    @Test
    public void josEiTarpeeksiRahaa() {
        kassapaate.syoMaukkaasti(maksukortti);
        kassapaate.syoMaukkaasti(maksukortti);
        assertTrue(kassapaate.syoEdullisesti(maksukortti)==false);
        assertTrue(kassapaate.syoMaukkaasti(maksukortti)==false);
        assertTrue(maksukortti.saldo()==200);
        assertTrue(kassapaate.edullisiaLounaitaMyyty()==0);
        assertTrue(kassapaate.maukkaitaLounaitaMyyty()==2);   
    }
    
    @Test
    public void kassaEiMuutuKortilla() {
        kassapaate.syoMaukkaasti(maksukortti);
        kassapaate.syoEdullisesti(maksukortti);
        assertTrue(kassapaate.kassassaRahaa()==100000);
    }
    
    @Test
    public void rahanLataaminenToimii() {
        kassapaate.lataaRahaaKortille(maksukortti, 100);
        assertTrue(maksukortti.saldo()==1100);
        assertTrue(kassapaate.kassassaRahaa()==100100);
        kassapaate.lataaRahaaKortille(maksukortti, -100);
        assertTrue(maksukortti.saldo()==1100);
        assertTrue(kassapaate.kassassaRahaa()==100100);
        
    }
}
