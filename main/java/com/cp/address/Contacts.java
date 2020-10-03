package com.cp.address;

public class Contacts {

	private String firstName, lastName, address, city, zip, phoneNo, email;

	ValidateContact validateContact = new ValidateContact();

	public String getFirstName() {
		return firstName;
	}

	public boolean setFirstName(String firstName) {
		boolean bool = validateContact.validateFirstName(firstName);
		if (bool)
			this.firstName = firstName;
		else
			System.out.println("Enter First Name Properly");
		return bool;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean setLastName(String lastName) {
		boolean bool = validateContact.validateLastName(lastName);
		if (bool)
			this.lastName = lastName;
		else
			System.out.println("Enter Last Name Properly");
		return bool;
	}

	public String getAddress() {
		return address;
	}

	public boolean setAddress(String address) {
		boolean bool = validateContact.validateAddress(address);
		if (bool)
			this.address = address;
		else
			System.out.println("Enter Address Properly");
		return bool;
	}

	public String getCity() {
		return city;
	}

	public boolean setCity(String city) {
		boolean bool = validateContact.validateCity(city);
		if (bool)
			this.city = city;
		else
			System.out.println("Enter City Properly");
		return bool;
	}

	public String getZip() {
		return zip;
	}

	public boolean setZip(String zip) {
		boolean bool = validateContact.validateZip(zip);
		if (bool)
			this.zip = zip;
		else
			System.out.println("Enter Zip Properly");
		return bool;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public boolean setPhoneNo(String phoneNo) {
		boolean bool = validateContact.validatePhoneNo(phoneNo);
		if (bool)
			this.phoneNo = phoneNo;
		else
			System.out.println("Enter Phone No Properly");
		return bool;
	}

	public String getEmail() {
		return email;
	}
	public boolean setEmail(String email) {
		boolean bool = validateContact.validateEmail(email);
		if (bool)
			this.email = email;
		else
			System.out.println("Enter Email Properly");
		return bool;

	}
}