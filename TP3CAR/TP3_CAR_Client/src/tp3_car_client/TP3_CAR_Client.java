/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_car_client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author sofian
 */
public class TP3_CAR_Client {

    static final String serverName = "localhost";
    static final int serverPort = 4010;
    static Socket as = null;

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(serverName, serverPort);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.flush();
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        System.out.println("Client created");

        Scanner sc = new Scanner(System.in);
        String clientText = sc.nextLine();
        Object response = "";
        while (!response.equals("quit")) {
            out.writeObject(clientText);
            out.flush();
            response = in.readObject();
            System.out.println(response);
            if (!response.equals("quit")) {
                System.out.println("-------\nwaiting for new entry\n---------");
                clientText = sc.nextLine();
            }
        }
        System.out.println("Closing connection");
        in.close();
        out.close();
        socket.close();
    }
}
