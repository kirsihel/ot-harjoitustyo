/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import rabbitry.Breeding;
import rabbitry.Rabbit;
import user.User;

/**
 *
 * @author Kirsi
 */
public class BreedingDao implements DaoBreeding {
    private List<Breeding> breedings;
    private String file;
    
    public BreedingDao(String file, UserDao userdao, RabbitDao rabbitdao) throws Exception {   
        breedings = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] words = reader.nextLine().split(";");
                int id = Integer.parseInt(words[0]);
                boolean done = Boolean.parseBoolean(words[4]);
                User user = userdao.getUsers().stream().filter(u->u.getUsername().equals(words[5])).findFirst().orElse(null); 
                Rabbit buck = rabbitdao.getRabbits().stream().filter(r->r.getName().equals(words[1])).findFirst().orElse(null);
                Rabbit doe = rabbitdao.getRabbits().stream().filter(r->r.getName().equals(words[2])).findFirst().orElse(null);
                Breeding breeding = new Breeding(id, buck, doe, LocalDate.parse(words[3]), done, user);
                breedings.add(breeding);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
        
    }
    
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Breeding breeding : breedings) {
                writer.write(breeding.getId() + ";" + breeding.getBuck().getName() + ";" +
                        breeding.getDoe().getName() + ";" + breeding.getDate() + ";" +
                        breeding.getDone() + ";" + breeding.getUser().getUsername() + "\n");
            }
        }
    }    
    
    private int newId() {
        return breedings.size() + 1;
    }
    
    @Override
    public List<Breeding> getBreedings() {
        return breedings;
    }
    
    @Override
    public Breeding create(Breeding breeding) throws Exception {
        breeding.setId(newId());
        breedings.add(breeding);
        save();
        return breeding;
    }   
    
    @Override
    public void setDone(int id) throws Exception {
        for (Breeding breeding : breedings) {
            if (breeding.getId() == id) {
                breeding.setDone();
            }
        }
        save();
    }    


    
}
