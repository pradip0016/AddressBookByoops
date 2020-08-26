package com.info;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class AddressBookManager implements AddressBookManagerInterface {
	public String fileName;
	public String fileuse;
	public String option;
	public FileReader fr;
	public String num;
	public FileWriter fileWriter;
	public BufferedWriter bw;
	public BufferedReader br;
	public String str;
	public String find;
	int flag = 0;
	public static File file;
	public String regexphone = "[0-9]{10}";
	public static String path = "E:\\Pradip\\AddressBookUsingOops\\csv\\";
	public static Scanner sc = new Scanner(System.in);
	public ArrayList<Person> personarraylist12 = new ArrayList<Person>(100);
	public ArrayList<Person> personarraylistreal = new ArrayList<Person>(100);
	public HashMap<String, ArrayList<Person>> personarraylist1o = new HashMap<>(100);

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
		AddressBook AddressBook = new AddressBook();
		fileuse = AddressBook.acess();
		if (fileuse != null) {
			fileuse = fileuse;
			System.out.println("Please Enter Your Choice \n");
			System.out.println("1) Add Person \n" + "2) Edit Person \n" + "3) Delete Person \n" + "4) Search Person \n"
					+ "5) Sort ByZip \n" + "6) Sort ByName \n" + "7) Display");
			int ch2 = sc.nextInt();
			switch (ch2) {
			case 1:
				personarraylist1o = AddressBook.addperson(fileuse);
				System.out.println("Please save Below data In addressBook by click on saveaddressBook 3");
				Iterator it = personarraylist1o.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					System.out.println(pair.getKey() + " = " + pair.getValue());
				}
				break;
			case 2:
				AddressBook.editperson(fileuse);
				break;
			case 3:
				AddressBook.deleteperson(fileuse);
				break;
			case 4:
				AddressBook.searchperson(fileuse);
				break;
			case 5:
				AddressBook.sortbyzipperson(fileuse);
				break;
			case 6:
				AddressBook.sortbynameperson(fileuse);
				break;
			case 7:
				AddressBook.Display(fileuse);
				break;
			default:
				System.out.println("enter correct choice");
			}
			return personarraylist1o;
		}

		return personarraylist1o;

	}

	@Override
	public void saveaddressbook(String key, ArrayList<Person> personarraylist13) throws IOException {
		fileWriter = new FileWriter(path + key + ".csv", true);
		bw = new BufferedWriter(fileWriter);
		for (int J = 0; J < personarraylist13.size(); J++) {
			num = personarraylist13.get(J).getPhonenumber().trim();
			System.out.println("checking with number "+num+" any data present or not");
			System.out.println("---------");
			System.out.println("------------");
			File input = new File((path + key + ".csv"));
			fr = new FileReader(input);
			br = new BufferedReader(fr);
			while ((str = br.readLine()) != null) {
				if (str.contains(num))
				{
					flag++;
					find = str;
				}
				
			}
			br.close();
			if (flag == 0) {
				bw.write(personarraylist13.get(J).toString() + "\n");
				System.out.println("Data not present with "+num+" And Data Saved in AddressBook :" + key + ".csv");
			} else {
				System.out.println("already Data present with same Number with :" + find);
			}

		}
		bw.close();
		fileWriter.close();
	}

	@Override
	public void saveasaddressbook() {
		System.out.println("AddressBook Present in System \n");
		File f = new File(path);
		String[] s = f.list();
		for (String s1 : s) {
			System.out.println(s1);
		}
		System.out.println("Please enter name which book want to rename");
		String filename = sc.next();
		System.out.println("please enter new name of book");
		String newname = sc.next();
		File oldFile = new File((path + filename + ".csv"));
		File newFile = new File(path + newname + ".csv");
		boolean b = oldFile.renameTo(newFile);
		if (b == true) {
			System.out.println("file renamed and saved");
		} else

		{
			System.out.println("file not saved as ");

		}

	}

	@Override
	public void closeaddressbook(FileWriter fwriter) throws IOException {
		fileWriter.close();
		System.out.println("AddressBook Closed");
	}

	@Override
	public void quit() {
		System.exit(0);
	}

	@Override
	public void showAddressBook() {
		System.out.println("AddressBook Present in System \n");
		File f = new File(path);
		String[] s = f.list();
		for (String s1 : s) {
			System.out.println(s1);
		}
		System.out.println("======================");
	}
}
