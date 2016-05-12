package testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import base.Common;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import page_object_model.Login;
import page_object_model.OrganizationManagement;

public class TC003_Delete_Organization extends Common {

	@Test (priority =3)
	public void deleteOrganization() throws BiffException, IOException, InterruptedException
	{
		File f2 = new File(".\\Test Data Sheet\\GTSM_Test_Data.xls");
		 Workbook wf2 = Workbook.getWorkbook(f2);
		 Sheet s2 = wf2.getSheet("Add Organization");
		 
		
		 
		 Cell c4 = s2.getCell(3,1);
			String UpdatedOrganizationName = c4.getContents();
			Cell c5 = s2.getCell(4,1);
			String UpdatedOrganizationType = c5.getContents();
			
			 Login obj = new Login(driver);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				obj.loginAsConsultant();
			
			
		OrganizationManagement org = new OrganizationManagement(driver);
		org.goToHomePage();
		org.clickOnOrganizationManagementLink();
		org.enterOrganizationNameToBeDeleted(UpdatedOrganizationName);
		org.enterOrganizationTypeToBeDeleted(UpdatedOrganizationType);
		org.selectOrganizationToBeDeleted();
		org.clickonDeleteButton();
		org.clickOnOkButton();
		org.verifyOrganizationDeleted();
	}

	
	
}
