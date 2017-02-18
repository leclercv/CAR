/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_car_server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sofian
 */
public class Server {

    private int nbFiles = 0;
    static final int port = 4010;
    private String repertoirePath = "/home/sofian/Bureau/M1_MIAGE/CAR/TP2CAR/TP3_CAR_server/download_files/Files";
    private String filePath = "/home/sofian/Bureau/M1_MIAGE/CAR/TP2CAR/TP3_CAR_server/download_files/Files/";
    private String tagsPath = "/home/sofian/Bureau/M1_MIAGE/CAR/TP2CAR/TP3_CAR_server/download_files/";

    private HashMap<String, ArrayList<String>> fileAndTags = new HashMap();

    public Server() {
    }

    public void parsingLineTags(String ligne) {
        String[] tag = ligne.split(":");
        for (int i = 0; i < tag.length; i++) {
            if (fileAndTags.containsKey(tag[i])) {
                ArrayList<String> tags = fileAndTags.get(tag[i]);
                tags.add(tag[0]);
                fileAndTags.put(tag[i], tags);
            }
        }
    }

    public String parsingFormat(String ligne) {
        String format = ligne.substring(ligne.length() - 3);
        if (format.equals("txt")) {
            return "text";
        }
        if (format.equals("bin")) {
            return "binaire";
        }
        return "Not recognized";
    }

    public ArrayList<String> listeTags() {
        ArrayList<String> tags = new ArrayList();
        File tagsfile = new File(tagsPath + "tags");
        try {
            InputStream ips = new FileInputStream(tagsfile);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne = "";
            while ((ligne = br.readLine()) != null) {
                parsingLineTags(ligne);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return tags;
    }

    public ArrayList<String> listeRepertoire(File repertoire) {
        if (repertoire.exists() && repertoire.isDirectory()) {
            File[] fichiers = repertoire.listFiles();
            ArrayList<String> listfiles = new ArrayList();
            if (fichiers != null) {
                for (File fichier : fichiers) {
                    nbFiles++;
                    fileAndTags.put(fichier.getName(), new ArrayList());
                }
                return listfiles;
            } else {
                System.err.println(repertoire + " : Erreur de lecture.");
            }
        }
        return null;
    }

    public void getCommand(ObjectOutputStream out, String filename) throws IOException {
        File file = new File(filePath + filename);
        File repertoire = new File(repertoirePath);
        if (file.exists()) {
            listeRepertoire(repertoire);
            listeTags();
            ArrayList<String> tab = new ArrayList();
            for (Map.Entry<String, ArrayList<String>> entry : fileAndTags.entrySet()) {
                String key = entry.getKey();
                if (key.equals(file.getName())) {
                    tab = entry.getValue();
                }
            }
            String format = parsingFormat(file.getName());
            try {
                InputStream ips = new FileInputStream(file);
                InputStreamReader ipsr = new InputStreamReader(ips);
                BufferedReader br = new BufferedReader(ipsr);
                String ligne = "";
                String chaine = "";
                while ((ligne = br.readLine()) != null) {
                    parsingLineTags(ligne);
                    chaine += ligne + "\n";
                }
                br.close();
                if (format.equals(format.equals("bin")))
                chaine = Base64.getEncoder().encodeToString(chaine.getBytes("UTF-8"));
                out.writeObject("FIC " + file.getName() + "\n" + "TAGS: " + tab.toString() + "\nTYPE: " + format + "\n\n" + chaine + "\n\n");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } else {
            out.writeObject("ERR 404\nFile does not exist");
        }
        out.flush();

    }

    public void listCommand(ObjectOutputStream out) throws IOException {
        File repertoire = new File(repertoirePath);
        listeRepertoire(repertoire);
        listeTags();
        String listResponse = "NUM " + nbFiles + "\n";
        for (Map.Entry<String, ArrayList<String>> entry : fileAndTags.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> tab = entry.getValue();
            listResponse += key + "\n" + tab.toString() + "\n";
        }
        out.writeObject(listResponse + "\n");
        out.flush();
        nbFiles = 0;
        fileAndTags.clear();
    }

    public void start() throws Exception {
        ServerSocket s = new ServerSocket(port);
        Socket soc = s.accept();
        System.out.println("Serveur a accepte connexion: " + soc);

        ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());
        out.flush();
        ObjectInputStream in = new ObjectInputStream(soc.getInputStream());

        while (true) {
            String msg = (String) in.readObject();
            if (msg.equals("quit")) {
                out.writeObject("quit");
                out.flush();
                System.out.println("closing connection with client");
                soc.close();
                soc = s.accept();
                out = new ObjectOutputStream(soc.getOutputStream());
                out.flush();
                in = new ObjectInputStream(soc.getInputStream());
            } else {
                String[] tokens = msg.split(" ");
                if (tokens[0].equals("GET") && tokens.length > 1) {
                    getCommand(out, tokens[1]);
                } else if (tokens[0].equals("LIST")) {
                    listCommand(out);
                } else {
                    out.writeObject("Command not known\n");
                    out.flush();
                }
            }
        }
    }
}
