/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package busticket.management_system;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author User Adnan Ahmed
 */
public class FXMLDocumentController implements Initializable {
    
  @FXML
    private Button login_in;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField passwordin;

    @FXML
    private Button signupin;

    @FXML
    private TextField usernamenew;
     @FXML
    private Button close;
     
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result; 
    public void login_in(){ 
        String sql = "SELECT * FROM admin WHERE username = ? and password = ?";

        connect = database.connectDb();

        Alert alert;
     
    }
    try{ 
 
}
    
    
     
  @FXML
     public void close(){ 
         
         System.exit(0);
     }
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
