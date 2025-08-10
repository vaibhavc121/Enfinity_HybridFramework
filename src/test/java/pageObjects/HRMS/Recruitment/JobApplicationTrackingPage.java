package pageObjects.HRMS.Recruitment;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.HRMS.HRCore.EmployeePage;
import utilities.BrowserUtils;
import utilities.DateUtils;
import utilities.JavaScriptUtils;

import java.text.MessageFormat;

public class JobApplicationTrackingPage extends BasePage
{
    public JobApplicationTrackingPage(WebDriver driver)
    {
        super(driver);
    }

    //region Locators

    //region Job Listing

    @FindBy(xpath = "(//td[@class='list-hyperlink'])[1]") private  WebElement jobName;
    @FindBy(xpath = "(//tr)[12]") private WebElement jobRow;
    //endregion

    //region Candidates
    @FindBy(xpath="//h3[normalize-space()='Screening']") private WebElement screening;
    //endregion

    //region Advance Candidate Search
    @FindBy(xpath="(//span[@class='dx-tab-text-span'])[1]") private WebElement description;
    @FindBy(xpath="(//span[@class='dx-tab-text-span'])[2]") private WebElement candidates;
    @FindBy(xpath="(//span[@class='dx-tab-text-span'])[3]") private WebElement edit;
    @FindBy(xpath="(//span[@class='dx-tab-text-span'])[4]") private WebElement assesment;
    @FindBy(xpath="(//span[@class='dx-tab-text-span'])[5]") private WebElement advanceCandidateSearch;

    //region Skills
    @FindBy(xpath = "//input[contains(@id,'Skills')]") private WebElement skills;
    //endregion

    //region Experience (In Years)
    @FindBy(xpath = "//input[contains(@id,'MinimumWorkExperience')]") private WebElement minimumWorkExperience;
    @FindBy(xpath = "//input[contains(@id,'MaximumWorkExperience')]") private WebElement maximumWorkExperience;
    //endregion

    //region Salary Range
    @FindBy(xpath = "//input[contains(@id,'MinimumSalaryRange')]") private WebElement minimumSalaryRange;
    @FindBy(xpath = "//input[contains(@id,'MaximumSalaryRange')]") private WebElement maximumSalaryRange;
    //endregion

    //region Notic Period (In Days)
    @FindBy(xpath = "//input[contains(@id,'MinimumNoticePeriodInDays')]") private WebElement minimumNoticePeriodInDays;
    @FindBy(xpath = "//input[contains(@id,'MaximumNoticePeriodInDays')]") private WebElement maximumNoticePeriodInDays;
    //endregion

    //region Personal
    @FindBy(xpath = "//input[contains(@id,'NationalityCountries')]") private WebElement nationalityCountries;
    @FindBy(xpath = "//input[contains(@id,'VisaType')]") private WebElement visaType;
    @FindBy(xpath = "(//input[contains(@id,'Gender')])[2]") private WebElement gender;
    @FindBy(xpath="(//span[@class='dx-checkbox-icon'])[3]") private WebElement drivingLicense;
    //endregion

    //region Age
    @FindBy(xpath = "//input[contains(@id,'MinimumAge')]") private WebElement minimumAge;
    @FindBy(xpath = "//input[contains(@id,'MaximumAge')]") private WebElement maximumAge;
    @FindBy(xpath = "//span[normalize-space()='Search Candidates']") private WebElement searchCandidates;
    //endregion

    @FindBy(xpath="//span[normalize-space()='Assign']") private WebElement assign;


    //endregion

    //region JAT Pipeline

    //region Applied

    //endregion

    //region Screening
    @FindBy(xpath = "(//h3[@class='widget-content text-right animation-pullDown'])[2]") private WebElement screeningPipeline;
    @FindBy(xpath="//span[normalize-space()='Screening']") private WebElement screening1;
    @FindBy(xpath = "//input[contains(@id,'HiringTimeline')]") private WebElement statusDD;
    @FindBy(xpath="//div[@id='StatusUpdateButton']//span[@class='dx-button-text'][normalize-space()='Update']") private WebElement update;
    @FindBy(xpath = "(//div[@class='widget-icon pull-left animation-fadeIn'])[2]") private WebElement screeningCount;
    @FindBy(xpath = "(//h3[@class='widget-content text-right animation-pullDown'])[3]") private WebElement interviewPipeline;
    //endregion

    //region Interview
    @FindBy(xpath="//i[@class='dx-icon dx-icon-event']") private WebElement intervieButton;
    @FindBy(xpath="//span[normalize-space()='New']") private WebElement newButton;
    @FindBy(xpath = "(//h3[@class='widget-content text-right animation-pullDown'])[4]") private WebElement offeredPipeline;
    @FindBy(xpath="(//span[@class='dx-button-text'][normalize-space()='Cancel'])[2]") private WebElement cancelPopupInterview;

    //region Schedule Interview Popup
    @FindBy(xpath = "//input[contains(@id,'InterviewType')]") private WebElement interviewType;
    @FindBy(xpath = "//input[contains(@id,'InterviewDateTime')]") private WebElement interviewDateTime;
    @FindBy(xpath="(//div[@class='dx-dropdowneditor-icon'])[17]") private WebElement interviewDateTimeCalendarIcon;
    @FindBy(xpath="//div[@aria-label='Today']//div[@class='dx-button-content']") private WebElement today;
    @FindBy(xpath="(//span[@class='dx-button-text'][normalize-space()='OK'])[2]") private WebElement oKCalendar;
    @FindBy(xpath = "//input[contains(@id,'Duration')]") private WebElement interviewDuration;
    @FindBy(xpath = "//input[contains(@id,'Mode')]") private WebElement interviewMode;
    @FindBy(xpath = "//input[contains(@id,'Location')]") private WebElement location;
    @FindBy(xpath = "//input[contains(@id,'InterviewerEmployeeId')]") private WebElement interviewer;
    @FindBy(xpath = "//input[contains(@id,'GuestInterviewerIds')]") private WebElement guestInterviewer;
    @FindBy(xpath="//span[@class='dx-vam dxm-contentText'][normalize-space()='Save']") private WebElement save;
    @FindBy(xpath="//span[normalize-space()='Ok']") private WebElement ok;
    @FindBy(xpath="(//span[@class='dx-button-text'][normalize-space()='Cancel'])[3]") private WebElement cancel;
    @FindBy(xpath="(//i[@class='dx-icon dx-icon-close'])[2]") private WebElement closeSchduledInterviewPopupIcon;
    @FindBy(xpath="//label[normalize-space()='Scheduled']") private WebElement interviewStatus;
    //endregion
    //endregion

    //region Offered
    @FindBy(xpath="//td[normalize-space()='Not Generated']") private WebElement offerStatus;
    @FindBy(xpath = "(//td[@class='verticalAlign'])[8]") private WebElement offerStatus1;
    @FindBy(xpath="//i[@class='dx-icon dx-icon-message']") private WebElement offerIcon;
    @FindBy(xpath = "(//h3[@class='widget-content text-right animation-pullDown'])[5]") private WebElement hiredPipeline;
    @FindBy(xpath = "//i[@class='dx-icon dx-icon-new-icon']") private WebElement newLineButton;


    //region Job Offer Page
    @FindBy(xpath="//span[normalize-space()='View']") private WebElement viewButton;
    @FindBy(id="JobOffer.JobOfferReportIdLookup_I") private WebElement jobOfferTemplateDD;
    @FindBy(id="JobOfferSalaryComponents_RPHT") private WebElement salaryComponentsSection;
    @FindBy(id="JobOfferSalaryComponent_SalaryComponentId_I") private WebElement SalaryComponentDD;
    @FindBy(xpath="(//div[@class='dxgBCTC dx-ellipsis'])[2]") private WebElement salaryAmount;
    @FindBy(id="JobOfferLeaveTypes_RPHT") private WebElement leaveTypes;
    @FindBy(xpath="//td[contains(text(),'Leave Type')]") private WebElement leaveTypeLabel;
    @FindBy(id="JobOfferLeaveType_LeaveTypeId_I") private WebElement LeaveTypeDD;
    @FindBy(xpath="//span[normalize-space()='Generate Offer']") private WebElement generateOffer;
    @FindBy(xpath="//span[normalize-space()='Preview']") private WebElement preview;
    //endregion
    //endregion

    //region Hired

    @FindBy(xpath = "(//h3[@class='widget-content text-right animation-pullDown'])[6]") private WebElement rejectedPipeline;

    //region Initiate Onboarding
    @FindBy(xpath="//i[@class='dx-icon dx-icon-bolt-solid']") private WebElement initiateOnboardingIcon;
    @FindBy(xpath="//input[contains(@id,'OnboardingProcessId')]") private WebElement processDD;
    @FindBy(xpath="//span[normalize-space()='Next']") private WebElement next;

    //region Initiate Onboarding Popup

    @FindBy(xpath = "//input[contains(@id,'JoiningDate')]") private WebElement joiningDate;
    @FindBy(xpath = "//input[contains(@id,'ArrivalTime')]") private WebElement arrivalTime;
    @FindBy(xpath = "//input[contains(@id,'ContactEmployeeId')]") private WebElement contactPerson;
    @FindBy(xpath = "(//input[contains(@id,'DepartmentId')])[2]") private WebElement department;
    @FindBy(xpath = "(//input[contains(@id,'DesignationId')])[2]") private WebElement designation;
    @FindBy(xpath = "//input[contains(@id,'WorkLocationId')]") private WebElement workLocation;
    @FindBy(xpath="(//div[@aria-label='Editor content'])[2]") private WebElement welcome;
    @FindBy(xpath = "//input[contains(@id,'WelcomeUrl')]") private WebElement welcomeUrl;
    @FindBy(xpath = "//textarea[contains(@id,'OtherInstructions')]") private WebElement otherInstructions;
    @FindBy(xpath="//i[@class='dx-icon dx-icon-edit-button-addrow']") private WebElement addIcon;

    //region Introction question popup
    @FindBy(xpath = "//input[contains(@id,'QuestionName')]") private WebElement questionName;
    @FindBy(xpath = "//input[contains(@id,'QuestionFormatType')]") private WebElement type;
    @FindBy(xpath="(//span[@class='dx-button-text'][normalize-space()='Save'])[3]") private WebElement save1;
    //endregion

    @FindBy(xpath="//span[normalize-space()='Initate']") private WebElement initate;

    //endregion

    //endregion

    //region Convert to Employee
    @FindBy(xpath="//i[@class='dx-icon dx-icon-user']") private WebElement convertToEmployeeIcon;
    //endregion

    //endregion

    //region Rejected

    //endregion

    //endregion

    //endregion

    //region Action Methods

    //region Job Listing

    public String getJobName()
    {
        String jobNameText = waitForElement(jobName).getText();
        return jobNameText;
    }

    public void openJob()
    {
        waitForElement(jobRow).click();
        clickOnEdit();
    }

    public void openJobFromListing(String jobNameValue)
    {
        // selectFilterAll();
        filterByIndex(2, jobNameValue);
        BaseTest.log("value filtered");
        waitTS(2);
        String employee = resultValue(1);
        // Thread.sleep(2000);
        if (employee.contains(jobNameValue))
        {
            selectRow();
            BaseTest.log("row selected");
            try
            {
                clickOnEdit();
                BaseTest.log("clicked On Edit");

            } catch (Exception e)
            {
                clickOnView();
                BaseTest.log("clicked On View");
            }

        } else
        {
            throw new RuntimeException("VRC- No matching record found");
        }
    }
    //endregion

    //region Candidates
    public void clickOnCandidates()
    {
        waitForElement(candidates).click();
    }
    public boolean isScreeningLabelDisplay()
    {
        String screeningText = waitForElement(screening).getText().trim();
        if (screeningText.equals("Screening"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean candidateLabelDisplay(String candidateNm)
    {
        String screeningText = waitForElement1(By.xpath("//span[normalize-space()='" +candidateNm + "']")).getText().trim();
        if (screeningText.equals(candidateNm))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //endregion

    //region Advance Candidate Search

    public void clickAdvanceCandidateSearch()
    {
        waitForElement(advanceCandidateSearch).click();
    }

    //region Skills
     public void provideSkills(String skillsValue)
     {
         provideAndEnter(skills, skillsValue);
     }
    //endregion

    //region Experience (In Years)
    public void provideMinimumWorkExperience(String minimumWorkExperienceValue)
    {
        clearAndProvide1(minimumWorkExperience, minimumWorkExperienceValue);
    }
    public void provideMaximumWorkExperience(String maximumWorkExperienceValue)
    {
        clearAndProvide1(maximumWorkExperience, maximumWorkExperienceValue);
    }

    //endregion

    //region Salary Range
    public void provideMinimumSalaryRange(String minimumSalaryRangeValue)
    {
        clearAndProvide1(minimumSalaryRange, minimumSalaryRangeValue);
    }
    public void provideMaximumSalaryRange(String maximumSalaryRangeValue)
    {
        clearAndProvide1(maximumSalaryRange, maximumSalaryRangeValue);
    }

    //endregion

    //region Notic Period (In Days)
    public void provideMinimumNoticePeriodInDays(String minimumNoticePeriodInDaysValue)
    {
        clearAndProvide1(minimumNoticePeriodInDays, minimumNoticePeriodInDaysValue);
    }
    public void provideMaximumNoticePeriodInDays(String maximumNoticePeriodInDaysValue)
    {
        clearAndProvide1(maximumNoticePeriodInDays, maximumNoticePeriodInDaysValue);
    }

    //endregion

    //region Personal
    public void provideNationality(String nationalityValue)
    {
        provideAndEnter(nationalityCountries, nationalityValue);
    }
    public void provideVisaType(String visaTypeValue)
    {
        clearAndProvide1(visaType, visaTypeValue);
    }
    public void provideGender(String genderValue)
    {
        provideAndEnter(gender, genderValue);
    }
    public void clickDrivingLicense()
    {
        waitForElement(drivingLicense).click();
    }

    //endregion

    //region Age
    public void provideMinimumAge(String minimumAgeValue)
    {
        clearAndProvide1(minimumAge, minimumAgeValue);
    }
    public void provideMaximumAge(String maximumAgeValue)
    {
        clearAndProvide1(maximumAge, maximumAgeValue);
    }
    public void clickSearchCandidates()
    {
        waitForElement(searchCandidates).click();
    }

    public void scrollToTop()
    {
        scrollIntoView(driver,advanceCandidateSearch);
    }

    //endregion

    public void selectCandidate(String candidateName)
    {
        waitTS(2);
        waitForElement1(By.xpath("//span[normalize-space()='" + candidateName + "']/../../../../..//span[@class='dx-checkbox-icon']")).click();
    }

    public void clickAssign()
    {
        waitForElement(assign).click();
    }



    //endregion

    //region JAT Pipeline

    public void changePipelineStatus(String currentStageStatus, String nextStageStatus)
    {
        waitForElement1(By.xpath("//span[normalize-space()='" + currentStageStatus + "']")).click();
        waitForElement1(By.xpath("//input[contains(@id,'HiringTimeline')]")).click();
        selectDropdownOption(nextStageStatus);
        waitForElement1(By.xpath("//div[@id='StatusUpdateButton']//span[@class='dx-button-text'][normalize-space()='Update']")).click();
        waitTS(2);
    }

    //region Applied

    //endregion

    //region Screening
    public void clickScreeningPipeline()
    {
        waitForElement(screeningPipeline).click();
    }
    public void clickScreening()
    {
        waitForElement(screening1).click();
    }
    public void selectStatus(String statusValue)
    {
        waitForElement(statusDD).click();
        selectDropdownOption(statusValue);
    }
    public void clickUpdate()
    {
        waitForElement(update).click();
    }
    public void switchPipelineToInterview()
    {
        String screeningCount1= waitForElement(screeningCount).getText().trim();
        if(screeningCount1.equals("0"))
        {
            waitForElement(interviewPipeline).click();
        }
        else
        {
            throw new RuntimeException("Candidate has not been added to Screening Pipeline, kindly check the Screening Pipeline first.");
        }
    }
    //endregion

    //region Interview
    public void clickInterviewPipeline()
    {
        waitForElement(interviewPipeline).click();
    }
    public void clickInterviewButton()
    {
        try
        {
            waitForElement(intervieButton).click();
        } catch (Exception e)
        {
            waitForElement(intervieButton).click();
            waitTS(5);
        }

    }
    public void clickNewButton()
    {
        waitTS(2);
        try
        {
            waitForElement(newButton).click();
        } catch (Exception e)
        {
            waitForElement(newButton).click();
        }

        waitTS(5);
    }

    //region Schedule Interview Popup
    public void selectInterviewType()
    {
        provideAndEnter(interviewType, "HR Interview");
    }
    public void provideInterviewDateTime()
    {
        //clearAndProvide1(interviewDateTime, DateUtils.getCurrentDateTime1("dd-MMM-yyyy hh:mm A"));
        clickOnElement1(interviewDateTimeCalendarIcon);
        clickOnElement1(today);
        clickOnElement1(oKCalendar);
    }
    public void provideInterviewDuration()
    {
        clearAndProvide1(interviewDuration, "60");
    }
    public void selectInterviewMode()
    {
        provideAndEnter(interviewMode, "Face To Face");
    }
    public void provideLocation()
    {
        clearAndProvide1(location, "Online");
    }
    public void selectInterviewer()
    {
        provideAndEnter(interviewer, "001 | Vaibhav Chavan");
    }
    public void selectGuestInterviewer()
    {
        provideAndEnter(guestInterviewer, "002");
    }
    public void clickSave()
    {
        waitForElement(save).click();
    }
    public void clickCancel()
    {
        waitTS(3);
        try
        {
            waitForElement(cancel).click();
        } catch (Exception e)
        {
            waitForElement(cancel).click();
        }

    }
    public void clickCancelPopupInterview()
    {
        waitTS(3);
        try
        {
            waitForElement(cancelPopupInterview).click();
        } catch (Exception e)
        {
            waitForElement(cancelPopupInterview).click();
        }
    }
    public boolean getStatusOfInterview()
    {
        String interviewStatusText = waitForElement(interviewStatus).getText().trim();
        if (interviewStatusText.equals("Scheduled"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void clickCloseSchduledInterviewPopupIcon()
    {
        waitForElement(closeSchduledInterviewPopupIcon).click();
    }
    //endregion

    public void clickOk()
    {
        waitForElement(ok).click();
    }



    //endregion

    //region Offered
    public void clickOfferedPipeline()
    {
        waitForElement(offeredPipeline).click();
    }
    public void provideOfferLetter() throws InterruptedException
    {
        waitTS(2);
        String offerStatusText = waitForElement(offerStatus1).getText().trim();
        if (offerStatusText.equals("Not Generated") || offerStatusText.equals("Draft") || offerStatusText.equals("Sent"))
        {
            waitForElement(offerIcon).click();
            BaseTest.log("Offer letter icon clicked.");

            BasePage.waitTS(5);

            switchTab();
            BaseTest.log("Switched to Offer Letter tab.");

            //BasePage.waitTS(5);

            if(waitForElement(preview).isDisplayed())
            {
                System.out.println("Offer letter is already generated.");
            }
            else
            {

                //if(waitForElement(viewButton).isDisplayed())
//                try
//                {
//                    clickOnEdit();
//                } catch (Exception e)
//                {
//                    clickOnEdit();
//                }
//                BaseTest.log("Clicked on Edit button");
//
//                pressTab();
//                BaseTest.log("Pressed Tab key");
//
//                pressTab();
//                BaseTest.log("Pressed Tab key");



                clearAndProvide1(jobOfferTemplateDD, "Job Offer");
                BaseTest.log("provided Job Offer Template");

                clickOnElement1(salaryComponentsSection);
                BaseTest.log("Clicked on Salary Components Section");

                clickOnView();
                BaseTest.log("Clicked on View button");

                clickOnEdit();
                BaseTest.log("Clicked on Edit button");

                waitTS(2);

                clickOnNewLine();
                BaseTest.log("Clicked on New Line button");

                provideAndEnter(SalaryComponentDD, "Basic");
                BaseTest.log("Provided Salary Component");

                clearAndProvide2(salaryAmount, "500");
                BaseTest.log("Provided Salary Amount");

                clickOnElement1(salaryComponentsSection);
                BaseTest.log("closed Salary Components Section");

                //region Leave Types Section
//            JavaScriptUtils.scrollToBottom(driver);
//            BaseTest.log("Scrolled to bottom of the page");
//
//            clickOnElement1(leaveTypes);
//            BaseTest.log("Clicked on Leave Types Section");
//
//            JavaScriptUtils.scrollToBottom(driver);
//            BaseTest.log("Scrolled to bottom of the page");
//
//            JavaScriptUtils.scrollIntoView(driver, newLineButton);
//            BaseTest.log("Scrolled to New Line button");
//
//            clickOnElement1(leaveTypeLabel);
//            BaseTest.log("Clicked on Leave Type Label");
//
//            try
//            {
//                clickOnElement1(newLineButton);
//            } catch (Exception e)
//            {
//                clickOnElement1(newLineButton);
//            }
//            BaseTest.log("Clicked on New Line button for Leave Type");
//
//            provideAndEnter(LeaveTypeDD, "Unpaid Leave");
//            BaseTest.log("Provided Leave Type");

                //endregion


                clickOnView();
                BaseTest.log("Clicked on View button");

                clickOnElement1(generateOffer);
                BaseTest.log("clicked on Generate Offer button");
            }

            closeUnwantedTab();
            BaseTest.log("job offer tab closed.");

            BrowserUtils.refreshPage(driver);
            BaseTest.log("Page refreshed");

            clickOnElement1(candidates);
            BaseTest.log("Clicked on Candidates tab");

            clickOnElement1(offeredPipeline);
            BaseTest.log("Clicked on Offered Pipeline");


        }
        else
        {
            System.out.println("Offer letter is already generated.");
        }
    }
    public boolean checkOfferStatus()
    {
        waitTS(3);
        String offerStatusText1 = waitForElement(offerStatus1).getText().trim();
        if (offerStatusText1.equals("Sent"))
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    //endregion

    //region Hired

    public void clickHiredPipeline()
    {
        clickOnElement1(hiredPipeline);
    }

    //region Initiate Onboarding
    public void clickInitiateOnboardingIcon()
    {
        waitForElement(initiateOnboardingIcon).click();
    }

    public void selectProcess()
    {
        waitForElement(processDD).click();
        waitTS(2);
        selectDropdownOption("Onboarding Process");
    }

    public void clickNext()
    {
        waitForElement(next).click();
    }

    //region Initiate Onboarding Popup
    public void provideJoiningDate()
    {
        clearAndProvide1(joiningDate, DateUtils.addDaysToCurrentDate(7,"dd-MMM-yyyy"));

    }
    public void provideArrivalTime()
    {
        clearAndProvide1(arrivalTime, DateUtils.getCurrentTime("hh:mm a"));
    }
    public void selectContactPerson()
    {
        provideAndEnter(contactPerson, "001 | Vaibhav Chavan");
    }
    public void selectDepartment()
    {
        provideAndEnter(department, "QC");
    }
    public void selectDesignation()
    {
        provideAndEnter(designation, "Systems Analyst");
    }
    public void selectWorkLocation()
    {
        provideAndEnter(workLocation, "Salmiya City");
    }
    public void provideWelcomeMessage()
    {
        clearAndProvide1(welcome, "Welcome to the team!");
    }
    public void provideWelcomeUrl()
    {
        clearAndProvide1(welcomeUrl, "https://www.example.com/welcome");
    }
    public void provideOtherInstructions()
    {
        clearAndProvide1(otherInstructions, "Please complete the onboarding process.");
    }
    public void clickAddIcon()
    {
        waitForElement(addIcon).click();
    }
    public void provideQuestionName()
    {
        clearAndProvide1(questionName, "what is your name?");
    }
    public void selectType()
    {
        provideAndEnter(type, "Free Text");
    }
    public void clickSave1()
    {
        waitForElement(save1).click();
    }
    public void clickInitate()
    {
        waitForElement(initate).click();
    }
    //endregion

    //endregion

    //region Convert to Employee

    public void clickConvertToEmployeeIcon()
    {
        waitTS(3);
        try
        {
            waitForElement(convertToEmployeeIcon).click();
        } catch (Exception e)
        {
            waitForElement(convertToEmployeeIcon).click();
        }

    }








    //endregion

    //endregion

    //region Rejected

    //endregion

    //endregion

    //endregion

    //endregion
}