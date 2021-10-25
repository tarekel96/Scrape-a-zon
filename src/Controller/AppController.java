/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Tarek
 */
public class AppController {
    
    @FXML
    private TextField userSearchInput;
    
    @FXML
    private Label outputLabel;
    
    @FXML
    private Button searchButton;
    
    private String userInput;
    
    public void submit(ActionEvent event) {
        userInput = userSearchInput.getText();
        
        outputLabel.setText(userInput);
    }
    
    @FXML
    public void initialize() {
        System.out.println("hello");
    }
    
    /**
     * Initializes the controller class.
     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }    
    
}
