/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.cp.address;
import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		System.out.println("Welcome to address book ---");

		Scanner in = new Scanner(System.in);
		AddressBookList addressbooklist = new AddressBookList();
		
		System.out.println("Enter 1 to open addressbook");
		System.out.println("Enter 2 to create new addressbook");
		System.out.println("Enter 3 to exit");
		int option = in.nextInt();
		while(option != 3) {
			if(option == 1)
				addressbooklist.openAddressBook();
			else if(option == 2)
				addressbooklist.newAddressBook();
			else if(option == 3)
				break;
			else
				System.out.println("Enter Correct option");
			
			
			System.out.println("Enter Choice");
			option = in.nextInt();
		}
		
	}
}
