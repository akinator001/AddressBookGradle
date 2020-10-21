package com.cp.address;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBookFileIOTest {
	@Test
	public void givenContactsInFileShouldRead() {
		AddressBookFileIOService addressBookFileIOService = new AddressBookFileIOService();
		List<Contacts> contactList = new ArrayList<>();
		contactList = addressBookFileIOService.readData();
		System.out.println(contactList);
		Assert.assertEquals(2, contactList.size());
	}

	@Test
	public void writeContactsToFile() {
		AddressBookFileIOService addressBookFileIOService = new AddressBookFileIOService();
		List<Contacts> contactList = new ArrayList<>();
		Contacts contact1 = new Contacts("Aakash", "Gandhi", "Shanti nagar", "panipat", "haryana", "132103", "9856257845", "aakash@ygmail.com");
		Contacts contact2 = new Contacts("Gunjan", "Sinha", "Model towm", "delhi", "delhi", "254806", "7878787878", "gunna@gmail.com");
		contactList.add(contact1);
		contactList.add(contact2);
		addressBookFileIOService.writeData(contactList);
		Assert.assertEquals(2, addressBookFileIOService.countEntries());
	}
	
	@Test
	public void givenContactsFromCSVFileShouldRead() {
		AddressBookFileIOService addressBookFileIOService = new AddressBookFileIOService();
		List<Contacts> contactList = new ArrayList<>();
		contactList = addressBookFileIOService.readCSVData();
		System.out.println(contactList);
		Assert.assertEquals(2, contactList.size());
	}

	@Test
	public void writeContactsToCSVFile() {
		AddressBookFileIOService addressBookFileIOService = new AddressBookFileIOService();
		List<Contacts> contactList = new ArrayList<>();
		Contacts contact1 = new Contacts("Aakash", "Gandhi", "Panipat", "Panipat", "Haryana", "123456", "7878787878", "aakashg@yahoo.co.in");
		Contacts contact2 = new Contacts("Par", "Sahani", "Town", "Nagar", "TN", "785478", "9856257845", "par@gmail.com");
		contactList.add(contact1);
		contactList.add(contact2);
		boolean b = addressBookFileIOService.writeCSVData(contactList);
		Assert.assertTrue(b);
	}	
	
	@SuppressWarnings("deprecation")
	@Test
	public void writeContactsToJsonFile() {
		AddressBookFileIOService addressBookFileIOService = new AddressBookFileIOService();
		List<Contacts> contactList = new ArrayList<>();
		Contacts contact1 = new Contacts("Arijit", "Dey", "sodepur", "kolkata", "WB", "123456", "7878787878", "arijiy@yahoo.co.in");
		Contacts contact2 = new Contacts("Partha", "Saha", "NewTown", "BidhanNagar", "WB", "785478", "9856257845", "partha@gmail.com");
		contactList.add(contact1);
		contactList.add(contact2);
		boolean b = addressBookFileIOService.writeJsonData(contactList);
		Assert.assertTrue(b);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void readContactsFromJsonFile() {
		AddressBookFileIOService addressBookFileIOService = new AddressBookFileIOService();
		List<Contacts> contactList = new ArrayList<>();
		Contacts contact1 = new Contacts("Arijit", "Dey", "sodepur", "kolkata", "WB", "123456", "7878787878", "arijiy@yahoo.co.in");
		Contacts contact2 = new Contacts("Partha", "Biswas", "NewTown", "BidhanNagar", "WB", "785478", "9856257845", "partha@gmail.com");
		contactList.add(contact1);
		contactList.add(contact2);
		boolean b = addressBookFileIOService.readJsonFile();
		Assert.assertTrue(b);
	}
}
