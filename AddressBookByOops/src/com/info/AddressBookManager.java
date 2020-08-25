package com.info;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookManager implements AddressBookManagerInterface {
	public String fileName;
	public String fileuse;
	public String option;
	public FileReader fr;
	public FileWriter fileWriter;
	public BufferedWriter bw;
	public static File file;
	public String regexphone="[0-9]{10}";
	public static String path = "E:\\Pradip\\AddressBookUsingOops\\csv\\";
	public static Scanner sc = new Scanner(System.in);
	public ArrayList<Person> personarraylist12 = new ArrayList<Person>(100);
	public HashMap<String,ArrayList<Person>> personarraylist1o = new HashMap<>(100);

	@Override
	public File newaddressbook() throws IOException {
		System.out.print("Enter the desired name of your Book: ");
		fileName = sc.next();
		fileName = fileName + ".csv";
		file = new File(path + fileName);
		System.out.println("Do U want To create Address Book Y/N");
		String op = sc.next();
		if (op.equalsIgnoreCase("Y")) {
			file.createNewFile();
			fileWriter = new FileWriter(file, true);
			bw = new BufferedWriter(fileWriter);
			bw.write("FirstName");
			bw.write(",Lastname");
			bw.write(",City");
			bw.write(",State");
			bw.write(",Zipcode");
			bw.write(",Phonenumber");
			bw.newLine();
			System.out.println("Address Book Created ");
		} else {
			System.out.println("Address Book Not created already present");
		}
		bw.close();
		fileWriter.close();
		return file;
	}
	@Override
	public HashMap<String, ArrayList<Person>> openaddressbook()
			throws ReflectiveOperationException, RuntimeException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveaddressbook(String key, ArrayList<Person> personarraylist13) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveasaddressbook() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeaddressbook(FileWriter fwriter) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAddressBook() {
		// TODO Auto-generated method stub
		
	}

}
