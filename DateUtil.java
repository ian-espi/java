//Assignment #3
//Brittney Witts. 016927077
//Ian Espinosa. 014252899
import java.util.Calendar;

public class DateUtil {
	
	
	public static Date convertStringDatetoCalendarDate(String date)
	{

		int day = getDay(date);
		int month = getMonth(date);
		int year = getYear(date);
		
		
		Date cDate = new Date(year,month,day);
		
		
		return cDate;
	}
	
	private static int getDay(String date)
	{
		return getPart(date, 2, 4);
	}
	
	private static int getMonth(String date)
	{
		return getPart(date, 0, 2);
	}
	
	private static int getYear(String date)
	{
		return getPart(date, 4, 8);
	}
	
	private static int getPart(String date, int from, int to)
	{
		System.out.println(date);
		return Integer.parseInt(date.substring(from, to));
		
	}

	@SuppressWarnings("deprecation")
	public static String getFormattedDate(Date date) {
		
		
		return date.toString();
	}
	
}

