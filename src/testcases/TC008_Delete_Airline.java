package testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.Test;

import base.Common;
import page_object_model.Airline_Management;
import page_object_model.Login;

public class TC008_Delete_Airline extends Common {
	
	@Test (priority =8)
	public void deleteAirline() throws BiffException, IOException, InterruptedException
	{
		File f2 = new File(".\\Test Data Sheet\\GTSM_Test_Data.xls");
		 Workbook wf2 = Workbook.getWorkbook(f2);
		 Sheet s2 = wf2.getSheet("Airline Management");
		 Cell c1 = s2.getCell(0,1);
		 String AirlineCode = c1.getContents();
		  Cell c3 = s2.getCell(2,1);
		  String UpdatedDescription = c3.getContents();
		  
		  Login login = new Login(driver);
			login.loginAsAdmin();
		
		Airline_Management air = new Airline_Management(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		air.clickOnAirlineManagementLink();
		air.enterAirlineCodeToBeUpdated(AirlineCode);
		air.enterUpdatedAirlineDescription(UpdatedDescription);
		air.selectAndClickAirlineToBeDeleted();
		air.clickOnDeleteButton();
		air.clickOnOkButtonOnWarningMessage();
		air.verifyAirlineIsDeleted();
		
		
	}

}
