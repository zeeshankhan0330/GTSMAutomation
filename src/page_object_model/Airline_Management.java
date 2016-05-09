package page_object_model;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Airline_Management {
	
	ChromeDriver driver;
	public Airline_Management(ChromeDriver driver){
	this.driver = driver;
	}
	public void clickOnAirlineManagementLink()
	{
		driver.findElement(By.xpath("//ul/li[@id='adminAirlinefunctioncontentmenuitem4']/a")).click();
	}

	public void clickOnAddTab()
	{
		driver.findElement(By.xpath("//ul/li[@class='ui-state-default ui-corner-top']/a[@id='ui-id-3']")).click();
	}
	
	public void enterNewAirlineCode(String AirlineCode)
	{
		driver.findElement(By.xpath("//td/input[@id='txtairlineCode' and @name='txtairlineCode' ]")).sendKeys(AirlineCode);
	}
	
	public void enterNewAirlineDescription(String Description)
	{
		driver.findElement(By.xpath("//td/input[@id='txtdescription' and @name='txtdescription' ]")).sendKeys(Description);
	}
	
	public void clickOnAddButton()
	{
		driver.findElement(By.xpath("//td/input[@id='' and @class='btnModify marginRight']")).click();
	}
	
	public void verifyNewAirlineIsAdded()
	{
		String expected = "The airline details added successfully.";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
	   	String actual = driver.findElement(By.xpath("//div/div[contains(text(),' The airline details added successfully. ')]")).getText();
			Assert.assertEquals(actual, expected);
			driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']/button[@class='ui-button-text-only']")).click();
	}
	
	public void goToHomePage()
	{
		driver.findElementByLinkText("Home").click();
	}
	
	public void enterAirlineCodeToBeUpdated(String AirlineCode)
	{
		driver.findElement(By.xpath("//div/input[@id='gs_Airline Code']")).sendKeys(AirlineCode);
	}
	
	public void enterAirlineDescriptionToBeUpdated(String Description)
	{
		driver.findElement(By.xpath("//div/input[@id='gs_Airline Desc']")).sendKeys(Description);
	}
	
	public void selectAndClickOnAirlineToBeUpdated() throws InterruptedException
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
	}
	
	public void clearTextfromAirlineDescriptionField(String UpdatedDescription)
	{
		driver.findElement(By.xpath("//tr/td/input[@id='txtupdairlinedesc']")).sendKeys(UpdatedDescription);
	}
	
	public void clickOnUpdateButton()
	{
		driver.findElement(By.xpath("//tr/td[@align='right']/input[@class='btnModify marginRight' and @value='Update']")).click();
	}
	
	public void verifyAirlineIsUpdated()
	{
		String expected = "The airline details updated successfully.";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	   	String actual = driver.findElement(By.xpath("//div[@id='divvalidationMsg']/div[@class='successmessage']")).getText();
			Assert.assertEquals(actual, expected);
			driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']/button[@class='ui-button-text-only']")).click();
	}
	
	public void enterUpdatedAirlineDescription(String UpdatedDescription)
	{
		driver.findElement(By.xpath("//div/input[@id='gs_Airline Desc']")).sendKeys(UpdatedDescription);
	}
	
	public void selectAndClickAirlineToBeDeleted() throws InterruptedException
	{
		List<WebElement>  abc= driver.findElements(By.id("myGrid"));  
    	for(WebElement abcd : abc)
    	{
    		Thread.sleep(5000);
             abcd.click();
    	}
    	
	}
	
	public void clickOnDeleteButton()
	{
		driver.findElement(By.xpath("//td/input[@id='btndelete' and @class='btnRemove marginRight']")).click();
	}
	
	public void clickOnOkButtonOnWarningMessage()
	{
		driver.findElement(By.xpath("//div/input[@id='btnok']")).click();
	}
	
	public void verifyAirlineIsDeleted()
	{
		String expected = "The selected airline was deleted successfully.";
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
	   	String actual = driver.findElement(By.xpath("//div[@id='divvalidationMsg']/div[@class='successmessage']")).getText();
			Assert.assertEquals(actual, expected);
			driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']/button[@class='ui-button-text-only']")).click();
	}
}
