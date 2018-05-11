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

public class Course
{
	private String courseID;
	private String courseName;
	private double courseHours;
	private int staffRequired;

	

	public Course(String courseID, String courseName, double courseHours, int staffRequired)
	{

		this.courseID = courseID;
		this.courseName = courseName;
		this.courseHours = courseHours;
		this.staffRequired = staffRequired;
	}

	public String getCourseID()
	{
		return courseID;
	}

	public String getCourseName()
	{
		return courseName;
	}

	public double getCourseHours()
	{
		return courseHours;
	}

	public void createCourse()
	{
		// inserting new staff details
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter Course ID:");
		courseID = scan.nextLine();
		System.out.println("Enter Course Name:");
		courseName = scan.nextLine();
		courseName = courseName.replace(" ", "_");
		System.out.println("Enter Course Hours Required:");
		courseHours = scan.nextDouble();
		System.out.println("Enter number of Staff Required:");
		staffRequired = scan.nextInt();
		try
		{
			writeUsingFileWriter(courseID, courseName, courseHours, staffRequired);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("New course successfully added");

	}

	public void writeUsingFileWriter(String courseID, String courseName, double courseHours, int courseStaff)
			throws FileNotFoundException
	{
		File created = new File("/Users/Olly/eclipse-workspace/Software Assignment 1/src/course.txt");
		try
		{
			if (created.exists() == false)
			{
				System.out.println("We had to make a new file.");
				created.createNewFile();
			}
			PrintWriter out = new PrintWriter(new FileWriter(created, true));

			out.append(courseID + " " + courseName + " " + courseHours + " " + courseStaff + "\n");
			out.close();
		} catch (IOException e)
		{
			System.out.println("COULD NOT ADD RECORD!!");
		}

	}

	public void viewCourseDetails()
	{

		String fileName = "C://Users//Olly//eclipse-workspace//Software Assignment 1//src//course.txt";
		try
		{
			// file reader to read the fileName variable above
			FileReader filereader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(filereader);
			// variable for lines in the file
			String lineInput;

			String courseID = null;

			String courseName = null;
			String courseHours = null;

			String courseStaff = null;

			List<String> list = new ArrayList<String>();
			// read through document while there is a new line in the file
			System.out.println("-------------------------------------------------------------------------------------");
		    System.out.printf("%10s %30s %20s %10s", "Course ID", "Course Name", "Teaching Hours", "Staff Needed");
		    System.out.println();
		    System.out.println("-------------------------------------------------------------------------------------");
			while ((lineInput = bufferedReader.readLine()) != null)
			{
				list.add(lineInput);
				// array to split text on line to get user name and password
				String[] checkCredentials = lineInput.split(" }");
				String[] individualRecord = checkCredentials[0].split(",");
				courseID = individualRecord[0].replace("{","");
				courseName = individualRecord[1];
				
				courseHours = individualRecord[2];
				courseStaff = individualRecord[3];

				// condition to check if user exists in the file
				 
			
				
					// System.out.println(checkCredentials[0]);
					 
				        System.out.format("%10s %30s %20s %10s  ",
				        		 courseID, courseName, courseHours, courseStaff);
				        System.out.println();
				   
				    /*
				    System.out.println("-----------------------------------------------------------------------------");
				System.out
						.println("Course ID:" + courseID + "\nCourse Name: " + courseName + "\nTeaching Hours Needed: "
								+ courseHours + "\nNumber of Staff Needed: " + courseStaff + "\n");
								*/
			}
			System.out.println("-------------------------------------------------------------------------------------");
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
public void viewApplications() {
		
	String fileName = "C://Users//Olly//eclipse-workspace//Software Assignment 1//src//approvedApplication.txt";
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
		System.out.printf("%10s %10s %40s", "Job ID", "Staff ID", "Date of Application");
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
			

			System.out.format("%10s %10s %40s ",
					jobID2, staffID,dateOfApp);
	        System.out.println();
			
	
		
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


	}

