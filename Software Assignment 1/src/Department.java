
public class Department 
{

	private String deptName;
	private String deptNum;
	private String deptManager;
	
	
	public Department(String deptName, String deptNum, String deptManager)
	{
	
		this.deptName = deptName;
		this.deptNum = deptNum;
		this.deptManager = deptManager;
	}


	public String  getDeptName()
	{
		return deptName;
	}


	public void setDeptName(String deptName)
	{
		this.deptName = deptName;
	}


	public String getDeptNum()
	{
		return deptNum;
	}


	public void setDeptNum(String deptNum)
	{
		this.deptNum = deptNum;
	}


	public String getDeptManager()
	{
		return deptManager;
	}


	public void setDeptManager(String deptManager)
	{
		this.deptManager = deptManager;
	}
	
	public String toString()
	{
	return String.format("Department: %s ",getDeptName());	
	}
	
}
