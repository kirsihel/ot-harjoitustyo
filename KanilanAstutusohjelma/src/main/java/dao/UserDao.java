/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import user.User;

/**
 *
 * @author Kirsi
 */
public class UserDao implements Dao<User, Integer> {
    
    @Autowired
    JdbcTemplate jdbctemplate;
    
    @Override
    public void create(User user) throws SQLException {
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbctemplate.update(connection -> {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO User (username, rabbitryname, breederid) "
            + "VALUES (?, ?, ?)", new String[]{"id"});
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getRabbitryName());
                stmt.setString(3, user.getBreederId());
                return stmt;
        }, keyholder);
        user.setId(keyholder.getKey().intValue());
    }
    
    @Override
    public User read(Integer key) throws SQLException {
        User user = jdbctemplate.queryForObject(
            "SELECT * FROM User WHERE id =?",
            new BeanPropertyRowMapper<>(User.class),
            key);
        return user;        
    }
    
     @Override
     public User update(User user) throws SQLException {
        jdbctemplate.update("UPDATE User SET username = ?, rabbitryname, breederid WHERE id = ?", 
           user.getUsername(), 
           user.getRabbitryName(),
           user.getBreederId(),
           user.getId());
        return user;
     }
     
     @Override
     public void delete(Integer key) throws SQLException {
         jdbctemplate.update("DELETE FROM User WHERE id = ?",
            key);
     }
     
     @Override
     public List<User> list() throws SQLException {
        List<User> users = jdbctemplate.query("SELECT * FROM User",
            (rs, rowNum) -> new User(rs.getInt("id"), rs.getString("username"), rs.getString("rabbitryname"),
            rs.getString("breederid")));
        return users;
     }
    
}
