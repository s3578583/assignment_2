import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Timetable
{
	private String timetableID;
	private String startTime;
	private String endTime;
	private String day;

	public Timetable(String timetableID, String startTime, String endTime, String day)
	{

		this.timetableID = timetableID;
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
	}

	public String getTimetableID()
	{
		return timetableID;
	}

	public String getStartTime()
	{
		return startTime;
	}

	public String getEndTime()
	{
		return endTime;
	}

	public String getDay()
	{
		return day;
	}

	public void casualStaffTimeTable(String checkStaffTime)
	{

		
		String fileName = "C://Users//Olly//eclipse-workspace//Software Assignment 1//src//staffTimetable.txt";
		boolean found = false;
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
				String[] checkCredentials = lineInput.split("/}");
				String[] individualRecord = checkCredentials[0].split(",");
				String[] days = individualRecord[2].split("]");
				String[] certainDays = days[0].split("\\$");

				String staffID = individualRecord[0].replace("{", "");
				String courseID = individualRecord[1];

				if (staffID.equals("staffID:" + checkStaffTime))
				{
					System.out.println(staffID);
					System.out.println(courseID);
					for (int i = 0; i < certainDays.length; i++)
					{
						if (i != 0)
						{
							String day = certainDays[i].replaceAll("<|\\>", " ");
							System.out.println(day);
						}
					}
					System.out.println();
					found = true;
				}
				
			}
			if(found == false)
					System.out.println("Please enter a valid staff ID!!");
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
