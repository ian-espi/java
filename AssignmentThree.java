//Assignment #3
//Brittney Witts. 016927077
//Ian Espinosa. 014252899
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AssignmentThree 
{
	public static void main(String[] args)
	{
		if(args.length < 1)
		{
			sop("Need to pass name of input file as argument");
			System.exit(1);
		}
		
		mDailyLog = new ArrayList<String>();
		mSubscribers = new HashMap<String, Subscriber>();
		mVenues = new HashMap<String, Venue>();
		mSportingEvents = new HashMap<String, SportingEvent>();
		mMusicEvents = new HashMap<String, MusicEvent>();
		
		loadDailyTransactions(args[0]);
		displaySubscribers();
		displayVenues();
		displayEvents();
		displayTransactions();
		displayTransactionsBeforeDate("06012018");
		
	}
	
	private static ArrayList<String> readInput(String fileName)
	{
		ArrayList<String> input = new ArrayList<String>();

        try 
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while((line = bufferedReader.readLine()) != null) 
            {
                input.add(line);
            }   

            bufferedReader.close();   
            
        }
        catch(FileNotFoundException ex) 
        {
            sop("Unable to open file '" + fileName + "'");
            System.exit(1);
        } 
        catch (IOException e) 
        {
			e.printStackTrace();
			System.exit(1);
		}
        
        return input;
	}
	
	private static void loadDailyTransactions(String fileName)
	{
		mDailyLog = readInput(fileName);
		int ii = 0;
		while(ii < mDailyLog.size())
		{
			String line = mDailyLog.get(ii++);
			if(line.equals("S")) // Subscribe
			{
				String name = mDailyLog.get(ii++);
				String birthDate = mDailyLog.get(ii++);
				
				if(mSubscribers.containsKey(name))
				{
					sop(name + " is already a registered Subscriber");
					continue;
				}
				else
				{
					Subscriber p = new Subscriber(name, birthDate);
					mSubscribers.put(name, p);
				}
			}
			else if(line.equals("V")) // Venue
			{
				String name = mDailyLog.get(ii++);
				int capacity = Integer.parseInt(mDailyLog.get(ii++));
				
				if(mVenues.containsKey(name))
				{
					sop(name + " is already a registered Venue");
					continue;
				}
				else
				{
					Venue v = new Venue(name, capacity);
					mVenues.put(name, v);
				}
			}
			else if(line.equals("MU") || line.equals("SP"))  // New Event
			{
				String band = "", teamOne = "", teamTwo = "";
				
				String eventName = mDailyLog.get(ii++);
				String venueName = mDailyLog.get(ii++);
				String date = mDailyLog.get(ii++);
				double ticketPrice = Double.parseDouble(mDailyLog.get(ii++));
				if(line.equals("MU"))
				{
					band = mDailyLog.get(ii++);
				}
				else
				{
					teamOne = mDailyLog.get(ii++);
					teamTwo = mDailyLog.get(ii++);
				}	
				
				if(!mVenues.containsKey(venueName))
				{
					sop(venueName + " is not a registered Venue");
					continue;
				}
				
				Venue vObj = mVenues.get(venueName);
				
				if(line.equals("SP"))
				{
					if(mSportingEvents.containsKey(eventName))
					{
						sop(eventName + " is already a registered Sporting Event");
					}
					else
					{
						SportingEvent s = new SportingEvent(eventName, vObj, date, ticketPrice, teamOne, teamTwo);
						mSportingEvents.put(eventName, s);
					}
				}
				else
				{
					if(mMusicEvents.containsKey(eventName))
					{
						sop(eventName + " is already is a registered Music Event");
					}
					else
					{
						MusicEvent m = new MusicEvent(eventName, vObj, date, ticketPrice, band);
						mMusicEvents.put(eventName, m);
					}
				}
			}
			else if(line.equals("PM") || line.equals("PS")) // Ticket Purchase
			{
				String eventName = mDailyLog.get(ii++);
				String subscriber = mDailyLog.get(ii++);
				String purchaseDate = mDailyLog.get(ii++);
				String purchaseType = mDailyLog.get(ii++);
				
				Subscriber s = mSubscribers.get(subscriber);
				if(s == null)
				{
					sop( subscriber + " is not a registered Subscriber");
					continue;
				}
				
				Event e = null;
				if(line.equals("PS"))
				{
					e = mSportingEvents.get(eventName);
					if(e == null)
					{
						sop(eventName + " is not a registered Sporting event");
						continue;
					}
				}
				else
				{
					e = mMusicEvents.get(eventName);
					if(e == null)
					{
						sop(eventName + " is not a registered Music event");
						continue;
					}	
				}
						
				TicketPurchase tp = null;
				if(purchaseType.equals("CREDIT"))
				{
					tp = new CreditTicketPurchase(subscriber, e, purchaseDate);
				}
				else
				{
					tp = new CashTicketPurchase(subscriber, e, purchaseDate);
				}
					
				e.addTicketPurchase(tp);
				s.addTicketPurchase(tp);
			}
			else
			{
				sop("Bad input file");
				System.exit(1);
			}
		}
	}
	
	private static void sop(String s)
	{
		System.out.println(s);
	}
	
	private static void displaySubscribers()
	{
		ArrayList<String> names = new ArrayList<String>();
		
		Iterator<String> it = mSubscribers.keySet().iterator();
		while(it.hasNext())
		{
			names.add(it.next());
		}
		
		sop("\n********** Sorted Subscribers **********");
		Collections.sort(names);
		for(String name : names)
		{
			sop("" + mSubscribers.get(name));
		}
	}
	
	private static void displayVenues()
	{
		ArrayList<Venue> venues = new ArrayList<Venue>();
		
		Iterator<Venue> it = mVenues.values().iterator();
		while(it.hasNext())
		{
			venues.add(it.next());
		}
		
		sop("\n********** Sorted Venues (Sorts by decreasing capacity) **********");
		Collections.sort(venues);
		for(Venue venue : venues)
		{
			sop("" + venue);
		}
	}
	
	private static void displayEvents()
	{
		ArrayList<Event> events = new ArrayList<Event>();
		
		Iterator<SportingEvent> it = mSportingEvents.values().iterator();
		while(it.hasNext())
		{
			events.add(it.next());
		}
		
		Iterator<MusicEvent> it1 = mMusicEvents.values().iterator();
		while(it1.hasNext())
		{
			events.add(it1.next());
		}
		
		Collections.sort(events);
		
		sop("\n********** Sorted Events **********");
		sop("\nSporting is less than Music.\nSporting order by team one.\nMusic order by band.\n");
		for(Event e : events)
		{
			sop("" + e);
		}
	}
	
	public static void displayTransactions()
	{
		displayTransactionsBeforeDate("00");
	}
	
	public static void displayTransactionsBeforeDate(String date)
	{	
		String heading;
		if(date.equals("00")) 
		{
			date = "12019999";
			heading = " (ALL)";
		}
		else
		{
			heading = " Before: " + DateUtil.getFormattedDate(DateUtil.convertStringDatetoCalendarDate(date));
		}
		
		sop("\nSporting Event Ticket Purchases" + heading);
		ArrayList<Event> events = new ArrayList<Event>();
	
		Iterator<SportingEvent> it = mSportingEvents.values().iterator();
		while(it.hasNext())
		{
			events.add(it.next());
		}
		displayTransactionsBeforeDate(events, date);
		
		events.clear();
		sop("\nMusic Event Ticket Purchases" + heading);
		Iterator<MusicEvent> it1 = mMusicEvents.values().iterator();
		while(it1.hasNext())
		{
			events.add(it1.next());
		}
		displayTransactionsBeforeDate(events, date);
	}
	
	public static void displayTransactionsBeforeDate(ArrayList<Event> events, String beforeDate)
	{
		for(Event e : events)
		{
			ArrayList<TicketPurchase> transactions = e.getTicketPurchases(beforeDate);
			sop("Event: " + e);
			int n = 0;
			for(TicketPurchase t : transactions)
			{
				sop("   " + t.toString());
				n++;
			}
			
			sop("Total sales at price: " + e.getTicketPrice() + " is "  + (n * e.getTicketPrice()));
		}
	}

	private static List<String> mDailyLog;
	private static Map<String, Subscriber> mSubscribers;
	private static Map<String, SportingEvent> mSportingEvents;
	private static Map<String, MusicEvent> mMusicEvents;
	private static Map<String, Venue> mVenues;
	
}
