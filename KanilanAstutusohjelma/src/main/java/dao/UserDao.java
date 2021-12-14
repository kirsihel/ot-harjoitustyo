
package dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import user.User;

/**
* Luokka tarjoaa käyttäjä tietojen käsittelyä tiedoston avulla. 
*/
public class UserDao implements DaoUser {
    private List<User> users;
    private String file;
    
    public UserDao(String file) throws Exception {
        this.users = new ArrayList<>();
        this.file = file;
        load();
    }
    
    private void load() {
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] words = reader.nextLine().split(";");
                User user = new User(words[0], words[1], words[2]);
                
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
    * Metodin avulla voidaan tallentaa käyttäjiä tiedostoon. 
    */
    private void save() {
        try {
            FileWriter writer = new FileWriter(new File(file));
            for (User user : users) {
                writer.write(user.getUsername() + ";" + user.getRabbitryName() + ";" + user.getBreederId() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
    
    /**
    * Metodin avulla voidaan tarkastaa löytyykö käyttäjä tiedostosta. 
    */
    @Override
    public User find(String username) {
        return users.stream().filter(u->u.getUsername().equals(username)).findFirst().orElse(null);
    }
    
    /**
    * Metodin avulla voidaan luoda uusi käyttäjä.
    */
    @Override
    public User create(User user) {
        users.add(user);
        save();
        return user;
    }
                
}

