package userDefinedLibraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverSetup {

	public static WebDriver driver;
	public static String exePath;
	public static String browserName;
	public static String baseURL;
	
	 public static WebDriver openDriver(String browser, String baseUrl) {
		
		 browserName = browser;
		 baseURL = baseUrl;

		if (browserName.equalsIgnoreCase("firefox")) {
			
			exePath = "./Drivers/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",exePath);
			driver = new FirefoxDriver();
			
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			
			exePath = "./Drivers/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",exePath);
			driver = new ChromeDriver();
			
		} else {
			
			System.out.println("Not a valid browser");
			
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
		
		}
	 
	 public static void closeDriver() {
		 
		 driver.close();
		 
	 }
	 
}