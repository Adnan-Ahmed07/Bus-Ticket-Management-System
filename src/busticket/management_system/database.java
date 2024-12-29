/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busticket.management_system;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User Adnan Ahmed
 */
public class database {
    
    public static Connection connectDb(){
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
                                
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/busdata", "root", ""); 
            return connect;
        }catch(Exception e){e.printStackTrace();}
        return null;
    }
}
