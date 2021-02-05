//Assignment #3
//Brittney Witts. 016927077
//Ian Espinosa. 014252899
public class Date {

	public int year, month, day;
	private String mnthIn;
	public Date(int year, int month, int day){
		this.year =year;
		this.month = month;
		this.day =day;
		toInitials();
	}
	
	private void toInitials(){
		switch(month){
			case 1:
				mnthIn = "Feb";
				break;
			case 2:
				mnthIn = "Mar";
				break;
			case 3:
				mnthIn = "Apr";
				break;
			case 4:
				mnthIn = "May";
				break;
			case 5:
				mnthIn = "Jun";
				break;
			case 6:
				mnthIn = "Jul";
				break;
			case 7:
				mnthIn = "Aug";
				break;
			case 8:
				mnthIn = "Sep";
				break;
			case 9:
				mnthIn = "Oct";
				break;
			case 10:
				mnthIn = "Nov";
				break;
			case 11:
				mnthIn = "Dec";
				break;
			case 12:
				mnthIn = "Jan";
				year++;

				break;
			default:
				mnthIn = "whoops";
				break;
			
		}
	}
	
	@Override
	public String toString(){
		return mnthIn + "-" + day + "-" + year;
	}
}
