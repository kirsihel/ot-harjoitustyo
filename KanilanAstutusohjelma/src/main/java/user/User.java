
package user;

public class User {
   
    String username;
    String rabbitryname;
    String breederid;
    Integer id;
    
    public User(String username, String rabbitryname, String breederid) {
        this.username = username;
        this.rabbitryname = rabbitryname;
        this.breederid = breederid;

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
