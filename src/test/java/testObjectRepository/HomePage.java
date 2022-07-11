package testObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	
	public static WebDriver driver;
	
	@FindBy(how = How.XPATH, using = ".//input[@name='searchbox']")
	public WebElement searchBox;
	
	@FindBy(how = How.XPATH, using = ".//span[@class='icomoon-search2']")
	public WebElement searchClick;
	
	@FindBy(how = How.XPATH, using = "(//a[@class='modern-search-center__list__item__title ng-scope'])[2]")
	public WebElement clickGSD;

	public void enteringSearchText(String searchKey) {
		
		searchBox.sendKeys(searchKey);
		
	}
	
	public void clickingOnSearch() {
		
		searchClick.click();
		
	}
	
	public void clickingOnResult() {
		
		clickGSD.click();
		
	}
	
}