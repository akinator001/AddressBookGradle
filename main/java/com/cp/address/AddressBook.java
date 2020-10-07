package com.cp.address;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class AddressBook {
	Scanner in = new Scanner(System.in);
	
	Map<String, Contacts> contactMap = new HashMap<>();
    static List<Contacts> contactList = new ArrayList<>();

	public Map<String, Contacts> getContactMap() {
		return contactMap;
	}
	
	public void addContact(){
		Contacts person = new Contacts();
		System.out.print("First Name: ");
		while(true) {
			boolean bool = person.setFirstName(in.next());
			if(bool)
				break;
		}
		
		System.out.print("Last Name: ");
		while(true) {
			boolean bool = person.setLastName(in.next());
			if(bool)
				break;
		}
		
		System.out.print("Address: ");
		while(true) {
			boolean bool = person.setAddress(in.next());
			if(bool)
				break;
		}
		
		System.out.print("City: ");
		while(true) {
			boolean bool = person.setCity(in.next());
			if(bool)
				break;
		}
		
		System.out.print("State: ");
		while(true) {
			boolean bool = person.setState(in.next());
			if(bool)
				break;
		}
		
		System.out.print("Zip: ");
		while(true) {
			boolean bool = person.setZip(in.next());
			if(bool)
				break;
		}
		
		System.out.print("Phone Number: ");
		while(true) {
			boolean bool = person.setPhoneNo(in.next());
			if(bool)
				break;
		}
		
		System.out.print("Email: ");
		while(true) {
			boolean bool = person.setEmail(in.next());
			if(bool)
				break;
		}
		String name = person.getFirstName()+" "+person.getLastName();
		Boolean keyPresent = contactMap.containsKey(name);
		if (keyPresent) {
			System.out.println("This name is already present\n");
		}else {
			contactMap.put(name, person);
			contactList.add(person);
		}
		
	}
	
	public void showDetails() {
		if (contactList.size() == 0) {
			System.out.println("There is no contact.");
			return;
		}
		for (int i = 0; i < contactList.size(); i++) {
			Contacts person = contactList.get(i);
			System.out.println("\nContact :" + (i + 1));
			System.out.println(person);
		}
	}
	
	public void editContact() {
		if (contactList.size() == 0) {
			System.out.println("There is no contact.");
			return;
		}
		System.out.println("Enter First Name :");
    	String firstName = in.next();
    	System.out.println("Enter Last Name :");
    	String lastName = in.next();
		String name = firstName+" "+lastName;
		Boolean keyPresent = contactMap.containsKey(name);
		if (keyPresent) {
			System.out.println("Choose the option to edit");
		    System.out.println("1.Edit Last name");
		    System.out.println("2.Edit Address");
		    System.out.println("3.Edit City");
		    System.out.println("4.Edit Zip");
		    System.out.println("5.Edit Phone Number");
		    System.out.println("6.Edit Email");
		    System.out.println("7.Exit");
		    
		    
		    int option = in.nextInt();
		    if(option == 1)
		    	while(true) {
		   	  		boolean bool = contactMap.get(name).setLastName(in.next());
		   	  		if(bool)
		   	  			break;	
		    	}
		    else if(option == 2) {
		    	while(true) {
		    		boolean bool = contactMap.get(name).setAddress(in.nextLine());
		   	  		in.nextLine();
		    		
		   	  		if(bool)
		   	  			break;
		    	}
		    }
		    else if(option == 3) {
		    	while(true) {
		    		boolean bool= contactMap.get(name).setCity(in.next());
		    		if(bool)
		    			break;
		    	}
		    }
		   	  	
		    else if(option == 4) {
		    	while(true) {
		    		boolean bool =contactMap.get(name).setZip(in.next());
		    		if(bool)
		    			break;
		    	}
		    }
		   	 	
	        else if(option == 5) {
	        	while(true) {
	        		boolean bool =   contactMap.get(name).setPhoneNo(in.next());
	        		if(bool)
	        			break;
	        	}
	        }
		    else if(option == 6) {
		    	while(true) {
		    		boolean bool =contactMap.get(name).setEmail(in.next());
		    		if(bool)
		    			break;
		    	}
		    }
		    else
		    	return;
		    System.out.println("Contact updated succesfully");

		}
	}	
	
	public void deleteContact() {
		if (contactList.size() == 0) {
			System.out.println("There is no contact.");
			return;
		}
		System.out.println("Enter First Name :");
    	String firstName = in.next();
    	System.out.println("Enter Last Name :");
    	String lastName = in.next();
		String name = firstName+" "+lastName;
		
		Boolean keyPresent = contactMap.containsKey(name);
		if (keyPresent) {
			contactMap.remove(name);
			contactList.remove(contactMap.get(name));
		} 
		else {
			System.out.println("This name is not present in address book.");
		}
	}	
	
	public List<Contacts> searchPersonByCity(String city) {
		return contactList.stream().filter(person -> person.getCity().equals(city)).collect(Collectors.toList());
	}

	public List<Contacts> searchPersonByState(String state) {
		return contactList.stream().filter(person -> person.getState().equals(state)).collect(Collectors.toList());
	}
	
	public int countPersonsByCity(String city) {
		return contactList.stream().filter(person -> person.getCity().equals(city)).collect(Collectors.toList()).size();
	}

	public int countPersonsByState(String state) {
		return contactList.stream().filter(person -> person.getState().equals(state)).collect(Collectors.toList()).size();
	}	
	
	public List<Contacts> sortPersonsByName() {
		return contactList.stream().sorted((a, b) -> a.getFirstName().compareTo(b.getFirstName())).collect(Collectors.toList());
	}

}