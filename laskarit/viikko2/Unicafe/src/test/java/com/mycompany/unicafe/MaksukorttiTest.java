package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoOikein() {
        assertTrue(kortti.saldo()==10);
    }
    
    @Test
    public void saldoKasvaaOikein() {
        kortti.lataaRahaa(10);
        assertTrue(kortti.saldo()==20);
    }
    
    @Test
    public void saldoEiMuutuJosEiRahaa() {
        kortti.otaRahaa(15);
        assertTrue(kortti.saldo()==10);
    }
    @Test
    public void saldoVaheneeOikein() {
        kortti.otaRahaa(5);
        assertTrue(kortti.saldo()==5);
    }
    
    @Test
    public void riittaakoRahat() {
        assertTrue(kortti.otaRahaa(20)==false);
        assertTrue(kortti.otaRahaa(5)==true);
    }
    
    @Test
    public void Tuloste() {
        assertEquals("saldo: 0.10",kortti.toString());
    } 
}
