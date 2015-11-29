/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User_Model;
/**
 *
 * @author sari
 */
public class User_controller {
   
    User_Model umod;
    public User_controller(){
        umod=new User_Model();
    }
    public void signup(String username, String nama , String password , String email){
        try {
            umod.setNama(nama);
            umod.setEmail(email);
            umod.setPassword(password);
            umod.setUsername(username);
            umod.saveData();
        } catch (SQLException ex) {
            Logger.getLogger(User_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void login(String username, String password){
        umod.setUsername(username);
        umod.loadData();
        if(password==umod.getPassword()){
           System.out.print("login berhasil");
        }
        else{
            System.out.print("login gagal");
        }
    }
    public void addfriend(){
        
    }
    
}
