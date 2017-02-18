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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
 
public class Serveur {
    static final int port = 9999;
 
    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(port);
        System.out.println("Socket serveur: " + s);
 
        Socket soc = s.accept();
 
        System.out.println("Serveur a accepte connexion: " + soc);
 
        ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());
        out.flush();
 
        ObjectInputStream in = new ObjectInputStream(soc.getInputStream());
 
 
        System.out.println("Serveur a cree les flux");
 
        int[] tableauAEmettre = {7, 8, 9};
        String test = "testons avec une string";
        
        out.writeObject(test);
        out.flush();
 
        System.out.println("Serveur: donnees emises");
 
        Object objetRecu = in.readObject();
        int[] tableauRecu = (int[]) objetRecu;
 
        System.out.println("Serveur recoit: " + Arrays.toString(tableauRecu));
 
        in.close();
        out.close();
        soc.close();
    }
}