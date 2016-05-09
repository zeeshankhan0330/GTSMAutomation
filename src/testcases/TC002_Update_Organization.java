package testcases;

import java.io.File;
import java.io.IOException;


import org.testng.annotations.Test;



import base.Common;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import page_object_model.Login;
import page_object_model.OrganizationManagement;

public class TC002_Update_Organization extends Common {

	
	
	
	@Test (priority =2)
	public void updateOrganization() throws BiffException, IOException, InterruptedException
	{
		File f2 = new File(".\\Test Data Sheet\\GTSM_Test_Data.xls");
		 Workbook wf2 = Workbook.getWorkbook(f2);
		 
				
		 
		 Sheet s2 = wf2.getSheet("Add Organization");
		 Cell c1 = s2.getCell(0,1);
		 String OrganizationName = c1.getContents();
		 Cell c2 = s2.getCell(1,1);
		 String OrganizationType = c2.getContents();
		 Cell c3 = s2.getCell(2,1);
		 String AirlineCode = c3.getContents();
		Cell c4 = s2.getCell(3,1);
		String UpdatedOrganizationName = c4.getContents();
		Cell c5 = s2.getCell(4,1);
		String UpdatedOrganizationType = c5.getContents();
		
		

		
		 Login obj = new Login(driver);
			obj.loginAsConsultant();
		
		
		OrganizationManagement org1 = new OrganizationManagement(driver);
		org1.goToHomePage();
		org1.clickOnOrganizationManagementLink();
		
		
		org1.enterOrgName(OrganizationName);
		
		
		org1.enterOrgType(OrganizationType);
		
		
		org1.enterAirlineCode(AirlineCode);
	
		
		org1.selectOrganizationToBeUpdated();
		
		
		org1.clickOnModifyButton();
		
		
		org1.clearOrganizationName();
		
		
		org1.enterUpdatedOrganizationName(UpdatedOrganizationName);
		
		
		org1.updateOrgType(UpdatedOrganizationType);
		
		
		org1.clickOnUpdateButton();
	
		
org1.verifyOrganizationUpdated();
		
		
	
		
				
	}
}
