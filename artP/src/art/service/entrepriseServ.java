/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package art.service;

/**
 *
 * @author yessine
 */
import art.entities.entreprise;
import java.sql.*;
import artp.Ientreprise;
import art.utils.myCon;
public class entrepriseServ implements Ientreprise{
 Connection mycon = myCon.getInstance().getConnexion();

    @Override
    public void ajouterEnt(entreprise e) {
       
        String sql="select * from entreprise where nom_entr = ? ";
        try {
                 try (PreparedStatement ste = mycon.prepareStatement(sql)) {
                     ste.setString(1, e.getNom_entr());
                     
                     try (ResultSet rs = ste.executeQuery()) {
                         if(rs.next()){
                             System.out.println("does exist !");
                             
                             
                         }else{
                             String sqls="insert into entreprise values(null,?,?,?)";
                             try (PreparedStatement ste1 = mycon.prepareStatement(sqls)) {
                                 ste1.setString(1,e.getNom_entr());
                                 ste1.setString(2,e.getAdresse_entr());
                                 
                                 
                                 ste1.setString(3,e.getMail_entr());
                                    ste1.executeUpdate();
                                 System.out.println("add with success!");
                             }
                         }
                     }
                 }
        
    } catch (SQLException ex) {
            System.out.println(ex);
            
        }
    }
    @Override
    public void modifierEnt(entreprise e) {
         String sql="UPDATE entreprise SET nom_entr= ?, adresse_entr= ?, mail_entr = ? ";
        try{
           PreparedStatement preparedStatement = mycon.prepareStatement(sql);
           preparedStatement.setString(1, e.getNom_entr());
           preparedStatement.setString(2, e.getAdresse_entr());
           preparedStatement.setString(3, e.getMail_entr());
           preparedStatement.executeUpdate();
           
       }
    
       catch(SQLException ex){
           System.out.println(ex);
       }
    }

    @Override
    public void supprimerEnt(entreprise e) {
         String sql="delete  FROM entreprise WHERE id_entr = ?;";
         
        try {
            PreparedStatement ste=mycon.prepareStatement(sql);
                ste.setInt(0, e.getId_entr());
                ste.executeUpdate();
               
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
    }

    @Override
    public void afficherEnt() {
        
            String sql="select * from entreprise ";
        try {
     
    PreparedStatement ste=mycon.prepareStatement(sql);

      ResultSet myRs=ste.executeQuery();
     

      
      while (myRs.next()) {
        System.out.println("ID: " + myRs.getInt("id_entr"));
        System.out.println("nom_entreprise: " + myRs.getString("Nom_entr"));
        System.out.println("adresse entreprise: " + myRs.getString("adresse_entr"));
        System.out.println("mail entreprise: " + myRs.getString("mail_entr"));
       
        
            
        System.out.println("-------------------------------------");
    
      }
    } catch(SQLException ex){
         System.out.println(ex);
    }
    }
    
}
