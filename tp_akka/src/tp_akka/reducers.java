package tp_akka;

import java.util.HashMap;

import akka.actor.UntypedActor;

public class reducers  extends UntypedActor{
	public String name;
	public HashMap<String,Integer> wordlist = new HashMap<String,Integer>();
	
	public reducers(String name,HashMap<String,Integer>list) {
		this.name=name;
		this.wordlist=list;
	}
	
	@Override
	public void onReceive(Object arg) throws Exception {
		// TODO Auto-generated method stub
		if(arg instanceof String) {
			if(wordlist.containsKey(arg)){
				wordlist.put((String)arg, wordlist.get(arg)+1); 
			}
			else {this.wordlist.put((String)arg, 1);
		}
		
	}
		else {
			unhandled(arg);
		}
	
	

}
	public HashMap<String,Integer> getList(){
		return this.wordlist;
	}
}
