/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Helper;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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
    
    @FXML
    private Text outputText;
    
    // Non-FXML fields 
    private WebScraper Scraper;
    private String userInput;
    private boolean m_loading;
    private ArrayList<String> options = new ArrayList();
    
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
        options.add("travel");
        options.add("mystery");
        options.add("historical");
        options.add("fiction");
        options.add( "classics");
        options.add("fiction");
        userInput = userSearchInput.getText();
        if(Helper.inputIsValid(userInput.toLowerCase(), options) == false) {
            outputText.setText("Error: An invalid book category was entered.\nPlease follow directions.");
            return;
        }
        Scraper = new WebScraper(userInput, outputLabel, outputText);
        Scraper.fetchData(getLoading());
        if(!options.isEmpty()) {
            options.clear();
        }
        //scrapeProgressBar.setVisible(false);
    }
}
