package Server;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyThread extends Thread {

    private HashMap<String, Integer> mapWord = new HashMap();
    private Counter counter;
    public MyThread() {
    }

    public synchronized void run() {

        counter.counting(mapWord);
        try {
            this.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public HashMap<String, Integer> getMapWord() {
        return mapWord;
    }

    public void setMapWord(HashMap<String, Integer> mapWord) {
        this.mapWord = mapWord;
    }

    public Counter getCounter() {
        return counter;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }

    
    public void displayHashMap() {
        Iterator it = this.mapWord.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove();
        }
    }
}
