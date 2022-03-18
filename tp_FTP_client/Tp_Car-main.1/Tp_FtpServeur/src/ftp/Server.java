package ftp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * classe qui écoute en permanance si un client cherche à se connecter au serveur.
 *
 * @author razika
 */
public class Server {

    public Server(int port) throws IOException, InterruptedException {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("debut du serveur sur le port:" + port);
            while (true) {
                Socket sock = server.accept();
                System.out.println("un... ");
                FtpThread thread = new FtpThread(sock, server, port);


                String msg = "";
                //on recuper la donnée envoye par le client et effectue un traitement
                BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));


                msg = "bienvenue " + in.readLine() + ",t'es bien connecte\r\n";
                System.out.println("hi");
                //on envoie la donnée au client
                PrintStream out = new PrintStream(sock.getOutputStream());
                out.println(msg);

                out.flush();
                thread.start();

                //sock.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}