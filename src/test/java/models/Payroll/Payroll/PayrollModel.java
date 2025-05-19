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

}
