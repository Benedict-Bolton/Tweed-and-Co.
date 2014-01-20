import java.util.*;
public class State extends Others{
    
    //Instance Vars
    String[] _redStates = {"Oregon","Montana","Idaho","Wyoming","South Dakota","Nebraska","Kansas","Iowa","Nevada","Utah","Arizona","Alaska","Colorado","New Mexico","Oklahoma","Louisiana","Mississippi","Alabama","Florida","Georgia","South Carolina","Tennessee","Kentucky","Indiana","Ohio","New Hampshire","New Jersey","Delaware"};
    String[] _bluStates = {"Maine","New York","Massachussetts","Connecticut","Rhode Island","Pennsylvania","Virginia","Vermont","Maryland","West Virginia","North Carolina","Michigan","Wisconsin","North Dakota","Minnesota","Illinois","Missouri","Arkansas","Texas","California","Oregon","Hawaii"};
    String _stateName;
    
    public State(String stateName) throws Exception{
	int redIndex=-1;
	int bluIndex=-1;
	for(int i=0; i<_bluStates.length; i++){
	    if (_bluStates[i].equals(stateName)){
		bluIndex = i;}
	}
	for(int i=0; i<_redStates.length; i++){
	    if (_redStates[i].equals(stateName)){
		redIndex = i;}
	}

	if(redIndex < 0 && bluIndex < 0){
	    throw new Exception("Hey! That's not a state. -_-");
	}
	else{
	    _stateName = stateName;
	    if (redIndex > 0){ //create a Republican-leaning state
		setExRight(0.35 );
		setExLeft(0.20);
		setCompRight(0.65);
		setCompLeft(0.35);
		setHawks(45);
		setBears(40);
		setAveInc(35000);
	    }
	    else { //create a Democratic-leaning state
		setExRight(0.20);
		setExLeft(0.35);
		setCompRight(0.35);
		setCompLeft(0.65);
		setHawks(45);
		setBears(40);
		setAveInc(35000);	
	    }

	}//end else
    }//end constructor


    //toString method--returns _stateName and other instance vars
    public String toString(){
	String s ="This is what "+_stateName+ " looks like...";
	s+="\n\t"+getReps()+"% registered Republicans";
	s+="\n\t"+getDems()+"% registered Democrats";
	s+="\n\tRepublican extremism: "+getExRight()*100+"%";
	s+="\n\tDemocratic extremism: "+getExLeft()*100+"%";
	s+="\n\tThe people's willingness to intervene in the world (hawkishness): "+getHawks()+"%";
	s+="\n\tThe people's bleeding-heart charity for the world: "+getBears()+"%";
	s+="\n\tThe average household's income: $"+getAveInc();
	return s;
    }
}//end class
