package ftp;
import java.io.*;
import java.net.*;
import java.nio.file.*;

public class FtpThread extends Thread{
	
	private Socket sock;
	private ServerSocket server;
	private String user ="razika";
	private String pass ="pass";
	private DataOutputStream dataOut ;
	private PrintStream output;
	private BufferedReader buff1;
	//private BufferedReader buff2;
	private int port;
	private String currentDir;
	//private String root;
	//private File directory;
	private Mode mode;
	
	
	
	public FtpThread(Socket s, ServerSocket ser,int p) {
		this.sock = s;
		this.server =  ser;
		this.port = p;
	}
	
	public void run() {
		try {
			
			// entrée client 
			this.buff1 = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
			this.output = new PrintStream(this.sock.getOutputStream());
			
			// sortie pour le client
			this.dataOut = new DataOutputStream(output);
			dataOut.writeBytes("220 service pret pour un autre utilisateur\r\n");
			
			
			Path currentRelativePath = Paths.get(".");
			this.currentDir = currentRelativePath.toAbsolutePath().toString();
			
			
			String res ="";
			while(!res.equals("QUIT")) {
				
				System.out.println("attend la commande ");
				String data = buff1.readLine();
				if(data!=null) {
					System.out.println("commande reçu: " + data );
					res = this.CommandRequest(data);
					this.dataOut.writeBytes( res + "\r\n");
					
				}else {
					
					res = "QUIT";
					dataOut.writeBytes("221" + res + "\r\n");
				}
				
				
			}
			this.sock.close();		
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public String CommandRequest(String request) throws IOException{
		String[] data = request.split(" ");
		String res ="";
		String cmd = data[0];
		
		switch (cmd) {
		case "USER":
			for(String d : data){
				System.out.println("Data " + d);
			}
			res = this.User(data[1]);
		
			break;
		
		case "PASS":
			res =this.Pass(data[1]);
			break;
		
		case "LIST":
			this.LIST();			
			break;
				
		case "CWD":
			this.CWD(data[1]);
			break;
		
		case "QUIT":
			res =this.Quit(data[0]);
			break;

		default:
			res = "500 Syntax error ";
		}
		
		return res ;
		
		}
	
	
	//comportement de commande de l'utilisateur
	public String User(String data){
		
		if(data.equals(this.user)){
			return("331 User name success, please put your password");
		}
		return "500 Wrong user/password";
		
	} 	
		
		
	//comportement commande de mot de pass	
	public String Pass(String data){
		if(data.equals(this.pass)){
			return "230 Logged in"; 
		}
		return "500 Wrong user/password";
	}
	
	// comportement commande quit
	public String Quit(String data){
		return "221 QUIT"; 
	}
	
	
	//comportement commande cd
	public String	CWD(String directory){
		File chemin = new File(directory).getAbsoluteFile();
		if(chemin.exists()){
			
			boolean res = (System.setProperty("user.dir", chemin.getAbsolutePath())!=null);
			
			if(!res)
			{
				return "500 ERROR";
			}
			this.currentDir = directory;
			return  "200 directory changed";
		}
		else{

			return "431 directory not exist ";
		}
	}

	
   // comportement commande dir/list	
   private void LIST() throws IOException {
		
		// check connection
		if(sock.isClosed() || sock==null) {
			try {
				this.server = new ServerSocket(port);
				this.sock = this.server.accept();
				this.dataOut = new DataOutputStream(this.sock.getOutputStream());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		this.dataOut.writeBytes("150  open data connection."+ "\r\n");
				
		//String filename = this.currentDir;
		// ouverture de socket
		if (mode == Mode.PASSIF) {
				this.sock = this.server.accept();
		} else {
			this.sock = new Socket(sock.getInetAddress(), port);
		}
        
}
}
   



	
	
