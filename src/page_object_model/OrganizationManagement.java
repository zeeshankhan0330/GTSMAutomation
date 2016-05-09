package page_object_model;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class OrganizationManagement  {

	ChromeDriver driver;
	public OrganizationManagement(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickOnOrganizationManagementLink ()
	{
		driver.findElement(By.xpath("//li[@id='adminORGfunctioncontentmenuitem5']/a[@href='/Organization/OrganizationManagement']")).click();
			}
	
	public void clickOnAddTab()
	{
		driver.findElement(By.xpath("//li/a[@id='ui-id-3']")).click();
	}
	
	public void enterNewOrganizationName(String OrganizationName)
	{
		driver.findElement(By.id("txtorg_name")).sendKeys(OrganizationName);
	}
	
	public void selectOrganizationTypefromDropdown(String OrganizationType)
	{
		WebElement dropdownlist = driver.findElement(By.id("in_orgtype"));
  		Select OrganizationTypeDropdown = new Select(dropdownlist);
  		OrganizationTypeDropdown.selectByVisibleText(OrganizationType);
	}
	
	public void selectAirlineCodeFromDropdown(String AirlineCode)
	{
		WebElement dropdownlist1 = driver.findElement(By.id("inddnairlinecode"));
  		Select AirlineCodeDropDown = new Select(dropdownlist1);
  		AirlineCodeDropDown.selectByVisibleText(AirlineCode);
  		
	}
	
	public void clickOnAddButton()
	{
		driver.findElement(By.id("btnupdate")).click();
	}
	
	public void verifyNewOrganizationIsAddedOrNot() throws InterruptedException
	{
		Thread.sleep(5000);
		
		try {
			
  		  		String expected = "The organization details added successfully.";
  		 String actual = driver.findElement(By.xpath("//div[@id='divvalidationMsg']/div[@class='successmessage']")).getText();
  		Assert.assertEquals(actual, expected);
  	  		   		
  	  		   		 
  	  		   		 
		}
		
		catch (Exception e)
		{
			System.out.println("Exception in verifyNewOrganizationIsAddedOrNot"+e.getMessage());
		}
	}
	
	public void goToHomePage()
	{
		driver.findElementByLinkText("Home").click();
	}
	
	public void enterOrgName(String OrganizationName)
	{
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div/div[3]/div[2]/div/table/thead/tr[2]/th[2]/div/input")).sendKeys(OrganizationName);
	}
	
	public void enterOrgType(String OrganizationType )
	{
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div/div[3]/div[2]/div/table/thead/tr[2]/th[3]/div/input")).sendKeys(OrganizationType);
	}
	
	public void enterAirlineCode(String AirlineCode)
	{
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div/div[3]/div[2]/div/table/thead/tr[2]/th[4]/div/input")).sendKeys(AirlineCode);
	}
	
	public void selectOrganizationToBeUpdated() throws InterruptedException
	{
		List<WebElement>  abc= driver.findElements(By.id("myGrid"));  
		for(WebElement abcd : abc)
		{
			Thread.sleep(5000);
	         abcd.click();
		}
	   
	}
	
	public void clickOnModifyButton()
	{
		driver.findElement(By.xpath("//tr/td/input[@id='btnmodify']")).click();
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
	}
	
	public void clearOrganizationName()
	{
		driver.findElement(By.xpath("//input[@id='txtOrgName' and @class='input']")).clear();
	}
	
	public void enterUpdatedOrganizationName(String UpdatedOrganizationName)
	{
		driver.findElement(By.xpath("//input[@id='txtOrgName' and @class='input']")).sendKeys(UpdatedOrganizationName);
	}
	
	public void updateOrgType(String UpdatedOrganizationType)
	{
		WebElement dropdownlist = driver.findElement(By.id("ddnorgtype"));
		Select OrganizationTypeDropdown = new Select(dropdownlist);
		OrganizationTypeDropdown.selectByVisibleText(UpdatedOrganizationType);
	}
	
	public void clickOnUpdateButton()
	{
		driver.findElement(By.xpath("//input[@id='btnadd' and @class='btnModify marginRight']")).click();
	}
	
	public void verifyOrganizationUpdated()
	{
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String expected = "The organization details updated successfully.";
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); 
 		 String actual = driver.findElement(By.xpath("//div[@id='divvalidationMsg']/div[@class='successmessage']")).getText();
 		Assert.assertEquals(actual, expected);
 		 
 		 driver.findElement(By.xpath("//div/div/button[@type='button']")).click();
	}
	
	public void enterOrganizationNameToBeDeleted(String UpdatedOrganizationName)
	{
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div/div[3]/div[2]/div/table/thead/tr[2]/th[2]/div/input")).sendKeys(UpdatedOrganizationName);
	}
	
	public void enterOrganizationTypeToBeDeleted(String UpdatedOrganizationType)
	{
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div/div[3]/div[2]/div/table/thead/tr[2]/th[3]/div/input")).sendKeys(UpdatedOrganizationType);
	}
	
	public void selectOrganizationToBeDeleted() throws InterruptedException
	{
		List<WebElement>  abc= driver.findElements(By.id("myGrid"));  
		for(WebElement abcd : abc)
		{
			Thread.sleep(5000);
	         abc.get(0).click();
		}
	}
	
	public void clickonDeleteButton()
	{
		driver.findElement(By.xpath("//tr/td/input[@class='btnRemove marginRight']")).click();
	}
	
	public void clickOnOkButton()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//div/input[@id='btnok']")).click();
	}
	
	public void verifyOrganizationDeleted()
	{
		String expected = "The organization details deleted successfully.";
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); 
		 String actual = driver.findElement(By.xpath("//div[@id='divvalidationMsg']/div[@class='successmessage']")).getText();
		Assert.assertEquals(actual, expected);
		driver.findElement(By.xpath("//div/div[@class='ui-dialog-buttonset']/button[@class='ui-button-text-only']")).click();
	}
	
	
	
	
}
