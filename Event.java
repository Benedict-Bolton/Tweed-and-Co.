public class Event{
    
    private final String[][] EVENTS = new String[20][5];
    
    private String _text;
    private String[] _options = String[4];
    private String _type; 
    
    //pre: String type == Domestic || Foreign
    public Event(String type) {
	initializeEvents();
	_type = type;
	if (type.equals("Foreign")) {
	    int eventPlace = (int) (Math.random() * 4);
	    if (eventPlace = 0) {
		_text = EVENTS[eventPlace][0];
		for(int c = 1; c < EVENTS[eventPlace].length; c++) {
		    _options[c-1] = EVENTS[eventPlace][c];
		}
	    }
	}
    }
    
    public String toString() {
	ans += 

    public void initializeEvents () {
	EVENTS[0][0] = "Central Asia is again having issues of oppression and murder it seems, I suppose it is Tuesday after all. The Tajik majority in Tajikistan is forcing the migration of minority Uzbek's into camps outside the cities, these camps have very few facilities and many who are sick or injured are dying in the process. While the US can intervene and save lives, the US can also save a lot of money by being granted free access for military supplies through Tajikistan's strategically important roads.";
	//repsonses
	EVENTS[0][1] = "US Marines will be sent to Tajikistan to provide food and protection to the native Uzbek Communities until the situation diffuses";
	EVENTS[0][2] = "AMERICA!!! SEND THE TANKS AND AIR FORCE, WE ARE WIPING OUT THAT TAJIKISTAN AND UZEBKISTAN GOVERNMENT (just to be safe) AND DELIVERING A HUGE DOSE OF FREEDOM STRAIGHT FROM OUR CRUISE MISSILES!!!";
	EVENTS[0][3] = "We are not the World's police, and we have no grand geopolitical conflict to win. This is not our fight, we will raise the issue in the UN so other nations may come together to sove the issue, we cannot lead.";
	EVENTS[0][4] = "The Uzbeks have nothing to offer us, and we were elected to serve American Citizens, not Tajik Uzbeks. Let's start using those roads and save some money.";


	EVENTS[1][0] = "After many years of civil war a new faction has seized control of Afghanistan. They are known as the Talibana and worryingly are extremist Islamists who plan on running the country based on a strict interpretation of the Quran. While the US could kick out the Taliban from Kabul and hope a friendly government takes control, it is likely this would destabilize the country even more than it already is.";
	//repsonses
	EVENTS[1][1] = "US military advisors will be sent on the ground to help the Northern Alliance and ensure they respect liberties and human rights, unconditional funding will be sent to bribe them into accepting this and pay for the campaign.";
	EVENTS[1][2] = "Why bother even risking any lives? We can just throw some arms and money at the Northern Alliance, warlords, and Opium Dealers really anyone who does not like the Taliban) and they can do all the work to kick out the Taliban.";
	EVENTS[1][3] = "We have altered the course of Afghanistan's history enough, it is not our country to govern, for once we shall leave it alone.";
	EVENTS[1][4] = "US Air Strikes will be carried out against Kabul, Kandahar, and other major Taliban positions, so that other warlords may seize control. We will then be able to extort free trade from the next warlord as payment not to bomb them. Just wait for the first McDonalds in Kabul...it will be wonderful.";


	EVENTS[2][0] = "The US embassies in Yemen and Sudan have been bombed by Al-Qaeda militants. This necessatates a response, but what respect fro traditional American liberties should be maintained against these men who have no respect for these very liberties, or the lives they were made to protect?";
	//repsonses
	EVENTS[2][1] = "US Military advisors and Special Forces will be deployed to these coutnries to gain the information to hunt down and kill the culprits. In adddition US aid will be sent to rural communities to undermine and destroy support for Al-Qaeda.";
	EVENTS[2][2] = "Liberties? Respecting them? These terrorists ain't no US citizens, and anyone who supports them are traitors along with them. We'll bribe the local governments and use some Tomahawks to make sure any place they possibly could be does exist anymore. That will teach them.";
	EVENTS[2][3] = "We do not have the local influence to defeat these terrorists, the best we can do is be prepaired for another attack. Embassies will now have large military staff, and the general awareness and preparedness of US government facilities will be raised.";
	EVENTS[2][4] = "Why waste time crossing the ocean to go kill these terrorists, we can do it at home. Any bank accounts at all associated with the attacks will have their assets seized, also any based in our allies banks will be seized too, then we simply imprison anyone associated and execute half of them. Hey we can cut the deficit a lot with all the money seized from the Oil Emirs.";


	EVENTS[3][0] = "Recently the nation of Liberia, founded by former American Slaves, has emerged from an extremely bloody civil war of about 5 years with the prior warlord Charles Taylor as President. While finally under one bgovernment Liberia ia a pariah state for its use of blood diamonds to fuel the civil war in Sierra Leone. US action could stop these horrible actions, yet intervention could also seize control of the country putting the blood diamonds under US control.";
	//repsonses
	EVENTS[3][1] = "Freezes will be placed on Liberian accounts owned by government officials, and the US will invest into tracking and preventing the circulation of blood diamonds so they may not be used to fund civil war.";
	EVENTS[3][2] = "Are we weak little Belgians!?!? I think not, Marines will be sent to remove the Taylor government from the capital in Monrovia. The air force and paratroopers will then be used to mine the diamond mines so they cannot be used. That will bring freedom to those poor oppressed workers!";
	EVENTS[3][3] = "A Civil War! Disrespect of Human Rights! In Africa! Its never happened before! Well I suppose it has been about 2 years we were due for another one. We won't change anything like in the other 100, we should just stay out and let another dictator replace Taylor like in the past.";
	EVENTS[3][4] = "I do believe its time those freed slaves, and their assets, be re-united with their homeland. A large 'Peace-Keeping' force will be sent to Liberia holding major cities, and most importantly the diamond mines, until fair elections may be held. That will of course be determined by the US.";


} 
