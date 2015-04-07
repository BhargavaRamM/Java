import java.util.*;
import java.lang.*;
class FindIt extends Thread {
	private int startNumber;
	private int endNumber;
	private int number;
	private boolean runCondition = true;
	public FindIt(int start, int end, int n) {
		this.startNumber = start;
		this.endNumber = end;
		this.number = n;
	}
	public void setStart(int start) {
		startNumber = start;
	}
	public int getStart() {
		return startNumber;
	}
	public void setEnd(int end) {
		endNumber = end;
	}
	public int getEnd() {
		return endNumber;
	}
	public void setNumber(int n) {
		number = n;
	}
	public int getNumber() {
		return number;
	}
	public void setRunCondition(boolean condition) {
		runCondition = condition;
	}
	public boolean isRunCondition() {
		return runCondition;
	}
	
	public void search() {
		for(int i = startNumber; i <= endNumber; i++) {
			if(runCondition) {
				if(i == number) {
					System.out.println("Number found in the thread: "+this.getName()+"\n Number found out was: "+i);
					runCondition = false;
				}
				if(i%10 == 0) {
					Thread.yield();
				}
			} else {
				break;
			}
		}
	}
	public void run() {
		search();
	}
	
}