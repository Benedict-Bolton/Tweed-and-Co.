/**
 * Player object is subclass of Others.java; Players creates the object that
 *<br> the user directly controls and determines the interactions for within Driver.java
 * @author Shahruz Ghaemi and Benedict Bolton
 */
public class Player extends Others{

    //INSTANCE VARS
    /** State from which the player is elected, is the object that decides player's reelection */
    private State _homeState;
    /** Number of Legislations that has been passed or failed in accordance w/_homeState's interests */
    private int _achievements = 0;
    /** Political part that player represents, same as majority party in _homeState */ 
    private int _party; //0=republicans, 1=democrats
    /** Income of player, could be used to determine funds available for use during election season */
    private long _income;

    //constructors
    /**
     * Default constructor, setting: <br>
     * homeState to the default State constructor values <br>
     * _party to Majority party in _homeState <br>
     * _income to the _averageIncome in _homeState
     */ 
    public Player(){
	_homeState = new State();
	_party = _homeState.getMajority();
	_income = _homeState.getAveInc();
    }
    /**
     * Overloaded constructor, setting: <br>
     * homeState to the inputted State <br>
     * _party to Majority party in _homeState <br>
     * _income to the _averageIncome in _homeState times 10
     *
     * @param state state from which Player is elected, will fill _homeState
     */
    public Player(State state){
	_homeState = state;
	_party = state.getMajority();
	_income = state.getAveInc() * 10;
    }

    //accessors
    /**
     * Accessor method for _homeState
     * @return _homeState
     */
    public State getState(){ return _homeState;}

    //methods

    //~~~~~~~~~~~~~~~~~~~legislative achievement tally~~~~~~~~~~~~~~~~~~~
    //calculates a score given to you for your good work (or not-so-good work)
    //representing your state in Congress
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /** 
     * Calculates score for Player based on work representing _homeState <br> in accordance with its preferences in the Senate
     *
     * @param bill Legislation that was voted on by Player, that affects _homeState in some way
     * @return int representing achievement in representing _homeState's interests with Player's vote on bill
     */
    public int legisAchievement(Legislation bill){
	if (bill.getProp()==2 || bill.getProp()==_party){//bipartisan
	    _achievements+=1;
	    System.out.println("```DIAG```--bipartisan "+_achievements);
	}
	else {
	    _achievements+=-1;
	    System.out.println("```DIAG```--other party "+_achievements);
	}

	if (bill.getPork()==1){//pork barrel spending favoring your state
	    _achievements+=1;
	    System.out.println("```DIAG```--pork "+_achievements);
	}

	if (bill.getForeign()==0){//intervention
	    if(_homeState.getHawks()>0.5){_achievements+=1;}
	    if(_homeState.getBears()>0.5){_achievements-=1;}
	    System.out.println("```DIAG```--intervention "+_achievements);
 	}
	else if(bill.getForeign()==1){//international, UN hippie stuff
	    if(_homeState.getHawks()>0.5){_achievements-=1;}
	    if(_homeState.getBears()>0.5){_achievements+=1;}
	    System.out.println("```DIAG```--UN "+_achievements);
	}

	if (bill.getEcon()==0){//populist
	    if(_homeState.getExLeft()>0.5){_achievements+=1;}
	    if(_homeState.getExRight()>0.5){_achievements-=1;}
	    if(_homeState.getAveInc()<26000){_achievements+=1;}
	    System.out.println("```DIAG```--populist "+_achievements); }
	else if(bill.getEcon()==1){//trickle-down
	    if(_homeState.getExLeft()>0.5){_achievements-=1;}
	    if(_homeState.getExRight()>0.5){_achievements+=1;}
	    if(_homeState.getAveInc()>100000){_achievements+=1;}
	    System.out.println("```DIAG```--trickledown "+_achievements); }
	else if(bill.getEcon()==2){//modernization.globilization
	    if(_homeState.getExLeft()>0.5){_achievements-=1;}
	    if(_homeState.getExRight()>0.5){_achievements+=1;}
	    if(_homeState.getBears()>0.4){_achievements-=1;}
	    System.out.println("```DIAG```--modernize "+_achievements); }
	/*
	if (bill.getSoc()==0){//no regulation, libertarian
	    if(_homeState.getExLeft()>0.4){_achievements-=1;}
	    if(_homeState.getExRight()>0.7){_achievements+=1;}
	}*/
	if (bill.getSoc()==1){//left-leaning
	    if(_homeState.getCompLeft()>0.5){_achievements+=1;}
	    if(_homeState.getCompRight()>0.5){_achievements-=1;}
	    System.out.println("```DIAG```--lefty "+_achievements); }
	else if (bill.getSoc()==2){//right-leaning
	    if(_homeState.getCompLeft()>0.5){_achievements-=1;}
	    if(_homeState.getCompRight()>0.5){_achievements+=1;}
	    System.out.println("```DIAG```--righty "+_achievements); }
	/*else if (bill.getSoc()==3){//full-on regulation 24/7
	    if(_homeState.getExLeft()>0.7){_achievements+=1;}
	    if(_homeState.getExRight()>0.4){_achievements-=1;}}*/
	return _achievements;
    }


    //~~~~~~~~~~~~~~~~~~~~main method for testing~~~~~~~~~~~~~~~~
    /**
     * main(String[]) method for testing the code
     * @param args Unused
     */
    public static void main(String[] args){
	State soo = new State();
	try{soo = new State("New York");}
	catch(Exception e){System.out.println(e.getMessage());}
	System.out.println(soo);
	Player poo = new Player();
	Legislation loo = new Legislation();
	System.out.println(loo);
	System.out.println(poo.legisAchievement(loo));
    }

}//end class
