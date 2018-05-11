import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends AbstractRMITStaff
{
	public Admin(String staffID, String firstName, String lastName, String address, String email, String phone, int tfn)
	{
		super(staffID, firstName, lastName, address, email, phone, tfn);

	}

	private boolean exist = false;
	@SuppressWarnings("resource")
	public void hireStaff()
	{
		
		//inserting new staff details
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter staff ID:");
		String id = scan.nextLine();
		checkExistingStaffID(id);
		if(exist == false) {
		System.out.println("Enter first name:");
		String firstName = scan.nextLine();
		System.out.println("Enter last name:");
		String lastName = scan.nextLine();
		System.out.println("Enter address:");
		String address = scan.nextLine();
		System.out.println("Enter email address:");
		String email = scan.nextLine();

		System.out.println("Enter phone number:");
		String phone = scan.nextLine();

		System.out.println("Enter tax file number:");
		int tfn = scan.nextInt();
		//creates new staff 
		try
		{
			writeUsingFileWriter(id, firstName, lastName, address,email,phone,tfn);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("New staff member successfully added");
		}
	
		
	}


	public void writeUsingFileWriter(String id,String firstName,String lastName,String address,String email,String phone,int tfn)
			throws FileNotFoundException
	{
		File created = new File("/Users/Olly/eclipse-workspace/Software Assignment 1/src/casualStaffDetails.txt");
		try
		{
			if (created.exists() == false)
			{
				System.out.println("We had to make a new file.");
				created.createNewFile();
			}
			PrintWriter out = new PrintWriter(new FileWriter(created, true));

			
			out.append("\n{"+id +","+ firstName +","+ lastName +","+ address +","+ email +","+ phone +","+ tfn +"}");
			out.close();
		} catch (IOException e)
		{
			System.out.println("COULD NOT ADD RECORD!!");
		}

	}

	public void checkExistingStaffID(String checkID)
	{

		String fileName = "C://Users//Olly//eclipse-workspace//Software Assignment 1//src//casualStaffDetails.txt";
		try
		{
			// file reader to read the fileName variable above
			FileReader filereader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(filereader);
			// variable for lines in the file
			String lineInput;

			String staffID = null;

			List<String> list = new ArrayList<String>();
			// read through document while there is a new line in the file
			while ((lineInput = bufferedReader.readLine()) != null)
			{
				list.add(lineInput);
				// array to split text on line to get user name and password
				String[] checkCredentials = lineInput.split("}");
				String[] staffSearch = checkCredentials[0].split(",");
				staffID = staffSearch[0].replace("{", "");
				if (staffID.equals(checkID))
				{
					System.out.println("Cannot create staff member as staff ID already exists");
					exist = true;
					break;

				}

				// condition to check if user exists in the file

			}
		
			// close buffered reader
			bufferedReader.close();
		} catch (FileNotFoundException ex)
		{
			System.out.println("Unable to open file '" + fileName + "'");
		}
		// catch exception if IOException
		catch (IOException ex)
		{
			System.out.println("Error reading file '" + fileName + "'");

		}
	}

}
