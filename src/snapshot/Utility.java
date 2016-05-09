package snapshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;



public class Utility  {

	public static void captureScreenShot(ChromeDriver driver, String ScreenshotName ) throws IOException
	
	{
		try {
		TakesScreenshot tr =   (TakesScreenshot)driver;
		File source = tr.getScreenshotAs(OutputType.FILE);
		File f1 = new File("./Screenshots/"+ScreenshotName+".png");
		FileUtils.copyFile(source, f1);
		}
		catch (Exception e)
		{
			System.out.println("Exception in taking screenshot "+e.getMessage());
		}
	}
	
}
