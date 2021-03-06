package rabbitry;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import user.User;

/**
 * Luokka tarjoaa kanien tietojen ylläpitoa ja tietojen noutoa. 
 */
public class Rabbit {
    private String name;
    private String breed;
    private String sex;
    private LocalDate birthdate;
    private String father;
    private String mother;
    private String fathersfather;
    private String fathersmother;
    private String mothersfather;
    private String mothersmother;
    private User user;
    private List<String> family;
    
    public Rabbit(String name, String breed, String sex, LocalDate birthdate, 
            String father, String mother, String fathersfather, 
            String fathersmother, String mothersfather, String mothersmother, 
            User user) {
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.birthdate = birthdate;
        this.father = father;
        this.mother = mother;
        this.fathersfather = fathersfather;
        this.fathersmother = fathersmother;
        this.mothersfather = mothersfather;
        this.mothersmother = mothersmother;
        this.user = user;
        this.family = new ArrayList<>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getBreed() {
        return this.breed;
    }
    
    public String getSex() {
        return this.sex;
    }
    
    public LocalDate getBirthDate() {
        return this.birthdate;
    }
    
    public Period getAge() {
        LocalDate today = LocalDate.now();
        Period age = Period.between(this.birthdate, today);
        return age;
    }
    
    public String getFather() {
        return this.father;
    }
    
    public String getMother() {
        return this.mother;
    }
    
    public String getFathersFather() {
        return this.fathersfather;
    }
    
    public String getFathersMother() {
        return this.fathersmother;
    }
    
    public String getMothersFather() {
        return this.mothersfather;
    }
    
    public String getMothersMother() {
        return this.mothersmother;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public List<String> getFamily() {
        family.add(getFather());
        family.add(getMother());
        family.add(getFathersFather());
        family.add(getFathersMother());
        family.add(getMothersFather());
        family.add(getMothersMother());
        return family;
    }
    
    /**
    * Metodin avulla voidaan tarkistaa, onko kaksi kania toisilleen sukua. 
     * @param rabbit
     * @return 
    */
    public boolean isRelated(Rabbit rabbit) {
        getFamily();
        if (family.contains(rabbit.getFather())) {
            return true;
        } else if (family.contains(rabbit.getMother())) {
            return true;
        } else if (family.contains(rabbit.getFathersFather())) {
            return true;
        } else if (family.contains(rabbit.getFathersMother())) {
            return true;
        } else if (family.contains(rabbit.getMothersFather())) {
            return true;
        } else if (family.contains(rabbit.getMothersMother())) {
            return true;
        } else if (family.contains(rabbit.getName())) {
            return true;
        }
        
        return false;
    }
}
