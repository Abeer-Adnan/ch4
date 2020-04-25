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
public class TableViewPaneController implements Initializable {

    private TextField txtFieldID;
    private TextField txtFieldName;
    private TextField txtFieldMajor;
    private TextField txtFieldGrade;
    @FXML
    private TableView<Student> tableView;
    private TableColumn<Student, Integer> tcID;
    private TableColumn<Student, String> tcName;
    private TableColumn<Student, String> tcMajor;
    private TableColumn<Student, Double> tcGrade;
    @FXML
    private Button buttonShow;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonReset;
    @FXML
    private Button buttonExit;

    Statement statement;
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
    private TableColumn<?, ?> tcIDStudent;
    @FXML
    private TableColumn<?, ?> tcIDCourse;
    @FXML
    private TableColumn<?, ?> tcSemester;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
               DriverManager.
                getConnection("jdbc:mysql://127.0.0.1:3306/college?serverTimezone=UTC",
                        "root", "");
            this.statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcMajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("grade"));
        tableView.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedStudent() );
    
    }    

    @FXML
    private void buttonShowHandle(ActionEvent event) throws Exception {
    ResultSet rs = this.statement.executeQuery("Select * From Student");
        tableView.getItems().clear();
        while(rs.next()){
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setMajor(rs.getString("major"));
            student.setGrade(rs.getDouble("grade"));
            tableView.getItems().add(student);
        }
    }

    @FXML
    private void buttonAddHandle(ActionEvent event) throws Exception{
         Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String major = txtFieldMajor.getText();
        Double grade = Double.parseDouble(txtFieldGrade.getText());
        String sql = "Insert Into Student values(" + id + ",'" +name + "','" 
                + major + "'," + grade + ")";
        this.statement.executeUpdate(sql);
    }

    private void buttonEditHandle(ActionEvent event) throws Exception{
        Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String major = txtFieldMajor.getText();
        Double grade = Double.parseDouble(txtFieldGrade.getText());
        String sql = "Update Student Set name='" + name + "', major='" + 
                major + "', grade=" + grade + " Where id=" +id;
        this.statement.executeUpdate(sql);
    }

    private void buttonDeleteHandle(ActionEvent event) throws SQLException {
        Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String major = txtFieldMajor.getText();
        Double grade = Double.parseDouble(txtFieldGrade.getText());
        String sql = "Delete From Student Where id=" +id;
        this.statement.executeUpdate(sql);
    }


    @FXML
    private void buttonResetHandle(ActionEvent event) {
        resetControls();
    }
 private void resetControls(){
        txtFieldID.setText("");
        txtFieldName.setText("");
        txtFieldMajor.setText("");
        txtFieldGrade.setText("");
        tableView.getItems().clear();
    }
 
    @FXML
    private void buttonExitHandle(ActionEvent event) {
        System.exit(0);
    }
    private void showSelectedStudent(){
        Student student = tableView.getSelectionModel().getSelectedItem();
        if(student != null){
        txtFieldID.setText(String.valueOf(student.getId()));
        txtFieldName.setText(student.getName());
        txtFieldMajor.setText(student.getMajor());
        txtFieldGrade.setText(String.valueOf(student.getGrade()));
        }

    }
    
}
