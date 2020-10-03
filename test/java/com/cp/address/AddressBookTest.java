/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.cp.address;

import org.junit.Test;

import com.cp.address.AddressBookMain;

import static org.junit.Assert.*;

import org.junit.Assert;

public class AddressBookTest {
	 @Test
	    public void firstNameTest() {
	        ValidateContact contact = new ValidateContact();
	        boolean result = contact.validateFirstName("Aakash");
	        Assert.assertTrue(true);
	 } 
	 @Test
	    public void lastNameTest() {
	        ValidateContact contact = new ValidateContact();
	        boolean result = contact.validateLastName("Gandhi");
	        Assert.assertTrue(true);
	 }
	 @Test
	    public void emailTest() {
	        ValidateContact contact = new ValidateContact();
	        boolean result = contact.validateEmail("aakash.gandhi@gmail.com");
	        Assert.assertTrue(true);
	 }
	 @Test
	    public void phoneNoTest() {
	        ValidateContact contact = new ValidateContact();
	        boolean result = contact.validatePhoneNo("91 9807654321");
	        Assert.assertTrue(true);
	 }
	 @Test
	    public void addressTest() {
	        ValidateContact contact = new ValidateContact();
	        boolean result = contact.validateAddress("pnp");
	        Assert.assertTrue(true);
	 }
	 @Test
	    public void cityTest() {
	        ValidateContact contact = new ValidateContact();
	        boolean result = contact.validateCity("panipat");
	        Assert.assertTrue(true);
	 }

}
