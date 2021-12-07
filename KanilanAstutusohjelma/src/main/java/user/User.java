
package user;

public class User {
   
    String username;
    String rabbitryname;
    String breederid;
    Integer id;
    
    public User(Integer id, String username, String rabbitryname, String bnreederid) {
        this.username = username;
        this.rabbitryname = rabbitryname;
        this.breederid = breederid;
        this.id = null;
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
    
    public void setId(Integer id) {
        this.id = id;
    }  
    
    public Integer getId() {
        return this.id;
    }
    
}
