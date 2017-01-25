package Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.xml.bind.ParseConversionEvent;

public class Server {

    private int nbThreads;
    private ArrayList<MyThread> threads = new ArrayList();

    public void service() {
        for (int i = 0; i < this.nbThreads; i++) {
            MyThread t = new MyThread();
            this.threads.add(t);
        }
    }

    public Server(Integer nb) {
        this.nbThreads = nb;
    }

    public void start() {
        ServerSocket ps = null;
        this.service();
        try {
            ps = new ServerSocket(4010);
            Socket as = ps.accept();
            System.out.println("Connection established");
            while (true) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(as.getInputStream()));
                DataOutputStream out = new DataOutputStream(as.getOutputStream());
                String msg = in.readLine();
                if (msg != null) {
                    System.out.println("Message received: " + msg);
                    for (MyThread th : this.threads)
                    {
                        th.run(msg);
                    }
                    out.writeBytes("blabla\n");
                    System.out.println("Response has been sent.");
                }
            }
        } catch (IOException ex) {
            System.exit(-1);
        }
    }

}
