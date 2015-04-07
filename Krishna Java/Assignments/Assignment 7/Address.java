import java.util.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Address implements Serializable {
	String StreetName;
	String Apartment;
	String City;
	String State;
	String zip;
	public Address(String sname,String a,String c, String s,String zp){
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
	public void setZip (String zp) {
		zip = zp;
	}
	public String getZip() {
		return zip;
	}
	public String getAddress(){
		return "Address of Employee is :"+getStreetName()+"\n"+getApartment()+"\n"+getCity()+"\n"+getState()+" "+getZip();
	}
	/*
	public String toString() {
		return String.format("Address of Employee is :"+getStreetName()+"\n"+getApartment()+"\n"+getCity()+"\n"+getState()+" "+getZip());
	}
	public void employeeAddressDetails() {
		System.out.println ("employee address is :"+getStreetName()+"\n"+getApartment()+"\n"+getCity()+"\n"+getState()+" "+getZip());
	}*/
	private void writeObject(ObjectOutputStream out) throws IOException,ClassNotFoundException {
		out.writeUTF(getStreetName());
		out.writeUTF(getApartment());
		out.writeUTF(getCity());
		out.writeUTF(getState());
		out.writeUTF(getZip());
	}
	private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException {
		StreetName = in.readUTF();
		Apartment = in.readUTF();
		City = in.readUTF();
		State = in.readUTF();
		zip = in.readUTF();
	}
	
}