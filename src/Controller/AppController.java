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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
    
    public String testJsoup() {
        String html = "<html><head><title>Sample Title</title></head>"
                + "<body><p>Sample Content</p></body></html>";
        String parsedText = "";
        Document document = Jsoup.parse(html);
        System.out.println(document.title());
        Elements paragraphs = document.getElementsByTag("p");
        for (Element paragraph : paragraphs) {
            parsedText += paragraph.text();
        }
        return parsedText;
    }
    
    public void submit(ActionEvent event) {
        userInput = userSearchInput.getText();
        
//        outputLabel.setText(userInput);
        outputLabel.setText(testJsoup());
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
