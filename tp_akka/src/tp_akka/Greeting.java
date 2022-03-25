package tp_akka;

import java.io.Serializable;

public class Greeting implements Serializable{
	
	public String who;
	
	public Greeting(String who) {
		this.who=who;
	}

}
