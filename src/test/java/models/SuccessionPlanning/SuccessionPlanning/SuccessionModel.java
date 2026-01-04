package models.SuccessionPlanning.SuccessionPlanning;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class SuccessionModel
{
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SuccessionPlanningModel
    {
        public String name;
        public String designation;
        public String employee;
        public String minimumPercentage;
        public String qualificationPercentage;
        public String experiencePercentage;
        public String skillsPercentage;
        public String appraisalPercentage;
        public String coursePercentage;
        public String description;
    }

    public static class ReadinessModel
    {
        public String name;
        public String fromPercentage;
        public String toPercentage;
    }

    public static class SuperiorityModel
    {
        public String name;
        public String fromPercentage;
        public String toPercentage;
    }
}