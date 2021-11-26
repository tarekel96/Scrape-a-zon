/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Tarek
 * Static class for general helper methods
 */
public class Helper {


    public static String convertIntToStr(int i) {
        return (new Integer(i)).toString();
    }

    public static String convertFloatToStr(float f) {
        return (new Float(f)).toString();
    }
    
    public static String convertDoubleToStr(double d) {
        return (new Double(d)).toString();
    }
    
    public static String convertBooleanToStr(boolean b) {
        return (new Boolean(b)).toString();
    }
}
