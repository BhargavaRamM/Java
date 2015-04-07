import java.util.*;
import java.lang.*;
import java.io.*;
public class Contact implements Serializable {
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String mailId;
	
	public Contact(String fName,String lName,String mNumber,String email) {
		firstName = fName;
		lastName = lName;
		mobileNumber = mNumber;
		mailId = email;
	}
	public void setFirstName(String fName) {
		firstName = fName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setLastName(String lName) {
		lastName = lName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setMobileNumber(String mNumber) {
		mobileNumber = mNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setEmailId(String email) {
		mailId = email;
	}
	public String getEmailId() {
		return mailId;
	}
	public void writeObject(ObjectOutputStream out) throws IOException {
		out.writeUTF(firstName);
		out.writeUTF(lastName);
		out.writeUTF(mobileNumber);
		out.writeUTF(mailId);
	}
	public void readObject(ObjectInputStream in) throws IOException {
		firstName = in.readUTF();
		lastName = in.readUTF();
		mobileNumber = in.readUTF();
		mailId = in.readUTF();
	}
	public String toString() {
		return String.format("First Name: "+firstName+"\n"+"Last Name: "+lastName+"\n"+"Phone Number: "+mobileNumber+"\n"+"E-Mail Id: "+mailId);
	}
}