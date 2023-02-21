/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package renders;


import art.utils.myCon;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import art.entities.entreprise;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author yessine
 */
public class EntrepriseController implements Initializable {
    @FXML
    private TreeTableView<entreprise> entrepriseTable;
    @FXML
    private TreeTableColumn<entreprise,Integer> idCol;
    @FXML
    private TreeTableColumn<entreprise, String> nomCol;
    @FXML
    private TreeTableColumn<entreprise,String>  adrCol;
    @FXML
    private TreeTableColumn<entreprise,String>  mailCol;
   
    Connection mycon = myCon.getInstance().getConnexion();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadDate();
    }    
    @FXML
    private void close(MouseEvent event){
    
    }
    @FXML
    private void addUser(MouseEvent event){
    
    }
    @FXML
    private void Refresh(MouseEvent event){
    
        } 
    
     public ObservableList<entreprise> getEntrList()
    {
        ObservableList<entreprise> entrList = FXCollections.observableArrayList();
        Connection mycon;
        mycon = myCon.getInstance().getConnexion();
        String query = "SELECT * FROM entrprise";
        Statement st;
        ResultSet rs;
        try 
        {
          st = mycon.createStatement();
          rs = st.executeQuery(query);
          entreprise entr;
          while (rs.next())
          {
              entr = new entreprise(rs.getInt("id_entr"),rs.getString("nom_entr"),rs.getString("adresse_entr"),rs.getInt("mail_entr"));
              entrList.add(entr);
          }         
        }catch(SQLException ex){
        }
        return entrList;
    }
    private void loadDate() {
        ObservableList<entreprise> entrList = getEntrList();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id_entr"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom_entr"));
        adrCol.setCellValueFactory(new PropertyValueFactory<>("adresse_entr"));
        mailCol.setCellValueFactory(new PropertyValueFactory<>("mail_entr"));
        entrepriseTable.setItems(entrList);
    }  
    }

    

