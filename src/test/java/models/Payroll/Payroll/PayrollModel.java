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

	public static class LeaveAdjustmentModel
	{
		public String employee;
		public String effectiveDate;
		public String leaveType;
		public String paidDays;
		public String unpaidDays;
		public String remarks;

	}

	public static class LeaveEncashmentModel
	{
		public String employee;
		public String effectiveDate;
		public String leaveType;
		public String paidDays;
		public String paymentType;
		public String remarks;
	}

	public static class LeaveOpeningBalanceModel
	{
		public String employee;
		public String effectiveDate;
		public String leaveType;
		public String paidDays;
		public String remarks;
	}

	public static class BenefitSchemeEncashmentModel
	{
		public String employee;
		public String effectiveDate;
		public String employeeBenefitScheme;
		public String requestedAmount;
		public String approvedAmount;
		public String paymentType;
		public String remarks;
	}

	public static class TicketEncashmentModel
	{
		public String employee;
		public String effectiveDate;
		public String paymentType;
		public String issueTickets;
	}

	public static class TicketAdjustmentModel
	{
		public String reportName;
		public String employee;
		public String effectiveDate;
		public String paymentType;
		public String issueTickets;
	}

	public static class OvertimeModel
	{
		public String employee;
		public String effectiveDate;
		public String overtimeDate;
		public String overtimeType;
		public String overtimeHrs;
		public String expectedOvertimeAmt;

	}

	public static class LoanModel
	{
		public String employee;
		public String effectiveDate;
		public String loanType;
		public String repaymentStartPeriod;
		public String loanAmt;
		public String amountOfInstallments;
		public String remarks;

	}

}