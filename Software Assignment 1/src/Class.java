import java.sql.Time;

public class Class
{

		private String classID;
		private String roomNo;
		private int capacity;
		private Time length;
		private String type;
		
		public Class(String classID, String roomNo, int capacity, Time length,String type)
		{
			
			this.classID = classID;
			this.roomNo = roomNo;
			this.capacity = capacity;
			this.length = length;
			this.type = type;
		}
		public String getClassID()
		{
			return classID;
		}
		public String getRoomNo()
		{
			return roomNo;
		}
		public int getCapacity()
		{
			return capacity;
		}
		public Time getLength()
		{
			return length;
		}
		public String getType()
		{
			return type;
		}
		
		
		
}
