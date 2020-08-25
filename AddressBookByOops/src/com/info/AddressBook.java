package com.info;

import java.io.*;
import java.util.*;

public class AddressBook implements AddressBookInterface {
//variable Declaration
	public String firstname;
	public String lastname;
	public String city;
	public String state;
	public int zipcode;
	public String phonenumber;
	public String fileuse;
	public static File file;
	public FileReader fr;
	public FileWriter fileWriter;
	public BufferedWriter bw;
	public BufferedReader br;
	public PrintWriter pw;
	public String regexphone = "[0-9]{10}";
	public String dumyphonenumber;
	int flag = 0;
	public static String path = "E:\\Pradip\\AddressBookUsingOops\\csv\\";
	public static Scanner sc = new Scanner(System.in);
	public ArrayList<Person> personarraylist1 = new ArrayList<Person>(100);
	public HashMap<String, ArrayList<Person>> personarraylist11 = new HashMap<>(100);

	@Override
	public HashMap<String, ArrayList<Person>> addperson(String fileuse) throws IOException {
		System.out.println("How many data want to save in AddressBook :" + fileuse);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter First Name :");
			firstname = sc.next();
			System.out.println("Enter Last Name :");
			lastname = sc.next();
			System.out.println("Enter City :");
			city = sc.next();
			System.out.println("Enter State :");
			state = sc.next();
			System.out.println("Enter Zip Code :");
			zipcode = sc.nextInt();
			System.out.println("Enter Phone Number :");
			phonenumber = sc.next();
			boolean flag1 = phonenumber.matches(regexphone);
			while (flag1 == false) {
			System.out.println("Enter Phone Number with 10 digit between 0-9 :");
			phonenumber = sc.next();
			flag1 = phonenumber.matches(regexphone);
			}
			personarraylist1.add(new Person(firstname + ",", lastname + ",", city + ",", state + ",", zipcode, "," + phonenumber));
			personarraylist11.put(fileuse, personarraylist1);
		}
		return personarraylist11;
	}

	@Override
	public String editperson(String fileuse) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteperson(String fileuse) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String searchperson(String fileuse)
			throws ReflectiveOperationException, RuntimeException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sortbyzipperson(String fileuse) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sortbynameperson(String fileuse) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Display(String fileuse) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String acess() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
