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

    /**
     * Test of calculate method, of class Operation.
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");
        ArrayList<Integer> op = new ArrayList();
        ArrayList<String> operand = new ArrayList();
        op.add(1);
        op.add(3);
        operand.add("+");
        Operation instance = new Operation(op, operand);
        instance.calculate();
        assertEquals(instance.getResult(), "4");
    }

    /**
     * Test of recalculate method, of class Operation.
     */
    @Test
    public void testRecalculate() {
        System.out.println("recalculate");
        ArrayList<Integer> op = new ArrayList();
        ArrayList<String> operand = new ArrayList();
        op.add(1);
        op.add(3);
        operand.add("+");
        Operation lastOpe = new Operation(op, operand);
        lastOpe.calculate();
        ArrayList<Integer> op2 = new ArrayList();
        op2.add(3);
        Operation instance = new Operation(op2, operand);
        instance.recalculate(lastOpe);
        assertEquals(instance.getResult(), "7");
    }
}
