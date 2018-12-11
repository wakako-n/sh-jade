package smarthome.agent;

import jade.core.*;
import jade.core.behaviours.*;
import smarthome.ontology.*;
import utils.Prop;
import jade.lang.acl.*;
import eu.hansolo.galileo.*;

public class SensorAgent extends Agent {

	// delete later
	String sensorname = "light";
	int   sensorvalue = 9;
	String sensortype = "light";
	// AGENT BEHAVIOURS
	class HandleSensorBehaviour extends TickerBehaviour {		
		public HandleSensorBehaviour(Agent myAgent){
			super(myAgent,5000);   // how often to take a value from sensor
		}

		public void onTick(){
			try{
				GalileoIO galileoIO = new GalileoIO();
                                double  value = galileoIO.getAnalog(Analog.A0);
                                sensorvalue = (int) value;
 
                                // getting the value from sensor around here, now assign the specified value
				// TODO -- change --- get value from sensor
				// TODO -- change --- add number of sensor
				// set values 
				Sensor s = new Sensor();
				System.out.println("  Sensor name --> "+sensorname);			
				s.setName(sensorname);
				System.out.println("  Sensor value ---> "+sensorvalue);			
				s.setValue(sensorvalue);
				System.out.println("  Sensor type -----> "+sensortype);
				s.setType(sensortype);
				//System.out.print("  Sensor room -----> ");
				//s.setRoom(sensorroom);
				System.out.println(SensorOntology.NAME);
				//Ontology o = myAgent.getContentManager().lookupOntology(SensorOntology.NAME);		
				// Create and send an ACL message
				ACLMessage informMsg = new ACLMessage(ACLMessage.INFORM);
				informMsg.addReceiver(iid);
				//informMsg.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
				informMsg.setOntology(SensorOntology.NAME);
				informMsg.setContentObject(s);
				send(informMsg);
			} 
			catch (Exception e) { 
				System.err.println(" error: " + e.getMessage()); 
			}

		}

	}

	Reasoner d ;
	AID iid;
	// AGENT SETUP: 
	protected void setup() {

		// Register the codec for the SL0 language
		//getContentManager().registerLanguage(new SLCodec(), FIPANames.ContentLanguage.FIPA_SL0);	

		// Register the ontology used by this application
		//getContentManager().registerOntology(SensorOntology.getInstance());
		String reanm= Prop.getProperty("rn_a");
		iid = new AID(reanm, AID.ISLOCALNAME);
		// Create and add the main behaviour of this agent
		addBehaviour(new HandleSensorBehaviour(this));
	}

}
