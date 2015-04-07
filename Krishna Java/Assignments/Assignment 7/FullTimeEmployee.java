import java.util.*;
import java.io.*;
public class FullTimeEmployee extends Employee implements Serializable {
	private double salary;
	private int benefitPackage;
	public FullTimeEmployee(String fName,String lName,Address ad,Date dob,String empn,Date doe,double salary,int benPack) {
		super(fName,lName,ad,dob,empn,doe);
		this.salary = salary;
		benefitPackage = benPack;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getSalary() {
		return salary;
	}
	public void setBenefitPackage(int benPack){
		benefitPackage = benPack;
		while(true) {
			if(benefitPackage <= 0 || benefitPackage >5) {
				benefitPackage = Input.getInt("Enter Benefit Package again from 1-5");
				continue;
			}
			break;
		}
	}
	public int getBenefitPackage() {
		return benefitPackage;
	}
	private void writeObject(ObjectOutputStream out) throws IOException,ClassNotFoundException {
		out.writeDouble(salary);
		out.writeInt(benefitPackage);
	}
	private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException {
		salary = in.readDouble();
		benefitPackage = in.readInt();
	}
	public String toString() {
		return String.format(super.toString()+"\n"+"Salary: "+salary+"\n"+"Benefit Package: "+benefitPackage);
	}
}