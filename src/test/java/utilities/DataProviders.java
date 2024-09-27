package utilities;

import java.io.IOException;

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
}
