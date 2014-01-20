
import cs1.Keyboard;

public class Driver {
    
    public static void generateWorld(int year){
	System.out.println("The year is "+year+"\nYou are a venerable U.S. Senator from which state? (Remember to Capitalize the First Letter)");
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
	=============================
	boolean elected = true;
	while (elected) {
	    int worldStability; //higher lowers all financial indicators of public, keep it down,
	    //passing too much of one kind of legislation aggravates it. Yet, your party will always want you to pass more of the same. Range [0, 50]
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
	    Legislation[] finishedLegislation;
	    String[] votesOnBills; //tied to array just above this, three options are Yes, No, and Hell
	    while (legislationActive) {
		if ( (passageBill == 1) || (passageBill == 2) || (passagebill == 3) ) {
		    break;
		}
 		Legislation freshBill = new Legislation(); 
		String whoDelay = "No One"; // "No One" for when no one is delaying the bill, "You" for when you are delaying a bill, "Opposition" when the opposition to your vote of passing is delaying the vote, "Fail" you have attempted to delay too long and have failed, "Success" the opposition has failed in its delay tactics
		System.out.println(freshBill);
		int powerSource = (int) (Math.random() * 3);
		if (powerSource == 0) {
		    System.out.println("\n\n All the other Senators stare at that perfectly Hairsprayed hair of yours and stand in utter awe. \n Your perfect hair has given you Power over some of the other Senators votes, it is time to use the great power of hair products to cast your vote to attempt to determine the fate of this bill.\n\n");
		}
		else if (powerSourc == 1) {
		    System.out.println("\n\n It is new, it is shiny, and, by the majestic wings of your beautiful state bird, it is AMERICAN.\n That little American flag pin you put in your lapel this morning has enchanted some of the lesser Senators, your vote now hold theirs in its sway, use the power of your fake patriotism now to attempt to determine the fate of this bill with your vote.\n\n");
		}
		else {
		    System.out.println("\n\n They stand aghast in surprised amazement, could he really be going for it, flaunting the greatest, probably more like the 11th greatest, of Senate Traditions. Yes indeed you had, you wore....gasp!....Argyle Socks! You have thrown aside the tradition of plain dress socks, and as such every like maybe 3 steps the other Senators can sometimes see something that is not quite the color of your pants! This rebliousness inspires, it gives power, and thus you now have the support of some of the Senators, now you can vote to attempt to change the fate of this bill.\n\n");
		}
		if (passageBill == 0) {
		    System.out.print("Would you like to Vote 'For' or 'Against' this Bill?\n You can also attempt to delay it forever with either a 'Filibuster', 'Amendments', or 'Both' if you do not think you have the votes to stop this bill on its own:");
		    String vote = Keyboard.readString();
		}
		else if ( ( (passageBill == 4) || (passageBill == 5) || (passageBill == 9) ) && (whoDelay == "You") ) {
			System.out.print("You are are successfully deleying the passage of the bill, yet the opposition has not yet given up and let the bill die. They are matching you inch for inch in this battle of wills. You can 'Continue' to attempt to delay the bill further and hope the opposition surrenders, yet this continued obstructionism can have many dangerous effects, you may want to 'Surrender' and let the bill pass:");
			String tactic = Keyboard.readString();
		}


		

		
		
	    }//end while (legislationActive)
	}//end while(elected)
	================================*/
    }//end main
}//end driver
