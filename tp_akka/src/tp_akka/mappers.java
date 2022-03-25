package tp_akka;

import java.util.ArrayList;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class mappers extends UntypedActor{
	
	public String name;
	ArrayList<ActorRef> list = new ArrayList<>();
	
	public mappers(String name,ArrayList<ActorRef> reducers) {
		this.name=name;
		this.list=reducers;
	}
	
	
	public ActorRef partition(String mot,ArrayList<ActorRef>ltse) {
		int asciicode =(int) mot.charAt(0);
		return list.get(Math.abs(asciicode%list.size()));
		
	}
	
	

	@Override
	public void onReceive(Object arg) throws Exception {
		// TODO Auto-generated method stub
		if(arg instanceof Greeting) {
			System.out.println(((Greeting)arg).who);
		}
		else if(arg instanceof String) {
			String [] result= ((String)arg).split(" ");
			int i =0;
			while(i<result.length && result.length>1) {
				this.partition(result[i],this.list).tell(result[i], ActorRef.noSender());
				i+=1;
			}
		}
		else{
			unhandled(arg);
			}
		
	}

}
