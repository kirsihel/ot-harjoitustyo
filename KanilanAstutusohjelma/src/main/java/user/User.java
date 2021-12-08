
package user;

public class User {
   
    String username;
    String rabbitryname;
    String breederid;
    Integer id;
    
    public User(String username) {
        this.username = username;
        this.rabbitryname = null;
        this.breederid = null;

    }
    
    public void setRabbitryName(String name) {
        this.rabbitryname = name;
    }
    
    public void setBreederId(String id) {
        this.breederid = id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getRabbitryName() {
        return this.rabbitryname;
    }
    
    public String getBreederId() {
        return this.breederid;
    } 
}
