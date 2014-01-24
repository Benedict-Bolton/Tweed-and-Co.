import cs1.Keyboard;
import java.util.*;
public class Driver {
    
    private static final String americanFlag = 
	"\n=============;===========;()                       " 
	+"\n            # # # #::::::            _..._        " 
	+"\n            # # # #::::::           |||||||       " 
	+"\n            # # # #::::::           |||||||       " 
	+"\n            # # # #::::::         __|*****|__     " 
	+"\n            # # # # # # #         ( '-...-' )     " 
	+"\n            # # # # # # #         {`;-----;`}     "   
	+"\n            # # # # # # #         {(| a  a|)}     "
	+"\n            # # # # # # #          \\|  _\\ |/      "
	+"\n            # # # # # # #           \\  -  /       " 
	+"\n jgs        # # # # # # #       jgs  '{_}`        ";
    private static final String vote = 
	"\n__      __  ___   _______  _____ "
	+"\n\\ \\    / / / _ \\ |___ ___||  ___|"
	+"\n \\ \\  / / | | | |   | |   | |___ "
	+"\n  \\ \\/ /  | | | |   | |   |  ___|"
	+"\n   \\  /   | |_| |   | |   | |___ "
	+"\n    \\/     \\___/    |_|   |_____]";
   
    public static void delay(){ //simple mechanism to provide a chance for the player to read the text on-screen
	System.out.println("======================================");
	System.out.print("Enter anything to proceed  ");
	String whatever = Keyboard.readString();
    }

    public static Senate generateSenate(int year){
        //world-create Senate, show Senate
	System.out.println("=====================================");
	Senate senate = new Senate(year);
	System.out.println(senate);
	delay();
	return senate;
    }

    public static State generateState(){	
	boolean trigger = true;
	String ans = "";
	State homeState = new State();
	while(trigger){
	    System.out.println("\nYou are a venerable U.S. Senator from which state? \n(Remember to Capitalize the First Letter)");
	    ans = Keyboard.readString();
	    try{
		homeState = new State(ans); //State generation
		System.out.println("You are from "+ans);
		trigger=false;
	    }
	    catch (Exception ex){
		System.out.println(ex.getMessage() );
	    }
	}
	System.out.println("=====================================");
	try{//this try-catch system just to make it past the compiler
	    homeState=new State(ans);
	    System.out.println(homeState);
	}
	catch (Exception ex){}
	delay();
	return homeState;
    }//end generateState

    public static Player generatePlayer(State homeState){
	return new Player(homeState);
    }

    public static boolean electionTime(State playerState, ArrayList<Legislation> l, ArrayList<String[]> s){
	System.out.println("6 years have passed, your term is up...time to get back on the stump and try to keep your job...");
	System.out.println(americanFlag + vote);
	int percentSupport =  playerState.popularity(l,s);
	if (percentSupport < 0) {
	    System.out.println("Well it seems your nearly criminal actions have caught up to you, your repeated support of multiple questionable bills has been noticed by several large media organizations. Well, they love a good story and guess who is the new Lucifer of the Hill. The people are fine electing a scumbag as long as their is no evidence, and they can lie to themselves they elected someone who will help the country. Well, with the evidence on every major cable network your ratings plummted to negative levels (who even knew this was possible?) and you have been promptly impeached from office.");
	    return false;
	}
	else if (percentSupport > 50) {
	    System.out.println("You have successfully followed the demands of partisan politics in the US and have gained the support of " + percentSupport + "% of the voters in your home State. This has secured you your relection, and most importantly means your super comfy office chair will be yours for another six years.");
	    return true;
	}
	else {
	    System.out.println("Whatever you tried to do, you did wrong. Maybe you tried to be all nice and bipartisan, or perhaps you decided to be the maverick that changed the opinions of their state to what was actually beneficial for the state. Regadless it seems you have faced the harsh reality of politics that you are a slave to the people, every single stubborn one of them, and apparently you were a bad slave with only " + percentSupport + "% of your home state voting to reinstate you. Well, you failed to get relected and you're out of a job. Just make sure to swipe all the office supplies and confidential documents you can before you leave!");
	    return false;
	}
    }


    public static void main( String[] args ) {
	int year = 1996;
	System.out.println("The year is "+year);
	Senate senate = generateSenate(year);
	State playerState = generateState();
	Player player = generatePlayer(playerState);
	

	/*=============================	
	System.out.println("=====================================");
	Legislation test = new Legislation();
	System.out.println(test);
	System.out.println("Senate approval for this bill: "+senate.voteLegis(test));
	System.out.print("Enter anything to proceed  ");
	whatever = Keyboard.readString();
	=================================*/
	
	double worldStability = 0; //higher lowers all financial indicators of public, keep it down,
	//passing too much of one kind of legislation aggravates it. Yet, your party will always want you to pass more of the same. Range [0, 50]
	
	//***PHASING OUT WORLD STABILITY EFFECTS IN ORDER TO GET THIS THING OUT THE DOOR ASAP***
	//***hopefully we can work on it later***
	/*
	System.out.println("\tYou have been told the Senate has a unique system to help keep track of global stability.\n It is a nice simple number, the higher it is the more unstable the world is, the lower the more stable the world is.\n It is conveniently easy for them to keep track of as they spend excess amounts of time with women of questionable repute.\n It currently is: " + worldStability);  
	delay();
	*/

	boolean elected = true;
	boolean censored = false;
	boolean arrested = false;
	int yearsPlayed = 0;
        State orig = playerState;
	ArrayList<Legislation> finishedLegislation = new ArrayList<Legislation>();
	ArrayList<String[]> votesOnBills = new ArrayList<String[]>(); //tied to array just above this, three options are Yes, No, delay for the first(your vote), for the second it is the result, yes no or hell
	while (elected) {
	    if (playerState.getAveInc() <= (orig.getAveInc() * 0.4)) {  //conditions to get kicked out:
		elected = false;
		System.out.println("You have caused devastating effects to the income of your home state due to terrible responses to crisis around the world, as such you have been kicked from office");
		continue; 
	    }

	
	    System.out.println("It is " + year + " time to do some legislating so your home state does not make you out of a job in a few years");
	    System.out.println("======================================");
	    //if (censored) {
	    // elected = false;
	    // continue;
	    //if (arrested) {
	    // elected = false;
	    // continue;}


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

	
	    int powerSource = (int) (Math.random() * 3);
	    String powerName = "";
	    while (legislationActive) {  
		if ( (passageBill == 1) || (passageBill == 2) || (passageBill == 3) ) {
		    break;
		    //legislationActive = false;
		} 
 		Legislation freshBill = new Legislation(); 
		String whoDelay = "No One"; // "No One" for when no one is delaying the bill, "You" for when you are delaying a bill, "Opposition" when the opposition to your vote of passing is delaying the vote, "Fail" you have attempted to delay too long and have failed, "Success" the opposition has failed in its delay tactics
		System.out.println(freshBill);
		//System.out.println("Current Senate support for this bill: "+senate.voteLegis(freshBill)+"%"); are we sure we want this, would it be better for the player to have to discover it all?
		delay();
		if (powerSource == 0) {
		    powerName = "Magnificent Hair";
		    System.out.println("\n\n All the other Senators stare at that perfectly HAIRSPRAYED head of yours and stand in utter awe. \n Your perfect hair has given you Power over some of the other Senators votes, it is time to use the great power of hair products to cast your vote to attempt to determine the fate of this bill.\n\n");
		    delay();

		}
		else if (powerSource == 1) {
		    powerName = "Amazing Pin";		    
		    System.out.println("\n\n It is new, it is shiny, and, by the majestic wings of your beautiful state bird, it is AMERICAN.\n That little American FLAG PIN  you put in your lapel this morning has enchanted some of the lesser Senators, your vote now hold theirs in its sway, use the power of your fake patriotism now to attempt to determine the fate of this bill with your vote.\n\n"); 
		    delay();
		}

		else {
		    powerName = "Stupendous Argyle Socks";
		    System.out.println("\n\n They stand aghast in surprised amazement, could he really be going for it, flaunting the greatest--probably more like the 11th greatest--of Senate Traditions. Yes indeed you, you wore....gasp!....ARGYLE SOCKS! You have thrown aside the tradition of plain dress socks, and as such every 3 steps the other Senators can sometimes see something that is not quite the color of your pants! This rebliousness inspires, it gives power, and thus you now have the support of some of the Senators, now you can vote to attempt to change the fate of this bill.\n\n"); 
		    delay();
		}
		if (passageBill == 0) {
		    System.out.print("Would you like to Vote 'For' or 'Against' this Bill?\nYou can also attempt to delay it forever with either a 'Filibuster', 'Amendments', or 'Both' if you do not think you have the votes to stop this bill on its own:\n"); 
		    String vote = Keyboard.readString();
		    if (vote.equals("Both")) {
			System.out.println("Your tactic has been successful, the supporters of this bill have given up and it is to forever sit in the archives of never-voted-on Senate Bills"); delay();
			passageBill = 3;
			legislationActive = false;
			System.out.println(finishedLegislation.add(freshBill) );
			System.out.println("***DIAG a--finishedLegislation.size()*** "+finishedLegislation.size());
			//System.out.println("***DIAG c--finishedLegislation*** "+finishedLegislation);
			String[] votesBill = new String[3];
			votesBill[0] = ""+year;
			votesBill[1] = "Delay";
			votesBill[2] = "Hell";
			votesOnBills.add(votesBill);
			continue; 
		    }
		    else if (vote.equals("Amendments") || vote.equals("Filibuster") ) {
			System.out.println("Your attempt to delay the bill into eternity has failed, the other Senators have rejected these obstructionist tactics and are proceeding with the vote on the bill");delay();
		    }
		    double support = senate.voteLegis(freshBill,vote,player);
		    System.out.println("\n\n The percent of the Senate that voted for this bill was " + (support*100) + "%");
		    if (support <= 0.5) {
			System.out.println("It seems this bill has failed, despite the support some had for it");
			passageBill = 2;
			System.out.println(finishedLegislation.add(freshBill) );
			System.out.println("***DIAG b--finishedLegislation.size()*** "+finishedLegislation.size());
			//System.out.println("***DIAG c--finishedLegislation*** "+finishedLegislation);
			String[] votesBill = new String[3];
			votesBill[0] = ""+year;
			votesBill[1] = vote;
			votesBill[2] = "Fail";
			votesOnBills.add(votesBill);
			legislationActive = false;

		    }
		    else if (support > 0.5) {
			System.out.println("It seems this bill has passed, its supporters have triumphed over the resistant minority");
			passageBill = 1;
			System.out.println(finishedLegislation.add(freshBill) );
			System.out.println("***DIAG c--finishedLegislation.size()*** "+finishedLegislation.size());
			//System.out.println("***DIAG c--finishedLegislation*** "+finishedLegislation);
			String[] votesBill = new String[3];
			votesBill[0] = ""+year;
			votesBill[1] = vote;
			votesBill[2] = "Pass";
			votesOnBills.add(votesBill);
			legislationActive = false;

		    }
		}
		delay();
		if ( ( (passageBill == 4) || (passageBill == 5) || (passageBill == 9) ) && (whoDelay == "You") ) {
		    System.out.print("You are are successfully deleying the passage of the bill, yet the opposition has not yet given up and let the bill die. They are matching you inch for inch in this battle of wills. You can 'Continue' to attempt to delay the bill further and hope the opposition surrenders, yet this continued obstructionism can have many dangerous effects, you may want to 'Surrender' and let the bill pass:"); delay();
			String tactic = Keyboard.readString();
		}

		

			
		yearsPlayed+=1;
		System.out.println("***DIAG--yearsPlayed*** "+yearsPlayed+" / 6 = "+yearsPlayed%6);
	    }//end while (legislationActive)

	    boolean eventOccuring = true;
	    while (eventOccuring) {
		int eventChoice = (int) (Math.random());
		if (eventChoice == 0) {
		    Event currentEvent = new Event("Foreign");
		    if (yearsPlayed == 1){ //only show the first time players are introduced to this mechanism
			System.out.println("On account of " + powerName + " you have been appointed Chair of the Senate Committee on Foreign Relations. Seeing as it is a normal day there is a sum total of...No One in the committee, but your "+ powerName+ " has given you the courage to actually show up for a fine day of doing absolutely nothing.\n\nAhhh\n\t\t *WeeWoo*\nwait what's that?\n\t\t*WeeWoo*\nhuh?\n\t\t*WeeWooWeeWooWeeWoo*");
		    }
		    else{
			System.out.println("\t\t*WeeWoo* *WeeWoo* *WeeWooWeeWooWeeWoo*");
		    }
		    System.out.println("ITS THE ALARM! There is a new crisis somewhere in the world, and the Senate for once (meaning you) has to deal with it! The president always took care of it, but he's indisposed...maybe the change has to do with that new intern Ms. Lewinsky..."); 
		    
		    delay();
		    System.out.println(currentEvent);
		    System.out.println("=====================================");
		    System.out.print("Enter the number of the option you wish to pursue: ");
		    int responseChoice = Keyboard.readInt();
 
		    double[] response = Event.changeResult (playerState, worldStability, responseChoice);
		    playerState.setAveInc(playerState.getAveInc() +  (long) (response[0]) );
		    worldStability += response[1];
		    /*
		    System.out.println("Outcome of your decision: ");
		    System.out.println("Change to National Average Income -- " +response[0]);
		    System.out.println("Change to Overall World Stability -- " +response[1]);
		    */
		    eventOccuring = false;
		}
		yearsPlayed+=1;
		System.out.println("***DIAG--yearsPlayed*** "+yearsPlayed+" / 6 = "+yearsPlayed%6);
		delay();
	    }//end while(eventOccuring)
	    
	    year += 2;
	    
	    //~~~~~~~~~~~~~~ELEEEEEECTION TIME~~~~~~~~~~~~~~~~
	    if(yearsPlayed%6==0){
		elected = electionTime(playerState, finishedLegislation, votesOnBills ); 	   
	    }
	    
	}//end while(elected)
	
	System.out.println("So your journey has come to an end fair Senator. Thou hast had a good run, doing much in the way of helping one's home state and the world...maybe...or just enjoying all the free stuff, oak panelling, and comfy office chairs your daring appearence granted you. Thinking back you realize you won't miss it much, yes it was semi-not-really enjoyable, but to be honest it did not pay that great. Also the politics seemed to make no sense, it was like everyone voted on capricious whims based on established convictions with no basis in fact....hmm actually looking back US politics is horrible, its great to be out. Now you get to make the real money as a...LOBBYIST!!! ....So another journey begins."); 
	/*=============================
	  =================================*/
    }//end main
}//end driver
