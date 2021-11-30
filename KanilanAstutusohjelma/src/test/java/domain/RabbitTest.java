package domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import rabbitry.Rabbit;
import user.User;


public class RabbitTest {
    List<Rabbit> family;
    Rabbit rabbit;
    
    @Before
    public void setUp() {
        family = new ArrayList<>();
        this.rabbit = new Rabbit("Mystical Jolteon", "kääpiöluppa", "uros",
                LocalDate.of(2021, 4, 13), "Norbergs Viggo", "Mystical Snapchat", 
                "5441/1225", "Norbergs Belladonna", "Hiekkarinteen Ässä",
                "Harhakuvan Lumo");
    }
    
    @Test
    public void getName(){
        assertEquals(this.rabbit.getName(),"Mystical Jolteon");
    }
    
    @Test
    public void getBreed(){
        assertEquals(this.rabbit.getBreed(),"kääpiöluppa");
    }
    
    @Test
    public void getSex(){
        assertEquals(this.rabbit.getSex(),"uros");
    }
    
    @Test
    public void getAge(){
        assertEquals(this.rabbit.getAge(),Period.between(LocalDate.of(2021, 4, 13),LocalDate.now()));
    }
    
    @Test
    public void getFather(){
        assertEquals(this.rabbit.getFather(),"Norbergs Viggo");
    }
    
    @Test
    public void getMother(){
        assertEquals(this.rabbit.getMother(),"Mystical Snapchat");
    }
    
    @Test
    public void getFathersFather(){
        assertEquals(this.rabbit.getFathersFather(),"5441/1225");
    }
    
    @Test
    public void getFathersMother(){
        assertEquals(this.rabbit.getFathersMother(),"Norbergs Belladonna");
    }
    
    @Test
    public void getMothersFather(){
        assertEquals(this.rabbit.getMothersFather(),"Hiekkarinteen Ässä");
    }
    
    @Test
    public void getMothersMother(){
        assertEquals(this.rabbit.getMothersMother(),"Harhakuvan Lumo");
    }
    
    @Test
    public void isRelated(){
        Rabbit dora = new Rabbit("Hiekkarinteen Dora", "kääpiöluppa", "naaras",
                LocalDate.of(2021, 4, 29), "Kolartorpets Cumulus", 
                "Hiekkarinteen DominiQue", "Hans-Jürgen", "Kolartorpets Cornelia", 
                "Hiekkarinteen OsQ","Hiekkarinteen Dana");
        
        Rabbit panda = new Rabbit("Mystical Kung Fu Panda", "kääpiöluppa", "naaras",
                LocalDate.of(2020, 9, 10), "Töminän Walkopippuri", "Mystical Venus", 
                "Töminän Xiirappilaivos", "Töminän Uuniomena", "Hiekkarinteen Ässä",
                "Mystical Peanut Butter Cup");
        
        assertEquals(this.rabbit.isRelated(dora),false);
        assertEquals(this.rabbit.isRelated(panda),true);
    }
    
    
    
}
