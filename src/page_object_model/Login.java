package page_object_model;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import base.Common;
import jxl.*;
import jxl.read.biff.BiffException;


public class Login {
	
	
	
ChromeDriver driver;
public Login(ChromeDriver driver){
	this.driver = driver;
}
	
		
		 public void loginAsConsultant() throws BiffException, IOException{
			 
			 File f1 = new File(".\\Test Data Sheet\\GTSM_Test_Data.xls");
			 Workbook wf1 = Workbook.getWorkbook(f1);
			 Sheet s1 = wf1.getSheet("URL and Credentials");
			 Sheet s2 = wf1.getSheet("Add Organization");
			 Cell c2 = s1.getCell(1,1);
			 String Username = c2.getContents();
			 Cell c3 = s1.getCell(2,1);
			 String Password = c3.getContents();
			 
			 driver.findElement(By.id("txtusername")).sendKeys(Username);
			 driver.findElement(By.id("txtPassword")).sendKeys(Password);
			 driver.findElement(By.xpath("//a/img[@src='/Resources/images/loginButton.gif']")).click();
			
		 }
		 

	
	public void loginAsAdmin() throws BiffException, IOException
	{
		File f1 = new File(".\\Test Data Sheet\\GTSM_Test_Data.xls");
		 Workbook wf1 = Workbook.getWorkbook(f1);
		 Sheet s1 = wf1.getSheet("URL and Credentials");
		 Cell c1 = s1.getCell(0,2);
		 String URL = c1.getContents();
		 Cell c2 = s1.getCell(1,2);
		 String SuperUsername = c2.getContents();
		 Cell c3 = s1.getCell(2,2);
		 String SuperPassword = c3.getContents();
		 
		 driver.findElement(By.id("txtusername")).sendKeys(SuperUsername);
		 driver.findElement(By.id("txtPassword")).sendKeys(SuperPassword);
		 driver.findElement(By.xpath("//a/img[@src='/Resources/images/loginButton.gif']")).click();
	}
		 
		
		
	
		
	public void close()
	{
		driver.close();
	}

}
