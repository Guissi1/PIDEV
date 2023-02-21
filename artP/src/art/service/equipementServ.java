/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package art.service;

/**
 *
 * @author yessine
 */
import art.entities.equipement;
import java.sql.*;
import artp.Iequipement;
import art.utils.myCon;

public class equipementServ implements Iequipement{
 Connection mycon = myCon.getInstance().getConnexion();

    @Override
    public void ajoutereq(equipement eq) {
         String sql="select * from equipement where nom_equi = ? ";
        try {
                 try (PreparedStatement ste = mycon.prepareStatement(sql)) {
                     ste.setString(1, eq.getNom_equi());
                     
                     try (ResultSet rs = ste.executeQuery()) {
                         if(rs.next()){
                             System.out.println("does exist !");
                             
                             
                         }else{
                             String sqls="insert into equipement values(null,?,?)";
                             try (PreparedStatement ste1 = mycon.prepareStatement(sqls)) {
                                 ste1.setString(1,eq.getNom_equi());
                                 ste1.setString(2,eq.getType_eq());
                                 
                                 
                                 
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
    public void modifiereq(equipement eq) {
        String sql="UPDATE equipement SET nom_equi= ?, type_equi= ? ";
        try{
           PreparedStatement preparedStatement = mycon.prepareStatement(sql);
           preparedStatement.setString(1, eq.getNom_equi());
           preparedStatement.setString(2, eq.getType_eq());          
           preparedStatement.executeUpdate();
           
       }
    
       catch(SQLException ex){
           System.out.println(ex);
       }
    }

    @Override
    public void supprimereq(equipement eq) {
       String sql="delete  FROM entreprise WHERE id_equi= ?";
         
        try {
            PreparedStatement ste=mycon.prepareStatement(sql);
                ste.setInt(0, eq.getId_equi());
                ste.executeUpdate();
               
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
    }

    @Override
    public void affichereq() {
               String sql="select * from equipement ";
        try {
     
    PreparedStatement ste=mycon.prepareStatement(sql);

      ResultSet myRs=ste.executeQuery();
     

      
      while (myRs.next()) {
        System.out.println("ID: " + myRs.getInt("id_equi"));
        System.out.println("Nom_equipement: " + myRs.getString("Nom_equi"));
        System.out.println("prenom_equipement: " + myRs.getString("type_equi"));
        System.out.println("id entreprise: " + myRs.getInt("id_entr"));
       
        
            
        System.out.println("-------------------------------------");
    
      }
    } catch(SQLException ex){
         System.out.println(ex);
    }
    }

   
    
}
