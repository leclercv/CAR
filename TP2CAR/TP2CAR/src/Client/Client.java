package Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    static Socket as = null;

    public static void main(String[] args) throws UnknownHostException, IOException {
        try {
            System.out.println("Debut client");
            as = new Socket(InetAddress.getLocalHost(), 4010);
            System.out.println("Client: Connection established");
            DataOutputStream out = new DataOutputStream(as.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(as.getInputStream()));
            InputStream flux = new FileInputStream("/home/sofian/Bureau/M1_MIAGE/CAR/TP2CAR/TP2CAR/text2.txt");
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String ligne = "";
            while ((ligne = buff.readLine()) != null) {
                ligne += "\n";
                out.writeBytes(ligne);
                String response = in.readLine();
                System.out.println(response);
            }
            buff.close();
            as.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
