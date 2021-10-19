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
public class TestTest {
    
    public TestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of giveA method, of class Test.
     */
    @Test
    public void testGiveA() {
        System.out.println("giveA");
        char expResult = 'a';
        char result = Controller.Test.giveA();
        assertEquals(expResult, result);
    }

    /**
     * Test of giveB method, of class Test.
     */
    @Test
    public void testGiveB() {
        System.out.println("giveB");
        char expResult = 'b';
        char result = Controller.Test.giveB();
        assertEquals(expResult, result);
    }

    /**
     * Test of giveC method, of class Test.
     */
    @Test
    public void testGiveC() {
        System.out.println("giveC");
        char expResult = 'c';
        char result = Controller.Test.giveC();
        assertEquals(expResult, result);
    }
    
}
