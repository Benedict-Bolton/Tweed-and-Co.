
import cs1.Keyboard;

public class Driver {
    
    public static void generateWorld(int year){
	System.out.println("The year is "+year+"\nYou are a venerable U.S. Senator from which state?");
	//implement Player generation here
	String ans = Keyboard.readString();
	System.out.println("You are from "+ans);
	//implement delay here

	//create default 1996 U.S.
	System.out.println("=====================================");
	Senate senate = new Senate();
	System.out.println("This is what the Senate in 1996 looks like...");
	System.out.println("\t"+senate.getReps()+" Republican Senators");
	System.out.println("\t"+senate.getDems()+" Democratic Senators");
       	System.out.println("\tRepublican extremism: "+senate.getExRight()*100+"%");
	System.out.println("\tDemocratic extremism: "+senate.getExLeft()*100+"%");
	System.out.println("\tThe Senate's willingness to intervene in the world (hawkishness): "+senate.getHawks()+"%");
	System.out.println("\tThe Senate's bleeding-heart charity for the world: "+senate.getBears()+"%");
	System.out.println("\tThe average Senator's income: $"+senate.getAveInc() );
	
    }//end generatePlayer

    public static void main( String[] args ) {
	int year = 1996;
	generateWorld(year);
	/*=============================
	boolean elected = true;
	while (elected) {
	    boolean legislationActive;
	    int passageBill = 0; 
	    //0 = nothing done yet, 
	    //1 = passed, 
	    //2 = failed, 
	    //3 = sent to bill hell, 
	    //4 = being delayed by amendments, 
	    //5 = being delayed by filibuster, 
	    //9 = total delay attack
	    Event lastEvent;
	    while (legislationActive) {
		if ( (passageBill == 1) || (passageBill == 2) || (passagebill == 3) ) {
		    break;
		}
		Legislation majorityBill = new Legislation(); 
		//should include senate and public as variables for the method
		
	    }//end while (legislationActive)
	}//end while(elected)
	================================*/
    }//end main
}//end driver
