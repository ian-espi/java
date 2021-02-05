//Assignment #3
//Brittney Witts. 016927077
//Ian Espinosa. 014252899
import java.util.Calendar;


public class Subscriber implements Displayable, Comparable<Subscriber> {
	
	Subscriber(String name, String birthdate) {
		mName = name;
		mBirthDate = DateUtil.convertStringDatetoCalendarDate(birthdate);
	}

	public String getName() {
		return mName;
	}
	
	private String getBirthDate() {
		return mBirthDate.toString();
	}
	
	/**
	 * FIX ME
	 * @param tp
	 */
	public void addTicketPurchase(TicketPurchase tp) {

	}

	@Override
	public String toString()
	{
		return mName + ", Born: " + getBirthDate();
	}
	
	@Override
	public String display() {
		return toString();
	}
	
	@Override
	public int compareTo(Subscriber p)
	{
		return mName.compareTo(p.mName);
	}

	private String mName;
	private Date mBirthDate;

}
