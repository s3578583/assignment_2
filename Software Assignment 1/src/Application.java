import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Application
{
	private Date date;
	private String jobID;
	private boolean exist = false;
	private boolean result;

	public Application(Date date, String jobID, boolean result)
	{

		this.date = date;
		this.jobID = jobID;
		this.result = result;
	}

	public String getJobID()
	{
		return jobID;
	}

	public Date getDate()
	{
		return date;
	}

	public boolean isResult()
	{
		return result;
	}

	public void notifyApplicant(String jobID,String staffID,Date date, boolean result)
	{
		
			try
			{
				writeUsingFileWriterForApplication( jobID,  staffID, date,  result);
			} catch (FileNotFoundException e)
			{
				
				e.printStackTrace();
			}
			
		
			
		
	}
	public void submitApplication(String jobApproveApp, String approveApp, int number)
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		checkJobExists(jobApproveApp);
		date = new Date();
			if(exist == true) {
				
				System.out.print("Enter result for this application (Yes/No):");
				String answer  = scan.nextLine();
				if (answer.equalsIgnoreCase("yes"))
				{
					result = true;
					System.out.print(number);	
				if(number == 0) {
					try
					{
						writeUsingFileWriter( jobApproveApp, approveApp,date);
						System.out.print("The application has been forwarded for Approval");
					} catch (FileNotFoundException e)
					{
						
						e.printStackTrace();
					}
				}
				
				else if(number == 1)
				{
					System.out.print("Hello");
					notifyApplicant(jobApproveApp, approveApp,date,result);
					System.out.print("The applicant has been notified they were successful");
				}
				}	
				else {
					result = false;
					notifyApplicant(jobApproveApp, approveApp,date,result);
					System.out.print("The applicant has been notified they were not successful");
					
				}
			
			}
		
		
		
	}
	public void lodgeApplication(String userID)
	{

		date = new Date();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter jobID to apply for:");
		jobID = scan.nextLine();
		checkJobExists(jobID);

		if (exist == true)
		{
			try
			{
				writeUsingFileWriter( jobID, userID,date);
				System.out.println("Application successfully lodged!");
				exist = false;
			} catch (FileNotFoundException e)
			{

				e.printStackTrace();
			}
		}
	}

	public void writeUsingFileWriter(String jobID, String userID,Date date) throws FileNotFoundException
	{
			String filePath = "";
			
			if(result == false)
				filePath = "/Users/Olly/eclipse-workspace/Software Assignment 1/src/application.txt";
			else
				filePath = "/Users/Olly/eclipse-workspace/Software Assignment 1/src/approvedApplication.txt";
			
			File created = new File(filePath);
	
		try
		{
			if (created.exists() == false)
			{
				System.out.println("We had to make a new file.");
				created.createNewFile();
			}
			PrintWriter out = new PrintWriter(new FileWriter(created, true));

			out.append("{"+jobID + ","+ userID + ","+ date +  ",}\n");
			out.close();
		} catch (IOException e)
		{
			System.out.println("COULD NOT ADD RECORD!!");
		}

	}

	public void checkJobExists(String checkJob)
	{

		String fileName = "C://Users//Olly//eclipse-workspace//Software Assignment 1//src//job.txt";
		try
		{
			// file reader to read the fileName variable above
			FileReader filereader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(filereader);
			// variable for lines in the file
			String lineInput;

			jobID = null;

			List<String> list = new ArrayList<String>();
			// read through document while there is a new line in the file
			while ((lineInput = bufferedReader.readLine()) != null)
			{
				list.add(lineInput);
				// array to split text on line to get user name and password
				String[] checkCredentials = lineInput.split(" ");
				String[] jobSearch = checkCredentials[0].split(",");
				jobID = jobSearch[0].replace("{", "");
				if (jobID.equals(checkJob))
				{
					exist = true;
					break;

				}

				// condition to check if user exists in the file

			}
			if (!jobID.equals(checkJob))
			{
				System.out.println("Sorry, please enter a correct job ID!!");

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
	public void viewApplications(String JobID)
	{

		String fileName = "C://Users//Olly//eclipse-workspace//Software Assignment 1//src//application.txt";
		if(exist != false) {
		try
		{
			// file reader to read the fileName variable above
			FileReader filereader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(filereader);
			// variable for lines in the file
			String lineInput;

			List<String> list = new ArrayList<String>();
			// read through document while there is a new line in the file
			System.out.println("---------------------------------------------------------------");
			System.out.printf("%10s %10s %30s", "Job ID", "Staff ID", "Date of Application");
		    System.out.println();
		    System.out.println("---------------------------------------------------------------");
			while ((lineInput = bufferedReader.readLine()) != null)
			{
				list.add(lineInput);
				// array to split text on line to get user name and password
				String[] checkCredentials = lineInput.split("/} ");
				String[] appRecord = checkCredentials[0].split(",");
				String jobID2 = appRecord[0].replace("{", "");
				String staffID = appRecord[1];
				String dateOfApp = appRecord[2];
				// condition to check if user exists in the file
				
					
				if(jobID2.equals(JobID)) {
	
				System.out.format("%10s %10s %30s ",
						jobID2, staffID,dateOfApp);
		        System.out.println();
				
				}
		
			
			}
			System.out.println("---------------------------------------------------------------");
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
		else 
			System.out.println("Please enter an existing Job ID!!!");
	}
	
	public void writeUsingFileWriterForApplication(String jobID, String userID,Date date, boolean result) throws FileNotFoundException
	{
			
		
			
			File created = new File("/Users/Olly/eclipse-workspace/Software Assignment 1/src/viewApplicationStatus.txt");
	
		try
		{
			if (created.exists() == false)
			{
				System.out.println("We had to make a new file.");
				created.createNewFile();
			}
			PrintWriter out = new PrintWriter(new FileWriter(created, true));

			out.append("{"+jobID + ","+ userID + ","+ date + "," +result + ",}\n");
			out.close();
		} catch (IOException e)
		{
			System.out.println("COULD NOT ADD RECORD!!");
		}

	}	
	
	public void viewApplicationStatus(String jobID, String employeeID)
	{
		
		String fileName = "C://Users//Olly//eclipse-workspace//Software Assignment 1//src//viewApplicationStatus.txt";
		if(jobID.equals("print")&&employeeID.equals("show"))
			exist = true;
		
		if(exist != false) {
		try
		{
			// file reader to read the fileName variable above
			FileReader filereader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(filereader);
			// variable for lines in the file
			String lineInput;

			List<String> list = new ArrayList<String>();
			// read through document while there is a new line in the file
			if(!jobID.equals("print")&&employeeID.equals("show")) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("%10s %30s %20s", "Job ID", "Date of Application" , "Result:");
		    System.out.println();
		    System.out.println("---------------------------------------------------------------");
			}
			else {
				System.out.println("--------------------------------------------------------------------------");
				System.out.printf("%10s %10s %30s %20s", "Job ID","Staff ID", "Date of Application" , "Result:");
			    System.out.println();
			    System.out.println("--------------------------------------------------------------------------");
			}
			while ((lineInput = bufferedReader.readLine()) != null)
			{
				list.add(lineInput);
				// array to split text on line to get user name and password
				String[] checkCredentials = lineInput.split("/} ");
				String[] appRecord = checkCredentials[0].split(",");
				String jobID2 = appRecord[0].replace("{", "");
				String staffID = appRecord[1];
				String dateOfApp = appRecord[2];
				String appResult = appRecord[3];
				// condition to check if user exists in the file
				if(appResult.equals("false"))
					appResult = "unsuccessful";
				else
					appResult = "successful";
					
				
				if(jobID2.equals(jobID)&& staffID.equals(employeeID)) {
				
				System.out.format("%10s %30s %20s ",
						jobID2,dateOfApp,appResult);
		        System.out.println();
				
				}
				else if(jobID.equals("print")&& employeeID.equals("show")) {
					
					System.out.format("%10s %10s %30s %20s ",
							jobID2,staffID,dateOfApp,appResult);
			        System.out.println();
					
					}

			
			}
			System.out.println();
			System.out.println("--------------------------------------------------------------------------");
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
	
	public void checkApplicationExists(String checkJob, String checkStaffID, int number)
	{

		String fileName = "";
		if (number == 1)
		 fileName = "C://Users//Olly//eclipse-workspace//Software Assignment 1//src//approvedApplication.txt";
		else
		 fileName = "C://Users//Olly//eclipse-workspace//Software Assignment 1//src//viewApplicationStatus.txt";
		if(exist != false) {
		try
		{
			// file reader to read the fileName variable above
			FileReader filereader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(filereader);
			// variable for lines in the file
			String lineInput;

			jobID = null;
			String staffID = null;

			List<String> list = new ArrayList<String>();
			// read through document while there is a new line in the file
			while ((lineInput = bufferedReader.readLine()) != null)
			{
				list.add(lineInput);
				// array to split text on line to get user name and password
				String[] checkCredentials = lineInput.split(" ");
				String[] jobSearch = checkCredentials[0].split(",");
				jobID = jobSearch[0].replace("{", "");
				staffID = jobSearch[1];
				
				if (jobID.equals(checkJob)&&staffID.equals(checkStaffID))
				{
					
					exist = true;
					break;

				}

				// condition to check if user exists in the file

			}
			if (!jobID.equals(checkJob))
			{
				System.out.println("Sorry, no applications results are available yet, please check again later");

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
	
	
	
	
	
	
	
}
