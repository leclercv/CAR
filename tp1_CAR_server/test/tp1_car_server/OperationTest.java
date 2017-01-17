/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_car_server;

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
public class OperationTest {
    
    public OperationTest() {
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
     * Test of calculate method, of class Operation.
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");
        Operation instance = null;
        instance.calculate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recalculate method, of class Operation.
     */
    @Test
    public void testRecalculate() {
        System.out.println("recalculate");
        Operation lastOpe = null;
        Operation instance = null;
        instance.recalculate(lastOpe);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Operation.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Operation instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOp method, of class Operation.
     */
    @Test
    public void testGetOp() {
        System.out.println("getOp");
        Operation instance = null;
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.getOp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOp method, of class Operation.
     */
    @Test
    public void testSetOp() {
        System.out.println("setOp");
        ArrayList<Integer> op = null;
        Operation instance = null;
        instance.setOp(op);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOperand method, of class Operation.
     */
    @Test
    public void testGetOperand() {
        System.out.println("getOperand");
        Operation instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getOperand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOperand method, of class Operation.
     */
    @Test
    public void testSetOperand() {
        System.out.println("setOperand");
        ArrayList<String> operand = null;
        Operation instance = null;
        instance.setOperand(operand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResult method, of class Operation.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        Operation instance = null;
        String expResult = "";
        String result = instance.getResult();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResult method, of class Operation.
     */
    @Test
    public void testSetResult() {
        System.out.println("setResult");
        String result_2 = "";
        Operation instance = null;
        instance.setResult(result_2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
