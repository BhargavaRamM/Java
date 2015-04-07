import java.util.*;
import java.lang.*;

public class test{
    public static void main(String args[]){
        Date[] k = new Date[3];        
        k[0] = new Date(1,3,2004);
        k[1] = new LongDate("January",3,2008);
        k[2] = new Date(1,4,2009);
        for(int i=0;i<k.length;i++){
                System.out.println(k[i].getDate());
        }
    }
}

class LongDate extends Date{
    private int day;
	private int month;
	private int year;
	private String monthName;
	
	public LongDate(String monthName,int x, int y) {
          
				super(0,x,y);
                int m=0;
                switch(monthName){
                case "January":
                        m=1;
                        break;
                case "February":
                        m=2;
                        break;
                case "March":
                        m=3;
                        break;
                case "April":
                        m=4;
                        break;
                        
                case "May":
                        m=5;
                        break;
                case "June":
                        m=6;
                        break;
                        
                case "July":
                        m=7;
                        break;
                        
                case "August":
                        m=8;
                        break;
                case "September":
                        m=9;
                        break;
                case "October":
                        m=10;
                        break;
                case "November":
                        m=11;
                        break;
                case "December":
                        m=12;
                        break;
                }
                
                
                
                month=m;
                this.monthName=monthName;
                this.day=x;
                this.year=y;
                
        }
        
		public void setDate(String monthName,int x, int y){
                this.monthName=monthName;
                this.day=x;
                this.year=y;
        }
        
		public String getDate(){
                return monthName+" "+day+","+year;
                
        }
        public String getShortDate(){
        super.setDate(month,day,year);
        return super.getDate();                        
    }
}



 


