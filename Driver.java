
import cs1.Keyboard;

public class Driver {
    
    public static void generatePlayer(){
	System.out.println("The year is 1996. \nYou are a venerable U.S. Senator from which state?");
	State homeState = new State(Keyboard.readString() );
	
	
    }

    public static void main( String[] args ) {
	
	generatePlayer();
	
	boolean elected = true;
	while (elected) {
	    int worldStability; //higher lowers all financial indicators of public, keep it down,
	    //passing too much of one kind of legislation aggravates it. Yet, your party will always want you to pass more of the same.
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
		Legislation freshBill = new Legislation(); 
		System.out.println(freshBill);
		int powerSource = (int) Math.random() * 3;
		if (powerSource == 0) {
		    System.out.println("\n\n All the other Senators stare at that perfectly Hairsprayed hair of yours and stand in utter awe. \n Your perfect hair has given you Power over some of the other Senators votes, it is time to use the great power of hair products to cast your vote to attempt to determine the fate of this bill.");
		}
		else if (powerSourc == 1) {
		    System.out.println("\n\n It is new, it is shiny, and, by the majestic wings of your beautiful state bird, it is AMERICAN.\n That little American flag pin you put in your lapel this morning has enchanted some of the lesser Senators, your vote now hold theirs in its sway, use the power of your fake patriotism now to attempt to determine the fate of this bill with your vote.");
		}
		else {
		    System.out.println("\n\n They stand aghast in surprised amazement, could he really be going for it, flaunting the greatest, probably more like the 11th greatest, of Senate Traditions. Yes indeed you had, you wore....gasp!....Argyle Socks! You have thrown aside the tradition of plain dress socks, and as such every like maybe 3 steps the other Senators can sometimes see something that is not quite the color of your pants! This rebliousness inspires, it gives power, and thus you now have the support of some of the Senators, now you can vote to attempt to change the fate of this bill.");
		}

		
		
