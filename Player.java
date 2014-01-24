public class Player extends Others{

    //INSTANCE VARS
    private State _homeState;
    private int _achievements = 0;
    private int _party; //0=republicans, 1=democrats
    private long _income;

    //constructors
    public Player(){
	_homeState = new State();
	_party = _homeState.getMajority();
	_income = _homeState.getAveInc();
    }
    public Player(State state){
	_homeState = state;
	_party = state.getMajority();
	_income = state.getAveInc() * 10;
    }

    //accessors
    public State getState(){ return _homeState;}

    //methods

    //~~~~~~~~~~~~~~~~~~~legislative achievement tally~~~~~~~~~~~~~~~~~~~
    //calculates a score given to you for your good work (or not-so-good work)
    //representing your state in Congress
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
