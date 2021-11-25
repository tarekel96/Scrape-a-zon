/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Tarek
 * Represents an Amazon product
 */
public class Product {
    
    /* CONSTRUCTOR */
    public Product(String name, double price, int numOfReviews, float rating) {
        m_name = name;
        m_price = price;
        m_numOfReviews = numOfReviews;
        m_rating = rating;
    }
    
    
    /* FIELDS */
    private String m_name;
    private double m_price;
    private int m_numOfReviews;
    private float m_rating;
    
    /* METHODS */
    @Override
    public String toString() {
        String ret = "\n******************\nProduct";
        ret += "\nName: " + m_name;
        ret += "\nPrice: " + Helper.convertDoubleToStr(m_price);
        ret += "\nProduct Rating: " + Helper.convertFloatToStr(m_rating);
        ret += "\nNumber of Reviews: " + Helper.convertIntToStr(m_numOfReviews);
        return ret;
    }
}
