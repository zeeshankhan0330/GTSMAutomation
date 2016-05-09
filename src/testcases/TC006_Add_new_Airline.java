package testcases;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.Test;

import base.Common;
import page_object_model.Airline_Management;
import page_object_model.Login;

public class TC006_Add_new_Airline extends Common {
	
	@Test (priority =6)
	public void addNewAirline() throws BiffException, IOException
	{
		
		File f2 = new File(".\\Test Data Sheet\\GTSM_Test_Data.xls");
		 Workbook wf2 = Workbook.getWorkbook(f2);
		 Sheet s2 = wf2.getSheet("Airline Management");
		 Cell c1 = s2.getCell(0,1);
		 String AirlineCode = c1.getContents();
		 Cell c2 = s2.getCell(1,1);
		 String Description = c2.getContents();
		 
		 
		 
		Login login = new Login(driver);
		login.loginAsAdmin();
		
		Airline_Management air = new Airline_Management(driver);
		air.clickOnAirlineManagementLink();
		air.clickOnAddTab();
		air.enterNewAirlineCode(AirlineCode);
		air.enterNewAirlineDescription(Description);
		air.clickOnAddButton();
		air.verifyNewAirlineIsAdded();
		
	}

}
