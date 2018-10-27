/* By: Jack Finamore
 * Class Name: BusinessCardParser
 * Purpose: The purpose of this class is to take a file and parse out specific information,
 * specifically the name, phone number, and email of the card.
 * 
 *Input statements for all Java libraries used
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class BusinessCardParser 
{
	//Variables private to the BusinessCardParser 
	private static ContactInfo personContactInfo; //Holds the contact info from the business card
	private static ArrayList<String> businessCardInfo;//Holds any information within the txt file
	private static Scanner fileInput;//Scanner object that reads in data from the txt file
	private static File OCRDataFile; //File object that holds the OCR Data
	private static int emailLineLocation;//Variable that holds the spot within the ArrayList that has the email
	private static int phoneNumLineLocation;//Variable that holds the spot within the ArrayList that has the phone number
	private static int nameLineLocation;//Variable that holds the spot within the ArrayList that has the name
	
	//Constructor for BusinessCardParser class
	public BusinessCardParser()
	{
		businessCardInfo = new ArrayList<String>();
	}
	
	//This method calls the private methods that gets the specific contact information from the OCR Data
	public void getContactInfo(String document) throws FileNotFoundException
	{
		OCRDataFile = new File(document);
		fileInput = new Scanner(OCRDataFile);
		while(fileInput.hasNextLine())  //This loops reads in the data from the file
		{
			 businessCardInfo.add(fileInput.nextLine());
		}
		
		for(int i = 0; i < businessCardInfo.size();i++) //This loop finds the email within the array list
		{
			if(emailAddressFinder(businessCardInfo.get(i)))
			{
				emailLineLocation = i;
				i = businessCardInfo.size();;
			}
		}
		
		for(int i = 0; i < businessCardInfo.size();i++) //This loop finds the phone number within the array list
		{
			if(phoneNumberFinder(businessCardInfo.get(i)))
			{
				phoneNumLineLocation = i;
				i = businessCardInfo.size();;
			}
		}
		
		for(int i = 0; i < businessCardInfo.size();i++) //This loop finds the name located within the array list
		{
			if(nameFinder(businessCardInfo.get(i), businessCardInfo.get(emailLineLocation)))
			{
				nameLineLocation = i;
				i = businessCardInfo.size();;
			}
		}
		
		//These next two lines creates the person's ContactInfo object and then prints it out
		personContactInfo = new ContactInfo(businessCardInfo.get(nameLineLocation),numberFormatter(businessCardInfo.get(phoneNumLineLocation)), businessCardInfo.get(emailLineLocation));
		printContactInfo();
	}
	
	//This method prints out the name, phone and email in a formatted manner.
	public void printContactInfo()
	{
		System.out.println("Printing Business Card Info:");
		System.out.println("Name:  " + personContactInfo.getName());
		System.out.println("Phone: " + personContactInfo.getPhoneNumber());
		System.out.println("Email: " + personContactInfo.getEmailAddress());
		
	}

	//This method returns true or false depending on the line holds the email address
	private boolean emailAddressFinder(String value) 
	{
		//I determined the email address by using the @ symbol which typically
		//would only be found within the email address
		if(value.contains("@")) { return true; }
		return false;
	}
	
	//This method returns true or false depending on if the line holds the phone number
	private boolean phoneNumberFinder(String value) 
	{
		value = value.toLowerCase();
		/* These are the most popular cases I could find on business cards that would 
		 * most likely trigger the contains() method. Most business, person, or email addresses
		 * shouldn't contain these cases so it should be pretty reliable.   
		 */
		if(value.contains("(")){ return true; }
		if(value.contains("tel:")) { return true; }
		if(value.contains("phone:")) { return true; }
		if(value.contains("+1")) { return true; }
		if(value.contains("-")) { return true; }
		return false;
	}
	
	//This method returns true or false if the name is contained within the email. 
	private boolean nameFinder(String lineDeterminer, String email) 
	{
		//This method determines whether the line contains the name by using the email determined previously. 
		String part2OfName = lineDeterminer.substring(lineDeterminer.indexOf(" ")+1);
		part2OfName = part2OfName.toLowerCase();
		part2OfName = part2OfName.trim();
		if(email.contains(part2OfName)) { return true;}
		return false;
	}
	
	//This method takes the OCR data for the phone number and puts it into only the raw digits
	public static String numberFormatter(String phoneNumber)
	{
		String unformattedNumber = "";
		String regex = "[0-9]+";
		String tempLetterHolder = "";
		for(int i = 0; i < phoneNumber.length(); i++)
		{
			tempLetterHolder = phoneNumber.substring(i,i+1);
			if(tempLetterHolder.matches(regex)) 
			{
				unformattedNumber += phoneNumber.substring(i,i+1);
			}
		}
		return unformattedNumber;
	}

}
