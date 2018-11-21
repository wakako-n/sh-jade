package smarthome.agent;


import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.content.lang.sl.*;
import jess.*;
import java.io.*;
import java.util.Hashtable;
import java.util.Iterator;
import smarthome.ontology.*;
import smarthome.ontology.Action;
import utils.Prop;
import jade.content.*;
import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.onto.basic.*;
import jade.lang.acl.*;

public class ReasonerBehaviour extends CyclicBehaviour {
	Rete jess;
	Agent myAgent;
	String actuator = Prop.getProperty("ac_a");
	private MessageTemplate template = MessageTemplate.and(
			MessageTemplate.MatchPerformative(ACLMessage.INFORM),
			MessageTemplate.MatchOntology(SensorOntology.NAME));
	AID iid = new AID(actuator, AID.ISLOCALNAME);

	public ReasonerBehaviour(Agent agent, String jessFile){
		// Create a Jess engine
		super(agent);
		jess = new Rete();
		myAgent = agent;
		try {
			FileReader fr = new FileReader(jessFile);
			Jesp j = new jess.Jesp(fr, jess);
			// parse and execute one construct, without printing a prompt
			j.parse(false);
		} catch (JessException re) {
			System.out.println(re);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}

	public void action() {
		ACLMessage rmsg = myAgent.receive(template);

		Iterator fact;
		String command= null, name = null, type = null;
		int value = -100;

		if (rmsg != null) {
			Sensor s = null;
			// getting the sensor status from receive message
			try{
				s = (Sensor) rmsg.getContentObject();
				name = s.getName();
				value= s.getValue();
				type = s.getType();		
			}
			catch(Exception e){
				System.err.println(" error: " + e.getMessage()); 
			}
			// assert the fact message in Jess
			try {
				Fact fac = new Fact("sensor", jess);
				fac.setSlotValue("name", new Value(name, RU.STRING));
				fac.setSlotValue("value", new Value(value, RU.INTEGER));
				fac.setSlotValue("type", new Value(type, RU.STRING));
				jess.assertFact(fac);
				fact = jess.listFacts(); 
				// getting the result fact about action command
				while(fact.hasNext()){
					Fact fac2 = (Fact)fact.next();
					if( fac2.getName().equals("MAIN::Action")){ 
						command = fac2.getSlotValue( "command" ).toString();
						System.out.println( "command: " +  command);
						// sending the result command to actuator agent
						try {
							Action a = new Action();
							ACLMessage smsg = new ACLMessage(ACLMessage.INFORM);
							a.setCommand(command);
							smsg.addReceiver(iid);
							smsg.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
							smsg.setOntology(SensorOntology.NAME);
							smsg.setContentObject(a);
							myAgent.send(smsg);
						}
						catch(Exception e){
							System.err.println(" error: " + e.getMessage()); 
						}
					}
				}   
			} catch (JessException e) {
				e.printStackTrace();
			}
		}
		else {
			block();
		}
		try {
			jess.run();

		} catch (JessException re) {
			re.printStackTrace(System.err);
		}
	}


}