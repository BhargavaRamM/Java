import java.util.*;
import java.io.*;
public class Employee extends Person implements Serializable {
	private String employeeNum;
	private Date hireDate;
	public Employee(String fName,String lName,Address ad, Date dob,String employeeNumber,Date doe) {
		super(fName,lName,ad,dob);
		employeeNum = employeeNumber;
		hireDate = doe;
	}
	public void setEmployeeNum(String empn) {
		employeeNum = empn;
	}
	public String getEmployeeNum() {
		return employeeNum;
	}
	public void setHireDate(Date doe) {
		hireDate = doe;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public String toString() {
		return String.format("First Name: "+getFirstName()+"\n"+"Last Name: "+getLastName()+"\n"+"Address: "+getAddress().getAddress()+"\n"+"Birth Date: "+getBirthDate().getDate()+"\n"+"Employee Number: "+employeeNum+"\n"+"Hire Date: "+hireDate.getDate());
	}
	private void writeObject(ObjectOutputStream out) throws IOException,ClassNotFoundException {
		out.writeUTF(employeeNum);
		out.writeObject(hireDate);
	}
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		employeeNum = in.readUTF();
		hireDate = (Date) in.readObject();
	}
}