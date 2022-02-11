package ftp;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            //demande de connexion au serveur
            Socket sock = new Socket("localhost", 2056);

            //envoyer une donnéé au serveur
            System.out.println("msg");

            // on recuper la donnéé par la console
            Scanner sc = new Scanner(System.in);
            String Msg = sc.next();

            //envoye une donnéé au serveur
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            // on recupere la donée envoyée par le serveur

            PrintStream out = new PrintStream(sock.getOutputStream());
            out.println(Msg);
            //repurer la chaine de caractere

            System.out.println(in.readLine());

            while (true) {
                Msg = sc.next();
                out.println(Msg);
            }

        } catch (Exception ex) {
            System.out.println();

        }
    }
}