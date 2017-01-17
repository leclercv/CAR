/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_car_server;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sofian
 */
public class ServerTest {
    
    public ServerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculatrice method, of class Server.
     */
    @Test
    public void testCalculatrice() {
        System.out.println("calculatrice");
        String message = "";
        Server instance = new Server();
        String expResult = "";
        String result = instance.calculatrice(message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOperand method, of class Server.
     */
    @Test
    public void testIsOperand() {
        System.out.println("isOperand");
        String str = "";
        boolean expResult = false;
        boolean result = Server.isOperand(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNumeric method, of class Server.
     */
    @Test
    public void testIsNumeric() {
        System.out.println("isNumeric");
        String str = "";
        boolean expResult = false;
        boolean result = Server.isNumeric(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
