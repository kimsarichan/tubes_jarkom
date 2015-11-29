/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sari
 */
public class User_Model {
    private Database db;
    private ResultSet rs;
    private String username,password, nama ,email ;

    public User_Model() {
        this.db = new Database();
    }
    
    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    public void saveData() throws SQLException{
            String sql = "insert into  user (user_id, nama, email, password) values  ('"+username+"',"+ "'"+nama+"',"+ "'"+email+"',"+ ""+password+")";
            db.query(sql);
            rs.close();
    }
    public void loadData(){
        try{
            String sql = "SELECT user_id,password FROM user WHERE user_id='"+username+"'";
            rs=db.getData(sql); 
            if(rs!=null){
            while(rs.next()) {
                       this.username=rs.getString("user_id");
                       this.nama = rs.getString("nama");
                       this.email = rs.getString("email");
                       this.password = rs.getString("password");
                   }
               rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(User_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
