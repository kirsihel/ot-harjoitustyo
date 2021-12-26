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
    User user;
    
    @Before
    public void setUp() {
        family = new ArrayList<>();
        this.user = new User("kirsihel","Mystical","F131");
        this.rabbit = new Rabbit("Mystical Jolteon", "kääpiöluppa", "uros",
                LocalDate.of(2021, 4, 13), "Norbergs Viggo", "Mystical Snapchat", 
                "5441/1225", "Norbergs Belladonna", "Hiekkarinteen Ässä",
                "Harhakuvan Lumo", user);
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
    public void getBirthDate() {
        assertEquals(this.rabbit.getBirthDate(),LocalDate.of(2021, 4, 13));
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
        
        Rabbit ametisti = new Rabbit("Mystical Amethyst", "kääpiöluppa", "naaras",
                LocalDate.of(2019, 12, 28), "Mystical One Sweet World", 
                "Hiekkarinteen Rebecca", "Töminän Oboy", "Harhakuvan Lumo", 
                "Hiekkarinteen Iisak","Hiekkarinteen Dolly", user);
        
        Rabbit panda = new Rabbit("Mystical Kung Fu Panda", "kääpiöluppa", "naaras",
                LocalDate.of(2020, 9, 10), "Töminän Walkopippuri", "Mystical Venus", 
                "Töminän Xiirappilaivos", "Töminän Uuniomena", "Hiekkarinteen Ässä",
                "Mystical Peanut Butter Cup", user);
        
        Rabbit lumo = new Rabbit("Harhakuvan Lumo", "kääpiöluppa", "naaras",
                LocalDate.of(2016, 6, 17), "Hiekkarinteen Edi", "Harhakuvan Brianna", 
                "Honey Bunny's Theilon", "Betty", "Vihervaaran Bart",
                "Olivianan Opintopiste", user);
        
        Rabbit same = new Rabbit("Mystical Jolteon", "kääpiöluppa", "uros",
                LocalDate.of(2021, 4, 13), "Norbergs Viggo", "Mystical Snapchat", 
                "5441/1225", "Norbergs Belladonna", "Hiekkarinteen Ässä",
                "Harhakuvan Lumo", user);
        
        Rabbit uuno = new Rabbit("Mystical One Sweet World", "kääpiöluppa", "uros",
                LocalDate.of(2018, 2, 6), "Töminän Oboy", "Harhakuvan Lumo", 
                "Töminän Vaniljahippu", "Töminän Omaherkku", "Hiekkarinteen Edi",
                "Harhakuvan Brianna", user);
        
        Rabbit x = new Rabbit("A", "kääpiöluppa", "uros",
                LocalDate.of(2018, 2, 6), "B", "C", 
                "D", "E", "F",
                "Harhakuvan Lumo", user);
        
        assertEquals(this.rabbit.isRelated(panda),true);
        assertEquals(this.rabbit.isRelated(lumo),true);
        assertEquals(this.rabbit.isRelated(same),true);
        assertEquals(uuno.isRelated(ametisti),true);
        assertEquals(this.rabbit.isRelated(ametisti),true);
        assertEquals(this.rabbit.isRelated(x),true);
    }
    @Test
    public void getUser() {
        assertEquals(this.rabbit.getUser().getUsername(),"kirsihel");
    }
    
    
}
