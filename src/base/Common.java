package base;



import java.io.IOException;







import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;






import org.testng.annotations.Parameters;

import snapshot.Utility;




public class Common {

	
	
	public WebDriver driver;
	
	
	@BeforeClass
	@Parameters("browser")
	public void initiate(String browser){
		
		
	
		if(browser.equalsIgnoreCase("chrome"))
		{
System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver.exe");
	driver = new ChromeDriver();
	
	
		}
		
		else if (browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			
		}
		
		else if (browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./BrowserDrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
			
		}
		
		driver.manage().window().maximize();
		
		driver.get("http://10.7.247.99/");
	
	}

	@AfterMethod
	public void TearDown(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenShot(driver, result.getName());
		}
		
		driver.close();
		driver.quit();
		
	}
	
	 


}



