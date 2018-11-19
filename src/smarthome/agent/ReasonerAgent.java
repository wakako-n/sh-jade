package smarthome.agent;

import jade.core.Agent;

public class ReasonerAgent extends Agent{
		protected void setup(){
			String filepath = "/home/wakako-nakano/eclipse-workspace/smarthome/src/agent/Reasoner.clp";
		    addBehaviour(new ReasonerBehaviour(this,filepath)); 
		}
	}
