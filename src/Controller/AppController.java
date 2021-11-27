/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FileHelper;
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
    @FXML
    private Button saveButton;
    
    // Non-FXML fields 
    private WebScraper m_scraper;
    private FileHelper m_fileHelper;
    private String m_userInput;
    private boolean m_loading;
    private ArrayList<String> m_options = new ArrayList();
    
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
        saveButton.setVisible(false);
        m_options.add("travel");
        m_options.add("mystery");
        m_options.add("historical");
        m_options.add("fiction");
        m_options.add( "classics");
        m_options.add("fiction");
        m_userInput = userSearchInput.getText();
        if(Helper.inputIsValid(m_userInput.toLowerCase(), m_options) == false) {
            outputText.setText("Error: An invalid book category was entered.\nPlease follow directions.");
            return;
        }
        m_scraper = new WebScraper(m_userInput, outputLabel, outputText);
        int response = m_scraper.fetchData(getLoading());
        if(response == 0) {
            saveButton.setVisible(true);
        }
        if(!m_options.isEmpty()) {
            m_options.clear();
        }
    }
    
    public void saveToFile(ActionEvent event) {
        // only triggers if the saveButton is visible
        if(saveButton.isVisible()) {
            if(m_scraper.getGridMatrix() == null) {
                System.out.println("Error: Cannot write results to file because the scraper is missing a GridMatrix.");
            }
            // only writes if has matrix to write to file
            else {
                m_fileHelper = new FileHelper(m_scraper.getGridMatrix());
                m_fileHelper.writeOutputToFile();
            }
        }
    }
}
