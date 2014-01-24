import java.util.*;
/**
 * Subclass of Others, is the class that determines Player's reelection,
 * and provides the instance variables to determine the why the Player should vote
 *
 * @author Shahruz Ghaemi and Benedict Bolton
 */
public class State extends Others{
    
    //Instance Vars
    /** All possible Republican majority states */
    String[] _redStates = {"Washington","Montana","Idaho","Wyoming","South Dakota","Nebraska","Kansas","Iowa","Nevada","Utah","Arizona","Alaska","Colorado","New Mexico","Oklahoma","Louisiana","Mississippi","Alabama","Florida","Georgia","South Carolina","Tennessee","Kentucky","Indiana","Ohio","New Hampshire","New Jersey","Delaware"};
    /** All possible Democrat majority states */
    String[] _bluStates = {"Maine","New York","Massachussetts","Connecticut","Rhode Island","Pennsylvania","Virginia","Vermont","Maryland","West Virginia","North Carolina","Michigan","Wisconsin","North Dakota","Minnesota","Illinois","Missouri","Arkansas","Texas","California","Oregon","Hawaii"};
    String _stateName;
    int redIndex=-1;
    int bluIndex=-1;
    
    //constructor
    /**
     * Default constructor for State, randomly chooses whether state will be a red or blue state, <br>
     * if a Red State the variables are assigned as: <br>
     * _extremismRight is 0.35 <br>
     * _extremismLeft is 0.20 <br>
     * _percentCompRight is 0.65 <br>
     * _percentCompLeft is 0.35 <br>
     * _hawkLvl is 45 <br>
     * _careBearLvl is 40 <br>
     * _average income is 35000 <br><br>
     * if a Blue State the variables are assigned the same, excpet _extremismLeft and _extremism Right are swapped, and _percentCompLeft and _percentCompRight are swapped.
     */
    public State(){
	int rand = (int)(Math.random()* 2);
	if (rand==0){
	    redIndex  = (int)(Math.random()*_redStates.length);	    
	}
	else{
	    bluIndex = (int)(Math.random()*_bluStates.length);
	}
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
    }

    /**
     * Overloaded State constructor, it is the same as the default, except for two changes: <br>
     * The arguement provides the State instead of it being randomly choosen<br>
     * The extremism of the majority in the State is 0.65 and the minority is 0.50
     *
     * @throws Exception exception to be thrown when user enters invalid state name
     * @param stateName name of state, capitalized, that is chosen by the user
     */
    public State(String stateName) throws Exception{
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
		setExRight(0.65 );
		setExLeft(0.50);
		setCompRight(0.65);
		setCompLeft(0.35);
		setHawks(45);
		setBears(40);
		setAveInc(35000);
	    }
	    else { //create a Democratic-leaning state
		setExRight(0.50);
		setExLeft(0.65);
		setCompRight(0.35);
		setCompLeft(0.65);
		setHawks(45);
		setBears(40);
		setAveInc(35000);	
	    }

	}//end else
    }//end constructor


    //toString method--returns _stateName and other instance vars
    /**
     * Overwritten toString method
     * @return A string representation of the state that calls the method
     */
    public String toString(){
	String s ="These are the people of "+_stateName+", your constituents...";
	s+="\n\t"+round(getCompRight()*100.0)+"% registered Republicans";
	if(getCompRight()>getCompLeft()){s+="   (MAJORITY)";}
	s+="\n\t"+round(getCompLeft()*100.0)+"% registered Democrats";
	if(getCompLeft()>getCompRight()){s+="   (MAJORITY)";}
	s+="\n\tRepublican extremism: "+round(getExRight()*100)+"%";
	s+="\n\tDemocratic extremism: "+round(getExLeft()*100)+"%";
	s+="\n\tThe people's willingness to intervene in the world (hawkishness): "+getHawks()+"%";
	s+="\n\tThe people's bleeding-heart charity for the world: "+getBears()+"%";
	s+="\n\tThe average household's income: $"+getAveInc();
	return s;
    }

    //indicates the State's happiness with a Player parameter
    //returns an int that is popularity in percent
    /**
     * Method used to calculate Player's popularity in a State, based on bills Player has passed or Failed.
     * Popularity then determines whether Player is reelected.
     *
     * @param legis ArrayList of Legislation that has been voted on
     * @param votesOnBills ArrayList of String[] that are the Player's votes, and the result, of all the Legislation in legis. Indices correspond with legis.
     *
     * @return An int which is the percent support the player has in the State
     */
    public int popularity(  ArrayList<Legislation> legis, ArrayList<String[]> votesOnBills) {
	int percentSupport = 0;
	int countOfCorruption = 0;
	for (Legislation l: legis) {
	    if ( (l.getGerry() == 1) || (l.getSelf() == 1) || (l.getPork() == 1) ) {
		countOfCorruption += 1;
	    }
	}
	for (int c = legis.size() - 3; c < legis.size(); c++) {
	    Legislation checking = legis.get(c);
	    boolean[] matchesParty = new boolean[5];
	    if ( getCompRight() > getCompLeft() ) {
		if (checking.getSoc() == 2) {
		    matchesParty[4] = true;
		}
		if (checking.getEcon() == 1) {
		    matchesParty[3] = true;
		}
		if (checking.getForeign() == 0) {
		    matchesParty[2] = true;
		}
		if (checking.getProp() == 0) {
		    matchesParty[0] = true;
		}
		if  ( (checking.getGerry() == 1) || (checking.getSelf() == 1) || (checking.getPork() == 1) ) {
		    matchesParty[1] = true;
		}
	    }
	    if ( getCompLeft() > getCompRight() ) {
		if (checking.getSoc() == 1) {
		    matchesParty[4] = true;
		}
		if (checking.getEcon() == 0) {
		    matchesParty[3] = true;
		}
		if (checking.getForeign() == 2) {
		    matchesParty[2] = true;
		}
		if (checking.getProp() == 1) {
		    matchesParty[0] = true;
		}
		if  ( (checking.getGerry() == 1) || (checking.getSelf() == 1) || (checking.getPork() == 1) ) {
		    matchesParty[1] = true;
		}
	    }
	    if (matchesParty[1]) {
		if ( (votesOnBills.get(c))[1].equals("For") ) {
		    percentSupport += 40;
		}
	    }
	    if (matchesParty[4] && matchesParty[0]) {
		if ( (votesOnBills.get(c))[1].equals("For") ) {
		    percentSupport += 10;
		}
		else if ( (votesOnBills.get(c))[1].equals("Delay") ) {
		    percentSupport -= 5;
		}
		else {
		    percentSupport -= 10;
		}
	    }
	    else {
		if ( (votesOnBills.get(c))[1].equals("Against") ) {
		    percentSupport += 10;
		}
		else if ( (votesOnBills.get(c))[1].equals("Delay") ) {
		    percentSupport += 10;
		}
		else {
		    percentSupport -= 10;
		}
	    }
	    if (matchesParty[2] || matchesParty[3]) {
		if ( (votesOnBills.get(c))[1].equals("For") ) {
		    percentSupport += 10;
		}
		else if ( (votesOnBills.get(c))[1].equals("Delay") ) {
		    percentSupport -= 5;
		}
		else {
		    percentSupport -= 10;
		}
	    }
	    else {
		if ( (votesOnBills.get(c))[1].equals("Against") ) {
		    percentSupport += 10;
		}
		else if ( (votesOnBills.get(c))[1].equals("Delay") ) {
		    percentSupport += 10;
		}
		else {
		    percentSupport -= 10;
		}		
	    }
	}
	if (percentSupport < 0) {
	    percentSupport = 0;
	}
	if (countOfCorruption >= 4) {
	    percentSupport -= 101;
	}
	
	return percentSupport;
    }
	
    //~~~~~~~~~~~~~~~~~returns the majority party in this state~~~~~~~~~~~~~~~~~~~
    //0=republicans, 1=democrats
    /**
     * determines majoirty party in state, 0 = republicans, 1 = democrats
     *
     * @return The majority party in the state, 1 == democrats, 0 == republicans
     */
    public int getMajority(){
	if(getCompRight() > 0.5){return 0;}
	else if(getCompLeft() > 0.5){return 1;}
	else{return (int)(Math.random()*2.0);}
    }

    //~~~~~~~~~~~~~~~~~~returns the name of this state~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Accessor method for _stateName
     * @return _stateName
     */
    public String getName(){
	return _stateName;
    }
}//end class
