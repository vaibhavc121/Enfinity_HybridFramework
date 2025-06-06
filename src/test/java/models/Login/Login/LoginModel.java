package models.Login.Login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.Payroll.Payroll.PayrollModel;

public class LoginModel
{
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class SignInModel
	{
		public String Url;
		public String Username;
		public String Password;
	}

}
