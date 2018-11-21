package smarthome.agent;
import jade.core.Agent;
import utils.Prop;

public class ReasonerAgent extends Agent{
		protected void setup(){
			String filepath = Prop.getProperty("url");
		    addBehaviour(new ReasonerBehaviour(this,filepath)); 
		}
	}
