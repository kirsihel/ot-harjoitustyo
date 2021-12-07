
package domain;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import user.User;

public class UserTest {
    List<User> users;
    
    @Before
    public void setUp() {
        users = new ArrayList<>();
    }
    
    @Test
    public void noUsers(){
        assertTrue(users.isEmpty());
    }
    
    @Test
    public void getUser(){
        User user = new User(1,"kirsihel","Mystical","F131");
        users.add(user);
        assertEquals(users.get(0).getUsername(),"kirsihel");
    }
    
    @Test
    public void setRabbitryName() {
        User user = new User(1,"kirsihel","Mystical","F131");
        User second = new User(2,"user",null,null);
        user.setRabbitryName("Mystical");
        users.add(user);
        users.add(second);
        assertEquals(users.get(0).getRabbitryName(),"Mystical");
        assertEquals(users.get(1).getRabbitryName(),null);
    }
    
    @Test
    public void setBreederId() {
        User user = new User(1,"kirsihel","Mystical","F131");
        User second = new User(2,"user",null,null);
        user.setBreederId("F131");
        users.add(user);
        users.add(second);
        assertEquals(users.get(0).getBreederId(),"F131");
        assertEquals(users.get(1).getBreederId(),null);
    }
}
