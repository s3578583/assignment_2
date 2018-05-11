import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import java.util.Date;

public class CasualStaff extends AbstractRMITStaff
{

	public CasualStaff(String staffID, String firstName, String lastName, String address, String email, String phone,
			int tfn)
	{
		super(staffID, firstName, lastName, address, email, phone, tfn);

	}

	public void resumeUpload()

	{

	}

	public void viewProfile(String userID)
	{
		String fileName = "C://Users//Olly//eclipse-workspace//Software Assignment 1//src//casualStaffDetails.txt";
		try
		{
			// file reader to read the fileName variable above
			FileReader filereader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(filereader);
			// variable for lines in the file
			String lineInput;

			List<String> list = new ArrayList<String>();
			// read through document while there is a new line in the file
			while ((lineInput = bufferedReader.readLine()) != null)
			{
				list.add(lineInput);
				// array to split text on line to get user name and password
				String[] checkCredentials = lineInput.split(" }");
				String[] staffDetails = checkCredentials[0].split(",");

				// condition to check if user exists in the file

				if (staffDetails[0].equals("{" + userID))
				{
					for (int i = 0; i < staffDetails.length; i++)
					{
						staffDetails[i] = staffDetails[i].replaceAll("[\\[\\](){}]", "");

					}
					System.out.println("Staff id:" + staffDetails[0] + "\nFull Name:" + staffDetails[1]
							+ staffDetails[2] + "\nAddress:" + staffDetails[3] + "\nEmail:" + staffDetails[4]
							+ "\nPhone Number:" + staffDetails[5] + "\nTax File Number:" + staffDetails[6]);

				}
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
