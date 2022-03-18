package ftp;
import java.io.IOException;
import ftp.Server;

/**
 * classe principale qui permet de lancer le serveur en créant une instance de celui-ci
 * @author razika
 *
 */
public class Main {
	public static void main(String[] args) {
		int port = 2056;
		
		
		try {
			Server s = new Server(port);
		}catch(IOException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
}
