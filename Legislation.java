public class Legislation {

    //important: http://infohost.nmt.edu/tcc/help/xfer/scp.html
    
    //text of the bill
    private String text;

    //all possible bill texts
    //8 attributes for each bill == text, econType, socType, forType, proposer, changeRelection, PorkBarrel, selfEnrichment;
    private final int[][] POS_BILLS = { {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {} };
    private final String[] TEXT_REFERENCE;

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
	TEXT_REFERENCE[10] = "Enable Greater Investment and Vitality on Wall-Street:\n The New York Stock Exchange is the largest Stock Exchange in the world, and the US hosts the largest financial sector in the world. It generates billions of dollars a year for the US, yet it is constrained by unduly restrictive regulation. We need to liberate the financial markets. Regulations will be dropped in the Financial markets allowing for greater investment and economic growth (exact changes need to be expanded on)";
	TEXT_REFERENCE[11] =  "Align the US with International Sentiment:\n In order to improve the international image of the United States any aggressive military action carried out against an armed foreign power, in non-emergancy situations (these determined by the Presidant and JCS) now require either the passage of a resolution within the UN general assembly calling for said action, authorization from the UN security council, or a 2/3 vote from the Senate and 3/5 vote from the House.";
	TEXT_REFERENCE[12] = "Fund Research and Development in New Technologies:\n Funding will be diverted from the budget for military bases and aid abroad towards the funding of new technologies for use by the United States armed forces. These advances shall focuse on new military technologies, as well as new production techniques for US military gear to decrease the man power, materials, and time needed for its production through mechanization and digitization of production methods.";
	//I'll do three more real bills, you need to write 5 Shahruz, and ill write the 10 corrupt bills
	//from there i will cover the rest of the class, we need to distribute tomorrow what must be done by 3:30 on Sunday
    	
}
