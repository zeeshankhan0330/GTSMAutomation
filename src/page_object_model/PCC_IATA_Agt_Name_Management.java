package page_object_model;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class PCC_IATA_Agt_Name_Management {

	WebDriver driver;
	public PCC_IATA_Agt_Name_Management(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickonPCCIATAdopdown()
	{
		WebElement lMail=driver.findElement(By.xpath(".//*[@id='adminPCCIATAfunctioncontentmenuitem3']/a"));
		//WebElement lMail=driver.findElement(By.linkText("PCC/IATA/Agent Name Management"));
		lMail.click();
       /* Actions builder=new Actions(driver);
        builder.moveToElement(lMail).perform();
        driver.findElement(By.xpath("//li[@id='adminmenuitem3']")).click();*/
	}
	
	public void enterAgencyName(String AgencyName)
	{
	
		
		driver.findElement(By.xpath("//div/input[@id='gs_agentname' and @name='agentname']")).sendKeys(AgencyName);
		
	}
	
	public void enterIataNumber(String IATANumber)
	{
		driver.findElement(By.xpath("//div/input[@id='gs_iata' and @name='iata']")).sendKeys(IATANumber);
       
	}
	
	public void enterPCC(String PCC)
	{
		 driver.findElement(By.xpath("//div/input[@id='gs_pccshow' and @name='pccshow']")).sendKeys(PCC);
	}
	
	public void selectAgenyToSuspend() throws InterruptedException
	{
		 List<WebElement>  abc= driver.findElements(By.id("myGrid"));  
	    	for(WebElement abcd : abc)
	    	{
	    		Thread.sleep(5000);
	             abcd.click();
	    	}
	}
	
	public void clickOnSuspendActiveButton()
	{
		driver.findElement(By.xpath("//input[@id='btnSuspendActive' and @value='Suspend/Active']")).click();
	}
	
	public void clickOnOkButtonAfterClickingSuspendActiveButton()
	{
		driver.findElement(By.xpath("//input[@id='btnok' and @class='btnModify marginRight']")).click();
	}
	
	public void clickOnSuspendButtonOnWarningMessageBox()
	{
		driver.findElement(By.xpath("//input[@id='btnSuspend' and @class='btnModify marginRight']")).click();
	}
	
	public void verifyAgencyIsSuspended()
	{
		String expected = "The iata number suspended successfully.";
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
    	String actual = driver.findElement(By.xpath("//div[@id='divvalidationMsg']/div[@class='successmessage']")).getText();
		Assert.assertEquals(actual, expected);
		driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']/button[@class='ui-button-text-only']")).click();
	}
	
	public void goToHomePage()
	{
		driver.findElement(By.xpath(".//li[@id='home']/a")).click();
	}
	
	public void enterAgencyNameToBeUpdated(String AgencyName)
	{
		driver.findElement(By.xpath("//div/input[@id='gs_agentname' and @name='agentname']")).sendKeys(AgencyName);
	}
	
	public void enterIATANumberToBeUpdated(String IATANumber)
	{
		 driver.findElement(By.xpath("//div/input[@id='gs_iata' and @name='iata']")).sendKeys(IATANumber);
	}
	
	public void enterPCCtoBeUpdated(String PCC)
	{
		driver.findElement(By.xpath("//div/input[@id='gs_pccshow' and @name='pccshow']")).sendKeys(PCC);
	}
	
	public void selectAgencyToBeUpdated() throws InterruptedException
	{
		 List<WebElement>  abc= driver.findElements(By.id("myGrid"));  
		   	for(WebElement abcd : abc)
		   	{
		   		Thread.sleep(5000); 
		            abcd.click();
		   	}
	}
	
	public void clickOnActivateButton()
	{
		driver.findElement(By.xpath("//input[@id='btnActivate' and @class='btnModify marginRight']")).click();
	}
	
	public void verifyAgencyIsActivated()
	{
		String expected = "The iata number activated successfully.";
	   	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
	   	String actual = driver.findElement(By.xpath("//div[@id='divvalidationMsg']/div[@class='successmessage']")).getText();
			Assert.assertEquals(actual, expected);
			driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']/button[@class='ui-button-text-only']")).click();
	}
}
