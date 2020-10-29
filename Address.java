package joshi.schoolSystem;
/** Address Class
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
public class Address {
	private String streetAddress, city, province;
	private String postalCode;
	/**
	 * Empty Address Constructor.
	 */
	public Address ()
	{
		
	}
	/**
	 * The super constructor of the object type "Address".
	 * <p>
	 * This method will receive 4 different variables from the School System class
	 * and will set the information into its variables using the received information.
	 * <p>
	 * @param 	streetAddress1
	 * <br>		The inputed street address which will be used to set the value of the streetAddress variable.
	 * @param 	city1
	 * <br>		The inputed city which will be used to set the value of the city variable.
	 * @param 	province1
	 * <br>		The inputed province which will be used to set the value of the province variable.
	 * @param 	postalCode1
	 * <br>		The inputed postal Code which will be used to set the value of the postalCode variable.
	 * @throws 	InvalidInputException
	 * <br> 	Throws a invalid input exception if the entered information does not match the required format.
	 */
	public Address (String streetAddress1, String city1, String province1, String postalCode1) throws InvalidInputException
	{
		super();
		this.setStreetAddress(streetAddress1);
		this.setCity(city1);
		this.setProvince(province1);
		this.setPostalCode(postalCode1);
	}
	/**
	 * The getter created for the streetAddress variable.
	 * @return 	streetAddress
	 * <br> 	Returns the information stored in the streetAddress variable.
	 */
	public String getStreetAddress() {
		return streetAddress;
	}
	/**
	 * This method sets the information into the streetAddress variable using information received 
	 * from the SchoolSystem class.
	 * <p><font color = "green">
	 * The street address variable will not accept any input that includes punctuation in it.
	 * <p><font color = "black">
	 * @param 	streetAddress
	 * <br>		The streetAddress inputed by the user which will be used to create the new streetAddress variable.
	 * @throws 	InvalidInputException
	 * <br>		Throws an invalid input exception if the entered information does not match the required format. 
	 */
	public void setStreetAddress(String streetAddress) throws InvalidInputException {
		if (streetAddress.matches("[\\p{Punct}]*"))//checks if there is any punctuation in the inputed information
		{
			throw new InvalidInputException("Not a valid street address name. Please make sure there are no special characters.");// throws an exception if the inputed value has punctuation in it
		}
		else
		{
			this.streetAddress = streetAddress;// sets the information to the streetAddress variable if no exceptions are thrown
		}	
	}
	/**
	 * The getter created for the city variable.
	 * @return	city
	 * <br>		Returns the information stored in the city variable.
	 */
	public String getCity() {
		return city;
	}
	/**
	 * This method sets the information into the city variable using information received 
	 * from the SchoolSystem class.
	 * <p><font color = "green">
	 * The city variable will only accept input that consists of only letters.
	 * <p><font color = "black">
	 * @param 	city
	 * <br>		The city inputed by the user which will be used to create the new city variable.
	 * @throws 	InvalidInputException
	 * <br>		Throws an invalid input exception if the entered information does not match the required format. 
	 */
	public void setCity(String city) throws InvalidInputException {
		city = city.replaceAll(" ", "");// removes any spaces in the inputed word
		if (!city.matches("[a-zA-Z]*"))// checks for any input that is not a letter
		{
			throw new InvalidInputException("Not a valid city name. Please make sure there are no spaces or special characters.");// throws an exception if a non-letter is inputed
		}
		else	
		{
			this.city = city;// sets the information to the city variable if no exceptions are thrown
		}
	}
	/**
	 * The getter for the province variable.
	 * @return 	province
	 * <br>		Returns the information stored in the province variable
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * This method sets the information into the province variable using information received 
	 * from the SchoolSystem class.
	 * <p><font color = "green">
	 * The province variable will only accept input that consists of only letters.
	 * <p><font color = "black">
	 * @param 	province
	 * <br>		The province inputed by the user which will be used to create the new province variable.
	 * @throws 	InvalidInputException
	 * <br>		Throws an invalid input exception if the entered information does not match the required format. 
	 */
	public void setProvince(String province) throws InvalidInputException{
		province = province.replaceAll(" ", "");// removes any spaces in the inputed word
		if (!province.matches("[a-zA-Z]*"))// checks for any input that is not a letter
		{
			throw new InvalidInputException("Not a valid province name. Please make sure there are no spaces or special characters.");// throws an exception if a non-letter is inputed
		}
		else
		{
			this.province = province;// sets the information to the city variable if no exceptions are thrown
		}
	}
	/**
	 * The getter for the postalCode variable.
	 * @return 	postalCode
	 * <br>		Returns the information stored in the postalCode variable.
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * This method sets the information into the postalCode variable using information received 
	 * from the SchoolSystem class.
	 * <p><font color = "green">
	 * The postalCode variable will only accept input that consists of letters and numbers, and
	 * they must follow a specific pattern. It must also be 6 characters long.
	 * <br>
	 * The postal code must be entered in the order "Letter, Number, Letter, Number, Letter, Number".
	 * <p><font color = "black">
	 * @param 	postalCode
	 * <br>		The postal code inputed by the user which will be used to create the new postalCode variable.
	 * @throws 	InvalidInputException
	 * <br>		Throws an invalid input exception if the entered information does not match the required format. 
	 */
	public void setPostalCode(String postalCode)throws InvalidInputException {
		postalCode = postalCode.replaceAll(" ", "");// removes any spaces in the inputed word

		if (postalCode.length() == 6)// ensures that the length of the postal code is correct
		{
			if (Character.isLetter(postalCode.charAt(0)))//next 6 if statements ensure that characters are in the correct order
			{
				if (Character.isDigit(postalCode.charAt(1)))
				{
					if (Character.isLetter(postalCode.charAt(2)))
					{
						if (Character.isDigit(postalCode.charAt(3)))
						{
							if (Character.isLetter(postalCode.charAt(4)))
							{
								if (Character.isDigit(postalCode.charAt(5)))
								{
									this.postalCode = postalCode;// sets the information to the postalCode variable if no exceptions are thrown
								}
								else
								{
									throw new InvalidInputException("Not a valid postal code.");// throws an exception if any of the conditions are not true
								}
							}
							else
							{
								throw new InvalidInputException("Not a valid postal code.");
							}
						}
						else 
						{
							throw new InvalidInputException("Not a valid postal code.");
						}	
					}
					else
					{
						throw new InvalidInputException("Not a valid postal code.");
					}
				}
				else
				{
					throw new InvalidInputException("Not a valid postal code.");
				}
			}
			else
			{
				throw new InvalidInputException("Not a valid postal code.");
			}
		}
		else
		{
			throw new InvalidInputException("Not a valid postal code.");
		}
	}

}
