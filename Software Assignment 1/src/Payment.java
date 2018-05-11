import java.util.Date;

public class Payment
{

		private String payrollID;	
		private Date date;
		private double grossPay;
		private double netPay;
		private double tax;
		
	
		public Payment(String payrollID, Date date, double grossPay)
		{
			
			this.payrollID = payrollID;
			this.date = date;
			this.grossPay = grossPay;
		}



		public String getPayrollID()
		{
			return payrollID;
		}
		public Date getDate()
		{
			return date;
		}
	

		public double getGrossPay()
		{
			return grossPay;
		}
		public double calculateTax() {
			return tax;

		}
		public double calculateNetPay() {
			return netPay;
			
		}
		@Override
		public String toString()
		{
		return String.format("Gross Pay: %.02f Net Pay: %.02f ",grossPay,netPay);	
		}
		
}
