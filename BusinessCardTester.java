/* By: Jack Finamore
 * Class Name: BusinessCardTester
 * Purpose: The purpose of this class is to implement the BusinessCardParser
 * and ContactInfo java classes. 
 * 
 * Input statements for the different Java libraries used.
 */
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class BusinessCardTester 
{
	public static void main(String[] args) throws IOException, FileNotFoundException
	{ 
		//Declaring all variables to be used within this class
		Scanner console = new Scanner(System.in); //Reads in input from the console
		String fileName; //String variable that holds the filename
		//Welcome menu for the Business Card Parser Program
		System.out.println("Welcome to the Business Card Parser Program.");
		System.out.println("Please enter the name of the file you'd like to read data from(in the form of 'OCRData.txt'): ");
		fileName = console.next(); //input line
		
		System.out.println("Thank you for the file name!");
		BusinessCardParser cardParser = new BusinessCardParser();//Creation of BusinessCardParser class object
		cardParser.getContactInfo(fileName);//returns the correct information in the proper format
	}
	
}
