public class Legislation {

    //important: http://infohost.nmt.edu/tcc/help/xfer/scp.html
    
    //INSTANCE VARS
    //text of the bill
    private String text;

    //all possible bill texts
    //8 attributes for each bill == text, econType, socType, forType, proposer, PorkBarrel, selfEnrichment, gerrymandering;
    private final int[][] POS_BILLS = { {0, 1, 0, 0, 0, -1, 0, 1}, {1, 0, 0, 0, 0, 0, -1, 2}, {2, 0, 0, 0, 0, 0, -1, 2}, {3, 0, 0, 0, 0, -1, 1, 2}, {4, 1, 0, 0, 0, -1, 0, 1}, {5, 2, 0, 0, 0, -1, 2, 2}, {6, 1, 0, 0, 0, -1, 0, 1}, {7, 2, 0, 0, 0, 1, -1, -1}, {8, 0, 0, 0, 0, 0, -1, 2}, {9, 1, 0, 0, 0, 2, -1, 1}, {10, 0, 0, 0, 0, -1, 1, 2}, {11, 1, 0, 0, 0, 1, -1, 1}, {12, 0, 0, 0, 0, 2, 2, 2}, {13, 1, 0, 0, 0, -1, 0, 1}, {14, 1, 0, 0, 0, 2, 2, 1}, {15, 0, 0, 0, 0, -1, 1, 2}, {16, 2, 0, 0, 0, -1, -1, 0}, {17, 2, 0, 0, 0, -1, 2, 1}, {18, 2, 0, 0, 0, 1, -1, 2}, {19, 0, 0, 0, 0, -1, 1, 2}, {20, 2, 1, 0, 0, -1, -1, -1}, {21, 2, 0, 1, 0, -1, -1, -1}, {22, 2, 1, 0, 0, -1, -1, -1}, {23, 2, 0, 0, 1, -1, -1, -1}, {24, 2, 0, 0, 1, -1, -1, -1} };
    private final String[] TEXT_REFERENCE = new String[25];

    private int propParty; //1 = demo, 0 = repub, 2 = bipartisan
    private int porkBarrel; // 1 = yes, 0 = no
    private int selfEnrichment; // 1 = yes, 0 = no
    private int gerryMandering; // 1 = yes , 0 = no

    //types of bills, form of ints which must be -1, 0, 1, or 2
    private int foreignType;
    // 0 = Interventionist, 1 = Internationalist, 2 = Isolationist, -1 = has nothing to do with Foreign Affairs
    private int economicsType;
    // 0 = Populist (Raises jobs, neutral on income, lowers stock market), 1 = Trickle-Down (Raises Jobs and Stock Market, hurts income), 2 = Modernization (Raises Incomes and Stock Market, hurts Jobs, -1 = no effect on economy);
    // -1, 0, 1, 2, 3
    private int socialType;
    // 0 = Libertarians (0% regulation) , 1 = Left-Leaning, 2 = Right-Leaning, 3 = Fascist (100% regulation), -1 = None of the Above
    
    public int position;
    
    public Legislation () {
	int randChoice = (int) (Math.random() * 25);
	populateText();
	position = randChoice;
	text = TEXT_REFERENCE[ (POS_BILLS[randChoice][0]) ];
	propParty = POS_BILLS[randChoice][1];
	porkBarrel = POS_BILLS[randChoice][2];
	selfEnrichment = POS_BILLS[randChoice][3];
	gerryMandering = POS_BILLS[randChoice][4];
	foreignType = POS_BILLS[randChoice][5];
	economicsType = POS_BILLS[randChoice][6];
	socialType = POS_BILLS[randChoice][7];
	
    }
    
    //overriding the good ole' to String (faster than writing out the designations for each bill
    public String toString () {
	String ans = "";
	ans += "Text of Legislation -- " + text + "\n======================================\n";
	ans += "Party that Proposed the Legislation: ";
	if (propParty == 0) { ans += "Republicans"; }
	else if (propParty == 1) { ans += "Democrats"; }
	else {ans += "This Bill was Proposed by a Bipartisan group of Senators, Its a Miracle!"; }
	ans += "\n"; 
	ans += "Does this Bill allocate Pork-Barrel spending for your State?: ";
	if (porkBarrel == 0) { ans += "No"; }
	else { ans += "Yes"; }
	ans += "\n";
	ans += "Does this bill raise your salary for no reason?: ";
	if (selfEnrichment == 0) { ans += "Nope, :("; }
	else { ans += "Aww Yisss"; }
	ans += "\n";
	ans += "Does this Bill help fudge elections to help you get relected?: ";
	if (gerryMandering == 0) { ans += "No"; }
	else { ans += "Yes...((shhh))"; }
	ans += "\n";
	ans += "Foreign Policy Ideology Pursued by the Bill: ";
	if (foreignType == 0) { ans += "Interventionalism"; }
	else if (foreignType == 1) { ans += "Internationalism"; }
	else if (foreignType == 2){ ans += "Isolationism"; }
	else {//ans += "This Bill is largely independant of any Foreign Policy Ideology";
	    ans+="None";}
	ans += "\n";
	ans += "Economic Policy Pursued by the Bill: ";
	if (economicsType == 0) { ans += "Populism"; }
	else if (economicsType == 1) { ans += "Supply-Side Economics"; }
	else if (economicsType == 2) { ans += "Modernization"; }
	else {//ans += "This Bill is largely independant of any defined Economic Policy";
	    ans+="None";}
	ans += "\n";
	ans += "Overall this bill might be deemed by society as: ";
	if (socialType == 0) { ans += "Libertarian"; }
	else if (socialType == 1) { ans += "Left-Leaning"; }
	else if (socialType == 2) { ans += "Right-Leaning"; }
	else if (socialType == 3) { ans += "Fascist"; }
	else {ans += "This is one of those rare bills that is simultaneously adored by every politician, and hated by every citizen, thus defiying classification";}
	return ans;
    }

    //accessors
    public int getGerry () {
	return gerryMandering;
    }
    public int getSelf () {
	return selfEnrichment;
    }
    public int getProp () {
	return propParty;
    }
    public int getPork () {
	return porkBarrel;
    }
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
    public int getPosition () {
	return position;
    }
    
    public void populateText () {
	TEXT_REFERENCE[0] = "Nationalized Health Care:\n A National Publically Administrated Health Insurence Policy will be provided by the the Federal Government. It will be subsidized by tax funding, the cost of the heath insurence will be determined by the income of the applicant, and the management of the Public Insurence will create new regulation for the control of the Insurence industry. A government managed online health care exhange will also be created in order to provide an open market where individuals can easily find and purchase their desired insurence.";
	TEXT_REFERENCE[1] = "Liberate Iraq:\n The government in Iraq has committed genocide against its own citizens, has repeatedly resisted and has been openly hostile to integration of its oil market into the global free market, is horribly corrupt with those close to Saddam Hussein's family having accumulated millions while many live in poverty, and it is a repressive dictatorship that opposes proper AMERICAN freedom and democracy. Saddam's reign ends now, the glorious American military will now liberate the oppressed Iraqi people from their horrid government";
	TEXT_REFERENCE[2] = "Send Special Forces to Somalia:\n After the overthrow of the Communist government of Mohamed Siad Barre the nation of Somalia has descended into anarchy with multiple warlords and rebels controlling bits and pieces of the country, yet with no central government actually providing the services people need. The UN has attempted to provide aid to the embattled people of Somalia, but the attacks and opposition of local warlords have impeded these efforts. The Seals are here to save the day! They will be sent in to 'remove' some of these more problamatic warlords.";
	TEXT_REFERENCE[3] = "Generate Dynamism and Growth in the Economy:\n Tax cuts will be implemented across the board, with extra tax cuts to all capital gains income. In addition, tax breaks, subsidies, and credits will be granted to American companies, about half will be dependant on re-investment of the funds, yet all the other breaks are unconditional. In order to fund this spending will be cut on unemployment, social security, and Medicaid benefits";
	TEXT_REFERENCE[4] = "Ensure Fair Distribution of Resources:\n Spending shall be raised on unemployment, Medicaid, social security, subsidized houseing, and state welfare program benefits. This will be funded by the Income tax on the top 5% of Americans will be raised, the Capital Gains tax will be brought up to be the same level as that of the income tax for the designated income bracket of the earner. Businesses that are not classified as small businesses by the US small business administration will see a raise of 40% in their taxes.";
	TEXT_REFERENCE[5] = "Modernize Production Infrastructure:\n Spending on tax breaks and subsidies to Heavy Industry, Textile, and Small Consumer Product low-skilled manufactering shall be diverted towards funding for companies within industries that have high levels of computarized technology, automization, or highly skilled labor. Funding for highly computarized service sector companies (e.g. Google, Goldman Sachs, Pfizer, etc.) shall also be increased, especially for funding of any Research and Development or Institutional Advancement.";
	TEXT_REFERENCE[6] = "Protect America's Heartland:\n An administration to be known as the Competition Rectification Administration (CRA) shall be created to identify nations with lower labor costs than our own which should be targeted with higher tariffs in order to protect US manufactering. These tariff recommendations will then be implemented by the US Tresury Department and the US Customs Service";
	TEXT_REFERENCE[7] = "Rebuild Rwanda:\n Aid funds for education, health care, and infrastructure development will be provided to the new Government in Rwanda to help the nation rebuil after the genocide of 100,000s Tutsi's in the Rwandan genocide.";
	TEXT_REFERENCE[8] = "Ensure American Dominance and Freedom:\n The US has multiple fleets stationed around the world, not to mention the many bases we in equally numerous countries to project powere abroad. However, there are multiple rising powers that could threaten US interests. In order to counter them additional fleetswill be created and deployed in Cape Town, South Africa; The Faukland Islands, UK; Darwin, Australia; Dhaka, Bangladesh. In order to gain support and operational bases for the fleets the designated countries funding will be provided to build bases in the listed location and to gain permission from the host governments to build these bases.";	
	TEXT_REFERENCE[9] = "Refocus US efforts to the Homefront:\n The US has multiple fleets and military bases around the world, yet with the end of the Cold War, these are mostly uneccessary. It is now the responsibility of the federal government to focus attention and funding back into the United States. As such the 4th and 10th fleet on the US east coast will be halved and merged to form one fleet at Fort Meade Maryland. In addition the 6th fleet in Naples will be disbanded and its military assets will be sold off to NATO allies. Finally, all US military bases not located in the Americas or Japan, or are needed to protect US interests in an on-going or imminent (within one year) conflict, will be closed and the troops at these bases will be brough back home to the US. (An exception will be made for a singular base in Bahrain to support the 5th fleet.";
	TEXT_REFERENCE[10] = "Enable Greater Investment and Vitality on Wall-Street:\n The New York Stock Exchange is the largest Stock Exchange in the world, and the US hosts the largest financial sector in the world. It generates billions of dollars a year for the US, yet it is constrained by unduly restrictive regulation. We need to liberate the financial markets. Regulations will be dropped in the Financial markets allowing for greater investment and economic growth. The US congress will also make a specific endorsement of securitization of debt related assets that generate income flows due to their undprecidented ability to generate stability and profits in the world financial markets.";
	TEXT_REFERENCE[11] =  "Align the US with International Sentiment:\n In order to improve the international image of the United States any aggressive military action carried out against an armed foreign power, in non-emergancy situations (these determined by the Presidant and JCS) now require either the passage of a resolution within the UN general assembly calling for said action, authorization from the UN security council, or a 2/3 vote from the Senate and 3/5 vote from the House.";
	TEXT_REFERENCE[12] = "Fund Research and Development in New Technologies:\n Funding will be diverted from the budget for military bases and aid abroad towards the funding of new technologies for use by the United States armed forces. These advances shall focuse on new military technologies, as well as new production techniques for US military gear to decrease the man power, materials, and time needed for its production through mechanization and digitization of production methods.";
	TEXT_REFERENCE[13] = "Ensure Living Wage Standards:\n The US minimum wage will be raised by 42.5% in order that the minimum wage be brought closer in line to the wage needed to that of a basic living wage, and to expand the purchasing power of those working for minimum wage so that they may help to engage in stimulating the economy.";
	TEXT_REFERENCE[14] = "Reduce Dependance on Fossil Fuels:\n 50% of federal subsidies and tax breaks to fossil fuel (natural gas, oil, and coal) will be removed in order to fund an expansion of tax breaks and subsidies to all companies who engage in the production, research, installation, or marketing of alternative renewable energies. In addition a federal program to provide startup capital to renewable energy companies will be established to provide low interest loans to companies who engage in the production, research, installation, or marketing of alternatice renewable energies.";
	TEXT_REFERENCE[15] = "A Bill to Ensure American Competitiveness:\n All federal business safety, environmental, and labor regulations will be removed gradually over a period of 12 months starting at the end of the current fiscal year. As these regulations are removed a committee will be established to determine which local juristiction, either state, county, or city, will be responsible for reestablishment of locally appropriate and effective safety, environmental, and labor regulations as determined by these local governments.";
	TEXT_REFERENCE[16] = "Ensure Fiscal Independance in the United States:\n The FED, get rid of it. That is all. If more information is needed please refer to Dr. Ron Paul for further information.";
	TEXT_REFERENCE[17] = "Revolutionize Travel in the United States:\n Funding will be diverted from federal support for car manufactoring companies, and from federal support and maintenence of large highways, freeways, and interstate roads to support and develop a high speed rail system within the United States based upon the model of mainly Japan, as well as the EU.";
	TEXT_REFERENCE[18] = "Lead NATO Intervention in Yugoslavia:\n Since 1991 Yugoslavia has slowly been breaking down into its constituent states, yet the former leading ethnic group and state within Yugoslavia, the Serbs and Serbia respectively, have brutally resisted this change. They have attacked and resisted Independancce movements efforts to gain freedom for their ethnic group, and carried out ethnic cleansing and forced migration of non-Serbian ethnic groups to gain control over Yugoslavia. These actions are unacceptable and stand contrary to the freedom that America stands for. As such the US will lead NATO in carrying out air strikes against Serbian forces and Infrastructure to assist Yugoslavian rebel independance groups.";
	TEXT_REFERENCE[19] = "To Ensure Proper Supply and Demand within the Labor Market:\n The minimum wage distorts supply and demand within the labor market leading to less jobs and lower productivity and market efficiency. As such all federalm minimum wage standards will be abolished to correct this inaccuracy.";
	TEXT_REFERENCE[20] = "Advance and Modernize the.....blah, blah, blah:\n....ugh what's this waste of time, do I really need to vote on its not like anyone in my state will notice it let alone know what it does, I mean its 673 pages long!...WAIT! This is my chance, no one will notice if I slip in a little clause to send a couple million dollars to my state in between the clauses on differing regulations on filing the percent composition between anthracite and bitumonous coal for graphite mines in Wyoming. It will help me get reelected when I can talk about all the jobs it created, who cares about the government debt it will make, I mean isn't getting reelected what I'm trying to do anyways?";
	TEXT_REFERENCE[21] = "***Top Secret Classified*** Advance the Salaries of Senators:\n We provide the USA with the most valuable service of leadership of this great nation, yet the public seems to think we are of the same class as their lowly selves. We are the greatest of this greatest nation and should be paid as such to support the lifestyle befitting ones as great as ourselves. As such the salaries of Congress will be raised by 100%, it should help grealty in funding the stupid reelection campaigns we always have to deal with.";
	TEXT_REFERENCE[22] = "A Bill to Rennovate US Infrastructure and Roads:\n Upon the circumstance....ugh another one of these 500+ page bills that do nothing, just a bunch of conlicting qualifications, loop-holes, and mandates that, while they satisfy each party enough to get the bill passed, make this bill do effectively nothing, thanks to their contradictory effects, to solve the very real problem this bill tries to fix. My state is going to be pissed at me for not pushing the other side to pass what they want to fix it, but that was not possible, and at least this bill does a little something. The people are too stupid, they can't see the bigger picture, and now I lose my job because of it....if only I could placate them....well people always like jobs....hmmm I can slip in a couple million in spnending for my state right within the loopholes for roads between buildings inside chemical production plants in Oklahoma. Hey it will jump up the deficit, but at least it lets me keep my job when I've done nothing wrong.";
	TEXT_REFERENCE[23] = "A Bill to Ensure the Proper Districting of Congressional Districts:\n The proper drawing of districts can have a huge effect on the ability of government officials to be reelected, yet regulations and oversight over this process gets in the way of state legislators exercising the will of the people. Thus from hence forth the regulations on the drawing of congressional districts shall be reduced enabling more freedom in this drawing. This practice will be referred to as gerrymandering in future debates.";
	TEXT_REFERENCE[24] = "Rid the Nation of Voter Fraud:\n New more extensive voter registration laws shall be implemented across the United States to prevent voter fraud so that the outcome of elections can be ensured to be honest. The nature and implementation of these new laws shall be determined by the Senators from each state as they fully represent their whole state and thus have the most knowledge and connections for implementation about and throughout their state."; 
    }
    
    
    public static void main (String[] args) {
	Legislation test = new Legislation();
	System.out.println(test);
    }
    	
}
