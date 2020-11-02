package com.cp.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {

	private Connection getConnection() throws AddressBookDBException {
		String jdbcURL = "jdbc:mysql://localhost:3306/addressbook_service?allowPublicKeyRetrieval=true&&useSSL=false";
		String userName = "root";
		String password = "Aakash@123";
		try {
			return DriverManager.getConnection(jdbcURL, userName, password);
		} catch (SQLException e) {
			throw new AddressBookDBException(AddressBookDBException.ExceptionType.CONNECTION_ERROR, e.getMessage());
		}
	}

	public List<Contacts> readContacts() throws AddressBookDBException {
		// TODO Auto-generated method stub
		String sql = "select * from addressbook;";
		List<Contacts> contactList = new ArrayList<Contacts>();
		try(Connection connection = this.getConnection()){
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			contactList = getContactData(result);
		}catch(SQLException e) {
			throw new AddressBookDBException(AddressBookDBException.ExceptionType.CONNECTION_ERROR, e.getMessage());
		}
		return contactList;
	}

	private List<Contacts> getContactData(ResultSet result) throws AddressBookDBException{
		List<Contacts> contactList = new ArrayList<Contacts>();
		try {
			while(result.next()) {
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String address = result.getString("address");
				String city = result.getString("city");
				String state = result.getString("state");
				String zip = result.getString("zip");
				String phoneNo = result.getString("phone");
				String email = result.getString("email");
				contactList.add(new Contacts(firstName, lastName, address, city, state, zip, phoneNo, email));
			}
		}catch(SQLException e) {
			throw new AddressBookDBException(AddressBookDBException.ExceptionType.CONNECTION_ERROR, e.getMessage());
		}
		return contactList;
	}	
	
	public int updatePersonAddress(String firstName, String column, String value) throws AddressBookDBException {
		// TODO Auto-generated method stub
		String sql =String.format ("update address a,contact c set a.%s ='%s' where a.person_id = c.person_id and c.first_name = '%s';", column, value, firstName);
		try(Connection connection = this.getConnection()){
			Statement statement = connection.createStatement();
			return statement.executeUpdate(sql);
		}catch(SQLException e) {
			throw new AddressBookDBException(AddressBookDBException.ExceptionType.CONNECTION_ERROR, e.getMessage());
		}
	}

	public Contacts isAddressBookInSyncWithDB(String firstName) throws AddressBookDBException {
		List<Contacts> tempList = this.readContacts();
		return tempList.stream()
				.filter(contact -> contact.getFirstName().contentEquals(firstName))
				.findFirst()
				.orElse(null);
	}
}
