

public class AbstractRMITStaff 
{

	private String staffID;
	private  String firstName;
	private  String lastName;
	private String address;
	private String email;
	private String phone;
	private int TFN;
	
	public AbstractRMITStaff(String staffID,String firstName, String lastName, String address, String email, String phone, int tfn)
	{
		this.staffID = staffID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.TFN = tfn;
		
	}
	
	public String getStaffID()
	{
		return staffID;
	}


	
	public String getFirstName()
	{
		return firstName;
	}




	public String getLastName()
	{
		return lastName;
	}




	public String getAddress()
	{
		return address;
	}




	public String getEmail()
	{
		return email;
	}




	public String getPhone()
	{
		return phone;
	}




	public int getTFN()
	{
		return TFN;
	}

	
	
	public String toString()
	{
	return String.format("Full Name: %s %s \nAddress: %s \nEmail: %s \nPhone: %s \nTFN: %s",getFirstName(),getLastName(),getAddress(),
			getEmail(),getPhone(), getTFN());	
	}

	public void login() {
	
	}
	
	public void logout() {
		
	}
	
	
}
