import java.util.*;
import java.io.*;
public class PartTimeEmployee extends Employee implements Serializable {
	private double hourlyRate;
	public PartTimeEmployee(String fName,String lName,Address ad,Date dob,String empn,Date doe,double hourlyRate) {
		super(fName,lName,ad,dob,empn,doe);
		this.hourlyRate = hourlyRate;
	}
	private void writeObject(ObjectOutputStream out) throws IOException,ClassNotFoundException {
		out.writeDouble(hourlyRate);
	}
	private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException {
		this.hourlyRate = in.readDouble();
	}
	public String toString() {
		return String.format(super.toString()+"\n"+"Hourly Rate: "+hourlyRate);
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public double getHourlyRate() {
		return hourlyRate;
	}
}