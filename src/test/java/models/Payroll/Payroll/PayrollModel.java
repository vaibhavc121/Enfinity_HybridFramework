package models.Payroll.Payroll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
        public String employee1;
        public String effectiveDate;
        public String leaveTypeUnpaid;
        public String leaveTypeCondolence;
        public String leaveTypeSick;
        public String leaveTypeHaj;
        public String leaveTypeMaternity;
        public String leaveTypeAnnual;
        public String fromDate;
        public String uptoDate;
        public String paymentType;
        public String expActualResumptionDate;
        public String expEarlyResumptionDate;
        public String expLateResumptionDate;
        public String paidDays;
        public String grantDays;
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
        public String encashmentDate;
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

    public static class IndemnityAdjustmentModel
    {
        public String reportName;
        public String employee;
        public String effectiveDate;
        public String asOnDate;
        public String indemnityType;
        public String paymentType;
        public String paidDays;
    }

    public static class OvertimeModel
    {
        public String employee;
        public String effectiveDate;
        public String overtimeDate;
        public String overtimeType;
        public String overtimeHrs;
        public String expectedOvertimeAmt;
        public String remarks;
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

    public static class PromotionModel
    {
        public String employee;
        public String promotionTypeSalRevision;
        public String promotionPeriod;
        public String salComp;
        public String incrementAmt;
        public String salCompEffectiveFromDate;

        public String promotionTypeJobProfileRevision;
        public String department;
        public String designation;
        public String workLocation;
        public String manager;
        public String Project;
    }

    public static class PenaltyModel
    {
        public String employee;
        public String penaltyDate;
        public String penaltyType;
        public String penaltyInDays;
        public String penaltyInAmt;
        public String expectedDeductionAmt;
    }

    public static class SuspendModel
    {
        public String effectiveDate;
        public String employee;
        public String suspendType;
        public String remarks;
        public String releaseSuspendDate;
    }

    public static class SalaryComponentModel
    {
        public String name;
        public String earningOrDeduction;
        public String computationType;
        public String calculationMethod;
        public String salaryComponentGroup;
    }

    public static class TicketAccrualModel
    {
        public String name;
        public String numberOfTicket;
        public String numberOfYear;
        public String earningSalaryComponent;
        public boolean includeUnpaidDaysInProvision;
        public List<AgeWisePaymentScheduleModel> ageWisePaymentSchedules;
    }

    public static class AgeWisePaymentScheduleModel
    {
        public String tillAge;
        public String percentage;
    }

    public static class ProjectModel
    {
        public String name;
        public String projectGroup;
        public String projectManagerEmployee;
    }

    public static class PaymentBatchModel
    {
        public String name;
        public String paymentBatchType;
    }

    public static class FinancialIntegrationGroupsModel
    {
        public String name;
        public String division;
        public String department;
        public String project;
        public String workLocation;
    }
}