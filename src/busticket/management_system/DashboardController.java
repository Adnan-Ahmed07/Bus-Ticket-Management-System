/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package busticket.management_system;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Adnan Ahmed
 * 
 */
public class DashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private AnchorPane main_form;
    @FXML
    private BorderPane Sign_Out;

    @FXML
    private Button availableB_Btn;

    @FXML
    private Button availableB_addBtn;

    @FXML
    private TextField availableB_busID;

    @FXML
    private TableColumn<?, ?> availableB_coi_busID;

    @FXML
    private TableColumn<?, ?> availableB_coi_date;

    @FXML
    private TableColumn<?, ?> availableB_coi_location;

    @FXML
    private TableColumn<?, ?> availableB_coi_price;

    @FXML
    private TableColumn<?, ?> availableB_coi_type;

    @FXML
    private DatePicker availableB_date;

    @FXML
    private Button availableB_deleteBtn;

    @FXML
    private AnchorPane availableB_form;

    @FXML
    private TextField availableB_location;

    @FXML
    private TextField availableB_price;

    @FXML
    private Button availableB_resetBtn;

    @FXML
    private TextField availableB_search;

    @FXML
    private ComboBox<?> availableB_status;

    @FXML
    private Button availableB_updateBtn;

    @FXML
    private Button bookingTicket_Btn;

    @FXML
    private ComboBox<?> bookingTicket_busid;

    @FXML
    private DatePicker bookingTicket_date;

    @FXML
    private TextField bookingTicket_firstName;

    @FXML
    private AnchorPane bookingTicket_form;

    @FXML
    private ComboBox<?> bookingTicket_gender;

    @FXML
    private TextField bookingTicket_lastName;

    @FXML
    private ComboBox<?> bookingTicket_location;

    @FXML
    private TextField bookingTicket_phoneNum;

    @FXML
    private Button bookingTicket_resetBtn;

    @FXML
    private Label bookingTicket_sci_busID;

    @FXML
    private Label bookingTicket_sci_date;

    @FXML
    private Label bookingTicket_sci_firstName;

    @FXML
    private Label bookingTicket_sci_gender;

    @FXML
    private Label bookingTicket_sci_lastName;

    @FXML
    private Label bookingTicket_sci_location;

    @FXML
    private Button bookingTicket_sci_pay;

    @FXML
    private Label bookingTicket_sci_phoneNum;

    @FXML
    private Button bookingTicket_sci_receipt;

    @FXML
    private Label bookingTicket_sci_ticketNum;

    @FXML
    private Label bookingTicket_sci_total;

    @FXML
    private Label bookingTicket_sci_type;

    @FXML
    private Button bookingTicket_selectBtn;

    @FXML
    private ComboBox<?> bookingTicket_ticketNum;

    @FXML
    private ComboBox<?> bookingTicket_type;

    @FXML
    private Button close;

    @FXML
    private AnchorPane customer_Form;

    @FXML
    private Button customers_Btn;

    @FXML
    private TableColumn<?, ?> customers_busID;

    @FXML
    private TableColumn<?, ?> customers_customerNum;

    @FXML
    private TableColumn<?, ?> customers_date;

    @FXML
    private TableColumn<?, ?> customers_firstName;

    @FXML
    private TableColumn<?, ?> customers_gender;

    @FXML
    private TableColumn<?, ?> customers_lastName;

    @FXML
    private TableColumn<?, ?> customers_location;

    @FXML
    private TableColumn<?, ?> customers_phoneNum;

    @FXML
    private TextField customers_search;

    @FXML
    private TableView<?> customers_tableView;

    @FXML
    private TableColumn<?, ?> customers_ticketNum;

    @FXML
    private TableColumn<?, ?> customers_type;

    @FXML
    private Button dashboard_Btn;

    @FXML
    private Label dashboard_availableB;

    @FXML
    private AreaChart<?, ?> dashboard_chart;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Label dashboard_incomeToday;

    @FXML
    private Label dashboard_totalncome;

    @FXML
    private Button logout;

    @FXML
    private Button minimize;

    @FXML
    private Label username;
    
    
    public void switchForm(ActionEvent event){ 
      if (event.getSource() == dashboard_Btn) {
           dashboard_form.setVisible(true);
            availableB_form.setVisible(false);
            bookingTicket_form.setVisible(false);
            customer_Form.setVisible(false);
            
        }else if (event.getSource() == availableB_Btn){ 
            dashboard_form.setVisible(false);
            availableB_form.setVisible(true);
            bookingTicket_form.setVisible(false);
            customer_Form.setVisible(false);
         
        }else if (event.getSource() == bookingTicket_Btn){ 
            dashboard_form.setVisible(false);
            availableB_form.setVisible(false);
            bookingTicket_form.setVisible(true);
            customer_Form.setVisible(false);
         
        }else if (event.getSource() == customers_Btn){ 
            dashboard_form.setVisible(false);
            availableB_form.setVisible(false);
            bookingTicket_form.setVisible(false);
            customer_Form.setVisible(true);
        
        }
     
    }
    
    
    public void close(){ 
        System.exit(0);
    }
    public void minimize(){ 
        Stage stage=(Stage)main_form.getScene().getWindow();
        stage.setIconified(true);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
