
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch4ass;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rant
 */
public class Ch4ass extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane paneTableView = FXMLLoader.load(getClass().getResource("TableViewPane.fxml"));
        Map<String,Pane>mapPanes=new TreeMap<>(); 
        mapPanes.put("tableView", paneTableView);
        
        Scene scene = new Scene(mapPanes.get("tableView"));
        
        primaryStage.setTitle("Student App");
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
