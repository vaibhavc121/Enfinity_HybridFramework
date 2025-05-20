package models.Payroll.Payroll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PayrollModel
{
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class VariableSalModel
	{
		public String employee;
		public String effectiveDate;
		public String remarks;
		public String salComponent;
		public String amt;

	}

	@Data
	public static class LeaveModel
	{
		public String employee;
		public String effectiveDate;
		public String leaveType;
		public String fromDate;
		public String uptoDate;
		public String paymentType;

	}

}
