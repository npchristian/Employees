import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;	//Import java utilities as necessary

public class Driver
{
	public static void main (String args[]){
		
		Scanner sc = new Scanner(System.in);										//scanner for user input
		
		int choice, count, count2;													//these integers are used to make choices and count loops
		int num_employees, num_manager, num_senior, num_pharmacists, num_techs;		//these integers are used to count how many employees and of what type
		int columns=4;																//number of columns in the text file
		double hours=-1;															//number of hours worked initalized at -1
				
		String count_employees;														//this string is used to do an initial read and count how many employees
		String [] store_columns = new String[columns];								//used to tokenize each line into different categories (first name, last name, etc.)
		
		num_employees=num_manager=num_senior=num_pharmacists=num_techs=0;			//initialize to zero to avoid error/warning that they may not be initialized
		
		try{																		//read file once to count number of employees and number of each role
			InputStream inputStream = new FileInputStream("employees.txt");
			InputStreamReader reader = new InputStreamReader(inputStream);
			BufferedReader buffer = new BufferedReader(reader);						//buffer/reader for initial read. 		

			buffer.readLine();														//Consumes initial header(name, job id, etc.)).
			count_employees=buffer.readLine();
			
			for (num_employees=0; count_employees != null; num_employees++){		//count how many employees and store in num_employees
				StringTokenizer st = new StringTokenizer(count_employees, ",");		//Seperate the columns by commas
				count_employees=buffer.readLine();									//read first employee and store in string
				switch (Integer.valueOf(st.nextToken()))							//read the first letter/integer (the role of the employee)
				{
					case 1:
						num_manager++;												//if the role is 1, increment the number of managers
					break;
					case 2:
						num_pharmacists++;											//if the role is 2 increment the number of pharmacists
					break;
					case 3:
						num_techs++;												//if the role is 3 increment the number of technicians
					break;
					case 4:
						num_senior++;												//if the role is 4 increment the number of seniors
					break;															
				}
			}
			buffer.close();
		}
		catch(IOException ex){			
			System.err.println(ex);	}												//exception for file not read/found
			
		String [] next_employee = new String[num_employees];						//create an array of strings to store the employee data
		Pharmacy_manager [] manager = new Pharmacy_manager[num_manager];			//create an array of Pharmacy Managers based on the number found above
		Staff_pharmacist [] pharmacist = new Staff_pharmacist[num_pharmacists];		//create an array of pharmacists based on the number found above
		Staff_technician [] technician = new Staff_technician[num_techs];			//create an array of technicians based on the number found above
		Senior_technician [] senior =  new Senior_technician[num_senior];			//create an array of seniors based on the number found above
		
		System.out.println("Welcome CSCI 240 Assignment 5!");
		System.out.println("Please make a selection.");
		System.out.println("\n1. Load Employees (From File)");
		System.out.println("2. Exit Program");										//print menu and prompt user to select an option

		choice =sc.nextInt();														//read the user's choice
		
		while (choice !=1 && choice !=2)
		{
			System.out.println("Error: Restrict input to options 1 or 2.");
			System.out.print("Please make your next selection: ");
			choice =sc.nextInt();													//if they did not select 1 or 2, print the warning and read again
		}
		if (choice==2)
		{
			System.out.println("Goodbye!");
			System.exit(0);															//exit if they choose option 2
		}

		try{																		
			InputStream inputStream2 = new FileInputStream("employees.txt");
			InputStreamReader reader2 = new InputStreamReader(inputStream2);
			BufferedReader buffer2 = new BufferedReader(reader2);					//when user selects 1, read the file again

			buffer2.readLine();														//this consumes the initial header(name, job id, etc.))

			for (count=0; count<num_employees; count++)
			{
				next_employee[count]=buffer2.readLine();							//read the first line and store as the next employee
				StringTokenizer st2=new StringTokenizer(next_employee[count], ",");	//seperate columns by commas
				
				for (count2=0;st2.hasMoreTokens(); count2++)
					store_columns[count2]=st2.nextToken();							//store each column into an array of strings called store_columns
				
				switch (Integer.valueOf(store_columns[0])) {
					case 1:{
						num_manager--;
						manager[num_manager] = new Pharmacy_manager(store_columns);	}	//if the role is 1, store as a manager object until all managers have been stored
					break;
					case 2:{
						num_pharmacists--;
						pharmacist[num_pharmacists] = new Staff_pharmacist(store_columns);}	//if the role is 2 store as a pharmacist object until all pharmacists have been stored
					break;
					case 3:{
						num_techs--;
						technician[num_techs] = new Staff_technician(store_columns);}	//if the role is 3, store as a technician until all techs have been stored
					break;
					case 4:{
						num_senior--;
						senior[num_senior] = new Senior_technician(store_columns);}		//if the role is 4 store as a senior until all seniors have been stored. 
					break;
					default:
						System.out.println("Error: unknown job ID/Role detected at line" + count2);
					break;}
			}
			System.out.println("Employee information succesffuly read from employees.txt\n");
		}
		catch(IOException ex){			
			System.err.println(ex);	}													//exception for file not read/found
		
		while (choice !=4)
		{
			System.out.println("1. Print Employee Information");
			System.out.println("2. Enter Hours Worked");
			System.out.println("3. Calculate Paychecks");
			System.out.println("4. Exit Program");
			System.out.print("Please make your next selection: ");					//prints the menu option and prompts user choice
			choice =sc.nextInt();
			
			while (choice >4 || choice <1)
			{
				System.out.println("Error: Restrict input to options 1, 2, 3, or 4.");
				System.out.print("Please make your next selection: ");
				choice=sc.nextInt();												//if user selects an invalid option, print the error and read the choice again
			}
			while (choice==3 && hours==-1)
			{
				System.out.println("Enter hours worked (option 2) before calculating paychecks.");
				System.out.print("Please make your next selection: ");
				choice =sc.nextInt();
			}																		//if user selects option 3 before option 2 print the error.
			switch (choice){
				case 1:{
					for (count=0; count<num_employees/4; count++)
					{
						manager[count].print_data();
						pharmacist[count].print_data();
						technician[count].print_data();
						senior[count].print_data();
					}																//print the user-data 
				}
				break;
				case 2:{
					System.out.println("Please enter the hours worked: ");
					hours=sc.nextDouble();											//read the hours worked
					if (hours<0)
					{
						System.out.println("Error: Hours worked cannot be negative. Try again: ");
						hours=sc.nextDouble();										//prevents user from entering negative hours worked. 
					}

				}
				break;
				case 3:{
					for (count=0; count<num_employees/4; count++)
					{
						manager[count].print_pay(hours);
						pharmacist[count].print_pay(hours);
						technician[count].print_pay(hours);
						senior[count].print_pay(hours);
					}
				}
				break;
			}
		}
		System.out.println("Goodbye!");
	}
}