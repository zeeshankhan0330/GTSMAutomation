package testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;






import base.*;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import page_object_model.Login;
import page_object_model.OrganizationManagement;

public class TC001_Add_Organization extends Common {
	
	

	
	
	
	@Test (priority =1)
	public void addOrganization() throws BiffException, IOException, InterruptedException{
		 
		File f1 = new File(".\\Test Data Sheet\\GTSM_Test_Data.xls");
		 Workbook wf1 = Workbook.getWorkbook(f1);
		
		 Sheet s2 = wf1.getSheet("Add Organization");
		 
		 Cell c1 = s2.getCell(0,1);
		 String OrganizationName = c1.getContents();
		 Cell c4 = s2.getCell(1,1);
		 String OrganizationType = c4.getContents();
		 Cell c5 = s2.getCell(2,1);
		 String AirlineCode = c5.getContents();
	
		
		
	
		 
		 Login obj = new Login(driver);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		obj.loginAsConsultant();
	
		
		OrganizationManagement org = new OrganizationManagement(driver);
		org.clickOnOrganizationManagementLink();

		
		org.clickOnAddTab();
		
		
		org.enterNewOrganizationName(OrganizationName);
		
		
		org.selectOrganizationTypefromDropdown(OrganizationType);
	
		
		org.selectAirlineCodeFromDropdown(AirlineCode);
	
		
		org.clickOnAddButton();
	
		
		
Thread.sleep(5000);
		
				
  		  		String expected = "The organization details added successfully.";
  		 String actual = driver.findElement(By.xpath("//div[@id='divvalidationMsg']/div[@class='successmessage']")).getText();
  		Assert.assertEquals(actual, expected);
  	  		   		
  	  		   		 
  	  		   		 
		
	
		 driver.findElement(By.xpath("//div/div/button[@type='button']")).click();
		
			
		
		
	
		
		
	}


}
