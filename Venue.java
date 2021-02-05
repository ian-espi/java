//Assignment #3
//Brittney Witts. 016927077
//Ian Espinosa. 014252899
public class Venue implements Comparable<Venue> {

	public Venue(String name, int capacity) {
		mName = name;
		mCapacity = capacity;
	}
	
	public String getName() {
		return mName;
	}
	
	public int getCapacity() {
		return mCapacity;
	}

	@Override
	public String toString() {
		return mName + ", Capacity: " + mCapacity;
	}
	
	@Override
	public int compareTo(Venue v) {
		if(this.mCapacity < v.getCapacity()) {
			return 1;
		}
		else if(this.mCapacity > v.getCapacity()) {
			return -1;
		}
		else return 0;
	}
	
	private String mName;
	private int mCapacity;

}
