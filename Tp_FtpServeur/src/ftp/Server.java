package ftp;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * classe qui écoute en permanance si un client cherche à se connecter au serveur.
 * @author razika
 *
 */
public class Server {
	
	public Server(int port) throws IOException,InterruptedException {
		
		ServerSocket server = new ServerSocket(port);
		System.out.println("debut du serveur sur le port:" + port );
		while(true) {
			Socket sock = server.accept();
			System.out.println("un client vient de se connecter ");
			FtpThread thread = new FtpThread(sock,server,port);
			thread.start();
			
		}
		
		
	}

}
