/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import rabbitry.Rabbit;
import java.time.LocalDate;
import user.User;

/**
 *
 * @author Kirsi
 */
public class RabbitDao implements DaoRabbit {
    private List<Rabbit> rabbits;
    private String file;
    private UserDao userdao;
    
    public RabbitDao(String file, UserDao userdao) throws Exception {
        this.rabbits = new ArrayList<>();
        this.file = file;
        this.userdao = userdao;
        load();
    }
    
    private void load() {
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] words = reader.nextLine().split(";");
                User user = userdao.getUsers().stream().filter(u->u.getUsername().equals(words[10])).findFirst().orElse(null);
                Rabbit rabbit = new Rabbit(words[0], words[1], words[2], LocalDate.parse(words[3]), words[4], words[5], words[6], words[7], words[8], words[9], user);
                
                rabbits.add(rabbit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
    * Metodin avulla voidaan tallentaa kaneja tiedostoon. 
    */
    private void save() {
        try {
            FileWriter writer = new FileWriter(new File(file));
            for (Rabbit rabbit : rabbits) {
                writer.write(rabbit.getName() + ";" + rabbit.getBreed() + ";" + 
                        rabbit.getSex() + ";" + rabbit.getBirthDate().toString() + ";" +
                        rabbit.getFather() + ";" + rabbit.getMother() + ";" +
                        rabbit.getFathersFather() + ";" + rabbit.getFathersMother() + ";" +
                        rabbit.getMothersFather() + ";" + rabbit.getMothersMother() + ";" + 
                        rabbit.getUser().getUsername() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Rabbit> getRabbits() {
        return rabbits;
    }
    
    /**
    * Metodin avulla voidaan tarkastaa löytyykö kani tiedostosta. 
    */
    @Override
    public Rabbit find(String name) {
        return rabbits.stream().filter(u->u.getName().equals(name)).findFirst().orElse(null);
    }
    
    /**
    * Metodin avulla voidaan luoda uusi käyttäjä.
    */
    @Override
    public Rabbit create(Rabbit rabbit) {
        rabbits.add(rabbit);
        save();
        return rabbit;
    }
}
