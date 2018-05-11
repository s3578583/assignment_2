import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestHRDriver
{

	public static void main(String[] args)
	{
		// login boolean value
		boolean login = false;
		do
		{
			// scanner to get user input

			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.print("Please enter your username:");
			// variable for user name
			String userName = input.nextLine();
			System.out.print("Please enter your password:");
			// variable for password
			String password = input.nextLine();
			String typeOfUser = "";
			String employeeID = "";
			// variable for file location
			// please change the path to your specific path of the users.txt file
			String fileName = "C://Users//Olly//eclipse-workspace//Software Assignment 1//src//users.txt";

			try
			{
				// file reader to read the fileName variable above
				FileReader filereader = new FileReader(fileName);

				BufferedReader bufferedReader = new BufferedReader(filereader);
				// variable for lines in the file
				String lineInput;
				// set user to null once they have logged out
				String user = null;
				// set password to null once they have logged out
				String pass = null;

				List<String> list = new ArrayList<String>();
				// read through document while there is a new line in the file
				while ((lineInput = bufferedReader.readLine()) != null)
				{
					list.add(lineInput);
					// array to split text on line to get user name and password
					String[] checkCredentials = lineInput.split(" ");
					user = checkCredentials[0];
					pass = checkCredentials[1];

					// condition to check if user exists in the file
					if (userName.equals(user) && password.equals(pass))
					{
						System.out.println("Successfully logged in as: " + user);
						typeOfUser = checkCredentials[2];
						employeeID = checkCredentials[3];
						login = true;
						break;
					}

				}
				// not equal condition to display message to user
				if (!userName.equals(user) && !password.equals(pass))
				{
					System.out.println("\nIncorrect password for " + userName + " user please try again");

				}
				// close buffered reader
				bufferedReader.close();

				// catch exception if file not found
			} catch (FileNotFoundException ex)
			{
				System.out.println("Unable to open file '" + fileName + "'");
			}
			// catch exception if IOException
			catch (IOException ex)
			{
				System.out.println("Error reading file '" + fileName + "'");

			}
			// variable to get user selection
			int selection;

			// menu options for an admin user
			if (typeOfUser.equals("admin") && login == true)
			{
				do
				{
					System.out.println("\nPlease enter your selection:");
					System.out.println("1 - Add new Staff member:");
					System.out.println("2 - Add staff hours:");
					System.out.println("3 - Add new Course:");
					System.out.println("4 - View Course Details:");
					System.out.println("\n0 - Logout");
					selection = input.nextInt();

					// switch, depending on option do certain action
					switch (selection)
					{

					case 1:
						// if a 1, add new admin object.
						Admin a1 = new Admin("ad001", "dave", "english", "1 lake street", "dave@gmail.com",
								"0400000000", 1111111);
						// use admin object to call on admin only tasks
						// call hirestaff from the admin class
						a1.hireStaff();

						break;

					case 2:
						System.out.print("Enter staff ID: ");
						// variable for staff id
						String staffID = input.next();
						// if a 1, add new payroll object.
						Payroll pay1 = new Payroll(staffID, null, null, null, 0);
						// call on add hours method
						pay1.addHours();
						// print out result
						System.out.println(pay1);
						break;

					case 3:
						Course c1 = new Course("", "", 0, 0);
						c1.createCourse();
						break;
					case 4:
						Course c2 = new Course("", "", 0, 0);
						c2.viewCourseDetails();
						break;

					case 0:
						// logout the user and result values
						userName = null;
						password = null;
						System.out.print("You have been logged out\n");
						// set variable to logout
						login = false;
					}

				} while (selection != 0);
			}
			else if (typeOfUser.equals("course") && login == true)
			{

				do
				{
					System.out.println("\n1 - Create new Course");
					System.out.println("\n2 - Advertise new Job");
					System.out.println("\n3 - View Job Applications");
					System.out.println("\n4 - View Casual Staff's Timetable");
					System.out.println("\n5 - Approve or Reject Applications");
					System.out.println("\n6 - View Approvals Decisions");
					System.out.println("\n0 - Quit");
					selection = input.nextInt();
					@SuppressWarnings("resource")
					Scanner scan = new Scanner(System.in);
					switch (selection)
					{

					case 1:
						Course c1 = new Course("", "", 0, 0);
						c1.createCourse();
						break;
						
					case 2:
						Job j1 = new Job("", "", "", "");
						j1.advertise();
						break;

					case 3:
						Application viewApp = new Application(null, "", false);
						System.out.println("Please enter Job ID applications to search for.");
						String searchApp = scan.nextLine();
						viewApp.checkJobExists(searchApp);
						viewApp.viewApplications(searchApp);
						break;
					
					case 4:
						Timetable t1 = new Timetable("","","","");
						System.out.println("Please enter the staff id to view their timetable");
						String searchRecord = scan.nextLine();
						t1.casualStaffTimeTable(searchRecord);
						break;
					
					case 5:
						Application approve = new Application(null, "", false);
						System.out.println("Please enter the Job ID to assign your decision on applications");
						String jobApproveApp = scan.nextLine();
						
						System.out.println("Please enter the staff id approve/reject their application");
						String approveApp = scan.nextLine();
						approve.submitApplication(jobApproveApp,approveApp,0);
						break;
					
					case 6:
						Application approved = new Application(null, "", false);
						
						String approvedStatus = "print";
						String employeeIDDetails = "show";
						approved.viewApplicationStatus(approvedStatus,employeeIDDetails);
						break;

					case 0:
						// logout the user and result values
						userName = null;
						password = null;
						System.out.print("You have been logged out\n");
						// set variable to logout
						login = false;

					}

				} while (selection != 0);
			}

			else if (typeOfUser.equals("casual") && login == true)
			{
				@SuppressWarnings("resource")
				Scanner scan = new Scanner(System.in);
				do
				{
					System.out.println("\n1 - View available Jobs");
					System.out.println("\n2 - Apply for Job");
					System.out.println("\n3 - View Application Status");
					System.out.println("\n4 - View Profile");
					
					System.out.println("\n0 - Quit");
					selection = input.nextInt();
					switch (selection)
					{

					case 1:
						Job view = new Job("", "", "", "");
						view.printJobList();

						break;
					case 2:
						Application app1 = new Application(null, "", false);
						app1.lodgeApplication(employeeID);

						break;
					case 3:
						Application status = new Application(null, "", false);
						System.out.print("Please enter Job ID to search:");
						String jobIDStatus = scan.nextLine();
						status.checkJobExists(jobIDStatus);
						status.viewApplicationStatus(jobIDStatus,employeeID);

						break;
					case 4:
						CasualStaff cs1 = new CasualStaff("", "", "", "", "", "", 0);
						cs1.viewProfile(employeeID);

						break;

					case 0:
						// logout the user and result values
						userName = null;
						password = null;
						System.out.print("You have been logged out\n");
						// set variable to logout
						login = false;

					}

				} while (selection != 0);
			}
			else if (typeOfUser.equals("approval") && login == true)
			{

				do
				{
					System.out.println("\n1 - View job applications");
					System.out.println("\n2 - View Staff Timetable");
					System.out.println("\n3 - Approve or Deny Application Request");
					System.out.println("\n0 - Quit");
					selection = input.nextInt();
					@SuppressWarnings("resource")
					Scanner scan = new Scanner(System.in);
					switch (selection)
					{

					case 1:
						Course viewApp = new Course("", "", 0, 0);
						
						System.out.println("Please review the following applications for approval.");
						viewApp.viewApplications();

						break;
					case 2:
						Timetable t1 = new Timetable("","","","");
						System.out.println("Please enter the staff id to view their timetable");
						String searchRecord = scan.nextLine();
						t1.casualStaffTimeTable(searchRecord);
						break;
						
					case 3:
						Application result = new Application(null, "", false);
						System.out.println("Please enter Job ID to approve/deny.");
						String jobID = scan.nextLine();
						result.checkJobExists(jobID);
						System.out.println("Please enter staff ID to approve/deny.");
						String staffID = scan.nextLine();
						result.checkApplicationExists(jobID,staffID,1);
						result.submitApplication(jobID,staffID,1);
						//result.viewApplications();

						break;

					case 0:
						// logout the user and result values
						userName = null;
						password = null;
						System.out.print("You have been logged out\n");
						// set variable to logout
						login = false;
					}
				} while (selection != 0);
			}
		} while (login == false);

	}

}
