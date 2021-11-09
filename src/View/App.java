package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.fxmisc.cssfx.CSSFX;
//import javafx.scene.control.Button;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
/**
 *
 * @author Tarek
 */
public class App extends Application {
    
    @Override
    public void start(Stage stage) {
        try {
            // load FXML Scene Builder - root node of application
            Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));
            Scene scene = new Scene(root);
            // set CSS stylesheet
            String css = this.getClass().getResource("app.css").toExternalForm();
            scene.getStylesheets().add(css);
            CSSFX.start();

            // App icon image
            Image iconImage = new Image("View/assets/images/scraper.png");

            // set title and icon image
            stage.setTitle("Scrap-A-Zon");
            stage.getIcons().add(iconImage);

            // set stage size
            stage.setHeight(600);
            stage.setWidth(900);

            // default positioning of stage
            stage.setX(50);
            stage.setY(50);
            stage.setScene(scene);
        
            //root.getChilren().add(header);
            stage.show();
        }
        catch(IOException e) {
            System.out.println("Error: An error occurred in opening the file.");
            System.out.println(e);
        }
        catch(Exception e) {
            System.out.println("Error: An unexpected error occurred.");
            System.out.println(e);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
