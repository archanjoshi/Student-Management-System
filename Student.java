package joshi.schoolSystem;
import java.util.ArrayList;
import java.util.Arrays;

/** Student Class
 * <p>
 * Holds the getters and setters for many different fields, which
 * as a whole contain the full address of one student.
 * <p><font color = "green">
 * Each field holds its own invalid input exceptions. They will ensure
 * that each piece of information is formatted in a specific way.
 * <p><font color = "black">
 * @version October 26th, 2018
 * @author Archan Joshi
 */
public class Student implements Comparable<Student> {
	private String lastName, firstName, middleInitials, email, studentNumber, phoneNumber, grade;
	private String [] classes;
	private Address address;
	/**
	 * Empty Student Constructor
	 */
	public Student()
	{
	}
	/**
	 * The super constructor of the object type "Student".
	 * <p>
	 * This method will receive 9 different variables from the School System class
	 * and will set the information into its variables using the received information.
	 * <p>
	 * @param 	firstName1
	 * <br>		The inputed first name which will be used to set the value of the firstName variable.
	 * @param 	middleInitials1
	 * <br>		The inputed middle initial(s) which will be used to set the value of the middleInitials variable.
	 * @param 	lastName1
	 * <br>		The inputed last name which will be used to set the value of the lastName variable.
	 * @param 	email1
	 * <br>		The inputed email address which will be used to set the value of the email variable.
	 * @param 	studentNumber1
	 * <br>		The inputed student number which will be used to set the value of the studentNumber variable.
	 * @param 	phoneNumber1
	 * <br>		The inputed phone number which will be used to set the value of the phoneNumber variable.
	 * @param 	grade1
	 * <br>		The inputed grade which will be used to set the value of the grade variable.
	 * @param 	classes1
	 * <br>		The inputed array of classes which will be used to set the value of the classes variable.
	 * @param 	address1
	 * <br>		The inputed address which will be used to set the value of the address variable.
	 * @throws 	InvalidInputException
	 * <br> 	Throws an InvalidInputException if the entered information does not match the required format.
	 */
	public Student(String firstName1, String middleInitials1, String lastName1, String email1, String studentNumber1, String phoneNumber1, String grade1, String [] classes1, Address address1) throws InvalidInputException
	{
		super();
		this.setFirstName(firstName1);
		this.setMiddleInitials(middleInitials1);
		this.setLastName(lastName1);
		this.setEmail(email1);
		this.setStudentNumber(studentNumber1);
		this.setPhoneNumber(phoneNumber1);
		this.setGrade(grade1);
		this.setClasses(classes1);
		this.setAddress(address1);
	}
	/**
	 * The getter created for the lastName variable.
	 * @return 	lastName
	 * <br> 	Returns the information stored in the lastName variable.
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * This method sets the information into the lastName variable using information received 
	 * from the SchoolSystem class.
	 * <p><font color = "green">
	 * The last name variable will not accept any input that is not only letters.
	 * <p><font color = "black">
	 * @param 	lastName
	 * <br>		The lastName inputed by the user which will be used to create the new lastName variable.
	 * @throws 	InvalidInputException
	 * <br>		Throws an invalid input exception if the entered information does not match the required format. 
	 */
	public void setLastName(String lastName) throws InvalidInputException {
		lastName  = lastName.replaceAll(" ", ""); // gets rid of all the spaces in the variable if there are any
		if (!lastName.matches("[a-zA-Z]*"))// checks to ensure only letters are inputed
		{
			throw new InvalidInputException("Not a valid last name. Please make sure there are no special characters or numbers.");//throws exception if anything besides letters are entered
		}
		else
		{
			this.lastName = lastName;
		}	
	}
	/**
	 * The getter created for the firstName variable.
	 * @return 	firstName
	 * <br> 	Returns the information stored in the firstName variable.
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * This method sets the information into the firstName variable using information received 
	 * from the SchoolSystem class.
	 * <p><font color = "green">
	 * The first name variable will not accept any input that is not only letters.
	 * <p><font color = "black">
	 * @param 	firstName
	 * <br>		The firstName inputed by the user which will be used to create the new firstName variable.
	 * @throws 	InvalidInputException
	 * <br>		Throws an invalid input exception if the entered information does not match the required format. 
	 */
	public void setFirstName(String firstName) throws InvalidInputException {
		firstName  = firstName.replaceAll(" ", "");// gets rid of all the spaces in the variable if there are any
		if (!firstName.matches("[a-zA-Z]*"))// checks to ensure only letters are inputed
		{
			throw new InvalidInputException("Not a valid first name. Please make sure there are no special characters or numbers.");//throws exception if anything besides letters are entered
		}
		else
		{
			this.firstName = firstName;
		}	
	}
	/**
	 * The getter created for the middleInitials variable.
	 * @return 	middleInitials
	 * <br> 	Returns the information stored in the middleInitials variable.
	 */
	public String getMiddleInitials() {
		return middleInitials;
	}
	/**
	 * This method sets the information into the middleInitials variable using information received 
	 * from the SchoolSystem class.
	 * <p><font color = "green">
	 * The middle initial(s) variable will not accept any input that is not only letters.
	 * <p><font color = "black">
	 * @param 	middleInitials
	 * <br>		The middleInitials inputed by the user which will be used to create the new middleInitials variable.
	 * @throws 	InvalidInputException
	 * <br>		Throws an invalid input exception if the entered information does not match the required format. 
	 */
	public void setMiddleInitials(String middleInitials) throws InvalidInputException {
		middleInitials  = middleInitials.replaceAll(" ", "");// gets rid of all the spaces in the variable if there are any
		if (!middleInitials.matches("[a-zA-Z]*"))// checks to ensure only letters are inputed
		{
			throw new InvalidInputException("Not a valid middle initial. Please make sure there are no special characters or numbers.");//throws exception if anything besides letters are entered
		}
		else
		{
			this.middleInitials = middleInitials;
		}	
	}
	/**
	 * The getter created for the email variable.
	 * @return 	email
	 * <br> 	Returns the information stored in the email variable.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * This method sets the information into the email variable using information received 
	 * from the SchoolSystem class.
	 * <p><font color = "green">
	 * The email variable will not accept any input that is only letters or only numbers.
	 * It must include an "@" symbol.
	 * <p><font color = "black">
	 * @param 	email
	 * <br>		The email inputed by the user which will be used to create the new email variable.
	 * @throws 	InvalidInputException
	 * <br>		Throws an invalid input exception if the entered information does not match the required format. 
	 */
	public void setEmail(String email) throws InvalidInputException {
		email = email.replaceAll(" ", "");// gets rid of all the spaces in the variable if there are any
		if (email.matches("[a-zA-Z]*") || email.matches("[//d]*"))// checks to ensure that there is an "@" symbol used
		{
			throw new InvalidInputException("Not a valid email address. Please make sure there is a '@' symbol.");
		}
		else
		{
			this.email = email;
		}	
	}
	/**
	 * The getter created for the grade variable.
	 * @return 	grade
	 * <br> 	Returns the information stored in the grade variable.
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * This method sets the information into the grade variable using information received 
	 * from the SchoolSystem class.
	 * <p><font color = "green">
	 * The grade variable will not accept any input that includes anything except numbers.
	 * <p><font color = "black">
	 * @param 	grade
	 * <br>		The grade inputed by the user which will be used to create the new grade variable.
	 * @throws 	InvalidInputException
	 * <br>		Throws an invalid input exception if the entered information does not match the required format. 
	 */
	public void setGrade(String grade) throws InvalidInputException {
		if (!grade.matches("[\\d]*"))// checks to make sure only numbers are inputed
		{
			throw new InvalidInputException("Not a valid grade. Please make sure there are no special characters or letters.");// throws exception if anything besides numbers are inputed
		}
		else
		{
			this.grade = grade;
		}	
	}
	/**
	 * The getter created for the classes variable.
	 * @return 	classes
	 * <br> 	Returns the information stored in the classes variable.
	 */
	public String [] getClasses() {
		return classes;
	}
	/**
	 * This method sets the information into the classes variable using information received 
	 * from the SchoolSystem class.
	 * <p><font color = "green">
	 * The classes variable will not accept any input that has digits.
	 * The array also must have 8 elements.
	 * <p><font color = "black">
	 * @param 	classes
	 * <br>		The classes inputed by the user which will be used to create the new classes variable.
	 * @throws 	InvalidInputException
	 * <br>		Throws an invalid input exception if the entered information does not match the required format. 
	 */
	public void setClasses(String [] classes) throws InvalidInputException {
		for (int i = 0; i < classes.length; i++)
		{
			if (classes.length != 8 || classes[i].matches("[\\d]*"))// makes sure that there are 8 classes and they all don't have digits
			{
				throw new InvalidInputException("Not a valid list of classes. Please make sure you enter 8 classes, and ensure there are no number or special characters.");// throws exception if clause isn't met
			}
			else
			{
				this.classes = classes;
			}	
		}
	}
	/**
	 * The getter created for the address variable.
	 * @return 	address
	 * <br> 	Returns the information stored in the address variable.
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * This method sets the information into the address variable using information received 
	 * from the Address class.
	 * <p>
	 * @param 	address
	 * <br>		The address created in the Address class which is used to create the new address variable.
	 */
	public void setAddress(Address address) throws InvalidInputException{
		this.address = address;
	}
	/**
	 * The getter created for the studentNumber variable.
	 * @return 	studentNumber
	 * <br> 	Returns the information stored in the studentNumber variable.
	 */
	public String getStudentNumber() {
		return studentNumber;
	}
	/**
	 * This method sets the information into the studentNumber variable using information received 
	 * from the SchoolSystem class.
	 * <p><font color = "green">
	 * The studentNumber variable will not accept any input that includes anything except numbers.
	 * It must also be 9 digits long.
	 * <p><font color = "black">
	 * @param 	studentNumber
	 * <br>		The studentNumber inputed by the user which will be used to create the new studentNumber variable.
	 * @throws 	InvalidInputException
	 * <br>		Throws an invalid input exception if the entered information does not match the required format. 
	 */
	public void setStudentNumber(String studentNumber) throws InvalidInputException {
		studentNumber = studentNumber.replaceAll(" ", "");
		if (!studentNumber.matches("[\\d]*") || studentNumber.length() != 9)//ensures student number is 9 digits long and is only digits
		{
			throw new InvalidInputException("Not a valid student number. Please make sure there are no special characters, and the student number or 9 digits long.");// throws exception if clause isn't met
		}
		else
		{
			this.studentNumber = studentNumber;
		}	
	}
	/**
	 * The getter created for the phoneNumber variable.
	 * @return 	phoneNumber
	 * <br> 	Returns the information stored in the phoneNumber variable.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * This method sets the information into the phoneNumber variable using information received 
	 * from the SchoolSystem class.
	 * <p><font color = "green">
	 * The phoneNumber variable will not accept any input that includes anything except numbers.
	 * It must also be 10 digits long.
	 * <p><font color = "black">
	 * @param 	phoneNumber
	 * <br>		The phoneNumber inputed by the user which will be used to create the new phoneNumber variable.
	 * @throws 	InvalidInputException
	 * <br>		Throws an invalid input exception if the entered information does not match the required format. 
	 */
	public void setPhoneNumber(String phoneNumber) throws InvalidInputException {
		phoneNumber = phoneNumber.replaceAll(" ", "");
		if (!phoneNumber.matches("[\\d]*") || phoneNumber.length() != 10)// ensures phone number is 10 digits long and only digits
		{
			throw new InvalidInputException("Not a valid phone number. Please make sure there are no special characters, and the phone number is 10 digits long.");// throws exception if clause isn't met
		}
		else
		{
			this.phoneNumber = phoneNumber;
		}	
	}
	/**
	 * This method is a custom toString that will change a student to a string, with all the information in the desired order.
	 * <p><font color = "green">
	 * This method will take all the variables that are part of the student variable and save them in 
	 * the order which will be printed onto the file.<br>
	 * This will help the programmer ensure that they know where each part of the student is.
	 * <p><font color = "black">
	 * @return 	printStudent
	 * <br>		The string which will be returned, containing all the information of one student.
	 */
	public String toString() {
		Address studentAddress = this.getAddress();
		String [] classes = this.getClasses();
		String printStudent = (getFirstName() + ";" + getMiddleInitials() + ";" + getLastName() + ";" + getEmail() + ";" + getStudentNumber()+ ";" + getPhoneNumber() + ";" + getGrade() + ";");
		for(int i = 0; i < classes.length; i++)
		{
			printStudent = printStudent + classes[i] + "#";
		}
		printStudent = printStudent + ";" + studentAddress.getStreetAddress() + ";" + studentAddress.getCity() + ";" + studentAddress.getProvince() + ";" + studentAddress.getPostalCode();
		return printStudent;
	}
	/**
	 * This method is a custom compareTo that will compare the student number of one student to another.
	 * <p><font color = "green">
	 * This method will compare the student number of the current student with the student number of
	 * the student sent to the method.
	 * <br> 
	 * It will then return an int value which will be 0 if they are the same, less than one if 
	 * the current student number is less than the one of the student sent to the method,
	 * or greater than one if the current student number is greater than the one of the student
	 * sent to the method.
	 * <p><font color = "black">
	 * @param	student
	 * <br> 	The student that is sent from the main school system
	 * @return	answer
	 * <br> 	The integer value that is received from the compareTo method and returned to the school system.
	 */
	@Override
	public int compareTo(Student student) {
		int answer = this.getStudentNumber().compareToIgnoreCase(student.getStudentNumber());//compares the two student numbers
		return answer;
	}
}
