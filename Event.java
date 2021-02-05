//Assignment #3
//Brittney Witts. 016927077
//Ian Espinosa. 014252899
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

public abstract class Event implements Displayable, Comparable<Event> {
	public Event(Venue vName, String mDate, double ticket, String type) {
		mTransactions = new ArrayList<TicketPurchase>();
		this.vName = vName;
		this.mDate = DateUtil.convertStringDatetoCalendarDate(mDate);
		this.mticketprice = ticket;
		this.type = type;
	}

	public double getTicketPrice() {
		return mticketprice;
	}
	
	public void addTicketPurchase(TicketPurchase tp) {
		mTransactions.add(tp);
	}

	public String display() {
		return null;
		// TODO Auto-generated method stub
	}
//	
//	@Override
//	public String toString() {
//		return "Type: " + getType() + ", Name: ";
//		
//	}

	public abstract String getType();

//	public ArrayList<TicketPurchase> getTicketPurchases(String beforeDate)
//	{
//		ArrayList<TicketPurchase> transactions = new ArrayList<TicketPurchase>();
//		Calendar bDate= DateUtil.convertStringDatetoCalendarDate(beforeDate);
//		
//		for(TicketPurchase t : mTransactions)
//		{
//			if(t.getDate().before(bDate)) transactions.add(t); 
//		}
//		
//		return transactions;
//	}

	private int mAccountNumber;
	protected List<TicketPurchase> mTransactions;
	//private String Sportname;
	protected Venue vName;
	protected Date mDate;
	protected double mticketprice;
	protected String type;
	
	public ArrayList<TicketPurchase> getTicketPurchases(String beforeDate) {
		// TODO Auto-generated method stub
		return (ArrayList<TicketPurchase>) mTransactions;
	}

}
