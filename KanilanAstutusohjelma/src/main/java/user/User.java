
package user;

public class User {
   
    String username;
    String rabbitry_name;
    String breeder_id;
    
    public User(String username){
        this.username = username;
        this.rabbitry_name = null;
        this.breeder_id = null;
    }
    
    public void setRabbitryName(String name){
        this.rabbitry_name = name;
    }
    
    public void setBreederId(String id){
        this.breeder_id = id;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getRabbitryName(){
        return this.rabbitry_name;
    }
    
    public String getBreederId(){
        return this.breeder_id;
    }
    
}
