import java.util.*;
import java.lang.*;
import java.io.*;
public class ContactsInfo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter File Name: ");
		String file = scan.nextLine();
		boolean condition = true;
		
		while(condition) {
			TreeMap<String,Contact> contacts = new TreeMap<String,Contact>();
			contacts = readContacts(file);
			System.out.println("Menu:\n a.Add a contact from the List"+"\n"+"b.Delete a contact from the List"+"\n"+"c.Display entire contact List"+"\n"+"d.Exit");
			String choice = scan.nextLine();
			switch(choice) {
				case "a": 
					addContacts(file,contacts);
					break;
				case "b":
					deleteContacts(file,contacts);
					break;
				case "c":
					for(Map.Entry con : contacts.entrySet()) {
						System.out.println("\n"+con.getKey()+" \n"+con.getValue()+"\n");
					}
					break;
				case "d":
					condition = false;
					break;
				default :
					System.out.println("Wrong choice...Enter Correctly...");
					break;
			}
		}
	}
	private static void addContacts(String fileName, TreeMap<String,Contact> contacts){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Adding Contact:\n");
		System.out.println("Enter First Name: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter Last Name: ");
		String lastName = scanner.nextLine();
		System.out.println("Enter phone number: ");
		String mobileNumber = scanner.nextLine();
		System.out.println("Enter Email Id: ");
		String email = scanner.nextLine();
		
		contacts.put(lastName+":"+firstName,new Contact(firstName,lastName,mobileNumber,email));
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
			out.writeObject(contacts);
			out.flush();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteContacts(String fileName,TreeMap<String,Contact> contacts) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the contact to be deleted: ");
		String key = scanner.nextLine();
		contacts.remove(key);
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
			out.writeObject(contacts);
			out.flush();
			out.close();
		}
		catch(Exception z) {
			z.printStackTrace();
		}
	}
	
	private static TreeMap<String,Contact> readContacts(String fileName) {
		TreeMap<String,Contact> readAllContacts = new TreeMap<String,Contact>();
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			readAllContacts = (TreeMap<String,Contact>) in.readObject();
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return readAllContacts;
	}
	
}