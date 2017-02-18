/* ############################################################################
 * 
 * Serveur.java : transmission de tableaux Java via des sockets
 * Client.java   
 * 
 * Auteur : Christophe Jacquet, Supélec
 * 
 * Historique
 * 2012-06-21  Création
 * 
 * ############################################################################
 */
 
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;
 
public class Client {
    static final String serverName = "localhost";
    static final int serverPort = 9999;
 
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(serverName, serverPort);
        System.out.println("Socket client: " + socket);
 
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.flush();
 
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
 
        System.out.println("Client a cree les flux");
 
        int[] tableauAEmettre = {1, 2, 3};
 
        out.writeObject(tableauAEmettre);
        out.flush();
 
        System.out.println("Client: donnees emises");
 
        Object objetRecu = in.readObject();
//        int[] tableauRecu = (int[]) objetRecu;
        System.out.println(objetRecu);
//        System.out.println("Client recoit: " + Arrays.toString(tableauRecu));
 
        in.close();
        out.close();
        socket.close();
    }
}