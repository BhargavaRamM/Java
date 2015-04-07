import java.util.*;
import java.lang.*;
class CatchExceptions6 {
	public static void main(String[] args) {
		System.out.println();
		try{
			divide(10,0);
		}
		catch(DivideByZeroException e) {
			try {
				System.out.println("Cannot be divided by zero.. enter another number:");
				int n = Input.getInt("Cannot be divided by zero.. enter another number:");
				divide(10,n); 
				
			}
			catch(DivideByZeroException x){
				int k = 0;
				try {
					do {
						k = Input.getInt("Wrong Number entered.. enter again:");
						//divide(10 ,k);
					} while(k == 0);
					if(k != 0) {
						divide(10,k);
					}
				}
				catch(DivideByZeroException z) {
					System.out.println("Cannot be divided by zero.. enter another number:");
				}
				
			}
		}
	}	
		public static double divide(int x,int y) throws DivideByZeroException  {
			double result = 0.00;
			try{
				result = x/y;
				System.out.println("Dividig: "+result);
			}
			catch (ArithmeticException e) {
				throw new DivideByZeroException(y);
			}
			return result;
		}
	
}
class DivideByZeroException extends Exception {
	private int denom;
	public DivideByZeroException() {
		
	}
	public DivideByZeroException(String s) {
		super(s);
	}
	public DivideByZeroException(int d) {
		super("Division by zero");
		denom = d;
	}
	public int getDenominator() {
		return denom;
	}
}