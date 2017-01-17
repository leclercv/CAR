/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_car_client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.ArrayList;

/**
 *
 * @author sofian
 */
public class Client {

    private ArrayList<String> request = new ArrayList();

    public Client(ArrayList<String> req) {
        Socket as = null;
        this.request = req;
        try {
            as = new Socket(InetAddress.getLocalHost(), 4000);
            System.out.println("Client: Connection established");
            DataOutputStream out = new DataOutputStream(as.getOutputStream());
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(as.getInputStream()));
            for (String sentence : this.request) {
                out.writeBytes(sentence);
                System.out.println("Message sent : " + sentence);
                String response = in.readLine();
                System.out.println("Message received: " + response + "\n");
            }
            System.out.println("Client disconnected");
            as.close();
        } catch (UnknownHostException ex) {
            System.exit(-1);
        } catch (IOException ex) {
            System.exit(-1);
        }
    }
}
