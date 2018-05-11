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

public class Job
{

	private String jobID;
	private String title;
	private String type;
	private String description;

	public Job(String jobID, String title, String type, String description)
	{
		super();
		this.jobID = jobID;
		this.title = title;
		this.type = type;
		this.description = description;
	}

	public String getJobID()
	{
		return jobID;
	}

	public String getDescription()
	{
		return description;
	}

	public String getTitle()
	{
		return title;
	}

	public String getType()
	{
		return type;
	}

	public void advertise()
	{

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter job ID:");
		jobID = scanner.nextLine();
		System.out.print("Enter job title:");
		title = scanner.nextLine();
		
		System.out.print("Enter position type eg(casual/full-time):");
		type = scanner.nextLine();
		System.out.print("Enter job description:");
		description = scanner.nextLine();
	

		try
		{
			writeUsingFileWriter(jobID, title, type, description);
			System.out.print("\nNew job successfully added!\n");

		} catch (FileNotFoundException e)
		{

			e.printStackTrace();
		}

	}

	private static void writeUsingFileWriter(String jobID, String title, String type, String description)
			throws FileNotFoundException
	{
		File created = new File("/Users/Olly/eclipse-workspace/Software Assignment 1/src/job.txt");
		try
		{
			if (created.exists() == false)
			{
				System.out.println("We had to make a new file.");
				created.createNewFile();
			}
			PrintWriter out = new PrintWriter(new FileWriter(created, true));

			out.append("\n"+"{"+jobID + ", " + title + ", " + type + ", " + description+",}" );
			out.close();
		} catch (IOException e)
		{
			System.out.println("COULD NOT ADD RECORD!!");
		}

	}

	public void printJobList()
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
			title = null;
			type = null;

			description = null;

			List<String> list = new ArrayList<String>();
			// read through document while there is a new line in the file
			while ((lineInput = bufferedReader.readLine()) != null)
			{
				list.add(lineInput);
				// array to split text on line to get user name and password
				String[] checkCredentials = lineInput.split(" }");
				String[] jobDetails = checkCredentials[0].split(",");
				jobID = jobDetails[0].replace("{", "");
				title = jobDetails[1];
				type = jobDetails[2];
				description = jobDetails[3].replace("}", "");;
				

				// condition to check if user exists in the file

				System.out.printf("\nJob ID: %s \nJob Title: %s \nPosition: %s \nJob Description: %s \n",jobID,title,type, description);
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
