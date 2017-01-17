/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_car_server;

import java.util.ArrayList;

/**
 *
 * @author sofian
 */
public class Operation {

    private ArrayList<Integer> op;
    private ArrayList<String> operand;
    private String result = "";

    public Operation(ArrayList<Integer> op, ArrayList<String> operand) {
        this.op = op;
        this.operand = operand;
    }

    public void calculate() {
        for (String operandTmp : this.operand) {
            for (int i = 0; i < op.size(); i += 2) {
                Integer op1 = op.get(i);
                Integer op2 = op.get(i + 1);
                if (operandTmp.equals("+")) {
                    this.result = String.valueOf(op1 + op2);
                } else if (operandTmp.equals("-")) {
                    this.result = String.valueOf(op1 - op2);
                } else if (operandTmp.equals("*")) {
                    this.result = String.valueOf(op1 * op2);
                } else if (operandTmp.equals("/")) {
                    this.result = String.valueOf(op1 / op2);
                } else {
                    this.result = "Erreur d'operand";
                }
            }
        }
    }

    public void recalculate(Operation lastOpe) {
        for (String operandTmp : this.operand) {
            for (int i = 0; i < op.size(); i++) {
                Integer op1 = op.get(i);
                if (operandTmp.equals("+")) {
                    this.result = String.valueOf(op1 + Integer.parseInt(lastOpe.getResult()));
                } else if (operandTmp.equals("-")) {
                    this.result = String.valueOf(op1 - Integer.parseInt(lastOpe.getResult()));
                } else if (operandTmp.equals("*")) {
                    this.result = String.valueOf(op1 * Integer.parseInt(lastOpe.getResult()));
                } else if (operandTmp.equals("/")) {
                    this.result = String.valueOf(op1 / Integer.parseInt(lastOpe.getResult()));
                } else {
                    this.result = "Erreur d'operand";
                }
            }
        }
    }

    public String toString() {
        return this.result + "\n";
    }

    public ArrayList<Integer> getOp() {
        return op;
    }

    public void setOp(ArrayList<Integer> op) {
        this.op = op;
    }

    public ArrayList<String> getOperand() {
        return operand;
    }

    public void setOperand(ArrayList<String> operand) {
        this.operand = operand;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
