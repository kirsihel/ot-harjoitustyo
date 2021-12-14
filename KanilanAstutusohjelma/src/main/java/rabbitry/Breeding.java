package rabbitry;

import java.time.LocalDate;

/**
* Luokka tarjoaa astutuksien tietojen ylläpitoa ja tietojen noutoa. 
*/
public class Breeding {
    Rabbit buck;
    Rabbit doe;
    LocalDate date;
    
    public Breeding(Rabbit buck, Rabbit doe, LocalDate date) {
        this.buck = buck;
        this.doe = doe;
        this.date = date;
    }
    
    public Rabbit getBuck() {
        return this.buck;
    }
    
    public Rabbit getDoe() {
        return this.doe;
    }
    
    public LocalDate getDate() {
        return this.date;
    }
}
