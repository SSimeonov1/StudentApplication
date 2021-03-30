package studentApplication;

import java.util.Scanner;

public class Account {
	
	static Scanner scanInt = new Scanner(System.in);
	public static int balance;
	public static int previousTransaction;
	
	
	public static void deposit(int amount) {
		if(amount != 0) {
			balance += amount;
			previousTransaction = amount;
		}
	}
	
	
	public static void withdraw(int amount) {
		if(amount != 0) {
			balance -= amount;
			previousTransaction = -amount;
		}
	}
	
	
	public static void getPreviousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("You deposited: $ " + previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("You withdrawned: $ " + Math.abs(previousTransaction));
		}
		else {
			System.out.println("No transaction occured");
		}
	}
	
	
	public static void showMenu() {
		int option;
		
		System.out.println();
		System.out.println("What would you like to do?");
		
		do {
			System.out.println("Enter an option: ");
			System.out.println();
			System.out.println(1 + " - Check your balance.");
			System.out.println(2 + " - Make a deposit.");
			System.out.println(3 + " - Make a withdrawal");
			System.out.println(4 + " - View previous transaction");
			System.out.println(0 + " - Exit");
			
		    option = scanInt.nextInt();
		    	
			switch(option) {
			case 1: 
				System.out.println("=========================");
				System.out.println("Balance = $ " + balance);
				System.out.println("=========================");
				System.out.println();
				break;
			case 2: 
				System.out.println("Enter the amount you want to deposit");
				int amount = scanInt.nextInt();
				deposit(amount);
				System.out.println();
				break;
			case 3: 
				System.out.println("Enter the amount you want to withdraw");
				int withdrawAmount = scanInt.nextInt();
				withdraw(withdrawAmount);
				System.out.println();
				break;
			case 4:
				System.out.println("=========================");
				getPreviousTransaction();
				System.out.println("=========================");
				System.out.println();
				break;
			case 0:
				System.out.println("=========================");
				break;
				default: System.out.println("An Error happened, you must pick 1, 2 ,3 or 4");
				break;
			}
		} while(option != 0);
		System.out.println("Thank you for using our services");
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
}
