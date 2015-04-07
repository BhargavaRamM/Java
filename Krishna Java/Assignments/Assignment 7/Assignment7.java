import java.util.*;
import java.io.*;
import java.lang.*;
public class Assignment7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter File Name: ");
		String file = scan.nextLine();
		boolean condition = true;
		while(condition) {
			System.out.println("Menu: "+"\n"+"a.Add an employee \tb.Display all employees \tc.exit");
			String choice = scan.nextLine();
			switch(choice) {
				case "a":
					System.out.println("Adding new employee: \n");
					System.out.println("Full Time or Part Time ?");
					addNewEmployee(scan.nextLine(),file);
					break;
				case "b":
					System.out.println("Displaying all employees: \n");
					ArrayList<Employee> employeeList = readEmployees(file);
					for(Employee employee : employeeList) {
						System.out.println(employee+"\n");
					}
					break;
				case "c":
					condition = false;
					break;
				default:
					System.out.println("Wrong choice... Enter correctly...");
			}
		}
	}
	private static void addNewEmployee(String type,String fileName) {
		Employee emp = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("Name\n");
		System.out.println("First Name: ");
		String firstName = scan.nextLine();
		
		System.out.println("Last Name: ");
		String lastName = scan.nextLine();
		
		System.out.println("Address of Employee: \n");
		
		System.out.println("Street Name: ");
		String street = scan.nextLine();
		System.out.println("Apartment: ");
		String apartment = scan.nextLine();;
		System.out.println("City: ");
		String city = scan.nextLine();
		System.out.println("State: ");
		String state = scan.nextLine();
		System.out.println("Zip: ");
		String zip = scan.nextLine();
		
		Address address = new Address(street,apartment,city,state,zip);
		
		System.out.println("Date of Birth: \n");
		System.out.println("Month: ");
		int month = Integer.parseInt(scan.nextLine());
		System.out.println("Day: ");	
		int day = Integer.parseInt(scan.nextLine());
		System.out.println("Year: ");
		int year = Integer.parseInt(scan.nextLine());
		
		Date birthDate = new Date(month, day, year);
		
		System.out.println("Employee Number: \n");
		String employeeNum = scan.nextLine();
		
		System.out.println("Date of Hire:\n");
		System.out.println("Month: ");
		month = scan.nextInt();
		System.out.println("Day: ");	
		day = scan.nextInt();
		System.out.println("Year: ");
		year = scan.nextInt();
		
		Date hireDate = new Date(month, day, year);
		
		//scan.nextLine();
		if(type.equals("full time")) {
			System.out.println("Full Time Employee: \n");
			System.out.println("Salary: ");
			double sal = scan.nextDouble();
			System.out.println("Employee Benefit Package: ");
			int benPack = scan.nextInt();
			emp = new FullTimeEmployee(firstName,lastName,address,birthDate,employeeNum,hireDate,sal,benPack);
		} else if(type.equals("part time")) {
			System.out.println("Part Time Employee: \n");
			System.out.println("Hourly Rate: ");
			double hourlyRate = scan.nextDouble();
			emp = new PartTimeEmployee(firstName,lastName,address,birthDate,employeeNum,hireDate,hourlyRate);
		} else {
			System.out.println("Enter type of employee correctly...");
		}
		try {
			ArrayList<Employee> employees = new ArrayList<Employee>();
			try {
				employees = readEmployees(fileName);
			} catch(Exception e) {
				//e.printStackTrace();
			}
			employees.add(emp);
			
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
			
			for(Employee e : employees) {
				out.writeObject(e);
			}
			
			out.flush();
			out.close();
		} catch(Exception z) {
			//z.printStackTrace();
		} 
	}
	private static ArrayList<Employee> readEmployees(String fileName) {
		ArrayList<Employee> emps = new ArrayList<Employee>();
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			while(true) {
				Employee employee = (Employee) in.readObject();
				emps.add(employee);
			}
		} catch(IOException | ClassNotFoundException i) {
			//i.printStackTrace();
		}
		finally {
			 try {
			 in.close();
			 } catch (Exception e) {
				// e.printStackTrace();
			 }
		}
		return emps;
	}
}