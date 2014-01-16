
public class Driver {
    
    public static void main( String[] args ) {
	boolean elected = true;
	while (elected) {
	    boolean legislationActive;
	    int passageBill = 0; // 0 = nothing done yet, 1 = passed, 2 = failed, 3 = sent to bill hell, 4 = being delayed by amendments, 5 = being delayed by filibuster, 9 = total delay attack
	    Event lastEvent;
	    while (legislationActive) {
		if ( (passageBill == 1) || (passageBill == 2) || (passagebill == 3) ) {
		    break;
		}
		Legislation majorityBill = new Legislation(); //should include senate and public as variables for the method
		
