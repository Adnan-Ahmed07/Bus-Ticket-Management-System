/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package busticket.management_system;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;


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
    private TableColumn<busData, String> availableB_col_busID;

    @FXML
    private TableColumn<busData, String> availableB_col_date;

    @FXML
    private TableColumn<busData, String> availableB_col_location;

    @FXML
    private TableColumn<busData, String> availableB_col_price;

    @FXML
    private TableColumn<busData, String> availableB_col_status;

    @FXML
    private DatePicker availableB_date;
    

    @FXML
    private Button availableB_deleteBtn;
     @FXML
    private TableView<busData> availableB_tableView;

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
    private ComboBox<?> bookingTicket_busId;

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
    private TableColumn<customerData,String> customers_busID;

    @FXML
    private TableColumn<customerData,String> customers_customerNum;

    @FXML
    private TableColumn<customerData,String> customers_date;

    @FXML
    private TableColumn<customerData,String> customers_firstName;

    @FXML
    private TableColumn<customerData,String> customers_gender;

    @FXML
    private TableColumn<customerData,String> customers_lastName;

    @FXML
    private TableColumn<customerData,String> customers_location;

    @FXML
    private TableColumn<customerData,String> customers_phoneNum;

    @FXML
    private TextField customers_search;

    @FXML
    private TableView<customerData> customers_tableView;

    @FXML
    private TableColumn<customerData,String> customers_ticketNum;

    @FXML
    private TableColumn<customerData,String> customers_type;

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
    
     private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;
    @FXML
    private Button reciptBtn;
    @FXML
    private AnchorPane ReciptAd;
    @FXML
    private ImageView reciptAdpdf;
    
    @FXML
    public void availableBusAdd() { 
    
    String addData = "INSERT INTO bus (bus_id,location,status,price,date) VALUES(?,?,?,?,?)";
    
    
    
    connect = database.connectDb();

        try {

            Alert alert;


            if (availableB_busID.getText().isEmpty()
                    || availableB_location.getText().isEmpty()
                    || availableB_status.getSelectionModel().getSelectedItem() == null
                    || availableB_price.getText().isEmpty()
                    || availableB_date.getValue() == null) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {


                String check = "SELECT bus_id FROM bus WHERE bus_id = '"
                        + availableB_busID.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);

                if (result.next()) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Bus ID: " + availableB_busID.getText() + " was already exist!");
                    alert.showAndWait();

                } else {

                    prepare = connect.prepareStatement(addData);
                    prepare.setString(1, availableB_busID.getText());
                    prepare.setString(2, availableB_location.getText());
                    prepare.setString(3, (String) availableB_status.getSelectionModel().getSelectedItem());
                    prepare.setString(4, availableB_price.getText());
                    prepare.setString(5, String.valueOf(availableB_date.getValue()));

                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();


                    availableBShowBusData();
                    availableBusReset();
                   

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    @FXML
     public void availableBusUpdate() {

        String updateData = "UPDATE bus SET location = '"
                + availableB_location.getText() + "', status = '"
                + availableB_status.getSelectionModel().getSelectedItem()
                + "', price = '" + availableB_price.getText()
                + "', date = '" + availableB_date.getValue()
                + "' WHERE bus_id = '" + availableB_busID.getText() + "'";

        connect = database.connectDb();

        Alert alert;

        try {

            if (availableB_busID.getText().isEmpty()
                    || availableB_location.getText().isEmpty()
                    || availableB_status.getSelectionModel().getSelectedItem() == null
                    || availableB_price.getText().isEmpty()
                    || availableB_date.getValue() == null) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the item first");
                alert.showAndWait();

            } else {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Bus ID: " + availableB_busID.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    prepare = connect.prepareStatement(updateData);
                    prepare.executeUpdate();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    availableBShowBusData();
                    availableBusReset();
                    
                } else {
                    return;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     
    @FXML
      public void availableBusDelete(){
        
        String deleteData = "DELETE FROM bus WHERE bus_id = '"
                +availableB_busID.getText()+"'";
        
        connect = database.connectDb();
        
        try{
            
            Alert alert;
            
            if (availableB_busID.getText().isEmpty()
                    || availableB_location.getText().isEmpty()
                    || availableB_status.getSelectionModel().getSelectedItem() == null
                    || availableB_price.getText().isEmpty()
                    || availableB_date.getValue() == null) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the item first");
                alert.showAndWait();

            } else {
                
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete Bus ID: " + availableB_busID.getText() + "?");
                
                Optional<ButtonType> option = alert.showAndWait();
                if(option.get().equals(ButtonType.OK)){
                    
                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();
                    
                    availableBShowBusData();
                    availableBusReset();
                    
                }else{
                    return;
                }
            }
 
        }catch(Exception e){e.printStackTrace();}
        
    }
     
     
     
     
    @FXML
    public void availableBusReset() {

        availableB_busID.setText("");
        availableB_location.setText("");
        availableB_status.getSelectionModel().clearSelection();
        availableB_price.setText("");
        availableB_date.setValue(null);

    }
    
    
    private String[] statusList = {"Available", "Not Available"};

    @FXML
    public void comboBoxStatus() {

        List<String> listS = new ArrayList<>();

        for (String data : statusList) {
            listS.add(data);
        }

        ObservableList listStatus = FXCollections.observableArrayList(listS);
        availableB_status.setItems(listStatus);

    }
    
    
    
    public ObservableList<busData> availableBusBusData() {

        ObservableList<busData> busListData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM bus";

        connect = database.connectDb();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            busData busD;

            while (result.next()) {
                busD = new busData(result.getInt("bus_id"),
                        result.getString("location"),
                        result.getString("status"),
                        result.getDouble("price"),
                        result.getDate("date"));

                busListData.add(busD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return busListData;

    }
    
    private ObservableList<busData> availableBBusListData;
    public void availableBShowBusData() {

        availableBBusListData = availableBusBusData();

        availableB_col_busID.setCellValueFactory(new PropertyValueFactory<>("busId"));
        availableB_col_location.setCellValueFactory(new PropertyValueFactory<>("location"));
        availableB_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        availableB_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        availableB_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        availableB_tableView.setItems(availableBBusListData);

    }
    
    @FXML
      public void avaialbleBSelectBusData() {

        busData busD = availableB_tableView.getSelectionModel().getSelectedItem();
        int num = availableB_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        availableB_busID.setText(String.valueOf(busD.getBusId()));
        availableB_location.setText(busD.getLocation());
        availableB_price.setText(String.valueOf(busD.getPrice()));
        availableB_date.setValue(LocalDate.parse(String.valueOf(busD.getDate())));

    }
      
      
    @FXML

  public void availableSearch() {
    ObservableList<busData> tableData = availableB_tableView.getItems();

    FilteredList<busData> filteredList = new FilteredList<>(tableData, e -> true);

    availableB_search.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredList.setPredicate(bus -> {
            
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String searchKey = newValue.toLowerCase();

            
            if (bus.getBusId() != null && bus.getBusId().toString().toLowerCase().contains(searchKey)) {
                return true;
            }
            if (bus.getLocation() != null && bus.getLocation().toLowerCase().contains(searchKey)) {
                return true;
            }
            if (bus.getStatus() != null && bus.getStatus().toLowerCase().contains(searchKey)) {
                return true;
            }
            if (bus.getDate() != null && bus.getDate().toString().toLowerCase().contains(searchKey)) {
                return true;
            }
            if (bus.getPrice() != null && bus.getPrice().toString().toLowerCase().contains(searchKey)) {
                return true;
            }

            return false; 
        });
    });

    SortedList<busData> sortedList = new SortedList<>(filteredList);
    sortedList.comparatorProperty().bind(availableB_tableView.comparatorProperty());

    availableB_tableView.setItems(sortedList);
}

   

      
      
       
    @FXML
     public void busIdList(){
        
        String busD = "SELECT * FROM bus WHERE status = 'Available'";
        
        connect = database.connectDb();
        
        try{
            prepare = connect.prepareStatement(busD);
            result = prepare.executeQuery();
            
            ObservableList listB = FXCollections.observableArrayList();
            
            while(result.next()){
                
                listB.add(result.getString("bus_id"));
            }
            bookingTicket_busId.setItems(listB);
            
            ticketNumList();
            
        }catch(Exception e){e.printStackTrace();}
        
    }  
      
      public void LocationList(){
        
        String locationL = "SELECT * FROM bus WHERE status = 'Available'";
        
        connect = database.connectDb();
        
        try{
            
            prepare = connect.prepareStatement(locationL);
            result = prepare.executeQuery();
            
            ObservableList listL = FXCollections.observableArrayList();
            
            while(result.next()){
                
                listL.add(result.getString("location"));
            }
            
            bookingTicket_location.setItems(listL);
            
        }catch(Exception e){e.printStackTrace();}
        
    }
      
       private String[] listT = {"First Class", "Economy Class"};
    
    public void typeList(){
        
        List<String> tList = new ArrayList<>();
        
        for(String data : listT){
            tList.add(data);
        }
        
        ObservableList listType = FXCollections.observableArrayList(tList);
        bookingTicket_type.setItems(listType);
        
    }
      
    @FXML
     public void ticketNumList(){
        List<String> listTicket = new ArrayList<>();
        for(int q = 1; q <= 40; q++){
            listTicket.add(String.valueOf(q));
        }
//        40 ARE OUR CAPACITY SEATS

        String removeSeat = "SELECT seatNum FROM customer WHERE bus_id='"
                +bookingTicket_busId.getSelectionModel().getSelectedItem()+"'";

        connect = database.connectDb();
        
        try{
            prepare = connect.prepareStatement(removeSeat);
            result = prepare.executeQuery();
            
            while(result.next()){
                listTicket.remove(result.getString("seatNum"));
            }
            
            ObservableList listTi = FXCollections.observableArrayList(listTicket);
            
            bookingTicket_ticketNum.setItems(listTi);

        }catch(Exception e){e.printStackTrace();}
    }
    
       
       
       
     private double priceData = 0;
    private double totalP = 0;
    @FXML
    public void bookingTicketSelect(){
        
        String firstName = bookingTicket_firstName.getText();
        String lastName = bookingTicket_lastName.getText();
        String gender = (String)bookingTicket_gender.getSelectionModel().getSelectedItem();
        String phoneNumber = bookingTicket_phoneNum.getText();
        String date = String.valueOf(bookingTicket_date.getValue());
        
        String busId = (String)bookingTicket_busId.getSelectionModel().getSelectedItem();
        String location = (String)bookingTicket_location.getSelectionModel().getSelectedItem();
        String type = (String)bookingTicket_type.getSelectionModel().getSelectedItem();
        String ticketNum = (String)bookingTicket_ticketNum.getSelectionModel().getSelectedItem();
        
        Alert alert;
        
        if(firstName == null || lastName == null 
                || gender == null || phoneNumber == null || date == null
                || busId == null || location == null
                || type == null || ticketNum == null){
            
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
            
        }else{
            
            String totalPrice = "SELECT price FROM bus WHERE location = '"
                    +location+"'";
            
            try{
                
                connect = database.connectDb();
                
                prepare = connect.prepareStatement(totalPrice);
                result = prepare.executeQuery();
                
                if(result.next()){
                    priceData = result.getDouble("price");
                }
                
                if(type == "First Class"){
                    totalP = (priceData + 300);
                }else if(type == "Economy Class"){
                    totalP = priceData; 
                }
            }catch(Exception e){e.printStackTrace();}
            
            bookingTicket_sci_total.setText("৳"+String.valueOf(totalP));
            bookingTicket_sci_firstName.setText(firstName);
            bookingTicket_sci_lastName.setText(lastName);
            bookingTicket_sci_gender.setText(gender);
            bookingTicket_sci_phoneNum.setText(phoneNumber);
            bookingTicket_sci_date.setText(date);
            
            bookingTicket_sci_busID.setText(busId);
            bookingTicket_sci_location.setText(location);
            bookingTicket_sci_type.setText(type);
            bookingTicket_sci_ticketNum.setText(ticketNum);
            
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Selected!");
            alert.showAndWait();
            
            bookingTicketReset();
            
        }
    }   
       
    @FXML
    public void bookingTicketReset(){
        
        bookingTicket_firstName.setText("");
        bookingTicket_lastName.setText("");
        bookingTicket_gender.getSelectionModel().clearSelection();
        bookingTicket_phoneNum.setText("");
        bookingTicket_date.setValue(null);
        
    }    
     private String[] genderL = {"Male","Female","Others"};
    
    @FXML
    public void genderList(){
        
        List<String> listG = new ArrayList<>();
        
        for(String data : genderL){
            listG.add(data);
        }
        
        ObservableList gList = FXCollections.observableArrayList(listG);
        bookingTicket_gender.setItems(gList);
        
    }
    
    
    private int countRow;
    @FXML
    public void bookingTicketPay(){
        
        String firstName = bookingTicket_sci_firstName.getText();
        String lastName = bookingTicket_sci_lastName.getText();
        String gender = bookingTicket_sci_gender.getText();
        String phoneNumber = bookingTicket_sci_phoneNum.getText();
        String date = bookingTicket_sci_date.getText();
        
        String busId = bookingTicket_sci_busID.getText();
        String location = bookingTicket_sci_location.getText();
        String type = bookingTicket_sci_type.getText();
        String seatNum = bookingTicket_sci_ticketNum.getText();
        
        String payData = "INSERT INTO customer (customer_id,firstName,lastName,gender,phoneNumber,bus_id,location,type,seatNum,total,date)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
        connect = database.connectDb();
        
        try{
            
            Alert alert;
            
            String countNum = "SELECT COUNT(id) FROM customer";
            statement = connect.createStatement();
            result = statement.executeQuery(countNum);
            
            while(result.next()){
                countRow = result.getInt("COUNT(id)");
            }
            

            if(bookingTicket_sci_firstName.getText().isEmpty()
                    || bookingTicket_sci_lastName.getText().isEmpty()
                    || bookingTicket_sci_gender.getText().isEmpty()
                    || bookingTicket_sci_phoneNum.getText().isEmpty()
                    || bookingTicket_sci_date.getText().isEmpty()
                    || bookingTicket_sci_busID.getText().isEmpty()
                    || bookingTicket_sci_location.getText().isEmpty()
                    || bookingTicket_sci_type.getText().isEmpty()
                    || bookingTicket_sci_ticketNum.getText().isEmpty()
                    || totalP == 0){
                
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the information first");
                alert.showAndWait();
                
            }else{
            
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                alert.showAndWait();
//                WE NEED TO REMOVE THE SEAT# IF THE CUSTOMER IS ALREADY CHOSE THAT 
                prepare = connect.prepareStatement(payData);
                prepare.setString(1, String.valueOf(countRow+1));
                prepare.setString(2, firstName);
                prepare.setString(3, lastName);
                prepare.setString(4, gender);
                prepare.setString(5, phoneNumber);
                prepare.setString(6, busId);
                prepare.setString(7, location);
                prepare.setString(8, type);
                prepare.setString(9, seatNum);
                prepare.setString(10, String.valueOf(totalP));
                prepare.setString(11, date);
                
                prepare.executeUpdate();
                
                String receiptData = "INSERT INTO customer_receipt (customer_id,total,date) VALUES(?,?,?)";
                
                getData.number = (countRow + 1);
                
                prepare = connect.prepareStatement(receiptData);
                prepare.setString(1, String.valueOf(countRow+1));
                prepare.setString(2, String.valueOf(totalP));
                prepare.setString(3, date);
                
                prepare.executeUpdate();
                
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successful!");
                alert.showAndWait();

                bookingTicket_sci_firstName.setText("");
                bookingTicket_sci_lastName.setText("");
                bookingTicket_sci_gender.setText("");
                bookingTicket_sci_phoneNum.setText("");
                bookingTicket_sci_date.setText("");
                bookingTicket_sci_busID.setText("");
                bookingTicket_sci_location.setText("");
                bookingTicket_sci_type.setText("");
                bookingTicket_sci_ticketNum.setText("");
                bookingTicket_sci_total.setText("৳0.0");
 
            }
        }catch(Exception e){e.printStackTrace();}
    } 
      
    
      public ObservableList<customerData> customersDataList(){
        
        ObservableList<customerData> customerList = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM customer";
        
        connect = database.connectDb();
        
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            customerData custD;
            
            while(result.next()){
                
                custD = new customerData(result.getInt("customer_id")
                        , result.getString("firstName")
                        , result.getString("lastName")
                        , result.getString("gender")
                        , result.getString("phoneNumber")
                        , result.getInt("bus_id")
                        , result.getString("location")
                        , result.getString("type")
                        , result.getInt("seatNum")
                        , result.getDouble("total")
                        , result.getDate("date"));
                
                customerList.add(custD);
                
            }
            
        }catch(Exception e){e.printStackTrace();}
        return customerList;
    }
    
    private ObservableList<customerData> customersDataL;
    public void customersShowDataList(){
        
        customersDataL = customersDataList();
        
        customers_customerNum.setCellValueFactory(new PropertyValueFactory<>("customerNum"));
        customers_ticketNum.setCellValueFactory(new PropertyValueFactory<>("seatNum"));
        customers_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        customers_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        customers_phoneNum.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
        customers_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        customers_busID.setCellValueFactory(new PropertyValueFactory<>("busId"));
        customers_location.setCellValueFactory(new PropertyValueFactory<>("location"));
        customers_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        customers_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        customers_tableView.setItems(customersDataL);
        
    }
    
    
    @FXML
    public void customersSearch() {
    ObservableList<customerData> tableData = customers_tableView.getItems();

    FilteredList<customerData> filteredList = new FilteredList<>(tableData, e -> true);

    customers_search.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredList.setPredicate(customer -> {
            
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String searchKey = newValue.toLowerCase();

            
            if (customer.getCustomerNum() != null && customer.getCustomerNum().toString().contains(searchKey)) {
                return true;
            }
            if (customer.getSeatNum() != null && customer.getSeatNum().toString().contains(searchKey)) {
                return true;
            }
            if (customer.getFirstName() != null && customer.getFirstName().toLowerCase().contains(searchKey)) {
                return true;
            }
            if (customer.getLastName() != null && customer.getLastName().toLowerCase().contains(searchKey)) {
                return true;
            }
            if (customer.getGender() != null && customer.getGender().toLowerCase().contains(searchKey)) {
                return true;
            }
            if (customer.getPhoneNum() != null && customer.getPhoneNum().toLowerCase().contains(searchKey)) {
                return true;
            }
            if (customer.getBusId() != null && customer.getBusId().toString().contains(searchKey)) {
                return true;
            }
            if (customer.getLocation() != null && customer.getLocation().toLowerCase().contains(searchKey)) {
                return true;
            }
            if (customer.getTotal() != null && customer.getTotal().toString().contains(searchKey)) {
                return true;
            }
            if (customer.getType() != null && customer.getType().toLowerCase().contains(searchKey)) {
                return true;
            }
            if (customer.getDate() != null && customer.getDate().toString().contains(searchKey)) {
                return true;
            }

            return false; // No match
        });
    });

    SortedList<customerData> sortedList = new SortedList<>(filteredList);
    sortedList.comparatorProperty().bind(customers_tableView.comparatorProperty());

    customers_tableView.setItems(sortedList);
}

    private double x = 0;
    private double y = 0;
    @FXML
    public void logout() {

        try {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                logout.getScene().getWindow().hide();

                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {

                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });
                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            } else {
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void switchForm(ActionEvent event) throws IOException{ 
      if (event.getSource() == dashboard_Btn) {
           dashboard_form.setVisible(true);
            availableB_form.setVisible(false);
            bookingTicket_form.setVisible(false);
            customer_Form.setVisible(false);
            ReciptAd.setVisible(false);
            
              dashboardDisplayAB();
               dashboardDisplayIT();
               dashboardDisplayTI();
               dashboardChart();
            
        }else if (event.getSource() == availableB_Btn){ 
            dashboard_form.setVisible(false);
            availableB_form.setVisible(true);
            bookingTicket_form.setVisible(false);
            customer_Form.setVisible(false);
           ReciptAd.setVisible(false);
            
            availableBShowBusData();
             availableSearch();
         
        }else if (event.getSource() == bookingTicket_Btn){ 
            dashboard_form.setVisible(false);
            availableB_form.setVisible(false);
            bookingTicket_form.setVisible(true);
            customer_Form.setVisible(false);
            ReciptAd.setVisible(false);
                    busIdList();
                    LocationList();
                    typeList();
                    ticketNumList();
                    genderList();
         
        }else if (event.getSource() == customers_Btn){ 
            dashboard_form.setVisible(false);
            availableB_form.setVisible(false);
            bookingTicket_form.setVisible(false);
            customer_Form.setVisible(true);
            ReciptAd.setVisible(false);
                    customersShowDataList(); 
                   
                    
        
        } else if(event.getSource() == reciptBtn){
                   dashboard_form.setVisible(false);
            availableB_form.setVisible(false);
            bookingTicket_form.setVisible(false);
            customer_Form.setVisible(false);
            ReciptAd.setVisible(true);
            handleRecipt(event);
            
        }
     
    }
    
    
     private int countAB = 0;
    public void dashboardDisplayAB(){
        
        String sql = "SELECT COUNT(id) FROM bus WHERE status = 'Available'";
        
        connect = database.connectDb();
        
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                countAB = result.getInt("COUNT(id)");
            }
            
            dashboard_availableB.setText(String.valueOf(countAB));
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
     private double incomeToday = 0;
    public void dashboardDisplayIT(){
        
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
        String sql = "SELECT SUM(total) FROM customer WHERE date ='"+sqlDate+"'";
        
        connect = database.connectDb();
        
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                incomeToday = result.getDouble("SUM(total)");
            }
            
            dashboard_incomeToday.setText("Tk.৳"+String.valueOf(incomeToday));
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
     private double totalIncome;
    public void dashboardDisplayTI(){
        
        String sql = "SELECT SUM(total) FROM customer";
        
        connect = database.connectDb();
        
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                totalIncome = result.getDouble("SUM(total)");
            }
            
            dashboard_totalncome.setText("Tk.৳"+String.valueOf(totalIncome));
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    
     public void dashboardChart(){
        
        dashboard_chart.getData().clear();
        
        String sql = "SELECT date,SUM(total) FROM customer WHERE date != '' GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 9";
        
        connect = database.connectDb();
        
        XYChart.Series chart = new XYChart.Series();
        
        try{

            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }
            
            dashboard_chart.getData().add(chart);
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    
    
    
    
    @FXML
    public void close(){ 
        System.exit(0);
    }
    @FXML
    public void minimize(){ 
        Stage stage=(Stage)main_form.getScene().getWindow();
        stage.setIconified(true);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        dashboardDisplayAB();
        dashboardDisplayIT();
        dashboardDisplayTI();
        dashboardChart();
        comboBoxStatus();
        availableBShowBusData();
        busIdList();
        LocationList();
        typeList();
        ticketNumList();
        genderList();
         customersShowDataList();
    }    

    @FXML
    private void handlereviced(ActionEvent event) {
        
     ObservableList<customerData> list=customersDataList();
        Pdf pdf = new Pdf();
        customerData cs = null;
    for(customerData fs:list){
        cs = fs;
 

}
     pdf.addRow(cs.getSeatNum().toString(),cs.getFirstName(),cs.getLastName(),cs.getGender(),cs.getPhoneNum(),cs.getLocation(),cs.getType(),cs.getTotal().toString());
    pdf.createPdf();
                 
    
    } 

   
    private void handleRecipt(ActionEvent event) throws IOException {
        String dest = new File("").getAbsolutePath()+" output.pdf" ;
        File file = new File(dest);  // Replace with your PDF file path
        PDDocument document = Loader.loadPDF(file);
        PDFRenderer renderer = new PDFRenderer(document);
        
        BufferedImage bufferedImage = renderer.renderImage(0); // Render first page
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        reciptAdpdf.setImage(image);
    }


}

