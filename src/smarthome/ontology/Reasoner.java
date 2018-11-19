package smarthome.ontology;

import jade.content.Concept;
import jade.core.AID;

public class Reasoner implements Concept {
	
    private String 	_name;
    private String   _room;
    private AID      _idd;
	
    // Methods required to use this class to represent the ADDRESS role
    public void setName(String name) {
	    _name = name;
    }
    public String getName() {
	    return _name;
    }
    public void setRoom(String room) {
	    _room = room;
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
