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
import page_object_model.PCC_IATA_Agt_Name_Management;

public class TC005_Activate_Agency extends Common {

	
	@Test (priority =5)
	public void activateAgency() throws BiffException, IOException, InterruptedException
	{
		File f2 = new File(".\\Test Data Sheet\\GTSM_Test_Data.xls");
		 Workbook wf2 = Workbook.getWorkbook(f2);
		 Sheet s2 = wf2.getSheet("PCC-IATA-Management");
		 Cell c1 = s2.getCell(0,1);
		 String AgencyName = c1.getContents();
		 Cell c2 = s2.getCell(1,1);
		 String IATANumber = c2.getContents();
		 Cell c3 = s2.getCell(2,1);
		 String PCC = c3.getContents();
		 
		 Login obj = new Login(driver);
			obj.loginAsConsultant();
		
		PCC_IATA_Agt_Name_Management pcc = new PCC_IATA_Agt_Name_Management(driver);
		pcc.goToHomePage();
		 pcc.clickonPCCIATAdopdown();
		pcc.enterAgencyNameToBeUpdated(AgencyName);
		pcc.enterIATANumberToBeUpdated(IATANumber);
		pcc.enterPCCtoBeUpdated(PCC);
		pcc.selectAgencyToBeUpdated();
		pcc.clickOnSuspendActiveButton();
		 pcc.clickOnOkButtonAfterClickingSuspendActiveButton();
		pcc.clickOnActivateButton();
		pcc.verifyAgencyIsActivated();
		
		
	}
	
}
