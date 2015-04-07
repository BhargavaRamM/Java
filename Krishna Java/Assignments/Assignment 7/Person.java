import java.util.*;
import java.io.*;
public class Person implements Serializable {
	private String firstName;
	private String lastName;
	private Address address;
	private Date birthDate;
	
	public Person(String fName,String lName,Address ad,Date dob) {
		firstName = fName;
		lastName = lName;
		address = ad;
		birthDate = dob;
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
	public void setAddress(Address ad) {
		address = ad;
	}
	public Address getAddress() {
		return address;
	}
	public void setBirthDate(Date dob) {
		birthDate = dob;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	private void writeObject(ObjectOutputStream out) throws IOException,ClassNotFoundException {
		out.writeUTF(firstName);
		out.writeUTF(lastName);
		out.writeObject(address);
		out.writeObject(birthDate);
	}
	private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException {
		firstName = in.readUTF();
		lastName = in.readUTF();
		address = (Address) in.readObject();
		birthDate = (Date) in.readObject();
	}
}