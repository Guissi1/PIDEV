/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package art.utils;

/**
 *
 * @author yessine
 */
import java.sql.*;

public class myCon {
    
    
    static String url="jdbc:mysql://localhost:3306/artplus";
    static String login="root";
    static String password;
    static Connection myConnexBD;
    
    public static myCon instance;
   
    private myCon(){
            try{
        myConnexBD = DriverManager.getConnection(url, login, password);
            System.out.println("connexion reussie");
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
     public static myCon getInstance(){
        if(instance == null){
            instance = new myCon();
        }
        return instance;
    }
    
    public Connection getConnexion(){
        return myConnexBD;
    }
}
