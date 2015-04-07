/*
import java.util.*;
import java.lang.*;

class LongDateDemo {
	public static void main(String []args) {
		String[] monthArray = {"January", "February","March","April","May","June","July","August","September","October","November","December"};
		Date[] dateCollection = { new Date(07,26,1992),new Date(01,18,2015), new LongDate("January",20,2015)};
		String str = Input.getString("Please enter correct month name");
		for(int j = 0; j < monthArray.length;j++) {
			if(str.equals(monthArray[j])){
				
				for(int i = 0; i < dateCollection.length; i++) {
				dateCollection[i].setDate(str,20,2015);
				dateCollection[i].getDate();
				}	
			} 
		}
		
			
	}
}

class LongDate extends Date {
	String monthName;
	int day;
	int month;
	int year;
	
	public LongDate(String m, int d, int y) {
		super(0,d,y);
		monthName = m;
	}
	public void setDate(String m, int d, int y) {
		monthName = m;
		
	}
	public String getDate() {
		//super.getDate();
		return monthName+" "+day+","+year;		
	}
	public String getShortDate() {
		return monthName;
	}
}
*/