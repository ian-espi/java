//Assignment #3
//Brittney Witts. 016927077
//Ian Espinosa. 014252899
import java.util.Calendar;


public class SportingEvent extends Event {

	public SportingEvent(String sport, Venue v, String date, double ticketPrice, String teamOne, String teamTwo) {
		super(v,date,ticketPrice,sport);
		mTeamOne = teamOne;
		
		mTeamTwo = teamTwo;
		
	}
	
	@Override
	public String toString() {
		return "Type: " + getType() + ", Name: " + type + ", Venue: " + vName + " Occurs On: " + mDate + ", Ticket Price: " + mticketprice + ", Teams: " + mTeamOne +" vs " + mTeamTwo;
	}
	
	public String getTeamOne() {
		return mTeamOne;
	}
	
	@Override
	public int compareTo(Event v) {
		if(!(v instanceof SportingEvent)) return 1;
		
		SportingEvent c = (SportingEvent)v;
		
		if(mTeamOne.compareTo(c.getTeamOne()) > 0) {
			return 1;
		}
		else if(mTeamOne.compareTo(c.getTeamOne()) < 0) {
			return -1;
		}else {
			return 0;
		}
	}

	public String getSport() {
		return type;
	}

	public String getType() {
		return "Sporting";
	}

	

	private String mTeamOne;
	private String mTeamTwo;
	
	@Override
	public String display() {
		// TODO Auto-generated method stub
		return null;
	}
}
