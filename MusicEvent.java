//Assignment #3
//Brittney Witts. 016927077
//Ian Espinosa. 014252899
import java.util.Calendar;


public class MusicEvent extends Event {
	
	public MusicEvent(String name, Venue vObj, String date, double ticketPrice, String band) {
		super(vObj,date,ticketPrice,name);
		mBand=band;
	
	}

	@Override
	public String toString() {
		return "Type: " + getType() + ", Name: " + type + ", Venue: " + vName + " Occurs On: " + mDate + ", Ticket Price: " + mticketprice + ", Band: " + mBand;
	}
	
	@Override
	public String display() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBand() {
		return mBand;
	}
	
	@Override
	public int compareTo(Event v) {
		if(!(v instanceof MusicEvent)) return 1;
		
		MusicEvent c = (MusicEvent)v;
		
		if(mBand.compareTo(c.getBand()) > 0) {
			return 1;
		}
		else if(mBand.compareTo(c.getBand()) < 0) {
			return -1;
		}else {
			return 0;
		}
	}

	public String getType() {
		return "Music";
	}
	
	private String mBand;
	
	
}
