package Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Server {

    private int nbThreads;
    private int nb = 0;
    private int pos = 0;
    private String word = "";
    private String[] tokens;
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

    public void parsing(String message) {

        this.tokens = message.split(" ");
    }

    public String divideMessage(String messageThread, Integer counterThread) {
        int nbword = this.tokens.length / nbThreads;
        for (int i = 0; i < nbword; i++) {
            messageThread += this.tokens[pos] + " ";
            pos++;
        }
        if (counterThread == nbThreads) {
            for (; pos < this.tokens.length; pos++) {
                messageThread += this.tokens[pos] + " ";
            }
        }
        return messageThread;
    }
    
    public void mergeMap() {
        HashMap<String, Integer> finalMap = new HashMap();
        for (MyThread th : this.threads) {
            th.getMapWord().forEach((k, v) -> finalMap.merge(k, v, Integer::sum));
        }
        Iterator it = finalMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if ((Integer) pair.getValue() > nb) {
                this.word = (String) pair.getKey();
                this.nb = (Integer) pair.getValue();
            }
            it.remove();
        }
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
                    parsing(msg);
                    int counterThread = 1;
                    for (MyThread th : this.threads) {
                        String messageThread = "";
                        messageThread = divideMessage(messageThread, counterThread);
                        Counter counter = new Counter(messageThread);
                        th.setCounter(counter);
                        counterThread++;
                        th.run();
                    }
                    mergeMap();
                    out.writeBytes("Word most found : " + word + " with " + nb + " occurences\n");
                    System.out.println("Response has been sent.");
                }
            }
        } catch (Exception ex) {
            System.exit(-1);
        }
    }

}
