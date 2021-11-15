/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import javafx.scene.control.Label;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Tarek
 */
public class WebScraper {
    
    // Overloaded Constructor
    public WebScraper(String tag, Label outputLabel) {
        m_outputLabel = outputLabel;
        initializeConnection(tag);
    }
    
    /* ************** FIELDS ************** */
    private boolean scrapeCompleted = false;
    private final String BASE_URL = "https://www.amazon.com/s?k=";
    private Document document = null;
    private Label m_outputLabel;
    
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
    
    public void fetchData(boolean loading, Label outputLabel) {
        setScrapeCompleted(false);
        System.out.println("Scrape begun...");
        Element element = null;
        loading = true;
        while(loading) {
            element = this.document.getElementById("nav-logo");
            if(element != null) {
                loading = false;
            }
        }
        setScrapeCompleted(true);

        String output = "Finished Scraping";
        output += "\nResults:";
        output += element.outerHtml();
        System.out.println(output);
        m_outputLabel.setText(output);
    }
}
