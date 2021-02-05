//Assignment #3
//Brittney Witts. 016927077
//Ian Espinosa. 014252899
public class CashTicketPurchase extends TicketPurchase {

	public CashTicketPurchase(String subscriber, Event e, String purchaseDate) {
		super(subscriber, purchaseDate,e.type);
	}

	
	@Override
	public String getType() {
		return "Cash";
	}
	
	@Override
	public String toString(){
		return  getType() + " , Subscriber: " + mName + " , Event: " + event + " , Purchase Date: " + mDate;
	}

}
