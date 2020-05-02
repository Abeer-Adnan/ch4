/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch4ass.Q2;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author rant
 */
public class Qustionn2 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane paneQustion2 = FXMLLoader.load(getClass().getResource("Qustionn2.fxml"));
       
        
        Map<String,Pane>mapPanes=new TreeMap<>(); 
        mapPanes.put("Qustion2", paneQustion2);
      
        
        Scene scene = new Scene(mapPanes.get("Qustion2"));
        
        primaryStage.setTitle("Query App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
//select * from student where major = 'Software Engineering';
//select * from student where grade >= 90 ;
//select * from student where grade >=60 order by name;
//update student set grade = grade + 3 where major = 'Computer Science' and grade <70;  