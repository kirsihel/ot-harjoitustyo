
package domain;

import java.time.LocalDate;
import java.time.Month;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import rabbitry.Breeding;
import rabbitry.Rabbit;
import user.User;

public class BreedingTest {
    Rabbit buck;
    Rabbit doe;
    LocalDate date; 
    Breeding breeding;
    
    @Before
    public void setUp() {
        User user = new User("kirsihel","Mystical","F131");
        
        this.buck = new Rabbit("Mystical Jolteon", "kääpiöluppa", "uros",
                LocalDate.of(2021, 4, 13), "Norbergs Viggo", "Mystical Snapchat", 
                "5441/1225", "Norbergs Belladonna", "Hiekkarinteen Ässä",
                "Harhakuvan Lumo", user);
        
        this.doe = new Rabbit("Hiekkarinteen Dora", "kääpiöluppa", "naaras",
                LocalDate.of(2021, 4, 29), "Kolartorpets Cumulus", 
                "Hiekkarinteen DominiQue", "Hans-Jürgen", "Kolartorpets Cornelia", 
                "Hiekkarinteen OsQ","Hiekkarinteen Dana", user);
        
        this.date = LocalDate.of(2020, 12, 6);
        
        this.breeding = new Breeding(1, this.buck, this.doe, this.date, false, user);
    }
    
    @Test
    public void getBuck(){
        assertEquals(this.breeding.getBuck().getName(),"Mystical Jolteon");
    }
    
    @Test
    public void getDoe(){
        assertEquals(this.breeding.getDoe().getName(),"Hiekkarinteen Dora");
    }
    
    @Test
    public void getDate(){
        assertEquals(this.breeding.getDate(),LocalDate.of(2020, Month.DECEMBER, 6));
    }
    
    @Test
    public void getDone() {
        this.breeding.setDone();
        assertEquals(this.breeding.getDone(),true);
    }
    
    @Test
    public void getUser() {
        assertEquals(this.breeding.getUser().getUsername(),"kirsihel");
    }
    
    @Test 
    public void getId() {
        this.breeding.setId(2);
        assertEquals(this.breeding.getId().toString(),"2");
    }
}
