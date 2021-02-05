//Assignment #3
//Brittney Witts. 016927077
//Ian Espinosa. 014252899
import java.util.Calendar;


public abstract class TicketPurchase {

	public TicketPurchase(String subscriber, String purchaseDate, String event) {
		mDate = DateUtil.convertStringDatetoCalendarDate(purchaseDate);
		mName = subscriber;
		this.event = event;
	}
	
	public Date getDate() {
		return mDate;
	}

	public abstract String getType();
	protected Date mDate;
	protected String mName;
	protected String event;
	@Override
	public String toString(){
		return "Subscriber: " + mName + ", Date: " + DateUtil.getFormattedDate(mDate);
	}
}
