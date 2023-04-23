package project1;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class WelcomeScreen {
	
	public static int isdigit()
	{
		int n=0;
		boolean flag;


		do
		{
		  try
		  {
		    Scanner sc = new Scanner(System.in);
		 
		    n=sc.nextInt();
		    flag=false;
		  }
		  catch(Exception e)
		  {
		    // accept integer only.
		    System.out.println("Invalid input. Valid input is digits 1 to 5.");
		    flag=true;
		  }
		}
		while(flag);
		return n;
	}
	
public static void main(String[] args) {
// TODO Auto-generated method stub
String filename;
final String FilePath = "C:\\Simplilearn Full stack Java Developer\\Phase 1\\FileCreation\\";
char ch;
File directory = new 
File(FilePath);
String[] flist = directory.list();
// Take user Option from the below mentioned Menu
Scanner input = new Scanner(System.in);
System.out.println("**********Prototype of Project For Company:Lockers Pvt. Ltd.************");
System.out.println("**********************Simplilearn Phase 1 Project***********************");
System.out.println("**********************Developer Name: Jeevan Salke**********************");
System.out.println("******************Course Name: Full Stack Java Developer****************");
System.out.println();
do {
System.out.println("Select File Option to perform any operation:");
System.out.println("1.List File.");
System.out.println("2.Create File.");
System.out.println("3.Delete File.");
System.out.println("4.Search file.");
System.out.println("5.Exit Application.\n");


int choice = isdigit();//input.nextInt();
if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5)
{
	
	do {
		System.out.println("Your input number is incorrect. Please select option 1 to 5. \n");
		choice = isdigit();
	   }while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5);
}
switch (choice) {
case 2:
// Code to create file start
System.out.println("Enter the file name for creating new file");
filename = input.next();
try {
File file = new 
File(FilePath + filename + ".txt");
if (file.createNewFile()) {
System.out.println("File Created Successfully");
} else {
if (file.exists()) {
System.out.println("File Already Exists");
} else {
System.out.println("File Doesen't exist");
}
}
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
break;
//Code to create file End********************
case 1:
listOfFiles();
break;
case 3:
System.out.println("Enter the file name which you want to delete \n");
filename = input.next();
filename = filename + ".txt";
File directory_delete = new 
File(FilePath);
String[] flist_delete = directory_delete.list();
// String[] flist = directory.list();
int flag_d = 0;
if (flist_delete == null) {
System.out.println("There is no file preseent in the directory \n");
} else {
// Linear search in the array
for (int i = 0; i < flist_delete.length; i++) {
String delete_filename = flist_delete[i];
if 
(delete_filename.equals(filename)) {
File file = new File(FilePath + delete_filename);
if (file.delete()) {
System.out.println("File deleted successfully \n");
} else {
System.out.println("Failed to delete the file \n");
}
flag_d = 1;
}
}
}
if (flag_d == 0) {
System.out.println("File Not Found");
}
break;
case 4:
// Create an object of the File class
// Replace the file path with path of the directory
System.out.println("Enter the file name for searching \n");
filename = input.next();
filename = filename + ".txt";
File directory_search = new 
File(FilePath);
String[] flist_search = directory_search.list();
int flag_s = 0;
if (flist_search == null) {
System.out.println("There is no file preseent in the directory \n");
} else {
// Linear search in the array
for (int i = 0; i < flist_search.length; i++) {
String search_filename = flist_search[i];
if 
(search_filename.equalsIgnoreCase(filename)) {
System.out.println(search_filename + " found");
flag_s = 1;
}
}
}
if (flag_s == 0) {
System.out.println("File Not Found \n");
}
break;
case 5:
System.out.println("Exiting Program. Thank you using program...");	
System.exit(0);
break;
default:
System.out.println("Your input number is incorrect.Choose correct Number \n");
break;
}
System.out.println("Do you want to continue Type (y or n)");
ch = (char)input.next().charAt(0);
if (ch != 'Y' && ch !='y' && ch != 'N' && ch !='n')
{
	
	do {
		System.out.println("Your input is incorrect. Please enter Y/y to continue or N/n to Exit \n");
		ch = (char)input.next().charAt(0);
		
	   }while (ch != 'Y' && ch !='y' && ch != 'N' && ch !='n');

}
if (ch == 'N' || ch =='n')
{
	System.out.println("Exiting Program. Thank you using program...");
}
} while (ch == 'Y' || ch == 'y');
}
// private static void fileSearch() {
// // TODO Auto-generated method stub
//
// }
private static void listOfFiles() {
File fileDir = new File("C:\\Simplilearn Full stack Java Developer\\Phase 1\\FileCreation\\");
if(fileDir.isDirectory() || fileDir.isFile())
{
	List<String> listFile = Arrays.asList(fileDir.list());
	Collections.sort(listFile);
	System.out.println("---------------------------------------");
	System.out.println("Sorting by filename in ascending order");
	for(String s:listFile)
	{
		System.out.println(s);
	}
}
}
}