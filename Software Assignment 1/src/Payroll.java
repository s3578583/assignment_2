import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Payroll
{
	// variables for payroll object.
	private String staffID;
	private Date date;
	private Date startTime;
	private Date finishTime;
	private double totalHours;
	private double wage;
	private double totalPay;
	

	// constructor
	public Payroll(String staffID, Date date, Date startTime, Date finishTime, double wage)
	{
		this.date = date;
		this.staffID = staffID;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.wage = wage;
	}

	public String getstaffID()
	{
		return staffID;
	}

	public Date getDate()
	{
		return date;
	}

	public Date getStartTime()
	{
		return startTime;
	}

	public Date getFinishTime()
	{
		return finishTime;
	}

	public double getWage()
	{
		return wage;
	}

	//if this isn't suppressed it has a yellow caution icon
	//if I close the scanner then the program does not work correctly
	@SuppressWarnings("resource")
	public void addHours()
	{
		Scanner input = new Scanner(System.in);
		//variable to check if input is number
		boolean isNumber = false;
		// check input to make sure it is a correct date
		do
		{
			System.out.print("Enter date (dd/mm/yy): ");

			try
			{
				//get user input and place it into date variable
				String inputDate = input.next();

				date = new SimpleDateFormat("dd/MM/yy").parse(inputDate);
				//System.out.println(date);
				//String newDate = new SimpleDateFormat("dd:MM:yy").format(date);
				//date = new SimpleDateFormat("dd:MM:yy").parse(newDate);
				//set number to true.
				isNumber = true;
			}
			//exception if format is not correct
			catch (ParseException e)
			{
				System.out.println("\nIncorrect format!\n");
				isNumber = false;
				input.next();

			}

		} while (!(isNumber));
		// check input to make sure it is a 24hr time
		do
		{
			System.out.print("Start Time in 24hr time (eg 1730) : ");

			try
			{
				
				String inputTime = input.next();
				//parse input and store in variable, used for calculations
				startTime = new SimpleDateFormat("HHmm").parse(inputTime);
				// set number to true
				isNumber = true;
			} 
			//exception if format is not correct
			catch (ParseException e)
			{
				System.out.println("\nIncorrect format!\n");
				// set number to false
				isNumber = false;

			}
		} while (!(isNumber));
		// check input to make sure it is a 24hr time
		do
		{
			System.out.print("Finish Time in 24hr time: (eg 1730) : ");

			try
			{
				//parse input and store in variable, used for calculations
				String inputTime = input.next();
				finishTime = new SimpleDateFormat("HHmm").parse(inputTime);
				isNumber = true;
			} 
			//exception if format is not correct
			catch (ParseException e)
			{
				System.out.println("\nIncorrect format!\n");
				isNumber = false;

			}
		} while (!(isNumber));

		
		do
		{
			System.out.print("Hourly wage $: ");
			//get wage value for specific staff member
			if (input.hasNextDouble())
				wage = input.nextDouble();
			if (wage > 0)
				isNumber = true;
			else
			{
				//if input is not a number, try again
				System.out.println("\nPlease enter a number!!");
				isNumber = false;
				input.next();
			}
		} while (!(isNumber));

		//calculate seconds difference between times
		long totalSeconds = (finishTime.getTime() - startTime.getTime())/1000;
		//calculate mintues difference between times
		double totalMinutes = totalSeconds/60;
		//store hours in variable 
		totalHours = totalMinutes/60;
		//if hours is set, calculate wages
		if(totalHours >0)
			totalPay = wage * totalHours;
	}

	@Override
	public String toString()
	{
		// print out the staff id, date, total hours, wage and Total pay of inputed record.
		return String.format("\nStaff ID: %s Date: %td-%tb-%ty \nHours: %.02f Wage: $%.02f Total Pay: $%.02f ", staffID,date,date,date, totalHours, wage,
				totalPay);
	}
}
