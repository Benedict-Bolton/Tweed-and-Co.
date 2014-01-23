public class Senate extends Others{
    
    //Instance Vars


    //Constructors
    //default constructor--creates random Senate 
    public Senate(){
	super();
    }
    //For use in game constructor
    public Senate(int year){
	this();
	if(year==1996){//creates a 1996 Senate (beginning of Clinton's second term)
	    setExRight(0.35);
	    setExLeft(0.20);
	    setCompRight(0.55);
	    setCompLeft(0.45);
	    setHawks(45);
	    setBears(40);
	    setAveInc(450000);

	}
    }

    //toString method--displays all instance variables
    public String toString(){
	String s ="This is what the Senate looks like...";
	s+="\n\t"+round(getCompRight()*100.0)+" Republican Senators";
	if(getCompRight()>getCompLeft()){s+="   (MAJORITY)";}
	s+="\n\t"+round(getCompLeft()*100.0)+" Democratic Senators";
	if(getCompLeft()>getCompRight()){s+="   (MAJORITY)";}
	s+="\n\tRepublican extremism: "+round(getExRight()*100.0)+"%";
	s+="\n\tDemocratic extremism: "+round(getExLeft()*100.0)+"%";
	s+="\n\tThe Senate's willingness to intervene in the world (hawkishness): "+getHawks()+"%";
	s+="\n\tThe Senate's bleeding-heart charity for the world: "+getBears()+"%";
	s+="\n\tThe average Senator's income: $"+getAveInc();
	return s;
    }
     
    
    
    
    
    
    
}
