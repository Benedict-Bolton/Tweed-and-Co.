
import cs1.Keyboard;
import java.util.*;
public class Driver {
    
    public static void delay(){ //simple mechanism to provide a chance for the player to read the text on-screen
	System.out.println("======================================");
	System.out.print("Enter anything to proceed  ");
	String whatever = Keyboard.readString();
    }

    public static Senate generateSenate(int year){
	boolean trigger = true;
	String ans = "";
	State homeState;
	while(trigger){
	    System.out.println("The year is "+year+"\nYou are a venerable U.S. Senator from which state? \n(Remember to Capitalize the First Letter)");
	    //implement Player generation here
	    ans = Keyboard.readString();
	    try{
		homeState = new State(ans); //State generation
		System.out.println("You are from "+ans);
		trigger=false;
	    }
	    catch (Exception ex){
		System.out.println(ex.getMessage() );
		System.out.println("Try again. You can't fool the bureaucracy...");
	    }
	}
	//implement delay here

	//create world

        //world-create Senate, show Senate
	System.out.println("=====================================");
	Senate senate = new Senate(year);
	System.out.println(senate);
	delay();

	//world-show home state
	System.out.println("=====================================");
	try{//this try-catch system just to make it past stupid compiler
	    homeState=new State(ans);
	    System.out.println(homeState);
	}
	catch (Exception ex){}
	delay();

	return senate;
    }//end generatePlayer

    public static void main( String[] args ) {
	int year = 1996;
	Senate senate = generateSenate(year);
	

	/*=============================	
	System.out.println("=====================================");
	Legislation test = new Legislation();
	System.out.println(test);
	System.out.println("Senate approval for this bill: "+senate.voteLegis(test));
	System.out.print("Enter anything to proceed  ");
	whatever = Keyboard.readString();
	=================================*/
	
	boolean elected = true;
	boolean censored = false;
	boolean arrested = false;
	while (elected) {
	    //if (public.getAvgInc() <= (orig.getAvgInc() * 0.4)) {  //conditions to get kicked out:
	    // elected = false;
	    // continue; }
	    //if (censored) {
	    // elected = false;
	    // continue;
	    //if (arrested) {
	    // elected = false;
	    // continue;}
	    double worldStability = 0; //higher lowers all financial indicators of public, keep it down,
	    //passing too much of one kind of legislation aggravates it. Yet, your party will always want you to pass more of the same. Range [0, 50]
	    System.out.println("\tYou have been told the Senate has a unique system to help keep track of global stability.\n It is a nice simple number, the higher it is the more unstable the world is, the lower the more stable the world is.\n It is conveniently easy for them to keep track of as they spend excess amounts of time with women of questionable repute.\n It currently is: " + worldStability);  
	    delay();

	    boolean legislationActive = true;
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
	    int powerSource = (int) (Math.random() * 3);
	    String powerName = "";
	    while (legislationActive) {  /*~~~~~~~~~~~~~~~~~~~~~~~`
		if ( (passageBill == 1) || (passageBill == 2) || (passageBill == 3) ) {
		    break;
		    legislationActive = false;
		    }  ~~~~~~~~~~~~~~~~~~*/
 		Legislation freshBill = new Legislation(); 
		String whoDelay = "No One"; // "No One" for when no one is delaying the bill, "You" for when you are delaying a bill, "Opposition" when the opposition to your vote of passing is delaying the vote, "Fail" you have attempted to delay too long and have failed, "Success" the opposition has failed in its delay tactics
		System.out.println(freshBill);
		System.out.println("Current support for this bill: "+senate.voteLegis(freshBill)*100+"%");
		delay();
		if (powerSource == 0) {
		    powerName = "Magnificent Hair";
		    System.out.println("\n\n All the other Senators stare at that perfectly Hairsprayed hair of yours and stand in utter awe. \n Your perfect hair has given you Power over some of the other Senators votes, it is time to use the great power of hair products to cast your vote to attempt to determine the fate of this bill.\n\n");
		    delay();

		}
		else if (powerSource == 1) {
		    powerName = "Amazing Pin";		    
		    System.out.println("\n\n It is new, it is shiny, and, by the majestic wings of your beautiful state bird, it is AMERICAN.\n That little American flag pin you put in your lapel this morning has enchanted some of the lesser Senators, your vote now hold theirs in its sway, use the power of your fake patriotism now to attempt to determine the fate of this bill with your vote.\n\n"); delay();
		}

		else {
		    powerName = "Stupendous Argyle Socks";
		    System.out.println("\n\n They stand aghast in surprised amazement, could he really be going for it, flaunting the greatest, probably more like the 11th greatest, of Senate Traditions. Yes indeed you had, you wore....gasp!....Argyle Socks! You have thrown aside the tradition of plain dress socks, and as such every like maybe 3 steps the other Senators can sometimes see something that is not quite the color of your pants! This rebliousness inspires, it gives power, and thus you now have the support of some of the Senators, now you can vote to attempt to change the fate of this bill.\n\n"); delay();
		}
		if (passageBill == 0) {
		    System.out.print("Would you like to Vote 'For' or 'Against' this Bill?\n You can also attempt to delay it forever with either a 'Filibuster', 'Amendments', or 'Both' if you do not think you have the votes to stop this bill on its own:"); delay();
		    String vote = Keyboard.readString();
		}
		else if ( ( (passageBill == 4) || (passageBill == 5) || (passageBill == 9) ) && (whoDelay == "You") ) {
		    System.out.print("You are are successfully deleying the passage of the bill, yet the opposition has not yet given up and let the bill die. They are matching you inch for inch in this battle of wills. You can 'Continue' to attempt to delay the bill further and hope the opposition surrenders, yet this continued obstructionism can have many dangerous effects, you may want to 'Surrender' and let the bill pass:"); delay();
			String tactic = Keyboard.readString();
		}

		

		
		
	    }//end while (legislationActive)

	    boolean eventOccuring = true;
	    while (eventOccuring) {
		int eventChoice = (int) (Math.random());
		if (eventChoice == 0) {
		    Event currentEvent = new Event("Foreign");
		    System.out.println("On account of " + powerName + " you have been appointed Chair of the Senate Committee on Foreign Relations. Seeing as it is a normal day there is a sum total of...No One in the committee, but your "+ powerName+ " has given you the courage to actually show up for a fine day of doing absolutely nothing.\n\n Ahhh *WeeWoo* wait what's that? *WeeWoo* huh? *WeeWooWeeWooWeeWoo* ITS THE ALARM! There is a new crisis somewhere in the world, and the Senate for once (meaning you) has to deal with it! The president always took care of it in the past...ugh maybe the change has to do with that new intern Ms. Lewinsky...");
		    System.out.println(currentEvent);
		    System.out.print("Enter the number of the option you wish to pursue: ");
		    int responseChoice = Keyboard.readInt();
		    double[] response = Event.changeResult (csa,worldStability, responseChoice);
		    //csa.setIncome(csa.getAveInc() + response[0]);
		    //worldStability += response[1];
		    System.out.println("Outcome of your decision: ");
		    System.out.println("Change to National Average Income -- " +response[0]);
		    System.out.println("Change to Overall World Stability -- " +response[1]);
		    eventOccuring = false;
		}
	    }//end while(eventOccuring) 	    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`````~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

		
	}//end while(elected)
	/*=============================
=================================*/
    }//end main
}//end driver
