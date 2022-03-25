package tp_akka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;



public class Main {
	public static void main(String[] args) throws InterruptedException{
		Config conf = ConfigFactory.parseString("system1{\r\n"
				+"akka{\r\n"
				+"remot{\r\n"
				+"enabled-transports =[\"akka.remot.netyy.tcp\"]\r\n"
				+" nettytcp{\r\n"
				+"hostname =\"localhost\"\r\n"
				+"port= 2523\r\n"
				+"}\r\n"
				+"}\r\n"
				+"}\r\n"
				+"}\r\n"
				+"\r\n"
				+ "system2{\r\n"
				+"akka{\r\n"
				+"remot{\r\n"
				+"enabled-transports =[\"akka.remot.netyy.tcp\"]\r\n"
				+" nettytcp{\r\n"
				+"hostname =\"localhost\"\r\n"
				+"port= 2524\r\n"
				+"}\r\n"
				+"}\r\n"
				+"}\r\n"
				+"}\r\n"
				+"");
		Config one = conf.getConfig("system1");
		Config two= conf.getConfig("system2");
		
		ActorSystem system1 = ActorSystem.create("system1",one);
		ActorSystem system2 = ActorSystem.create("system1",two);
		
		
		ActorRef mapper1,mapper2,mapper3,reducer1,reducer2,reducer3,reducer4;
		HashMap<String,Integer> wordlist = new HashMap<String,Integer> ();
		
		
		reducer1 =system1.actorOf(Props.create(reducers.class,"reducer1",wordlist),"reducer1");
		reducer2 =system1.actorOf(Props.create(reducers.class,"reducer2",wordlist),"reducer2");
		reducer3 =system2.actorOf(Props.create(reducers.class,"reducer3",wordlist),"reducer3");
		reducer4 =system2.actorOf(Props.create(reducers.class,"reducer4",wordlist),"reducer4");
	
		ArrayList<ActorRef> list = new ArrayList<>();
		list.add(reducer1);
		list.add(reducer2);
		list.add(reducer3);
		list.add(reducer4);
		
		
		
		
		mapper1=system1.actorOf(Props.create(mappers.class,"mapper1",list),"mapper1");
		mapper2=system1.actorOf(Props.create(mappers.class,"mapper2",list),"mapper2");
		mapper3=system2.actorOf(Props.create(mappers.class,"mapper3",list),"mapper3");
		
		HashMap<Integer,ActorRef> liste = new HashMap<Integer,ActorRef>();
		 liste.put(1, mapper1);
		 liste.put(2, mapper2);
		 liste.put(3, mapper3);
		 
		 
		 try {
			 int cpt =0;
			 File file = new File("/home/azzi/eclipse-workspace/tp_akka/src/tp_akka/texte.txt");
			 Scanner reader = new Scanner(file);
			 while(reader.hasNextLine()) {
				 String data = reader.nextLine();
				 liste.get(cpt%3 +1).tell(data.toLowerCase(), ActorRef.noSender());
				 cpt+=1;
			 }
			 reader.close();
		 }catch(FileNotFoundException e) {
			 System.out.println("error");
			 e.printStackTrace();
		 }
		 Thread.sleep(3000);
		 
		 Set set = wordlist.entrySet();
		 Iterator iterator = set.iterator();

		 while(iterator.hasNext()) {
			 Map.Entry me = (Map.Entry)iterator.next();
			 System.out.println("mot"+ me.getKey()+"est repete :"+ me.getValue());
		 }
		 system1.shutdown();
		 system2.shutdown();
		 
	}

}
