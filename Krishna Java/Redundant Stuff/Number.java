import java.util.*;
import java.lang.*;

public class Number {
	public static void main(String[] args) {
		int n;
		Random r = new Random();
		n = r.nextInt(1001);
		Thread range1 = new FindIt(0,349,n);
		Thread range2 = new FindIt(350,699,n);
		Thread range3 = new FindIt(700,1000,n);
		range1.start();
		range2.start();
		range3.start();
	}
}