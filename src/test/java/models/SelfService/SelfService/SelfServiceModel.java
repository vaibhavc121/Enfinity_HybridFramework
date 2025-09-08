package models.SelfService.SelfService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class SelfServiceModel
{

    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    public static class AdminSupportModel
    {
        public String supportRequestCategory;
        public String priority;
        public String remarks;
    }

    public static class BusinessTripClaimModel
    {
        public String expenseDate;
        public String remarks;
        public String claimCategory;
        public String currency;
        public String amount;
    }

    public static class ExpenseClaimModel
    {
        public String expenseDate;
        public String remarks;
        public String claimCategory;
        public String currency;
        public String amount;
    }

    public static class HRAssetRequestModel
    {
        public String txnDate;
        public String txnDate1;
        public String effectiveDate;
        public String HRAsset;
        public String expReturnDate;
        public String status;
        public String emp;
    }

    public static class HRAssetReturnModel
    {
        public String txnDate;
        public String effectiveDate;
        public String HRAsset;
        public String expReturnDate;
        public String status;
        public String emp;
    }

    public static class ITSupportModel
    {
        public String subject;
        public String priority;
        public String description;
        public String employee;
        public String recordDesc;
    }

    public static class LeaveRequestModel
    {
        public String leaveType;
        public String expEmpName;
        public String fromDate;
        public String toDate;
        public String expFromDate;
        public String expToDate;
    }

    public static class LeaveCancellationModel
    {
        public String leaveType;
        public String expEmpName;
    }

    public static class TimeOffModel
    {
        public String permisionDate;
        public String expPermisionDate;
        public String hrs;
        public String minutes;
        public String upTohrs;
        public String upToMinutes;
    }

    public static class LoanRequestModel
    {
        public String repaymentStartPeriod;
        public String loanAmt;
        public String loanType;
        public String installmentAmt;
        public String remarks;
    }

    public static class BenefitClaimModel
    {
        public String claimDate;
        public String benefitScheme;
        public String claimAmount;
        public String paymentType;
        public String remarks;
        public String empName;
    }

    public static class TravelRequestModel
    {
        public String fromDate;
        public String uptoDate;
        public String category;
        public String country;
        public String city;
        public String ticketDestination;
        public String ticketAmt;
        public String purpose;
        public String paymentType;
        public String remarks;
        public String empName;
    }

    public static class PromotionRequestModel
    {
        public String txnDate;
        public String effectiveDate;
        public String effectiveDate1;
        public String type;
        public String newDepartment;
        public String newDesignation;
        public String newWorkLocation;
        public String newProject;
        public String description;
        public String salaryComponent;
        public String incrementAmount;
        public String effectiveFromDate;
        public String effectiveToDate;
    }

    public static class OvertimeRequestModel
    {
        public String overtimeDate;
        public String overtimeType;
        public String hrs;
        public String remarks;
    }

    public static class ResignationModel
    {
        public String submittedDate;
        public String remarks;
    }

    public static class ExceptionRequestModel
    {
        public String exceptionDate;
        public String loginTime;
        public String logotTime;
        public String remarks;
    }

    public static class SupportRequestCategoryModel
    {
        public String categoryName;
        public String requestedTo;
        public String priority;
        public String workflow;
        public String attachment;
        public String desc;
    }

    public static class DeleteSupportRequestCategoryModel
    {
        public String categoryName;
    }

    public static class Entitlement
    {
        private int maximumLeaveBalance;
        private int eligibilityDaysAfterJoining;
        private boolean includeUnpaidLeaveInProvisions;
        private boolean countWeekendsAsLeaveDays;
        private boolean countWeekendsAsUnpaidDays;
        private boolean countPublicHolidaysAsPublicHolidays;
        private boolean grantPublicHolidaysDuringLeave;
        private boolean countRestDaysAsRestDays;
        private String leaveApplicability;
        private String leaveApplicabilityFor;
        private boolean allowExceedLeaveBalance;
    }

    public static class Restriction
    {
        private String leaveTypeApplicableFor;
        private boolean autoResumeLeave;
        private boolean considerLateResumeAsPaidIfBalanceAvailable;
        private boolean considerAllLateResumeAsUnpaid;
        private ApplicableCriteria applicableCriteria;
        private boolean assignLeaveTypeToNewEmployee;
        private boolean restrictUnpaidLeaveDays;
        private boolean allowSelfServicePortalRequests;
        private int maxPaidLeaveDaysPerRequest;
        private int leaveRequestAdvanceDays;
        private int leaveRequestBackdatedDays;
        private boolean requireSubstituteForLeaveRequest;
        private boolean allowBackdatedLeaveRequestsInPortal;
        private String restrictLeaveBeforeOrAfter;
        private boolean attachmentMandatoryForLeaveRequest;
    }

    public static class ApplicableCriteria
    {
        private String gender;
        private String maritalStatus;
        private String religion;
    }
}