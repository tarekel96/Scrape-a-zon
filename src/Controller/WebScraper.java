/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GridMatrix;
import Model.Helper;
import Model.Product;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Tarek
 */
public class WebScraper {
    
    // Overloaded Constructor
    public WebScraper(String tag, Label outputLabel, Text outputText) {
        m_tag = tag; // tag is userInput
        m_outputLabel = outputLabel;
        m_outputText = outputText;
        initializeConnection(tag);
    }
    
    /* ************** FIELDS ************** */
    private final String PROD_CLASS_NAME = "h3";
    private final String PROD_CLASS_PRICE = "price_color";
    private final String PROD_CLASS_AVAILABILITY = "instock availability";
    private String m_tag;
    private boolean scrapeCompleted = false;
    private Elements productNames;
    private Elements productPrices;
    private Elements productAvailabilities;
    private ArrayList<Product> products = new ArrayList();
    private GridMatrix m_gridMatrix;
    private Document document = null;
    private Label m_outputLabel;
    private Text m_outputText;
    
    /* ************** MUTATORS ************** */
    private void setDocument(Document doc) {
        document = doc;
    }
    
    private void setScrapeCompleted(boolean sc) {
        scrapeCompleted = sc;
    }
    
    public void generateProducts() { 
        for(int i = 0; i < productNames.size(); ++i) {
            String name = productNames.get(i).text();
            double price = Double.parseDouble(productPrices.get(i).text().substring(1));
            boolean inStock = assignAvailability(productAvailabilities.get(i).text());
            products.add(new Product(name, price, inStock));
        }
    }
    
    public void printProducts() {
        // print out items to ensure that were created
        for(Product cp: products) {
            System.out.println(cp);
        }
    }
    
    public void clearCollections() {
        try {
            productNames.clear();
            productPrices.clear();
            productAvailabilities.clear();
        }
        catch(Exception e) {
            System.out.println("Error: An error occurred in trying to clear collections");
        }
    }
    
    /* ************** ACCESSORS ************** */
    public boolean getScrapeStatus() {
        return scrapeCompleted;
    }
    
    public GridMatrix getGridMatrix() {
        return m_gridMatrix;
    }
    
    /* ************** HELEPER FUNCTIONS ************** */
    private void initializeConnection(String tag) {
        String url = "https://books.toscrape.com/catalogue/category/books/" + getProperTag(tag) + "/index.html";
        System.out.println("URL: " + url);
        try {
            m_outputLabel.setText("Loading...");
            setDocument(Jsoup
                    .connect(url)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.55 Safari/537.36")
                    .get());
        }
        catch(MalformedURLException e) {
            String errMsg = "Error: the request URL is not a HTTP or HTTPS URL, or is otherwise malformed";
            System.out.println(errMsg);
            m_outputText.setText(errMsg);
            e.printStackTrace();
        }
        catch(HttpStatusException e) {
            String errMsg = "Error: the response is not OK and HTTP response errors are not ignored";
            System.out.println(errMsg);
            m_outputText.setText(errMsg);
            e.printStackTrace();
        }
        catch(UnsupportedMimeTypeException e) {
            String errMsg = "Error: the response mime type is not supported and those errors are not ignored";
            System.out.println(errMsg);
            m_outputText.setText(errMsg);
            e.printStackTrace();
        }
        catch(SocketTimeoutException e) {
            String errMsg = "Error: the connection times out";
            System.out.println(errMsg);
            m_outputText.setText(errMsg);
            e.printStackTrace();
        }
        catch(IOException e) {
            String errMsg = "Error: An unknown error occurred in trying to connect to Amazon";
            System.out.println(errMsg);
            m_outputText.setText(errMsg);
            e.printStackTrace();
        }
    }
    
    public String getProperTag(String tag) {
        tag = tag.toLowerCase().replaceAll("\\s", "");
        String ret = "";
        switch(tag) {
            case "travel":
                ret = "travel_2";
                break;
            case "mystery":
                ret = "mystery_3";
                break;
            case "historicalfiction":
                ret = "historical-fiction_4";
                break;
            case "classics":
                ret = "classics_6";
                break;
            case "fiction":
                ret = "fiction_10";
                break;
            default:
                ret = "books_1";
                break;
        }
        return ret;
    }
    
    // helper method for getting size of results as a String
    private String returnResultSizeStr(ArrayList list) {
        return (new Integer(list.size())).toString();
    }
    
    private boolean listsAreEqualSize() {
        // using for-each loop for iteration over Map.entrySet()
        if(productNames.size() != productPrices.size()) {
            return false;
        }
        if(productNames.size() != productAvailabilities.size()) {
            return false;
        }
        if(productPrices.size() != productAvailabilities.size()) {
            return false;
        }
        return true;
    }
    
    // nneded bc Product model availability field is a boolean
    public boolean assignAvailability(String text) {
        return text.equals("In stock");
    }
    
    // method for fetching data via web JSoup
    public int fetchData(boolean loading) {
        clearCollections();
        setScrapeCompleted(false);
        System.out.println("Scrape begun...");
        loading = true;
        
        // brute force solution of updating loading state
        while(loading) {
            /* get NAMES */
            productNames = this.document.select(PROD_CLASS_NAME);
            System.out.println("Product Names Size: " + Helper.convertIntToStr(productNames.size()));
            /* get PRICES */
            productPrices = this.document.getElementsByClass(PROD_CLASS_PRICE);
            System.out.println("Product Prices Size: " + Helper.convertIntToStr(productPrices.size()));
            /* get AVAILABILITIES */
            productAvailabilities = this.document.getElementsByClass(PROD_CLASS_AVAILABILITY);
            System.out.println("Product Availability Size: " + Helper.convertIntToStr(productAvailabilities.size()));
            
            boolean test = listsAreEqualSize();
            if(test == false) {
                String errMessage = "Error: The data was not able to fetched correctly";
                System.out.println(errMessage);
                m_outputLabel.setText(errMessage);
                return -1; // -1 indicates the fetch failed
            }
            loading = false;
        }
        System.out.println("Scrape completed");
        // instantiate the products using Product model
        generateProducts();
        // generate the GridMatrix of products
        int rows = productAvailabilities.size(); 
        int columns = 3;
        ArrayList<String> columnTitles = new ArrayList();
        columnTitles.add("Name");
        columnTitles.add("Price");
        columnTitles.add("Is Available (in stock)");
        m_gridMatrix = new GridMatrix(rows, columns, columnTitles, products);
        System.out.println(m_gridMatrix);
        m_outputLabel.setText("Results: ");
        m_outputText.setText(m_gridMatrix.toString());
        return 0;
    }
}
