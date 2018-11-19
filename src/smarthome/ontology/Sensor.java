package smarthome.ontology;

import jade.content.Concept;

public class Sensor implements Concept {

	private String 	_name;           // sensor name
	private int        _value;          // sensor value
	private String      _type;           // sensor type
	private String      _room;	         // sensor room

	// Methods required to use this class to represent the ADDRESS role
	public void setName(String name) {
		_name=name;
	}
	public String getName() {
		return _name;
	}
	public void setValue(int value) {
		_value=value;
	}
	public int getValue() {
		return _value;
	}
	public void setType(String type) {
		_type=type;
	}
	public String getType() {
		return _type;
	}
	public void setRoom(String room) {
		_room=room;
	}
	public String getRoom() {
		return _room;
	}

	// Other application specific methods
	public boolean equals(Sensor a){
		if (!_name.equalsIgnoreCase(a.getName())){
			if(!_room.equalsIgnoreCase(a.getRoom())) 
				return false;
		}
		return true;
	}
}
