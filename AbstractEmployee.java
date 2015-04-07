import java.util.*;
import java.lang.*;



abstract class  Employee extends Date {
	String employeeNumber;
	Date dateofBirth;
	Date dateofEmployement;
	String fName;
	String lName;
	Address address;
	
	
	Employee(String empn,Date dob,Date doe,String fname,String lname,Address ad) {
		employeeNumber = empn;
		dateofBirth = dob;
		dateofEmployement = doe;
		fName = fname;
		lName = lname;
		address = ad;
	}
	public  abstract void benefits();
	//public abstract int workHours();
	
	public void setEmployeeNumber (String t) {
		employeeNumber = t;
	}
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	
	public void employeeNumberDetails() {
		System.out.println("Employee Number is: "+ employeeNumber);
	}
	public void setFirstName(String s) {
		fName = s;
	}
	public void setLastName (String l) {
		lName = l;
	}
	public  String getFirstName() {
		return fName;
	}
	public String getLastName() {
		return lName;
	}
	public void setDateofBirth(Date d) {
		dateofBirth = d;
	}
	public Date getDateofBirth(){
		return dateofBirth;
	}
	public void setDateofEmployement(Date date) {
		dateofEmployement = date;
	}
	public Date getDateofEmployement() {
		return dateofEmployement;
	}
	
	public void employeeNameDetails () {
		System.out.println("Employee name is: "+ fName+" "+lName);
	}
	public String toString() {
		return String.format("Employee Number is: "+getEmployeeNumber()+"\n "+"and Name: "+getFirstName()+" "+getLastName()+"\n Date of Birth"+getDateofBirth()+"\n Date of Employment"+getDateofEmployement()+"\n "+address.toString());
	}
	public abstract double earnings();
}

class SalariedEmp extends Employee {
	private double salary;
	public SalariedEmp(String empn, Date dob,Date doe,String fname,String lname,Address ad, double sal) {
		super(empn,dob,doe,fname,lname,ad);
		this.salary = sal;
	}
	public void setMonthSalary(double sal) {
		salary = sal;
	}
	public double getMonthSalary() {
		return salary;
	}
	public double earnings() {
		return getMonthSalary();
	}
	public String toString() {
		return String.format("Fixed salary employee : "+super.toString()+" Earnings: "+getMonthSalary());
	}
	public void benefits() {
		System.out.println("A full time salaried employee has benefits");
	}
}

class HourlySalariedEmp extends Employee {
	private double payment;
	private double hours;
	public HourlySalariedEmp(String empn,Date dob,Date doe,String fname,String lname,Address ad,double pay,double hoursWorked) {
		super(empn,dob,doe,fname,lname,ad);
		payment = pay;
		hours = hoursWorked;
		//setHourlyPay(double pay);
		//setHoursWorked(double hoursWorked);
	}
	public void setHourlyPay(double pay) {
		this.payment = pay;
	}
	public void setHoursWorked(double hoursWorked) {
		this.hours = hoursWorked;
	}
	public double getHourlyPay() {
		return payment;
	}
	public double getHoursWorked() {
		return hours;
	}
	public double earnings() {
		return getHoursWorked()*getHourlyPay();
	}
	public void benefits() {
		System.out.println("HourlyPaid Employees do not have any Benefits");
	}
}

class FullTimeHourlyEmp extends HourlySalariedEmp {
	private double payment;
	private double hours;
	private double threashold;
	public FullTimeHourlyEmp(String empn,Date dob,Date doe,String fname,String lname,Address ad, double pay, double hoursWorked,double threasholdHours,double overtimePay,double ovettimeHoursWorked) {
		super(empn,dob,doe,fname,lname,ad,pay,hoursWorked);
		this.payment = overtimePay;
		this.hours = ovettimeHoursWorked;
		this.threashold = threasholdHours;
	}
	public void setThreasholdHours(double threasholdhours) {
		threashold = threasholdhours;
	}
	public double getThreasholdHours() {
		return threashold;
	}
	public void setOvertimeHourlyRate(double overtimePay) {
		payment = overtimePay;
	}
	public double getOvertimeHourlyRate() {
		return payment;
	}
	public void setOvertimeHoursWorked(double ovettimeHoursWorked) {
		hours = ovettimeHoursWorked;
	}
	public double getOvertimeHoursWorked() {
		return hours;
	}
	public double earnings() {
		if(getThreasholdHours() < super.getHoursWorked()+getOvertimeHoursWorked()) {
			return super.earnings()+getOvertimeHourlyRate()*getOvertimeHoursWorked();
		} else return super.earnings();
	}
	public String toString() {
		return String.format("FullTimeHourly Paid Employee: "+super.toString()+"Earnings is : "+super.earnings()+getOvertimeHourlyRate()*getOvertimeHoursWorked());
	}
}

class PartTimeSalariedEmp extends SalariedEmp {
	private double maxHours;
	public PartTimeSalariedEmp(String empn, Date dob,Date doe, String fname,String lname,Address ad, double salary,double maximumHours) {
		super(empn,dob,doe,fname,lname,ad,salary);
		maxHours = maximumHours;
	} 
	public void setMaxHours(double maxiHours) {
		maxHours = maxiHours;
	}
	public double getMaxHours() {
		return maxHours;
	}
	public double earnings() {
		return super.earnings();
	}
	public String toString() {
		return String.format("PartTimeSalariedEmployee: "+ super.toString()+"Working Maximum Hours: "+getMaxHours());
	}
}		
	
public class AbstractEmployee {
	public static void main(String[] args) {
		SalariedEmp employee1 = new SalariedEmp("702262799",new Date(01,01,1990),new Date(01,01,2015),"Chandler","Bing",new Address("abc","k","newark","DE",19711),20000.00);
		HourlySalariedEmp employee2 = new HourlySalariedEmp("702262800",new Date(01,01,1991),new Date(01,01,2015),"Joseph","Tribbiani",new Address("abc","k","newark","DE",19711),100.00,150.00);
		FullTimeHourlyEmp employee3 = new FullTimeHourlyEmp("702262798",new Date(01,01,1992),new Date(01,01,2015),"Ross","Geller",new Address("abc","k","newark","DE",19711),100.00,150.00,168.00,120.00,20.00);
		PartTimeSalariedEmp employee4 = new PartTimeSalariedEmp("702262797",new Date(01,01,1993),new Date(01,01,2015),"Monica","Geller",new Address("abc","k","newark","DE",19711),15000.00,168.00);
		
		System.out.println("Salaried Employee Earnings:"+employee1.earnings());
		System.out.println("Hourly Salaried Employee Earnings:"+employee2.earnings());
		System.out.println("Full Time Hourly Employee Earnings:"+employee3.earnings());
		System.out.println("Part Time Salaried Employee Earnings:"+employee4.earnings());
		
		Employee employees[] = new Employee[4];
		employees[0] = employee1;
		employees[1] = employee2;
		employees[2] = employee3;
		employees[3] = employee4;
		
		for(Employee currentEmps : employees) {
			System.out.println(currentEmps);
			System.out.println("Earned: "+currentEmps.earnings());
			//System.out.println("Address of employee is :"+currentEmps.toString());
		}
	}
}
	
class Address  {
	String StreetName;
	String Apartment;
	String City;
	String State;
	int zip;
	public Address(String sname,String a,String c, String s,int zp){
		this.StreetName = sname;
		this.Apartment = a;
		this.City = c;
		this.State = s;
		this.zip = zp;
	}
	public void setStreetName(String sname) {
		StreetName = sname;
	}
	public String getStreetName(){
		return StreetName;
	}
	public void setApartment(String a) {
		Apartment = a;
	}
	public String getApartment() {
		return Apartment;
	}
	public void setCity(String c) {
		City = c;
	}
	public String getCity() {
		return City;
	}

	public void setState(String ad) {
		State = ad;
	}
	public String getState() {
		return State;
	}
	public void setZip (int zp) {
		zip = zp;
	}
	public int getZip() {
		return zip;
	}
	public String toString() {
		return String.format("Address of Employee is :"+getStreetName()+"\n"+getApartment()+"\n"+getCity()+"\n"+getState()+" "+getZip());
	}
	
	
	public void employeeAddressDetails() {
		System.out.println ("employee address is :"+getStreetName()+"\n"+getApartment()+"\n"+getCity()+"\n"+getState()+" "+getZip());
		//System.out.println ("employee zip is :"+ zip);
	}
	
}