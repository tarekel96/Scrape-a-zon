/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tarek
 */
public class UserInputTest {
    
    public UserInputTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getString method, of class UserInput.
     */
//    @Test
//    public void testGetString() {
//        System.out.println("getString");
//        String msg = "";
//        String expResult = "";
//        String result = UserInput.getString(msg);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of isInt method, of class UserInput.
     */
    @Test
    public void testIsInt() {
        
        System.out.println("isInt");
        String input;
        boolean expResult;
        boolean result;
        
         // testing out string, "1"
        input = "1";
        expResult = true;
        result = UserInput.isInt(input);
        assertEquals(expResult, result);
        
        
        // testing out string, ""
        input = "";
        expResult = false;
        result = UserInput.isInt(input);
        assertEquals(expResult, result);
        
         // testing out string, HelloWorld 
        input = "HelloWorld";
        expResult = false;
        result = UserInput.isInt(input);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isDouble method, of class UserInput.
     */
    @Test
    public void testIsDouble() {
        
        System.out.println("isDouble");
        String input;
        boolean expResult;
        boolean result;
        
         // testing out string, "1"
        input = "1.0";
        expResult = true;
        result = UserInput.isDouble(input);
        assertEquals(expResult, result);
        
        
        // testing out string, ""
        input = "";
        expResult = false;
        result = UserInput.isDouble(input);
        assertEquals(expResult, result);
        
         // testing out string, HelloWorld 
        input = "HelloWorld";
        expResult = false;
        result = UserInput.isDouble(input);
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of getDouble method, of class UserInput.
//     */
//    @Test
//    public void testGetDouble() {
//        System.out.println("getDouble");
//        String msg = "";
//        double expResult = 0.0;
//        double result = UserInput.getDouble(msg);
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of main method, of class UserInput.
//     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        UserInput.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
