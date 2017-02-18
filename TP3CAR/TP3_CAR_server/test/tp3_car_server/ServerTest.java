/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_car_server;

import java.io.File;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
     * Test of parsingLineTags method, of class Server.
     */
    @Test
    public void testParsingLineTags() {
        System.out.println("parsingLineTags");
        String ligne = "";
        Server instance = new Server();
        instance.parsingLineTags(ligne);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parsingFormat method, of class Server.
     */
    @Test
    public void testParsingFormat() {
        System.out.println("parsingFormat");
        String ligne = "";
        Server instance = new Server();
        String expResult = "";
        String result = instance.parsingFormat(ligne);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listeTags method, of class Server.
     */
    @Test
    public void testListeTags() {
        System.out.println("listeTags");
        Server instance = new Server();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.listeTags();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listeRepertoire method, of class Server.
     */
    @Test
    public void testListeRepertoire() {
        System.out.println("listeRepertoire");
        File repertoire = null;
        Server instance = new Server();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.listeRepertoire(repertoire);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCommand method, of class Server.
     */
    @Test
    public void testGetCommand() throws Exception {
        System.out.println("getCommand");
        ObjectOutputStream out = null;
        String filename = "";
        Server instance = new Server();
        instance.getCommand(out, filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listCommand method, of class Server.
     */
    @Test
    public void testListCommand() throws Exception {
        System.out.println("listCommand");
        ObjectOutputStream out = null;
        Server instance = new Server();
        instance.listCommand(out);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Server.
     */
    @Test
    public void testStart() throws Exception {
        System.out.println("start");
        Server instance = new Server();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
