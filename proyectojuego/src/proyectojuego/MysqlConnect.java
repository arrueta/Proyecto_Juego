/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojuego;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author BARRUETA
 */
public class MysqlConnect {
    Connection conn=null;
    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/usuarios","root","12345");
            JOptionPane.showMessageDialog(null,"conected to database");
            return conn;
        }
        
    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    return null;
}
    }
}
    

