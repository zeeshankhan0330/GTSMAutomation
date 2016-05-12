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
import page_object_model.Login;
import page_object_model.Region_Management;

public class TC009_Add_New_Country extends Common {

	@Test (priority =9)
	public void addNewCountry() throws BiffException, IOException
	{
		File f2 = new File(".\\Test Data Sheet\\GTSM_Test_Data.xls");
		 Workbook wf2 = Workbook.getWorkbook(f2);
		 Sheet s2 = wf2.getSheet("Region Management");
		 Cell c1 = s2.getCell(0,1);
		 String CountryCode = c1.getContents();
		 Cell c2 = s2.getCell(1,1);
		 String CountryName = c2.getContents();
		 
		 Login login = new Login(driver);
			login.loginAsAdmin();
		 
		 Region_Management rm = new Region_Management(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 rm.clickOnRegionManagementLink();
		 rm.clickOnAddTab();
		 rm.enterNewCountryCode(CountryCode);
		 rm.enterNewCountryName(CountryName);
		 rm.check_uncheckValueTickBox();
		 rm.check_uncheckVolumeTickBox();
		 rm.chekc_uncheckEmdEnableTickBox();
		 rm.clickOnAddButton();
		 rm.verifyNewCountryIsAdded();
		 
	}
	
}
