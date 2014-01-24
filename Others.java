/**
 * Overarching class for actors within the game,
 * thus being a Super class to Player.java, Public.java, Senate.java,
 * and State.java; provides the methods for the interactions between these
 * classes and with Legislation and Event objects. 
 *
 * @author Shahruz Ghaemi and Benedict Bolton
 */ 
public class Others {
    
    //Instance Vairables
    
    //willingness to lose and compromise (from 0 to 1, aka from 0% to 100%)
    //each var is capped at 100%, but can sum to <=200%
    /** _extremismRight represents the political Right's willingness to compromise and lose;<br> it has a range of [0.0, 1.0] */
    private double _extremismRight;
    /** _extremismLeft represents the political Left's willingness to compromise and lose;<br> it has a range of [0.0, 1.0] */
    private double _extremismLeft;
    
    //Composition, vars must add to 100% ALWAYS
    /**
     * percent of the Other subclass that would be members of any right leaning party,<br> as such range is [0.0, 1.0]; not used in Player subclass.
     */
    private double _percentCompRight;
    /**
     * percent of the Other subclass that would be members of any left leaning party,<br> as such range is [0.0, 1.0];  not used in Player subclass; 
     */
    private double _percentCompLeft;

    
    //Voting Factors (all uncapped)
    /**
     * Average Income of the Other subclass,<br>
     * range is limited only by variable type; not used in Player subclass
     */
    private long _averageIncome; //tied to all domestic legislation
    /**
     * Willingness of the Other subclass to engage in activities that<br>
     * would be deemed War Hawk-ish, such as military interventions
     */
    private int _hawkLvl; //tied to all foreign legislation
    /**
     * Willingness of the Other subclass to engage in activities that<br>
     * advance human rights, and General well being of the human race
     */
    private int _careBearLvl; //tied to all legislation
    
    //Accessor Methods
    /**
     * Accessor method for _extremismRight
     * @return _extremismRight rounded to be a clean percentage
     */
    public double getExRight () {
	//return Math.rint(_extremismRight);
	return round(_extremismRight);
    }
    /**
     * Accessor method for _extremismLeft
     * @return _extremismLeft rounded to be a clean percentage
     */
    public double getExLeft () {
	//return Math.rint(_extremismLeft); 
	return round(_extremismLeft);
    }
    /**
     * Accessor method for _percentCompRight
     * @return _percentCompRight rounded to be a clean percentage
     */
    public double getCompRight () {
	//return Math.rint(_percentCompRight);
	return round(_percentCompRight);
    }
    /**
     * Accessor method for _percentCompLeft
     * @return returns _percentCompLeft rounded to be a clean percentage
     */
    public double getCompLeft () {
	//return Math.rint(_percentCompLeft);
	return round(_percentCompLeft);
    }
    /**
     * Converter of _percentCompLeft from a double to an integer
     * of [0, 100]%
     * @return _percentCompLeft typecast into an int after being multiplied by 100
     */
    public int getDems() {
	return (int)(_percentCompLeft * 100);
    }
    /**
     * Accessor method for _averageIncome
     * @return _averageIncome
     */
    public long getAveInc () {
	return _averageIncome;
    }
    /**
     * Accessor method for _hawkLvl
     * @return _hawkLvl
     */
    public int getHawks () {
	return _hawkLvl;
    }
    /**
     * Accessor method for _careBearLvl
     * @return _averageIncome
     */
    public int getBears () {
	return _careBearLvl;
    }

    //Mutators
    /**
     * _extremismRight mutator
     * @param input new double to which _extremismRight is set
     * @return old value of _extremismRight
     */
    public double setExRight(double input){
	double old = _extremismRight;
	if (input > 1.0){
	    _extremismRight = 1.0;
	    return old;}
	else{
	    _extremismRight = input;
	    return old;} }
    /**
     * _extremismLeft mutator
     * @param input new double to which _extremismLeft is set
     * @return old value of _extremismLeft
     */
    public double setExLeft(double input){
	double old = _extremismLeft;
	if (input > 1.0){
	    _extremismLeft = 1.0;
	    return old;}
	else{
	    _extremismLeft = input;
	    return old;} }
    /**
     * _percentCompRight mutator
     * @param input new double to which _percentCompRight is set
     * @return old value of _percentCompRight
     */
    public double setCompRight(double input){
       	double old = _percentCompRight;
	if (input > 1.0){
	    _percentCompRight= 1.0;
	    return old;}
	else{
	    _percentCompRight = input;
	    return old;} }
    /**
     * _percentCompLeft mutator
     * @param input new double to which _percentCompLeft is set
     * @return old value of _percentCompLeft
     */
    public double setCompLeft(double input){
	double old = _percentCompLeft;
	if (input > 1.0){
	    _percentCompLeft = 1.0;
	    return old;}
	else{
	    _percentCompLeft = input;
	    return old;} }
    /**
     * _averageIncome mutator
     * @param input new long to which _averageIncome is set
     * @return old value of _averageIncome
     */
    public long setAveInc(long input){
	long old = _averageIncome;
	_averageIncome = input;
	return old;}
    /**
     * _careBearLvl mutator
     * @param input new int to which _careBearLvl is set
     * @return old value of _careBearLvl
     */
    public int setBears(int input){
	int old = _careBearLvl;
	_careBearLvl = input;
	return old;}
    /**
     * _hawkLvl mutator
     * @param input new int to which _hawkLvl is set
     * @return old value of _hawkLvl
     */
    public int setHawks(int input){
	int old = _hawkLvl;
	_hawkLvl = input;
	return old;}

    //default constructor
    /**
     * Default constructor for Others, setting <br>
     * _extremismRight to a random double <br>
     * _extremismLeft to a random double <br>
     * _percentCompRight to a random double <br>
     * _percentCompLeft to 1 - _percentCompRight<br>
     * _hawkLvl to a random int [0,99] <br>
     * _careBearLvl to a random int [0,99] <br>
     * _averageIncome to $450,000 yearly
     */
    public Others(){
	    setExRight(Math.random());
	    setExLeft(Math.random());
	    setCompRight(Math.random());
	    setCompLeft(1.0-getCompRight());
	    setHawks((int)(Math.random()*100));
	    setBears((int)(Math.random()*100));
	    setAveInc(450000);
    }

    //METHODS
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //calculates the votes for a particular Legislation, as a double
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Calculates the votes for a particular Legislation object,<br> based on its attributes in comparison to those of the Other object voting
     * @param bill Legislation object being voted on
     * @param player Player who is voting on the bill
     * @param vote of the player on the legislation
     *
     * @return double representing percent support for the bill; range [0.0, 1.0]
     */
    public double voteLegis (Legislation bill, String playerVote, Player player) {
    	//checks depending variables, 
	//calculates a percentage of support for the Legislation
	//based on extremism
	//bill proposed by one side gets 30% approval from that side

    	double support = 0.0;
	double percentLeft = getCompLeft();
	double percentRight = getCompRight();
	String proposedBy = "";
	if (bill.getProp() == 0){ proposedBy = "Democrat";}
	else if (bill.getProp() == 1){ proposedBy = "Republican";}
	else if (bill.getProp() == 2){ proposedBy = "Bipartisan";}

	//====support based on the player's awesome charisma====
	//player can vote: For, Against, Filibuster, Amendments, Both
	if ( playerVote.equals("None") || playerVote==null ){ //base case
	}
	else if (playerVote.equals("For")){
	    if(player.getState().getMajority()==0){//republican playerState
		support+=percentRight*0.5;
		percentRight*=0.5;
		//System.out.println("***DIAG--R senator swayed R in favor*** "+support);
	    }
	    else if(player.getState().getMajority()==1){//democratic playerState
		support+=percentLeft*0.5;
		percentLeft*=0.5;
		//System.out.println("***DIAG--D senator swayed D in favor*** "+support);
	    }
	}

	else if (playerVote.equals("Against")){
	    if(player.getState().getMajority()==0){//republican playerState
		percentRight*=0.5;
		//System.out.println("***DIAG--R senator swayed R against*** "+support);
	    }
	    else if(player.getState().getMajority()==1){//democratic playerState
		percentLeft*=0.5;
		//System.out.println("***DIAG--D senator swayed D against*** "+support);
	    }
	}
	
	

	//====support based on the merits of the bill itself=====	
	if(proposedBy.equals("Republican")){
	    support+=percentRight*0.3;
	    percentRight*=0.7;
	    //System.out.println("***DIAG--proposed R*** "+support);
	}
	else if(proposedBy.equals("Democrat")){
	    support+=percentLeft*0.3;
	    percentLeft*=0.7;
	    //System.out.println("***DIAG--proposed D*** "+support);
	}
	else if(proposedBy.equals("Bipartisan")){
	    //get the non-extremists of both parties
	    support+=percentRight*(1.0-_extremismRight);;
	    percentRight=(_extremismRight);
	    support+=percentLeft*(1.0-_extremismLeft);
	    percentLeft=(_extremismLeft);
	    //System.out.println("***DIAG--proposed R-D*** "+support);
	}
	//economic factors
	if(bill.getEcon() == 0){ //populist
	    double temp = percentLeft*_extremismLeft*0.3;
	    support+=temp;
	    percentLeft-=temp;
	    //System.out.println("***DIAG--populist*** "+support);
	}
	else if(bill.getEcon() == 1){ //trickle-down
	    double temp = percentRight*_extremismRight*0.3;
	    support+=temp;
	    percentRight-=temp;
	    //System.out.println("***DIAG--trickledown*** "+support);
	}/*
	else if(bill.getEcon() == 2){ //modernism, globilisation
	    //mostly get Republican support, some Democratic
	    double temp1 = percentRight*0.7;
	    support+= temp1;
	    percentRight-=temp1;
	    double temp2 = percentLeft*0.4;
	    support+= temp2;
	    percentLeft-=temp2;
	    //System.out.println("***DIAG--globilise*** "+support);
	}*/
	//foreign policy
	if(bill.getForeign()==0){//intervention, 'MURICA HELL YEAH
	    double temp1 = percentRight*(_hawkLvl/100.0);
	    support+=temp1;
	    percentRight-=temp1;
	    double temp2 = percentLeft*(_hawkLvl/100.0)*0.5;
	    //Dems generally dislike intervention
	    support+=temp2;
	    percentLeft-=temp2;
	    //System.out.println("***DIAG--intervene*** "+support);
	}
       	else if(bill.getForeign()==1){//international, the UN and world peace
	    double temp1 = percentRight*(_careBearLvl/100.0)*0.5;
	    //Reps generally dislike hippie stuff like this
	    support+=temp1;
	    percentRight-=temp1;
	    double temp2 = percentLeft*(_careBearLvl/100.0);
	    support+=temp2;
	    percentLeft-=temp2;
	    //System.out.println("***DIAG--UN*** "+support);
	}
	/*else if(bill.getForeign() ==2){//isolationist, alienates people who want to get involved
	    double temp1 = percentRight*(1-_careBearLvl);
	    support+=temp1;
	    percentRight-=temp1;
	    double temp2 = percentLeft*(1-_careBearLvl);
	    support+=temp2;
	    percentLeft-=temp2;
	    //System.out.println("***DIAG*** "+support);
	    }*/
	//social factors
	/*if(bill.getSoc()==0){//libertarian
	    double temp = percentRight*_extremismRight;
	    support+=temp;
	    percentRight-=temp;
	    //System.out.println("***DIAG--libertarian*** "+support);
	    }*/
	if(bill.getSoc()==1){//left-leaning
	    double temp = percentLeft*0.7;
	    support +=temp;
	    percentLeft-=temp;
	    //System.out.println("***DIAG--lefty*** "+support);
	}
	else if(bill.getSoc()==2){//right-leaning
	    double temp=percentRight*0.7;
	    support+=temp;
	    percentRight-=temp;
	    //System.out.println("***DIAG--righty*** "+support);
	}/*
	else if(bill.getSoc()==3){//all-regulation
	    double temp=percentLeft*_extremismLeft;
	    support+=temp;
	    percentRight-=temp;
	    //System.out.println("***DIAG--facist*** "+support);
	    }*/
	support = round(support);

	//System.out.println("***DIAG*** "+support);
	return support;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //changes the party composition of the Others by a input
    //ensures the total composition remains at 1 (aka 100%)
    //by subtracting from the other party.
    //returns the old value of the composition for that party.
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * adds to the _percentCompRight, by the number of senators inputted; maintains total composition of 1.0
     * @param input number of Republicans to be added
     * @return The old value of _percentCompRight
     */
    public double addReps(int input){
	double toAdd = (double)(input/10.0);
	setCompLeft(_percentCompLeft-=toAdd);
	return setCompRight(_percentCompRight+=toAdd);
    }
    /**
     * adds to the _percentCompLeft, by the number of senators inputted; maintains total composition of 1.0
     * @param input number of Democrats to be added
     * @return The old value of _percentCompLeft
     */
    public double addDems(int input){
	double toAdd = (double)(input/10.0);
	setCompRight(_percentCompRight-=toAdd);
	return setCompLeft(_percentCompLeft+=toAdd);
    }

    //~~~~~~~~~~~~~~~~rounding function~~~~~~~~~~~~~~~~~~~
    //takes care of the messy doubles
    //returns a nice, two-decimal place double
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Rounds inputed double to two decimal places
     * @param input double to be rounded
     * @return double after being rounded
     */
    public double round(double input){
	return(double)((int)(input*100.0)/100.0);
    }

    //~~~~~~~~~~~~~~~~main method for testing~~~~~~~~~~~~~~
    /**
     * main(String[]) method for testing to ensure method functionality
     * @param args Unused
     */
    public static void main( String[] args){
	/*
	Others foo = new Others();
	State soo = new State();
	Player poo = new Player(soo);
	Legislation legis = new Legislation();
	System.out.println("support for legis: "+foo.voteLegis(legis));

	System.out.println("Republicans: "+foo.getCompRight());
	System.out.println("Dems: "+foo.getCompLeft());
	double x = Math.random()*100;
	System.out.println(x+" ... ... ... "+Math.rint(x));
	*/
    }
}
