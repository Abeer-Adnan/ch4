/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch4ass;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author rant
 */
public class AddCourseController implements Initializable {

    @FXML
    private Label StudentID;
    @FXML
    private TextField txtFieldstudentID;
    @FXML
    private TextField txtFieldCourseid;
    @FXML
    private TextField txtFieldSemester;
    @FXML
    private Label CourseID;
    @FXML
    private Label Semester;
    @FXML
    private TableView<Registration> tableView;
    @FXML
    private TableColumn<Registration,Integer > tcIDStudent;
    @FXML
    private TableColumn<Registration, Integer> tcIDCourse;
    @FXML
    private TableColumn<Registration, String> tcSemester;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonShow;
    @FXML
    private Button buttonReset;
    @FXML
    private Button buttonExit;
    Statement statement;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
               DriverManager.
                getConnection("jdbc:mysql://127.0.0.1:3306/college?serverTimezone=UTC",
                        "root", "");
            this.statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tcIDStudent.setCellValueFactory(new PropertyValueFactory("studentid"));
        tcIDCourse.setCellValueFactory(new PropertyValueFactory("courseid"));
        tcSemester.setCellValueFactory(new PropertyValueFactory("semester"));
       
        tableView.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedRegistration() );
    }    

    @FXML
    private void buttonAddHandle(ActionEvent event) throws SQLException {
         Integer studentID = Integer.parseInt(txtFieldstudentID.getText());
        Integer courseid = Integer.parseInt(txtFieldCourseid.getText());
        String semester = txtFieldSemester.getText();
       
        String sql = "Insert Into Registration values(" + studentID + ",'"  
                + courseid + "'," + semester + ")";
        this.statement.executeUpdate(sql);
    }

    @FXML
    private void buttonShowHandle(ActionEvent event) throws SQLException {
        ResultSet rs = this.statement.executeQuery("Select * From Registration");
        tableView.getItems().clear();
        while(rs.next()){
            Registration registration = new Registration();
            registration.setStudentid(rs.getInt("studentid"));
            registration.setCourseid(rs.getInt("courseid"));
            registration.setSemeste(rs.getString("semester "));
            tableView.getItems().add(registration);
        }
    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
        txtFieldstudentID.setText("");
        txtFieldCourseid.setText("");
        txtFieldSemester.setText("");
        tableView.getItems().clear();
    }

    @FXML
    private void buttonExitHandle(ActionEvent event) {
        System.exit(0);
    }
     private void showSelectedRegistration(){
        Registration registration = tableView.getSelectionModel().getSelectedItem();
        if(registration != null){
        txtFieldstudentID.setText(String.valueOf(registration.getStudentid()));
        txtFieldCourseid.setText(String.valueOf(registration.getCourseid()));
        txtFieldSemester.setText(registration.getSemeste());
        
        }

    }
}
