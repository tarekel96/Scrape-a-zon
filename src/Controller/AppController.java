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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Tarek
 */
public class AppController {
    
    /* ************** FIELDS ************** */
    
    // FXML fields
    @FXML
    private TextField userSearchInput;
    @FXML
    private Label outputLabel;
    @FXML
    private Button searchButton;
    @FXML
    private ProgressBar scrapeProgressBar;
    
//    @FXML
//    private void initialize() {
//        System.out.println(scrapeProgressBar.toString());
//    }
    
    // Non-FXML fields 
    private WebScraper Scraper;
    private String userInput;
    private boolean m_loading;
   
    
    /* ************** Methods ************** */
    // loading mutator
    public void setLoading(boolean loading) {
        m_loading = loading;
    }
    // loading accessor
    public boolean getLoading() {
        return m_loading;
    }
    
    public void submit(ActionEvent event) {
        userInput = userSearchInput.getText();
        Scraper = new WebScraper(userInput, outputLabel);
        Scraper.fetchData(getLoading(), outputLabel);
    }
}
