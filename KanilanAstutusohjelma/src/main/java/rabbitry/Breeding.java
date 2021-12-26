package rabbitry;

import java.time.LocalDate;
import user.User;

/**
* Luokka tarjoaa astutuksien tietojen ylläpitoa ja tietojen noutoa. 
*/
public class Breeding {
    Rabbit buck;
    Rabbit doe;
    LocalDate date;
    int id;
    User user;
    Boolean done;
    
    public Breeding(Integer id, Rabbit buck, Rabbit doe, LocalDate date, Boolean done, User user) {
        this.id = id;
        this.buck = buck;
        this.doe = doe;
        this.date = date;
        this.user = user;
        this.done = done;
    }
    
    /**
     *
     * @param buck
     * @param doe
     * @param date
     * @param user
     */
    public Breeding(Rabbit buck, Rabbit doe, LocalDate date, User user) {
        this.buck = buck;
        this.doe = doe;
        this.date = date;
        this.user = user;
        this.done = false;
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
    
    public Integer getId() {
        return this.id;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public Boolean getDone() {
        return this.done;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setDone() {
        this.done = true;
    }
}
