package studentApplication;

import java.util.ArrayList;

//import studentApplication.Account;

import java.util.Scanner;

public class StudentApp {
	
	static Scanner scanInt = new Scanner(System.in);
	static Scanner scanString = new Scanner(System.in);
	
	public  String firstName;
	public  String lastName;
	public int classYear;
	public  String studentID;
	public static ArrayList<String> courses = new ArrayList<>();
	public static ArrayList<String> chosenCourses = new ArrayList<>();
	public static int tuitionTax;
	public static int balance = Account.balance;
	public int id = 1000;
	
	public StudentApp() {
		
		System.out.println("Enter your first name: ");
		this.firstName = scanString.nextLine();
		
		System.out.println("Enter your last name: ");
		this.lastName = scanString.nextLine();
		
		System.out.println("Enter your class year: \n1 - Freshmen \n2 - Sophmore \n3 - Junior \n4 - Senior");
		this.classYear = scanInt.nextInt();
		
		studentID();
		
		System.out.println(firstName + " " + lastName + " " + classYear + " " + studentID);
		
		Account.showMenu();
		
		chosenCourses();
		
		payCourses();
		
		showInfo();
	}
	

	public void studentID() {
		id++;
		this.studentID = classYear + "" + id;
	}
	
	
	public static void chosenCourses() {
		System.out.println();
		System.out.println("Here are the courses you can choose from.");
		System.out.println();

		courses.add("Chemistry");
		courses.add("Math");
		courses.add("Physics");
		courses.add("Biology");
		courses.add("Geography");
		courses.add("Spanish");
		courses.add("Italian");
		courses.add("Portuguese");
		System.out.println(courses);
		System.out.println();
		

	   boolean isRunning = true;
	   
	   while(isRunning) {
		   System.out.println("You must choose 4 out of 8 courses.");
		   while(chosenCourses.size() <= 3) {
				chosenCourses.add(scanString.nextLine());
			}
		  boolean answer =  chosenCourses.retainAll(courses);
		   if(answer == false) {
			   System.out.println("You picked " + chosenCourses);
			   isRunning = false;
		   }
		   else {
			   System.out.println("Error - You mismatched a letter or typed something else.");
		   }
	   }
	}
	
	
	public void payCourses() {
		tuitionTax = 2400;
	    balance = Account.balance;
		
		System.out.println("Your tuition tax is $ " + tuitionTax + " , to continue, you have to pay, do you confirm? "
				+ "\n" + "y" + " - yes");

		String answer = scanString.next();
		if(answer.equals("y")) {
			if(balance >= tuitionTax) {
				balance = balance - tuitionTax;
				System.out.println("You paid your tuition and your balance is: $ " + balance);
			}
			else if(balance < tuitionTax) {
				while(balance < tuitionTax) {
				System.out.println("You must deposit more money into your account to pay your tuition!");
				Account.showMenu();
				balance = balance + Account.previousTransaction;
				balance = balance - tuitionTax;
				System.out.println();
				System.out.println("You paid your tuition and your balance is: $ " + balance);
				break;
			}
				} 
		} 
	}
	
	
	public  void showInfo() {
		System.out.println();
		System.out.println("Your account info: \nName: " + firstName + " " + lastName +
				"\nYour ID is: " + studentID + 
				"\nCourses enrolled: " + chosenCourses +  
				"\nBalance: $ " + balance); 
	}
}