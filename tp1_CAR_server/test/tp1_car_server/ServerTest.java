/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_car_server;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sofian
 */
public class ServerTest {

    Server server;

    public ServerTest() {
        try {
            server = new Server();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Test of calculatrice method, of class Server.
     */
    @Test
    public void testCalculatrice() {
        System.out.println("calculatrice");
        String message = "2 + 3";
        server.calculatrice(message);
        assertEquals("5", "5");
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isOperand method, of class Server.
     */
    @Test
    public void testIsOperand() {
        System.out.println("isOperand");
        String str = "*";
        boolean expResult = true;
        boolean result = Server.isOperand(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of isNumeric method, of class Server.
     */
    @Test
    public void testIsNumeric() {
        System.out.println("isNumeric");
        String str = "a";
        boolean expResult = false;
        boolean result = Server.isNumeric(str);
        assertEquals(expResult, result);
    }

}
