package userDefinedLibraries;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	
	public static WebDriverWait wait;
	
	public static void emailPage(WebDriver driver) {
		
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginfmt")));
		
	}
	
	public static void passwordPage(WebDriver driver) {
		
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwd")));
	    
	}
	
	public static void staySignin(WebDriver driver) {
		
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@id='idSIButton9']")));
	    
	}
	
	public static void searchBoxVisiblity(WebDriver driver) {
		
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("searchbox")));
	    
	}
	
	public static void searchList(WebDriver driver) {
		
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@class='modern-search-center__list__item__title ng-scope'])[2]")));
	}
	
}