public class Player extends Others{

    //INSTANCE VARS
    private State _homeState;
    private int _achievements = 0;
    private int _party; //0=republicans, 1=democrats
    private int _income;

    //constructors
    public Player(){
	_homeState = new State();
	_party = home.getMajority();
	_income = home.getAvgInc();
    }
    public Player(State state){
	_homeState = state;
	_party = state.getMajority();
	_income = state.getAvgInc() * 10;
    }

    //methods

    //calculates a score given to you for your good work (or not-so-good work)
    //representing your state in Congress
    public int legisAchievement(Legislation bill){
	if (bill.getProp()==2 || bill.getProp()==_party){//republicants
	    _achievements+=1;
	}
	else {
	    _achievements+=-1;
	}

	if (bill.getForeign()==0){//intervention
	    if(_homeState.getHawks()>0.5){_achievements+=1;}
	    if(_homeState.getBear()>0.5){_achievements-=1;}
 	}
	else if(bill.getForeign()==1){//international, UN hippie stuff
	    if(_homeState.getHawks()>0.5){_achievements-=1;}
	    if(_homeState.getBear()>0.5){_achievements+=1;}
	}

	if (bill.getEcon()==0){//populist
	    if(_homeState.getExLeft()>0.5){_achievements+=1;}
	    if(_homeState.getExRight()>0.5){_achievements-=1;}
	    if(_homeState.getAvgInc()<26000){_achievements+=1;} }
	else if(bill.getEcon()==1){//trickle-down
	    if(_homeState.getExLeft()>0.5){_achievements-=1;}
	    if(_homeState.getExRight()>0.5){_achievements+=1;}
	    if(_homeState.getAvgInc()>100000){_achievements+=1;} }
	else if(bill.getEcon()==2){//modernization.globilization
	    if(_homeState.getExLeft()>0.5){_achievements-=1;}
	    if(_homeState.getExRight()>0.5){_achievements+=1;}
	    if(_homeState.getBears()>0.4){_achievements-=1;} }

	if (bill.getSoc()==0){//no regulation, libertarian
	    if(_homeState.getExLeft()>0.4){_achievements-=1;}
	    if(_homeState.getExRight()>0.7){_achievements+=1;}
	}
	else if (bill.getSoc()==1){//left-leaning
	    if(_homeState.getCompLeft()>0.5){_achievements+=1;}
	    if(_homeState.getCompRight()>0.5){_achievements-=1;}}
	else if (bill.getSoc()==2){//right-leaning
	    if(_homeState.getCompLeft()>0.5){_achievements-=1;}
	    if(_homeState.getCompRight()>0.5){_achievements+=1;}}
	else if (bill.getSoc()==3){//full-on regulation 24/7
	    if(_homeState.getExLeft()>0.7){_achievements+=1;}
	    if(_homeState.getExRight()>0.4){_achievements-=1;}}
	return _achievements;
    }



}//end class
