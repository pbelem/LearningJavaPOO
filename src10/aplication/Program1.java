package aplication;

import java.util.Locale;
import java.util.Scanner;

import entities.Accounts;
import util.Operation;

public class Program1 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Double currentAccountValue = 0.0;
		int accountNum;
		String accountHolder;
		char verific;

		System.out.println("Enter account number: ");
		accountNum = sc.nextInt();
		System.out.println("Enter the account holder: ");
		sc.nextLine();
		accountHolder = sc.nextLine();
		System.out.println("Is there an initial deposit?\ntype yes or not");
		verific = sc.next().charAt(0);
		if (verific == 'y' || verific == 'Y') {
			System.out.println("Enter the inital deposit value: ");
			currentAccountValue = sc.nextDouble();
		}

		Accounts acc = new Accounts(accountNum, accountHolder, currentAccountValue);

		for (boolean y = true; y;) {

			for (boolean x = true; x;) {
				Double newValue;
				String newName;
				System.out.println(
						"Which operation do you need?\n(1)Current Balance\n(2)Deposit value\n(3)Withdraw value\n(4)Change account holder name\n(5)Exit");
				int ope = sc.nextInt();
				switch (ope) {
				case 1:
					System.out.print(acc);
					x = false;
					break;
				case 2:
					System.out.println("Amount to deposit into the account");
					newValue = sc.nextDouble();
					currentAccountValue = Operation.depositAccount(currentAccountValue, newValue);
					acc.setCurrentValue(currentAccountValue);
					System.out.print("Updated " + acc);
					x = false;
					break;
				case 3:
					System.out.println("Ammount to withdraw from the account: ");
					newValue = sc.nextDouble();
					if (currentAccountValue - newValue >= 0) {
						currentAccountValue = Operation.withDrawAccount(currentAccountValue, newValue);
						acc.setCurrentValue(currentAccountValue);
						System.out.print("Updated " + acc);
						x = false;
					} else if (currentAccountValue - newValue < 0) {
						System.out.print("Insufficient balance, canceling operation\n" + acc);
					}
					break;
				case 4:
					System.out.println("What the new name?");
					sc.nextLine();
					newName = sc.nextLine();
					acc.setNameAccount(newName);
					System.out.print("Updated " + acc);
					x = false;
					break;
				case 5:
					x = false;
					y = false;
					break;
				default:
					System.out.print("Invalid operation, try again\n");
				}
			}
			if (y == true) {
				System.out.println("\nDid you need one more operation?\ntype yes or not");
				verific = sc.next().charAt(0);
				if (verific == 'n' || verific == 'Y') {
					y = false;
				}
			}
		}

		System.out.print("Thank you for your preference");
		sc.close();
	}

}