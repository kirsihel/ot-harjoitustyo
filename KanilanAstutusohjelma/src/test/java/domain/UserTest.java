
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
        User user = new User("kirsihel","Mystical","F131");
        users.add(user);
        assertEquals(users.get(0).getUsername(),"kirsihel");
        assertEquals(users.get(0).getRabbitryName(),"Mystical");
        assertEquals(users.get(0).getBreederId(),"F131");
    }
}
