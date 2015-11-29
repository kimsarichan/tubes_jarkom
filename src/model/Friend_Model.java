/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author sari
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Friend_Model {
    private Database db;
    private ResultSet rs;
    private String username_pemilik;
    private String username_friend;
    public Friend_Model(){
        db= new Database();
    }
    

    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public String getUsername_pemilik() {
        return username_pemilik;
    }

    public void setUsername_pemilik(String username_pemilik) {
        this.username_pemilik = username_pemilik;
    }

    public String getUsername_friend() {
        return username_friend;
    }

    public void setUsername_friend(String username_friend) {
        this.username_friend = username_friend;
    }
    public void saveData(){
        try {  
            String sql = "insert into  friend (user_id_pemilik, user_id_friend) values  ('"+username_pemilik+"',"+ "'"+username_friend+")";
            db.query(sql);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Friend_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void add_friend(){
    
    }
    public void LoadData(){
        
    }
}
