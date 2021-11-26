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
    public Product(String name, double price, boolean isAvailable) {
        m_name = name;
        m_price = price;
        m_isAvailable = isAvailable;
    }
    
    
    /* FIELDS */
    private String m_name;
    private double m_price;
    private boolean m_isAvailable;
    
    /* METHODS */
    @Override
    public String toString() {
        String ret = "\n******************\nProduct";
        ret += "\nName: " + m_name;
        ret += "\nPrice: " + Helper.convertDoubleToStr(m_price);
        ret += "\nIs Available: " + Helper.convertBooleanToStr(m_isAvailable);
        return ret;
    }
}
