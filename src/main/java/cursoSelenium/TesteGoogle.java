package cursoSelenium;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;


public class TesteGoogle {
	 
	@Test
	 
	public void teste() {
	//	System.setProperty("webdriver.gecko.driver", "C:/SeleniumDrivers/geckodriver.exe");
	//	System.setProperty("webdriver.chrome.driver", "C:/SeleniumDrivers/chromedriver.exe");
	//	System.setProperty("webdriver.ie.driver", "C:/SeleniumDrivers/IEDriverServer.exe");
	//	WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
	//	DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	//	caps.setCapability("ignoreZoomSetting", true);
		
	//@SuppressWarnings("deprecation")
	//WebDriver driver = new InternetExplorerDriver(caps);
		
		//driver.manage().window().setSize(new Dimension(1920,1080));
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		
		Assert.assertEquals("Google", driver.getTitle());
		
		driver.quit();
	}
	
}