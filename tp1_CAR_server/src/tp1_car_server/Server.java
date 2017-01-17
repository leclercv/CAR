/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_car_server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author sofian
 */
public class Server {

    private Operation lastOperation;

    public Server() {
        ServerSocket ps = null;
        try {
            ps = new ServerSocket(4000);
            Socket as = ps.accept();
            System.out.println("Connection established");
            while (true) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(as.getInputStream()));
                DataOutputStream out = new DataOutputStream(as.getOutputStream());
                String msg = in.readLine();
                if (msg != null) {
                    System.out.println("Message received: " + msg);
                    String result = "";
                    result = calculatrice(msg);
                    out.writeBytes(result);
                    System.out.println("Response has been sent.");
                }
            }
        } catch (IOException ex) {            
            System.exit(-1);
        }
    }

    public String calculatrice(String message) {
        ArrayList<String> operand = new ArrayList();
        ArrayList<Integer> op = new ArrayList();
        String result = "";
        String[] parsedMessage = message.split(" ");
        for (String t : parsedMessage) {
            if (isNumeric(t)) {
                op.add(Integer.parseInt(t));
            } else if (isOperand(t)) {
                operand.add(t);
            } else {
                result = "Erreur dans la syntaxe\n";
                return result;
            }
        }
        Operation operation = new Operation(op, operand);
        if (parsedMessage.length == 2) {
            if (isOperand(parsedMessage[0]) && isNumeric(parsedMessage[1])) {
                operation.recalculate(lastOperation);
            }
        } else {
            operation.calculate();
        }
        this.lastOperation = operation;
        result = operation.toString();
        return result;
    }

    public static boolean isOperand(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
