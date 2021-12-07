
package domain;

import java.time.LocalDate;
import java.time.Month;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import rabbitry.Breeding;
import rabbitry.Rabbit;

public class BreedingTest {
    Rabbit buck;
    Rabbit doe;
    LocalDate date; 
    Breeding breeding;
    
    @Before
    public void setUp() {
        this.buck = new Rabbit("Mystical Jolteon", "kääpiöluppa", "uros",
                LocalDate.of(2021, 4, 13), "Norbergs Viggo", "Mystical Snapchat", 
                "5441/1225", "Norbergs Belladonna", "Hiekkarinteen Ässä",
                "Harhakuvan Lumo");
        
        this.doe = new Rabbit("Hiekkarinteen Dora", "kääpiöluppa", "naaras",
                LocalDate.of(2021, 4, 29), "Kolartorpets Cumulus", 
                "Hiekkarinteen DominiQue", "Hans-Jürgen", "Kolartorpets Cornelia", 
                "Hiekkarinteen OsQ","Hiekkarinteen Dana");
        
        this.date = LocalDate.of(2020, 12, 6);
        
        this.breeding = new Breeding(this.buck, this.doe, this.date);
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
    
    
}
