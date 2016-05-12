package page_object_model;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Region_Management {
	
	WebDriver driver;
	public Region_Management(WebDriver driver){
	this.driver = driver;
	}
	
	public void clickOnRegionManagementLink()
	{
		driver.findElement(By.xpath("//li[@id='adminRegionfunctioncontentmenuitem1']/a[contains(text(),'Region Management')]")).click();
	}
	
	public void clickOnAddTab()
	{
		driver.findElement(By.xpath("//li/a[@id='ui-id-3']")).click();
	}
	
	public void enterNewCountryCode(String CountryCode)
	{
		driver.findElement(By.xpath("//td/input[@id='txtCountryCode']")).sendKeys(CountryCode);
	}
	
	public void enterNewCountryName(String CountryName)
	{
		driver.findElement(By.xpath("//td/input[@id='txtCountryName']")).sendKeys(CountryName); 
	}
	
	public void check_uncheckValueTickBox()
	{
		driver.findElement(By.xpath("//input[@id='chkValue']")).click();
	}
	
	public void check_uncheckVolumeTickBox()
	{
		driver.findElement(By.xpath("//input[@id='chkVolume']")).click();
	}
	
	public void chekc_uncheckEmdEnableTickBox()
	{
		driver.findElement(By.xpath("//input[@id='chkEmdEnable']")).click();
	}
	
	public void clickOnAddButton()
	{
		driver.findElement(By.xpath("//input[@class='btnAdd' and @type='button']")).click();
	}
	
	public void check_uncheckVolumeTickBoxOnUpdate()
	{
		
		driver.findElement(By.xpath("//input[@id='chkUpVolume']")).click();
    	
	}
	
	public void check_uncheckValueTickBoxOnUpdate()
	{
		driver.findElement(By.xpath("//input[@id='chkUpValue']")).click(); 
	
	}
	
	public void check_uncheckEMDTickBoxOnUpdate()
	{
		driver.findElement(By.xpath("//input[@id='chkUpEmdEnabled']")).click();
	}
	
	public void verifyNewCountryIsAdded()
	{
		String expected = "The new country/region is added successfully.";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
	   	String actual = driver.findElement(By.xpath("//div/div[@class='successmessage']")).getText();
			Assert.assertEquals(actual, expected);
			driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']/button[@class='ui-button-text-only']")).click();
	}
	
	public void goToHomePage()
	{
		driver.findElement(By.xpath(".//li[@id='home']/a")).click();
	}
	
	public void enterCountryCodeToBeUpdated(String CountryCode)
	{
		driver.findElement(By.xpath("//div/input[@id='gs_district_id']")).sendKeys(CountryCode); 
	}
	
	public void enterCountryNameToBeUpdated(String CountryName)
	{
		driver.findElement(By.xpath("//div/input[@id='gs_ditrict_name']")).sendKeys(CountryName);
	}
	
	public void selectCountryFromList() throws InterruptedException
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
		driver.findElement(By.xpath("//td/input[@id='btnmodify']")).click();
  	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void clearCountryNameField()
	{
		driver.findElement(By.xpath("//td/input[@id='txtupdCountryName']")).clear();
	}
	
	public void enterCountryNameToBeUpdatedInField(String UpdatedCountryName)
	{
	driver.findElement(By.xpath("//td/input[@id='txtupdCountryName']")).sendKeys(UpdatedCountryName);
	}
	
	public void clickOnModifyButtonToUpdateTheChanges()
	{
		driver.findElement(By.xpath("//input[@id='btnnodify']")).click();
	}
	
	public void verifyCountryNameIsUpdated()
	{
		String expected = "The country/region is updated successfully.";
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
       	String actual = driver.findElement(By.xpath("//div/div[@class='successmessage']")).getText();
    		Assert.assertEquals(actual, expected);
    		driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']/button[@class='ui-button-text-only']")).click();
	}
	
	public void enterUpdatedCountryName(String UpdatedCountryName)
	{
		driver.findElement(By.xpath("//div/input[@id='gs_ditrict_name']")).sendKeys(UpdatedCountryName); 
	}
	
	public void selectUpdatedCountryFromTheList() throws InterruptedException
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
		driver.findElement(By.xpath("//td/input[@class='btnDelete marginRight']")).click();
	}
	
	public void clickOnOkButtonOnWarningPrompt()
	{
		driver.findElement(By.xpath("//form/input[@id='btnok']")).click();
	}
	
	public void verifyCountryIsDeleted()
	{
		String expected = "The region is deleted successfully.";
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
       	String actual = driver.findElement(By.xpath("//div/div[@class='successmessage']")).getText();
    		Assert.assertEquals(actual, expected);
    		driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']/button[@class='ui-button-text-only']")).click();
	}
	
}
