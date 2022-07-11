package testObjectRepository;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GSDPage {
	
	public static WebDriver driver;
	public static WebElement countryList;
	public static WebElement Country;
	public static String[] header = new String[4];
	public static String[] gsdList1 = new String[7];
	public static String[] gsdList2 = new String[7];
	public static String[] gsdList3 = new String[7];
	public static String[] gsdList4 = new String[7];
	
	@FindBy(how = How.XPATH, using = ".//button[@id='menu4']")
	public WebElement menu;

	@FindBy(how = How.XPATH, using = ".//*[@id='ui-view']/div/div[4]/div/div/div/div/div[1]")
	public List<WebElement> GSDHeading;

	@FindBy(how = How.XPATH, using = ".//*[@id='ui-view']/div/div[4]/div/div/div[1]/div/div/div")
	public List<WebElement> GSDList1;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='ui-view']/div/div[4]/div/div/div[2]/div/div/div")
	public List<WebElement> GSDList2;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='ui-view']/div/div[4]/div/div/div[3]/div/div/div")
	public List<WebElement> GSDList3;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='ui-view']/div/div[4]/div/div/div[4]/div/div/div")
	public List<WebElement> GSDList4;
	
	public void clickingOnMenu() {
		
		menu.click();
		
	}
	
	public void clickingOnCountry(WebDriver driver, String country) {
		
		countryList = driver.findElement(By.xpath("//div[@class='col-6 mt-2 text-center']//a[contains(text(),'"+country+"')]"));
		countryList.click();
		
	}
	
	public String[] gettingHeader() {
		
		int i=0;
		
		for(WebElement a:GSDHeading) {
			
			header[i] = a.getText();
			i++;
			
		}
		
		return header;
		
	}
	
	public String[] gettingList1() {
		
		int i=0;
		
		for(WebElement a:GSDList1) {
			
			gsdList1[i] = a.getText();
			i++;
			
		}
		
		return gsdList1;
		
	}
	
	public String[] gettingList2() {
		
		int i=0;
		
		for(WebElement a:GSDList2) {
			
			gsdList2[i] = a.getText();
			i++;
			
		}
		
		return gsdList2;
		
	}
	
	public String[] gettingList3() {
		
		int i=0;
		
		for(WebElement a:GSDList3) {
			
			gsdList3[i] = a.getText();
			i++;
			
		}
		
		return gsdList3;
		
	}
	
	public String[] gettingList4() {
		
		int i=0;
		
		for(WebElement a:GSDList4) {
			
			gsdList4[i] = a.getText();
			i++;
			
		}
		
		return gsdList4;
		
	}
	
}