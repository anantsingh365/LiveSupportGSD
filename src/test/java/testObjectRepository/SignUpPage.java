package testObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUpPage {

	public static WebDriver driver;
	public static String NAME;
	public static String DESIGNATION;
	
	@FindBy(how = How.XPATH, using = ".//input[@name='loginfmt']")
	public WebElement emailEnter;
	
	@FindBy(how = How.XPATH, using = ".//input[@id='idSIButton9']")
	public WebElement emailClick;
	
	@FindBy(how = How.XPATH, using = ".//input[@name='passwd']")
	public WebElement passEnter;
	
	@FindBy(how = How.XPATH, using = ".//input[@id='idSIButton9']")
	public WebElement passClick;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='idDiv_SAOTCS_Proofs']/div[2]/div/div/div[2]")
	public WebElement logInOption;
	
	@FindBy(how = How.XPATH, using = ".//input[@name='otc']")
	public WebElement otpEnter;
	
	@FindBy(how = How.XPATH, using = ".//input[@type='submit']")
	public WebElement otpClick;
	
	@FindBy(how = How.XPATH, using = ".//input[@id='idSIButton9']")
	public WebElement stayClick;
	
	@FindBy(how = How.XPATH, using = ".//p[@id='user-name']")
	public WebElement name;
	
	@FindBy(how = How.XPATH, using = ".//span[@class='job-title']")
	public WebElement designation;
	
	public void enteringEmail(String eMail) {
		
		emailEnter.sendKeys(eMail);
		
	}
	
	public void submittingEmail() {
		
		emailClick.click();
		
	}
	
	public void enteringPassword(String passWord) {
		
		passEnter.sendKeys(passWord);
		
	}
	
	public void submittingPassword() {
		
		passClick.click();
		
	}
	
	public void clickingOnLogInOption() {
		
		logInOption.click();
		
	}
	
	// Used to login Through OTP
	
	public void enteringOTP(String otp) {
		
		otpEnter.sendKeys(otp);
		
	}
	
	// Used to login Through OTP
	 
	public void submittingOTP() {
		
		otpClick.click();
		
	}
	
	public void clickingOnStay() {
		
		stayClick.click();
		
	}
	
	public String gettingName() {
		
		NAME = name.getText();
		return NAME;
		
	}
	
	public String gettingDesignation() {
		
		DESIGNATION = designation.getText();
		return DESIGNATION;
		
	}
	
}