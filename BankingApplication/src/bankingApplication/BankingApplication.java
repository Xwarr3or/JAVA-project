package bankingApplication;

import java.util.Scanner;

public class BankingApplication {
	public static void main(String[] args) {
		BankAccount obj1 = new BankAccount("SBI001", "Vivekananda");
		obj1.showMenu();
	}
}


class BankAccount{
	String customerName;
	String customerId;
	int balance;
	int previousTransaction;
	
	//Constructor
	BankAccount(String cid, String cname){
		customerId = cid;
		customerName = cname;
	}
	
	void deposit(int amount) {
		if(amount != 0) {
			balance += amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount) {
		if(amount != 0) {
			balance -= amount;
			previousTransaction = -amount;
		}
	}
	
	void getPreviousTransaction() {
		if(previousTransaction > 0)
			System.out.println("Deposit: "+previousTransaction);
		else if(previousTransaction < 0)
			System.out.println("Withdrawn: "+Math.abs(previousTransaction));
		else
			System.out.println("No Transaction Occured");
	}
	
	void showMenu() {
		char option = '\0'; //initialize the char with '\0' value here
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome Sir, Good to have you back");
		System.out.println("Hello ! "+customerName);
		System.out.println("Your ID is: "+customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
		
		do {
			System.out.println("***** Enter an Option *****");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch(option) {
			
			case 'A':
				System.out.println("** ** ** ** ** ** ** ** ** **");
				System.out.println("Balance: "+balance);
				System.out.println("** ** ** ** ** ** ** ** ** **");
				System.out.println("\n");
				break;
				
			case 'B':
				System.out.println("** ** ** ** ** ** ** ** ** **");
				System.out.println("Enter an amount to deposit: ");
				System.out.println("** ** ** ** ** ** ** ** ** **");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
				
			case 'C':
				System.out.println("** ** ** ** ** ** ** ** ** **");
				System.out.println("Enter an amount to withdraw: ");
				System.out.println("** ** ** ** ** ** ** ** ** **");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 'D':
				getPreviousTransaction();
				System.out.println("\n");
				break;
				
			case 'E':
				System.out.println("----------------------------------");
				break;
				
				default:
					System.out.println("Sorry...invalid option !Please enter again...");
					break;
			}
		}while(option != 'E');
		
		System.out.println("Thank you for using our services");
	}
}