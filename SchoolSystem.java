package joshi.schoolSystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/** SchoolSystem Class
 * <p>
 * This class is the main class used for the SchoolSystem project. This class
 * holds many of the methods necessary to have a fully running school system.
 * <p><font color = "green">
 * This class contains the main menu, in which the user will be given 9 options
 * all of which will complete different tasks.
 * <br> The tasks that this program will be able to complete include creating a new
 * student, printing the students, saving the students to a file, <br>
 * loading students from a file, searching for a student. sorting all the students,
 * inserting a student, or deleting a student.<br>
 * When the user is done with the program, they will be able to quit using the quit button.
 * <p><font color = "black">
 * Keyboard and Screen I/O
 * @version October 26th, 2018
 * @author Archan Joshi
 */
public class SchoolSystem {
	public SchoolSystem() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws InvalidInputException, IOException {
		Scanner scan = new Scanner(System.in);
		ArrayList<Student> records = new ArrayList<Student>();
		File file = new File("src/joshi/schoolSystem/student.txt");
		int option = 0;
		boolean check1 = false;
		boolean check2 = false;

		System.out.println("Welcome to the School System program. Please enter one of the below numbers.");
		while (option != 9)
		{
			System.out.println("1 - Add student");
			System.out.println("2 - Print student");
			System.out.println("3 - Save student");
			System.out.println("4 - Load student");
			System.out.println("5 - Search student");
			System.out.println("6 - Sort students");
			System.out.println("7 - Insert student");
			System.out.println("8 - Delete student");
			System.out.println("9 - Quit");
			option = scan.nextInt();
			scan.nextLine();
			if (option == 1)
			{
				records.add(newRecord(records,check1,check2));
			}
			else if (option == 2)
			{
				printArrayList(records);
			}
			else if (option == 3)
			{
				System.out.println("Would you like to add to the current record or overrride it?");
				System.out.println("Press 1 to load the file first, or press 2 to override the file.");
				option = scan.nextInt();
				if (option == 1 && check2 == false)
				{
					loadFile(file, records);
				}
				saveFile(records);
			}
			else if (option == 4)
			{
				check2 = true;
				loadFile(file,records);
			}
			else if (option == 5)
			{
				System.out.println("What student number would you like to search for?");	
				String want = scan.nextLine();
				int spot = search(records,want);
				if (spot >= 0)
				{
					printRecord(records.get(spot));
				}
				else
				{
					System.out.println("This student number does not exist");
				}
			}
			else if (option == 6)
			{
				sort(records);
			}
			else if (option == 7)
			{
				insert(records,check1, check2);
			}
			else if (option == 8)
			{
				System.out.println("Enter the student number of the student you'd like to delete.");
				String studentNumber= scan.nextLine();
				delete(records,studentNumber);
			}
			else if (option == 9)
			{
				System.out.println("The program has been ended");
				break;
			}
			else
			{
				System.out.println("That is not a valid option. Please enter one of the below options.");
			}
		}
	}
	/**
	 * This method will be used to create a new student, by asking the user to answer questions about the student.
	 * <p><font color = "green">
	 * This program consists of many print statements in which the program asks the user for different information
	 * about the student being created.<br>
	 * The information asked for is a student number, a last name, a first name, a middle initial(s)
	 * ,an email address, a phone number, a grade, a list of 8 classes,<br>
	 * a street address, a city, a province, and lastly a postal code.
	 * All this information will then be used to create the student.
	 * <p>
	 * When each piece of information is entered, it is tried against the exception in the student/address class,
	 * and if there is an issue, it will ask for you to re enter the information.<br>
	 * The method will also check if duplicate student numbers are entered, and if they are, it
	 * will give you the option to modify the entered student number, or replace the student with that
	 * student number.
	 * <p><font color = "black">
	 * @param 	records
	 * <br>		The ArrayList of students that the new student is added to.
	 * @param 	check1
	 * <br>		The boolean used to repeat the program in a try and catch.
	 * @param 	check2
	 * <br>		The boolean used while checking for duplicate student numbers.
	 * @return	student
	 * <br>		The student created, which will be returned to the place it was called so that it can be added to the ArrayList.
	 * @throws 	InvalidInputException
	 * <br>		Exception thrown if inputed information does not fit in the created exceptions.
	 * @throws 	FileNotFoundException
	 * <br>		Exception used when working with the file.
	 */
	public static Student newRecord(ArrayList<Student> records, boolean check1, boolean check2) throws InvalidInputException, FileNotFoundException
	{
		//initializing all used variables
		Scanner scan = new Scanner(System.in);
		String firstName1 = null, middleInitial1 = null, lastName1 = null, email1 = null, studentNumber1 = "", phoneNumber1 = null, grade1 = null, streetAddress1, city1, province1, postalCode1;	
		String [] classes = new String[8];
		int answer = -1;
		File file = new File("src/joshi/schoolSystem/student.txt");
		Scanner fscan = new Scanner(file);
		int size = fscan.nextInt();
		boolean flag = false;
		Student student = null;
		Address address = null;
		// start of creating the record

		System.out.println("Please enter the student's student number");
		studentNumber1 = scan.nextLine();
		if (check2 == false)
		{
			for (int i = 0; i < records.size()-1; i++)
			{
				answer = records.get(i).getStudentNumber().compareToIgnoreCase(studentNumber1);//uses compareTo to check for duplicate student numbers
				if (answer == 0)
				{
					System.out.println("This student number already exists. Would you like to modify the entered number, or replace the student?");//options given if duplicate student numbers are entered
					System.out.println("If you'd like to modify, press 1. If you'd like to replace the student, press 2.");
					int option = scan.nextInt();
					while (option != 1 || option !=2)
					{
						if (option == 1)
						{
							System.out.println("Enter the new student number.");
							studentNumber1 = scan.next();
							answer = records.get(i).getStudentNumber().compareToIgnoreCase(studentNumber1); 
							if (answer == 0)
							{
								System.out.println("Please enter a different student number.");
								studentNumber1 = scan.next();
								records.get(records.size()-1).setStudentNumber(studentNumber1);
							}
							else
							{
								break;
							}	
						}
							else if (option == 2)
							{
								System.out.println("Enter the new student");
								check2 = true;
								records.set(i, newRecord(records,check1, check2));
								break;
							}
							else
							{
								System.out.println("Please enter either 1 or 2.");//code used when 1 or 2 isn't entered
								option = scan.nextInt();
							}
						}
					}
				}
				scan.nextLine();
			}
			System.out.println("Please enter the student's last name");
			lastName1 = scan.nextLine();
			
			System.out.println("Please enter the student's first name.");
			firstName1 = scan.nextLine();
			
			System.out.println("Please enter the student's middle initial(s).");
			middleInitial1 = scan.nextLine();
		
			System.out.println("Please enter the student's email address.");
			email1 = scan.nextLine();
			
			System.out.println("Please enter the student's phone number.");
			phoneNumber1 = scan.nextLine();
		
			System.out.println("Please enter the student's grade");
			grade1 = scan.nextLine();
			
			System.out.println("Please enter the student's eight classes, pressing enter after each class.");
			for (int i = 0; i < classes.length; i++)
			{
				classes[i] = scan.nextLine();
			}
			try// trying the entire address at once
			{
				System.out.println("Please enter the student's street address.");
				streetAddress1 = scan.nextLine();
				System.out.println("Please enter the student's city.");
				city1 = scan.nextLine();
				System.out.println("Please enter the student's province.");
				province1 = scan.nextLine();
				System.out.println("Please enter the student's postal code");
				postalCode1 = scan.nextLine();
				address = new Address(streetAddress1, city1, province1, postalCode1);//creates the address
				check1 = true;
			}
			catch (InvalidInputException e)
			{
				System.err.println(e.getMessage());
				check1 = false;
			}
			try {
				student = new Student(firstName1, middleInitial1, lastName1, email1, studentNumber1, phoneNumber1, grade1, classes, address);//creates the student
			}
			catch (InvalidInputException e)
			{
				System.err.println(e.getMessage());
				check1 = false;
			}
			return student;
		}
		/**
		 * This method is strictly used for printing out the information of one student in the desired order.
		 * <br>It will print each part of the student separately so that it looks neat in the console.
		 * @param 	student
		 * <br>		This will be the student received whose information will be printed.
		 * @void
		 * <br>		This method only prints, so nothing is returned.			
		 */
		public static void printRecord(Student student)
		{
			System.out.println("Last Name: " + student.getLastName());
			System.out.println("First Name: " + student.getFirstName());
			System.out.println("Middle Initial: " + student.getMiddleInitials());
			System.out.println("Email Address: " + student.getEmail());
			System.out.println("Student Number: " + student.getStudentNumber());
			System.out.println("Phone Number: " + student.getPhoneNumber());
			System.out.println("Grade: " + student.getGrade());
			System.out.println("Classes: " +  Arrays.toString(student.getClasses()));
			Address studentAddress = student.getAddress();
			System.out.println("Address: " + studentAddress.getStreetAddress().replaceAll("_", " ") + ", " + studentAddress.getCity() + ", " + studentAddress.getProvince() + ", " + studentAddress.getPostalCode() + ".");
		}
		/**
		 * This method will separate the ArrayList of students into individual students, which will be sent to the printing method.
		 * <br>This will print the all the students in the record.
		 * @param 	records
		 * <br>		This is the ArrayList of students that will be separated and then sent to the printing method to be displayed to the user.
		 * @void
		 * <br>		Calls the printRecord method, nothing will be returned.
		 */
		public static void printArrayList(ArrayList <Student> records)
		{
			for (int i = 0; i < records.size(); i++)
			{
				printRecord(records.get(i));
				System.out.println();
			}
		}
		/**
		 * This method will be used to save the inputed information into a text file.
		 * <p><font color = "green">
		 * This will be done by using the toString method. Once all the information for one student
		 * is inputed, <br> the program will save it all into one string, and then print that string
		 * in a text file.
		 * <br> This will allow for the student to be saved in the desired order.
		 * <p><font color = "black">
		 * @param 	records
		 * <br>		The ArrayList of students which will be printed onto the text file. 
		 * @throws 	IOException
		 * <br> 	An exception will be thrown if the information does not match what is required in the toString method.
		 * @void
		 * <br>		Saves information into file, nothing is changed in the program, so nothing will be returned.
		 */
		public static void saveFile(ArrayList <Student> records) throws IOException 
		{
			File file = new File("src/joshi/schoolSystem/student.txt");
			PrintStream fps = new PrintStream(file);
			fps.println(records.size());
			if (file.exists() == true)//saves information if a file already exists
			{
				for (int i = 0; i < records.size(); i++)
				{
					Student student = records.get(i);
					fps.println(records.get(i).toString().replaceAll(" ", "_"));//used to represent spaces in the address
				}
			}
			else //creates a new file and then saves the information in it
			{
				file.createNewFile();
				for (int i = 0; i < records.size(); i++)
				{
					Student student = records.get(i);
					fps.println(records.get(i).toString());
				}
			}
			fps.close();
		}
		/**
		 * This method will be used to load information from a file and save it into the ArrayList.
		 * <p><font color = "green">
		 * The method will save each student by first copying one line from the file, and then splitting
		 * it so that each part of the student is one element in the array.
		 * <br> It will then add the newly created student into the pre-exisiting ArrayList of students.
		 * <p><font color = "black">
		 * @param 	file
		 * <br>		This is the file from which the information will be taken.
		 * @param 	records
		 * <br>		This is the ArrayList of students that the new students will be added to.
		 * @throws 	FileNotFoundException
		 * <br>		Will throw an exception if the desired file is not found.
		 * @throws 	InvalidInputException
		 * <br>		Throws an exception if the input does not match what is required in the method.
		 * @void	
		 * <br>		Saves information directly into the ArrayList, so nothing will be returned.
		 */
		public static void loadFile(File file, ArrayList<Student> records) throws FileNotFoundException, InvalidInputException
		{
			Scanner fscan = new Scanner(file);//Scanner used to scan from the file
			int n = fscan.nextInt();//the number of students in the file
			fscan.nextLine();
			for (int i = 0; i < n; i++)
			{
				String [] studentInfo = fscan.next().split(";");//splits the student into an array of information
				Address address = new Address(studentInfo[8], studentInfo[9], studentInfo[10], studentInfo[11]);//creates the address
				Student student = new Student(studentInfo[0],studentInfo[1],studentInfo[2],studentInfo[3],studentInfo[4],studentInfo[5],studentInfo[6],studentInfo[7].split("#"),address);//creates the student and splits the classes into its own array
				records.add(student);//adds the student to the ArrayList
			}
			fscan.close();//closes the scanner
		}
		/**
		 * This method will search for a student in the records by searching for their studentNumber.
		 * <p><font color = "green">
		 * The program will use the compareTo method created in the Student Class to find the student number.
		 * <br> It will check the wanted student number and return 0 as answer. When answer equals 0
		 * it will set the value of spot to the spot in the ArrayList where the student is held.
		 * <br> If the student cannot be found, a -1 will be returned.
		 * <p><font color = "black">
		 * @param 	records
		 * <br>		The ArrayList of students that will be searched.
		 * @param 	want
		 * <br> 	The student number that is being searched for.
		 * @return	spot
		 * <br> 	The spot in the ArrayList where the wanted student is held.
		 */
		public static int search(ArrayList<Student> records, String want)
		{
			int spot = -1;
			for (int i = 0; i < records.size(); i++)// searches for the spot in the array where the wanted value is held
			{
				int answer = records.get(i).getStudentNumber().compareToIgnoreCase(want); // compareTo method will return 0 if the wanted number is found
				if (answer == 0)
				{
					spot = i;
				}
			}
			return spot;		
		}
		/**
		 * This method will be used to sort the ArrayList by student number, going from least to greatest.
		 * <p><font color = "green">
		 * Since the student class implements comparable, we can use Collections.sort to sort the array.
		 * <p><font color = "black">
		 * @param 	records
		 * <br>		The ArrayList of students that will be sorted.
		 * @void	
		 * <br>		The original ArrayList will be sorted, so nothing is returned.
		 */
		public static void sort(ArrayList<Student> records)
		{
			Collections.sort(records);
		}
		/**
		 * This method will insert a student into an ArrayList in its correct spot.
		 * <p><font color = "green">
		 * The program will first add the student to the end of the ArrayList, and will then immediately sort it, 
		 * so that student appears in their final position.
		 * <p><font color = "black">
		 * @param 	records
		 * <br>		The ArrayList of students that a new student will be inserted into.
		 * @param 	check1
		 * <br>		Variable used to continue adding a student.
		 * @param	check2
		 * <br>		Variable used when adding a student to ensure no student number is repeated.
		 * @throws 	FileNotFoundException
		 * <br>		File is used in the newRecord method.
		 * @throws 	InvalidInputException
		 * <br>		Exception thrown if the input does not match what is required.
		 * @void	
		 * <br>		The student is saved directly into the ArrayList, so nothing will be returned.
		 */
		public static void insert(ArrayList<Student>records, boolean check1, boolean check2) throws InvalidInputException, FileNotFoundException
		{
			records.add(newRecord(records, check1, check2));//adds the student
			sort(records);//sorts the ArrayList
		}
		/**
		 * This method will be used to remove a student from the ArrayList.
		 * <p><font color = "green">
		 * The method will first search for the student in the array using their student number.
		 * It will save the value of the spot returned in an int variable.
		 * <br> It will then delete the student using the .remove command.
		 * <p><font color = "black">
		 * @param 	records
		 * <br>		The ArrayList of students from which a student will be deleted.
		 * @param 	studentNumber
		 * <br>		The student number of the student that will be deleted.
		 * @void
		 * <br>		The student will be deleted from the original ArrayList, so nothing will be returned.
		 */
		public static void delete(ArrayList<Student>records, String studentNumber)
		{
			int spot = search(records,studentNumber);//searches for the student
			records.remove(spot);//deletes the student
		}

	}
