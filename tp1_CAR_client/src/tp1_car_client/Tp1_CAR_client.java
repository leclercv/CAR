/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_car_client;

import java.util.ArrayList;

/**
 *
 * @author sofian
 */
public class Tp1_CAR_client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<String> req = new ArrayList();
        req.add("2 + 3\n");
        req.add("6 / 3\n");
        req.add("6 * 2\n");
        req.add("3 - 1\n");
        req.add("4 + 10\n");
        req.add("+ 5\n");
        Client cl = new Client(req);
    }

}
