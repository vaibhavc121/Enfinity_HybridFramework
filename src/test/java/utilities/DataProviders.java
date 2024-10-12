package utilities;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DataProviders
{
	// data provider 1

	@DataProvider(name = "ResidencyInfo")
	public String[][] getResidencyInfo() throws IOException
	{
		String path = ".\\testdata\\testdata.xlsx";

		ExcelUtility xlutil = new ExcelUtility(path);

		int totalrows = xlutil.getRowCount("ResidencyInfo");
		int totalcols = xlutil.getCellCount("ResidencyInfo", 1);

		String data[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++)
		{
			for (int j = 0; j < totalcols; j++)
			{
				data[i - 1][j] = xlutil.getCellData("ResidencyInfo", i, j);
			}
		}

		return data;
	}

	// data provider 2
	@DataProvider(name = "employeeinfo")
	public Object[][] getDataFromDB() throws Exception
	{
		// Query to get test data
		String query = "SELECT email, name, mobile, DOJ, dept, designation, grade, gender, religion, maritalstatus FROM employees";

		// Fetch data from DB
		ResultSet resultSet = DatabaseUtility.getTestData(query);
		List<Object[]> testData = new ArrayList<>();

		// Loop through the result set and store data in List
		while (resultSet.next())
		{
			String email = resultSet.getString("email");
			String name = resultSet.getString("name");
			String mobile = resultSet.getString("mobile");
			String DOJ = resultSet.getString("DOJ");
			String dept = resultSet.getString("dept");
			String designation = resultSet.getString("designation");
			String grade = resultSet.getString("grade");
			String gender = resultSet.getString("gender");
			String religion = resultSet.getString("religion");
			String maritalstatus = resultSet.getString("maritalstatus");
			testData.add(new Object[]
			{ email, name, mobile, DOJ, dept, designation, grade, gender, religion, maritalstatus });
		}

		// Convert List to Object[][]
		return testData.toArray(new Object[testData.size()][]);
	}

}
