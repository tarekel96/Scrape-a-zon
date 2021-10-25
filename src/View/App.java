package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//import javafx.scene.control.Button;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
/**
 *
 * @author Tarek
 */
public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        // root node of application
        StackPane root = new StackPane();
        
        // main scene of App
        Scene scene = new Scene(root, 300, 250);
        
        // App icon image
        Image iconImage = new Image("View/assets/images/scraper.png");
        
        primaryStage.setTitle("Scrap-A-Zon");
        primaryStage.getIcons().add(iconImage);
        primaryStage.setScene(scene);
        
        Text header = new Text("Welcome to Scrap-A-Zon");
        
        //root.getChilren().add(header);
        primaryStage.show();

//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        root.getChildren().add(btn);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
