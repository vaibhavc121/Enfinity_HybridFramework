package models.Performance.Performance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class PerformanceModel
{
    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    public static class AppraisalCycleModel
    {
        public String appraisalFromDate;
        public String appraisalToDate;
        public String processFromDate;
        public String processToDate;
        public String description;
        public boolean goals;
        public boolean KRA;
        public boolean competency;
        public boolean reviewQuestions;
        public String goalsWeightage;
        public String KRAWeightage;
        public String competencyWeightage;
        public String goalRating;
        public String keyResultAreaRating;
        public String competencyRating;
        public String overallRating;
        public String employee;
        public boolean allowManualWorkflow;
        public String workflow;
        public boolean enableReviewerOpinion;
        public boolean enableSkillSetAssessment;
    }

    public static class FeedbackCycleModel
    {
        public String name;
        public String description;
        public String processFromDate;
        public String processToDate;
        public String workflow;
        public String minimumRater;
        public String maximumRater;
        public boolean allowRatingCheckbox;
        public String overallRating;
        public boolean manualOverallRatingCheckbox;
        public String joiningDateUntil;
        public String employee;
        public List<Question> questions;

        public static class Question
        {
            public String question;
            public String category;
            public String ratingType;
            public boolean mandatoryCheckbox;
        }
    }
}