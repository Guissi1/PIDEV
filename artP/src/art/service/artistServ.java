/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package art.service;

/**
 *
 * @author yessine
 */
import art.entities.artist;
import java.sql.*;
import artp.Iartist;
import art.utils.myCon;

public class artistServ  implements Iartist{
    
    Connection mycon = myCon.getInstance().getConnexion();

    @Override
    public void ajouterArtist(artist a) {
        
             String sql="select * from artist where (nom_Ar= ?) and (prenom_Ar= ?) ";
         
        try {
                 try (PreparedStatement ste = mycon.prepareStatement(sql)) {
                     ste.setString(1, a.getNom_Ar());
                     ste.setString(2, a.getPrenom_Ar());
                     try (ResultSet rs = ste.executeQuery()) {
                         if(rs.next()){
                             System.out.println("does exist !");
                             
                             
                         }else{
                             String sqls="insert into artist values(null,?,?,?,?,?)";
                             try (PreparedStatement ste1 = mycon.prepareStatement(sqls)) {
                                 ste1.setString(1,a.getNom_Ar());
                                 ste1.setString(2,a.getPrenom_Ar());
                                 // ste1.setDate(0, x, cal);
                                 ste1.setDate(3, a.getDate_nesAr());
                                 ste1.setString(2,a.getDetail_Ar());
                                    ste1.executeUpdate();
                                 System.out.println("add with success!");
                             }
                         }
                     }
                 }
            
        }
        
        
        
        
        
        catch (SQLException ex) {
            System.out.println(ex);
            
        }
    }
    
    
    @Override
    public void modifierArtist(artist a) {
       String sql="UPDATE artist SET nom_Ar = ?, prenom_Ar = ?, date_NesAr = ?, detail_Ar = ? WHERE id_Ar = ?;";
        try{
           PreparedStatement preparedStatement = mycon.prepareStatement(sql);
           preparedStatement.setString(1, a.getNom_Ar());
           preparedStatement.setString(2, a.getPrenom_Ar());
           preparedStatement.setDate(3, a.getDate_nesAr());
           preparedStatement.setString(4, a.getDetail_Ar());
           preparedStatement.setInt(5, a.getId_Ar());
           preparedStatement.executeUpdate();
           
       }
    
       catch(SQLException ex){
           System.out.println(ex);
       }
    
    }

    @Override
    public void supprimerArtist(artist a) {
         String sql="delete  FROM Personne WHERE id_Ar = ?;";
         
        try {
            PreparedStatement ste=mycon.prepareStatement(sql);
                ste.setInt(0, a.getId_Ar());
                ste.executeUpdate();
               
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
    }

    @Override
    public void afficherArtist() {
     
            String sql="select * from artist ";
        try {
     
    PreparedStatement ste=mycon.prepareStatement(sql);

      ResultSet myRs=ste.executeQuery();
     

      
      while (myRs.next()) {
        System.out.println("ID: " + myRs.getInt("id_Ar"));
        System.out.println("Nom_Artist: " + myRs.getString("Nom_Ar"));
        System.out.println("prenom_artist: " + myRs.getString("prenom_Ar"));
        System.out.println("date_nessance: " + myRs.getDate("date_NesAr"));
        System.out.println("Detail: " + myRs.getString("detail_Ar"));
        
            
        System.out.println("-------------------------------------");
    
      }
    } catch(SQLException ex){
         System.out.println(ex);
    }
        
    }
    
    
}
