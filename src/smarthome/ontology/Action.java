package smarthome.ontology;

import jade.content.Concept;

public class Action implements Concept {

	private String 	_command;           // operation name
	//private String      _type;               // actuator type

	public void setCommand(String command) {
		_command=command;
	}
	public String getCommand() {
		return _command;
	}
	/*public void setType(String type) {
		_type=type;
	}
	public String getType() {
		return _type;
	}*/

}
