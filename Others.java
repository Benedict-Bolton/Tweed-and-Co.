public class Others {
    
    //Instance Vairables
    
    //willingness to lose and compromise
    private double _extremismRight;
    private double _extremismLeft;
    
    //Composition, must add to 100 ALWAYS
    private double _percentCompRight;
    private double _percentCompLeft;
    
    //Voting Factors
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
    
    public boolean voteLegis (String tactics; Legislation action; Event lastEvent) {
    	//checks depending variables, if they concur, then the bill passes, if not it fails
    	return false;
    }
    
    
    
