package models.Learning.Learning;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.Payroll.Payroll.PayrollModel;

public class LearningModel
{
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class CourseModel
	{
		public String courseName;
		public String category;
		public String mode;
		public String courseTrainer;
		public String type;
		public String enroller;
		public List<Skill> Skills;
		public String batchName;
		public String startDate;
		public String endDate;

		public static class Skill
		{
			public String SkillName;
			public String Level;
			public String Weightage;
		}
	}

}
