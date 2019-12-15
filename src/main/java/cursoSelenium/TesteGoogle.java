package cursoSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;


public class TesteGoogle {
	//	System.setProperty("webdriver.gecko.driver", "C:/SeleniumDrivers/geckodriver.exe");
	//	System.setProperty("webdriver.chrome.driver", "C:/SeleniumDrivers/chromedriver.exe");
	//	System.setProperty("webdriver.ie.driver", "C:/SeleniumDrivers/IEDriverServer.exe");
	//	WebDriver driver = new FirefoxDriver();
	//	WebDriver driver = new ChromeDriver();
	//	DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	//	caps.setCapability("ignoreZoomSetting", true);
		
	//@SuppressWarnings("deprecation")
	//WebDriver driver = new InternetExplorerDriver(caps);
		
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializaSelenium() {
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(1920,1080));
		dsl = new DSL(driver);
	}
	
	@After
	public void finalizaSelenium() {
		driver.quit();
	}
	
	@Test
	public void teste() {
		System.out.println(driver.getTitle());
		dsl.checkField("Google", driver.getTitle());
	}
	
}