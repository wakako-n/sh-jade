package smarthome.ontology;

import jade.content.onto.*;
import jade.content.schema.*;
import java.util.*;

public class SensorOntology extends Ontology {

	/**
    A symbolic constant, containing the name of this ontology.
	 */
	public static final String NAME = "sensor-ontology";

	// VOCABULARY
	// Concepts
	public static final String SENSOR = "SENSOR";
	public static final String SENSOR_NAME = "name";
	public static final String SENSOR_VLAUE = "value";
	public static final String SENSOR_TYPE= "type";
	public static final String SENSOR_ROOM= "room";

	public static final String REASONER = "Reasoner";
	public static final String REASONER_NAME = "name";
	public static final String REASONER_ROOM= "room";

	public static final String ACTION = "ACTION";
	public static final String ACTION_COMMAND = "command";
	//public static final String ACTION_TYPE= "type";

	private static Ontology theInstance = new SensorOntology();

	public static Ontology getInstance() {
		return theInstance;
	}

	/**
	 * Constructor
	 */
	private SensorOntology() {
		//__CLDC_UNSUPPORTED__BEGIN
		super(NAME, BasicOntology.getInstance());

		try {
			add(new ConceptSchema(SENSOR), Sensor.class);
			add(new ConceptSchema(REASONER), Reasoner.class);
			add(new ConceptSchema(ACTION), Action.class);
			/*
		add(new PredicateSchema(WORKS_FOR), WorksFor.class);
		add(new PredicateSchema(PERSON_TOO_OLD), PersonTooOld.class);
		add(new PredicateSchema(ENGAGEMENT_ERROR), EngagementError.class);
		add(new AgentActionSchema(ENGAGE), Engage.class);
			 */
			ConceptSchema cs = (ConceptSchema)getSchema(SENSOR);
			cs.add(SENSOR_NAME, (PrimitiveSchema)getSchema(BasicOntology.STRING));
			cs.add(SENSOR_VLAUE, (PrimitiveSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
			cs.add(SENSOR_TYPE, (PrimitiveSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
			cs.add(SENSOR_ROOM, (PrimitiveSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);

			ConceptSchema cs2 = (ConceptSchema)getSchema(REASONER);
			cs.add(REASONER_NAME, (PrimitiveSchema)getSchema(BasicOntology.STRING));
			cs.add(REASONER_ROOM, (PrimitiveSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);

			ConceptSchema cs3 = (ConceptSchema)getSchema(ACTION);
			cs3.add(ACTION_COMMAND, (PrimitiveSchema)getSchema(BasicOntology.STRING));
			//cs3.add(ACTION_TYPE, (PrimitiveSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);

			/*    	
         	PredicateSchema ps = (PredicateSchema)getSchema(WORKS_FOR);
    	        ps.add(WORKS_FOR_PERSON, (ConceptSchema)getSchema(PERSON));
    	        ps.add(WORKS_FOR_COMPANY, (ConceptSchema)getSchema(COMPANY));

		AgentActionSchema as = (AgentActionSchema)getSchema(ENGAGE);
		as.add(ENGAGE_PERSON, (ConceptSchema)getSchema(PERSON));
		as.add(ENGAGE_COMPANY, (ConceptSchema)getSchema(COMPANY)); 	*/
		}
		catch(OntologyException oe) {
			oe.printStackTrace();
		}
	} 
}