package base;



import java.io.IOException;



import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;



import snapshot.Utility;




public class Common {

	
	
	public ChromeDriver driver;
	
	
	@BeforeClass
	public void initiate(){
System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver.exe");
	driver = new ChromeDriver();
	
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



