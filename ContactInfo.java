/* By: Jack Finamore
 * Class Name: ContactInfo
 * Purpose: The purpose of this class is to take the information from the Business Card Parser class
 * and store it in a object that has the users contact info(name, phone number, and email). 
 * 
 */
public class ContactInfo 
{
	//All variables that are private to this class
	private String name; //Holds the persons name
	private String phoneNumber; //Holds the persons phone number
	private String emailAddress; //Holds the persons email address
	
	//Constructor method for ContactInfo class
	public ContactInfo(String inputName, String inputPhoneNum, String inputEmailAdd) 
	{
		name = inputName;
		phoneNumber = inputPhoneNum;
		emailAddress = inputEmailAdd;
	}
	
	//This method returns the name to an instance of the class
	public String getName() {
		
		return name;
	}
	
	//This method returns the phone number to an instance of the class
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	//This method returns the email address to an instance of the class
	public String getEmailAddress() {
		return emailAddress;
	}

}
