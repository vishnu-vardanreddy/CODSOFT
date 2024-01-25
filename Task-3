package CodeSoftPrgs;

import java.util.Scanner;

class ATM {
    private AnotherBankAccount account;

    public ATM(AnotherBankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processTransaction() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double amount;

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: Rs. " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: Rs. ");
                    amount = scanner.nextDouble();
                    if (amount > 0) {
                        account.deposit(amount);
                        System.out.println("Deposit successful. New balance: Rs. " + account.getBalance());
                    } else {
                        System.out.println("Invalid deposit amount. Please enter a positive amount.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: Rs. ");
                    amount = scanner.nextDouble();
                    if (amount > 0 && amount <= account.getBalance()) {
                        account.withdraw(amount);
                        System.out.println("Withdrawal successful. New balance: Rs. " + account.getBalance());
                    } else if (amount <= 0) {
                        System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
                    } else {
                        System.out.println("Insufficient balance for withdrawal. Current balance: Rs. " + account.getBalance());
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}



public class Task_3 {
    public static void main(String[] args) {
        AnotherBankAccount userAccount = new AnotherBankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.processTransaction();
    }
}



//These is the second program to maintain the another account.
package CodeSoftPrgs;

public class AnotherBankAccount 
{
	
	    private double balance;

	    public AnotherBankAccount(double initialBalance) {
	        balance = initialBalance;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void deposit(double amount) {
	        balance += amount;
	    }

	    public boolean withdraw(double amount) {
	        if (amount <= balance) {
	            balance -= amount;
	            return true;
	        } else {
	            return false;
	        }
	    }
	

}
