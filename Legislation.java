public class Legislation {

    //important: http://infohost.nmt.edu/tcc/help/xfer/scp.html
    
    //text of the bill
    private String text;

    //all possible bill texts
    private final String[][] POS_BILLS;

    //types of bills, form of ints which must be -1, 0, 1, or 2
    private int foreignType;
    // 0 = Interventionist, 1 = Internationalist, 2 = Isolationist, -1 = has nothing to do with Foreign Affairs
    private int economicsType;
    // 0 = Populist (Raises jobs, neutral on income, lowers stock market), 1 = Trickle-Down (Raises Jobs and Stock Market, hurts income), 2 = Modernization (Raises Incomes and Stock Market, hurts Jobs, -1 = no effect on economy);
    // -1 , 0, 1, 2, 3
    private int socialType;
    // 0 = Libertarians (0% regulation) , 1 = Left-Leaning, 2 = Right-Leaning, 3 = Fascist (100% regulation)
    
    //accessors
    public int getSoc () {
	return socialType;
    }
    public int getEcon () {
	return economicsType;
    }
    public int getForeign () {
	return foreignType;
    }
    public String getText() {
	return text;
    }
    
    public void populateBills () {
	POS_BILLS[0][0] = "Nationalized Health Care: A National Publically Administrated Health Insurence Policy will be provided by the the Federal Government. It will be subsidized by tax funding, the cost of the heath insurence will be determined by the income of the applicant, and the management of the Public Insurence will create new regulation for the control of the Insurence industry. A government managed online health care exhange will also be created in order to provide an open market where individuals can easily find and purchase their desired insurence.";
	POS_BILLS[1][0] = "Liberate Iraq: The government in Iraq has committed genocide against its own citizens, has repeatedly resisted and has been openly hostile to integration of its oil market into the global free market, is horribly corrupt with those close to Saddam Hussein's family having accumulated millions while many live in poverty, and it is a repressive dictatorship that opposes proper AMERICAN freedom and democracy. Saddam's reign ends now, the glorious American military will now liberate the oppressed Iraqi people from their horrid government";
	POS_BILLS[2][0] = "Send Special Forces to Somalia: After the overthrow of the Communist government of Mohamed Siad Barre the nation of Somalia has descended into anarchy with multiple warlords and rebels controlling bits and pieces of the country, yet with no central government actually providing the services people need. The UN has attempted to provide aid to the embattled people of Somalia, but the attacks and opposition of local warlords have impeded these efforts. The Seals are here to save the day! They will be sent in to 'remove' some of these more problamatic warlords.";
	POS_BILLS[3][0] = "Generate Dynamism and Growth in the Economy: Tax cuts will be implemented across the board, with extra tax cuts to all capital gains income. In addition, tax breaks, subsidies, and credits will be granted to American companies, about half will be dependant on re-investment of the funds, yet all the other breaks are unconditional. In order to fund this spending will be cut on unemployment, social security, and Medicaid benefits";

    	
}