/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Tarek
 */
public class WebScraper {
    
    // Overloaded Constructor
    public WebScraper(String tag, Label outputLabel, TextFlow outputText) {
        m_tag = tag; // tag is userInput
        m_outputLabel = outputLabel;
        m_outputText = outputText;
        initializeConnection(tag);
    }
    
    /* ************** FIELDS ************** */
    private String m_tag;
    private boolean scrapeCompleted = false;
    private final String BASE_URL = "https://www.amazon.com/s?k=";
    private final String PROD_CLASS_NAME = "a-size-base-plus a-color-base a-text-normal";
    private final String PROD_CLASS_PRICE = "a-offscreen";
    private final String PROD_CLASS_numREVIEWS = "a-size-base";
    private final String PROD_CLASS_ratingREVIEWS = "a-icon-alt";
    private Document document = null;
    private Label m_outputLabel;
    private TextFlow m_outputText;
    
    /* ************** MUTATORS ************** */
    private void setDocument(Document doc) {
        document = doc;
    }
    
    private void setScrapeCompleted(boolean sc) {
        scrapeCompleted = sc;
    }
    
    /* ************** ACCESSORS ************** */
    public boolean getScrapeStatus() {
        return scrapeCompleted;
    }
    
    /* ************** HELEPER FUNCTIONS ************** */
    private void initializeConnection(String tag) {
        String url = BASE_URL;
        if(tag != null) {
            url += tag;
        }
        try {
            m_outputLabel.setText("Loading...");
            setDocument(Jsoup.connect(url).get());
        }
        catch(MalformedURLException e) {
            System.out.println("Error: the request URL is not a HTTP or HTTPS URL, or is otherwise malformed");
        }
        catch(HttpStatusException e) {
            System.out.println("Error: the response is not OK and HTTP response errors are not ignored");
        }
        catch(UnsupportedMimeTypeException e) {
            System.out.println("Error: the response mime type is not supported and those errors are not ignored");
        }
        catch(SocketTimeoutException e) {
            System.out.println("Error: the connection times out");
        }
        catch(IOException e) {
            System.out.println("Error: An unknown error occurred in trying to connect to Amazon");
        }
    }
    
    // helper method for getting size of results as a String
    private String returnResultSizeStr(ArrayList list) {
        return (new Integer(list.size())).toString();
    }
    
    // method for fetching data via web JSoup
    public void fetchData(boolean loading) {
        setScrapeCompleted(false);
        System.out.println("Scrape begun...");
        Element element = null;
        Elements products = null;

        loading = true;
        
        // brute force solution of updating loading state
        while(loading) {
            //element = this.document.getElementById("nav-logo");
            products = this.document.getElementsByClass(PROD_CLASS_PRICE);
            if(products != null) {
                loading = false;
            }
        }
        for (Element product : products) {

            System.out.println(product.text());

        }
        System.out.println(returnResultSizeStr(products));
        System.out.println(products);
        
//        setScrapeCompleted(true);
//        // set label
//        String outputLabelStr = "Finished Scraping for " + m_tag;
//        outputLabelStr += "\nResults:\n";
//        m_outputLabel.setText(outputLabelStr);
//        
//        String output = "";
//        output += element.outerHtml();
//        Text text = new Text(output);
//        m_outputText.getChildren().add(text);
//        System.out.println(output);
    }
}
