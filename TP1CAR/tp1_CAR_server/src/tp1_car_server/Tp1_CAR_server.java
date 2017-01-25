/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_car_server;

/**
 *
 * @author sofian
 */
public class Tp1_CAR_server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Server sv = new Server();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
