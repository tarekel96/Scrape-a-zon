/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Helper;
import Model.Product;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Label;
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
    private final String BASE_URL = "http://books.toscrape.com/";
    private final String PROD_CLASS_NAME = "result-heading";
    private final String PROD_CLASS_PRICE = "span.result-meta span.result-price";
    private final String PROD_CLASS_LOCATION = "result-meta result-hood";
    private Elements productNames;
    private Elements productPrices;
    private Elements productOrigins;
    private HashMap<String, Elements> resultsHashMap = new HashMap();
    private ArrayList<Product> products = new ArrayList();
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
    
    public void generateProducts() { 
        
    }
    
    public void clearCollections() {
        try {
            productNames.clear();
            productPrices.clear();
            productOrigins.clear();
            resultsHashMap.clear();
        }
        catch(Exception e) {
            System.out.println("Error: An error occurred in trying to clear collections");
        }
    }
    
    /* ************** ACCESSORS ************** */
    public boolean getScrapeStatus() {
        return scrapeCompleted;
    }
    
    public String attachTag(String tag) {
        return "sss?query=?" + tag;
    }
    
    /* ************** HELEPER FUNCTIONS ************** */
    private void initializeConnection(String tag) {
        String url = BASE_URL;
        if(tag != null) {
            url += attachTag(tag);
        }
        try {
            m_outputLabel.setText("Loading...");
            setDocument(Jsoup
                    .connect(url)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.55 Safari/537.36")
                    .get());
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
    
    private boolean listsAreEqualSize(HashMap<String, Elements> hm, int correctSize) {
         // using for-each loop for iteration over Map.entrySet()
        System.out.println(Helper.convertIntToStr(correctSize));
        for (Map.Entry<String, Elements> entry : hm.entrySet()){
            System.out.println(Helper.convertIntToStr(entry.getValue().size()));
            if(entry.getValue().size() != correctSize) { 
                System.out.println("Error: The list sizes are not of equal lengths");
                return false;
            }
        }
        return true;
    }
    
    // method for fetching data via web JSoup
    public void fetchData(boolean loading) {
        clearCollections();
        setScrapeCompleted(false);
        System.out.println("Scrape begun...");
        loading = true;
        
        // brute force solution of updating loading state
        Elements tempPrices = null;
        ArrayList<Element> pricesArrayList = new ArrayList();
        while(loading) {
            productNames = this.document.getElementsByClass(PROD_CLASS_NAME);
            System.out.println("Product Names Size: " + Helper.convertIntToStr(productNames.size()));
            resultsHashMap.put("productNames", productNames);
            productPrices = this.document.getElementsByClass(PROD_CLASS_PRICE);
            System.out.println("Product Prices Size: " + Helper.convertIntToStr(productPrices.size()));
//            tempPrices = this.document.getElementsByClass(PROD_CLASS_PRICE);
//            // remove duplicate prices from tempPrices and store in productPrices
//            for (int i = 0; i < tempPrices.size(); ++i) {
//                if(i % 2 == 0) {
//                    pricesArrayList.add(tempPrices.get(i));
//                }
//            }
            // clear tempPrices
//            tempPrices.clear();
//            productPrices = new Elements(pricesArrayList);
            resultsHashMap.put("productPrices", productPrices);
            //productOrigins = this.document.getElementsByClass(PROD_CLASS_LOCATION);
            //System.out.println("Product Origins Size: " + Helper.convertIntToStr(productOrigins.size()));
            //resultsHashMap.put("productOrigins", productOrigins);
            boolean test = listsAreEqualSize(resultsHashMap, resultsHashMap.get("productNames").size());
            if(test == false) {
                System.out.println("Error: The data was not able to fetched correctly");
            }
            loading = false;
        }
        System.out.println("Scrape completed");
    }
}
