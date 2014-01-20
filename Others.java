public class Others {
    
    //Instance Vairables
    
    //willingness to lose and compromise (from 0 to 1, aka from 0% to 100%)
    //each var is capped at 100%, but can sum to <=200%
    private double _extremismRight;
    private double _extremismLeft;
    
    //Composition, vars must add to 100% ALWAYS
    private double _percentCompRight;
    private double _percentCompLeft;

    
    //Voting Factors (all uncapped)
    private long _averageIncome; //tied to all domestic events
    private int _hawkLvl; //tied to all foreign events
    private int _careBearLvl; //tied to all events
    
    //Accessor Methods
    public double getExRight () {
	return _extremismRight;
    }
    public double getExLeft () {
	return _extremismLeft; 
    }
    public double getCompRight () {
	return _percentCompRight;
    }
    public int getReps() {
	return (int)(_percentCompRight * 100);
    }
    public double getCompLeft () {
	return _percentCompLeft;
    }
    public int getDems() {
	return (int)(_percentCompLeft * 100);
    }
    public long getAveInc () {
	return _averageIncome;
    }
    public int getHawks () {
	return _hawkLvl;
    }
    public int getBears () {
	return _careBearLvl;
    }

    //Mutators
    public double setExRight(double input){
	double old = _extremismRight;
	_extremismRight = input;
	return old;}
    public double setExLeft(double input){
	double old = _extremismLeft;
	_extremismLeft = input;
	return old;}
    public double setCompRight(double input){
       	double old = _percentCompRight;
	_percentCompRight = input;
	return old;}
    public double setCompLeft(double input){
	double old = _percentCompLeft;
	_percentCompLeft = input;
	return old;}
    public long setAveInc(long input){
	long old = _averageIncome;
	_averageIncome = input;
	return old;}
    public int setBears(int input){
	int old = _careBearLvl;
	_careBearLvl = input;
	return old;}
    public int setHawks(int input){
	int old = _hawkLvl;
	_hawkLvl = input;
	return old;}

    //METHODS
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //calculates the votes for a particular Legislation, as a percentage 
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public double voteLegis (Legislation bill) {
    	//checks depending variables, 
	//calculates a percentage of support for the Legislation
	//based on extremism
	//bill proposed by one side gets 30% approval from that side

    	double support = 0.0;
	double percentLeft = _percentCompLeft;
	double percentRight = _percentCompRight;
	String proposedBy = "";
	if (bill.getProp() == 0){ proposedBy = "Democrat";}
	else if (bill.getProp() == 1){ proposedBy = "Republican";}
	else if (bill.getProp() == 2){ proposedBy = "Bipartisan";}

	
	if(proposedBy.equals("Republican")){
	    support+=percentRight*0.3;
	    percentRight*=0.7;
	}
	else if(proposedBy.equals("Democrat")){
	    support+=percentLeft*0.3;
	    percentLeft*=0.7;
	}
	else if(proposedBy.equals("Bipartisan")){
	    //get the non-extremists of both parties
	    support+=percentRight*(1.0-_extremismRight);;
	    percentRight=(_extremismRight);
	    support+=percentLeft*(1.0-_extremismLeft);
	    percentLeft=(_extremismLeft);
	}
	//economic factors
	if(bill.getEcon() == 0){ //populist
	    double temp = percentLeft*_extremismLeft*0.3;
	    support+=temp;
	    percentLeft-=temp;
	}
	else if(bill.getEcon() == 1){ //trickle-down
	    double temp = percentRight*_extremismRight*0.3;
	    support+=temp;
	    percentRight-=temp;
	}
	else if(bill.getEcon() == 2){ //modernism, globilisation
	    //mostly get Republican support, some Democratic
	    double temp1 = percentRight*0.7;
	    support+= temp1;
	    percentRight-=temp1;
	    double temp2 = percentLeft*0.4;
	    support+= temp2;
	    percentLeft-=temp2;
	}
	//foreign policy
	if(bill.getForeign()==0){//intervention, 'MURICA HELL YEAH
	    double temp1 = percentRight*_hawkLvl;
	    support+=temp1;
	    percentRight-=temp1;
	    double temp2 = percentLeft*_hawkLvl*0.5;
	    //Dems generally dislike intervention
	    support+=temp2;
	    percentLeft-=temp2;
	}
       	else if(bill.getForeign()==1){//international, the UN and world peace
	    double temp1 = percentRight*_careBearLvl*0.5;
	    //Reps generally dislike hippie stuff like this
	    support+=temp1;
	    percentRight-=temp1;
	    double temp2 = percentLeft*_careBearLvl;
	    support+=temp2;
	    percentLeft-=temp2;
	}
	else if(bill.getForeign() ==2){//isolationist, alienates people who want to get involved
	    double temp1 = percentRight*_careBearLvl;
	    percentRight+=temp1;
	    support-=temp1*0.9;
	    temp1 = percentRight*_hawkLvl;
	    support-=temp1*0.9;
	    percentRight+=temp1;
	    double temp2 = percentLeft*_careBearLvl; 
	    percentLeft+=temp2;
	    support-=temp2*0.9;
	    temp2= percentLeft*_hawkLvl;
	    support-=temp2*0.9;
	    percentLeft+=temp2;
	}
	//social factors
	if(bill.getSoc()==0){//libertarian
	    double temp = percentRight*_extremismRight;
	    support+=temp;
	    percentRight-=temp;
	}
	else if(bill.getSoc()==1){//left-leaning
	    double temp = percentLeft*0.7;
	    support +=temp;
	    percentLeft-=temp;
	}
	else if(bill.getSoc()==2){//right-leaning
	    double temp=percentRight*0.7;
	    support+=temp;
	    percentRight-=temp;
	}
	else if(bill.getSoc()==3){//all-regulation
	    double temp=percentLeft*_extremismLeft;
	    support+=temp;
	    percentRight-=temp;
	}
	
	
	//clean up the messy decimal places
	int x = (int)(support*100.0);
	support = (double)(x/100.0);
	return support;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //changes the party composition of the Others by a input
    //ensures the total composition remains at 1 (aka 100%)
    //by subtracting from the other party.
    //returns the old value of the composition for that party.
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public double addReps(int input){
	double toAdd = (double)(input/10.0);
	setCompLeft(_percentCompLeft-=toAdd);
	return setCompRight(_percentCompRight+=toAdd);
    }
    public double addDems(int input){
	double toAdd = (double)(input/10.0);
	setCompRight(_percentCompRight-=toAdd);
	return setCompLeft(_percentCompLeft+=toAdd);
    }
}
