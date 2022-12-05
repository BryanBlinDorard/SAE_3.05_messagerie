import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        try {
            System.out.println("Bonjour, veuillez entrer l'adresse IP du serveur :");
            Scanner sc = new Scanner(System.in);
            String sc1 = sc.nextLine();
            Socket client = new Socket(sc1, 1234);
            System.out.println("Connexion au serveur reussie");

            System.out.println("Veuillez entrer votre nom :");
            String nomClient = sc.nextLine();

            // Envoie du nom du client au serveur
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF(nomClient);

            // On récupère le message du serveur
            DataInputStream in = new DataInputStream(client.getInputStream());
            String message = in.readUTF();
            System.out.println(message);
        } catch (Exception e) {
            if (e instanceof UnknownHostException) {
                System.out.println("Je ne trouve de serveur avec cette adresse IP");
            } else if (e instanceof IOException) {
                System.out.println("Erreur de connexion");
            }
        }
    }
}