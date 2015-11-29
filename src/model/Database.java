/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Adrian
 */
public class Database {
    private Statement stmt =null;
    private Connection connect = null;
    private ResultSet rs = null;
    
    public Database (){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "JDBC ERROR", JOptionPane.WARNING_MESSAGE);
        }
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/agram","root","");
            stmt= connect.createStatement();
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet getData(String sql){
        try {  
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    public void query(String sql){
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage(), "SQL ERROR", JOptionPane.WARNING_MESSAGE);;
        }
        finally{
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void close(){
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

