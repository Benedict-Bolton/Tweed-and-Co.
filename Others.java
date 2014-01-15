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
    public double getCompLeft () {
	return _percentCompLeft;
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
    public long setAveInc(double input){
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
    public boolean voteLegis (String tactics; Legislation action; Event lastEvent) {
    	//checks depending variables, if they concur, then the bill passes, if not it fails
    	return false;
    }
    
    
    
