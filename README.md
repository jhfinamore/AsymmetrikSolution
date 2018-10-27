# AsymmetrikSolution
These java files are a solution to the Business Card OCR problem. 
Solution done by: John Finamore

Steps for running program:
1. Clone github repository. 
2. In a command terminal run navigate to the AsymmetrikSolution repository. 
3. After navigating, type in the terminal java BusinessCardTester. (If you run into a ClassNotFoundException, see steps 8 and onwards)
4. After you type this in the code should appear below, there will be a prompt looking for a file name to import the data. The file can be anywhere in the file system by giving it the location, or you can use the Data.txt file I have provided in the repository and put the information inside there.  
5. The program will then thank you, and then return the name, phone number, and email for that particular business card's OCR data.
6. The program then exits and returns you to the command prompt.
7. You can run the program again by retyping in java BusinessCardTester.
Possible ClassNotFoundException
8. If you run into the error stated above, please make sure you are within the correct folder in your command line. 
9. Retry steps 3-7.
10. If the error persists, you should recompile the BusinessCardTester class by typing javac BusinessCardTester.java, if you get an error that states that the BusinessCardParser class doesn't exist, please type javac ContactInfo.java and then javac BusinessCardParser.java. Followed by javac BusinessCardTester.java
11. Retry steps 3-7 after this.
12. If you have any more errors, please feel free to contact me at jhfinamore@gmail.com and I can try and help you solve them.

Thank you for looking at my program. 
