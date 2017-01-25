package Server;

import java.util.HashMap;

public class Counter {

    private String message;
    private String[] tokens;

    public Counter(String message) {
        this.message = message;
        this.tokens = message.split(" ");
/*        for (int i = 0; i < tokens.length; i++)
        {
            System.out.println("tokens is : " + tokens[i]);
        }*/
    }

    public void counting(HashMap<String, Integer> map) {
        for (int i = 0; i < this.tokens.length; i++) {
            if (map.containsKey(this.tokens[i])) {
                Integer nb = map.get(this.tokens[i]);
                map.put(this.tokens[i], nb + 1);
            } else {
                map.put(this.tokens[i], 1);
            }
        }
    }

}
