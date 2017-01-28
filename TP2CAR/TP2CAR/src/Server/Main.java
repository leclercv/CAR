/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author casier
 */
public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("You need to put the number of threads used");
            return;
        }

        Server server = new Server(Integer.parseInt("4"));
        server.start();
    }
}
