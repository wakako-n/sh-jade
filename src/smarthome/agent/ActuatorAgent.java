package smarthome.agent;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import smarthome.ontology.*;

public class ActuatorAgent extends Agent{
	private MessageTemplate template = MessageTemplate.and(
			MessageTemplate.MatchPerformative(ACLMessage.INFORM),
			MessageTemplate.MatchOntology(SensorOntology.NAME));

	protected void setup(){
		addBehaviour(new CyclicBehaviour(this){
			public void action(){
				ACLMessage msg = myAgent.receive(template);
				if(msg != null){
					Action c = null;
					String command = null;
					// String type =null; <-- it's required?
					try {
						c = (Action) msg.getContentObject();
						command = c.getCommand();
						//type = c.getType();		                 
					}
					catch(Exception e){
						System.err.println(" error: " + e.getMessage()); 
					}
					System.out.println("Recieve: "+command);
					/*
					 * sending signals to actuator after this
					 */
					switch(command) {
					case "turn-up-light":
						break;
					}
				}
				else{
					block();
				}
			}
		} );
	}
}
