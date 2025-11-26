package models.SelfService.SelfService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
        public String employee;
        public String promotionTypeSalRevision;
        public String promotionTypeJobProfileRevision;
        public String promotionPeriod;
        public String salComp;
        public String incrementAmt;
        public String salCompEffectiveFromDate;
        public String remarks;
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

    public static class EntitlementModel
    {
        public String maximumLeaveBalance;
        public EligibilityDaysAfterJoining eligibilityDaysAfterJoining;
        public boolean includeUnpaidLeaveInProvisions;
        public boolean countWeekendsAsLeaveDays;
        public boolean countWeekendsAsUnpaidDays;
        public boolean countPublicHolidaysAsPublicHolidays;
        public boolean grantPublicHolidaysDuringLeave;
        public boolean countRestDaysAsRestDays;
        public List<String> leaveApplicability;
        public String leaveApplicabilityFor;
        public boolean allowExceedLeaveBalance;
    }

    public static class EligibilityDaysAfterJoining
    {
        public int days;
        public String leaveType;
        public String fromDate;
        public String toDate;
        public String expFromDate;
        public String expToDate;
    }

    public static class RestrictionModel
    {
        public String leaveTypeApplicableFor;
        public boolean autoResumeLeave;
        public boolean considerLateResumeAsPaidIfBalanceAvailable;
        public boolean considerAllLateResumeAsUnpaid;
        public ApplicableCriteria applicableCriteria;
        public boolean assignLeaveTypeToNewEmployee;
        public boolean restrictUnpaidLeaveDays;
        public boolean allowSelfServicePortalRequests;
        public String maxPaidLeaveDaysPerRequest;
        public String leaveRequestAdvanceDays;
        public String leaveRequestBackdatedDays;
        public boolean requireSubstituteForLeaveRequest;
        public boolean allowBackdatedLeaveRequestsInPortal;
        public String restrictLeaveBeforeOrAfter;
        public boolean attachmentMandatoryForLeaveRequest;
    }

    public static class ApplicableCriteria
    {
        public String gender;
        public String maritalStatus;
        public String religion;
    }

    public static class EntitlementModel1
    {
        public String leaveType;
        public String maximumLeaveBalance;
        public String eligibilityDaysAfterJoining;
        public boolean includeUnpaidLeaveInProvisions;
        public boolean countWeekendsAsLeaveDays;
        public boolean countWeekendsAsUnpaidDays;
        public boolean countPublicHolidaysAsPublicHolidays;
        public boolean grantPublicHolidaysDuringLeave;
        public boolean countRestDaysAsRestDays;
        public List<String> leaveApplicability;
        public String leaveApplicabilityFor;
        public boolean allowExceedLeaveBalance;
    }
}