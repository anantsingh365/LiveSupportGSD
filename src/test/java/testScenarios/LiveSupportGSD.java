package testScenarios;

import java.util.Scanner;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testObjectRepository.GSDPage;
import testObjectRepository.HomePage;
import testObjectRepository.SignUpPage;
import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ExcelReadWrite;
import userDefinedLibraries.ExplicitWait;
import userDefinedLibraries.ExtentReportManager;
import userDefinedLibraries.PropertiesRead;
import userDefinedLibraries.ScreenShot;


public class LiveSupportGSD extends DriverSetup {

	public static SignUpPage signUp;
	public static HomePage home;
	public static GSDPage gsd;
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static XSSFRow row;
	public static Set<String> allWindowHandles;
	public static String[] header = new String[4];
	public static String[] gsdList1 = new String[7];
	public static String[] gsdList2 = new String[7];
	public static String[] gsdList3 = new String[7];
	public static String[] gsdList4 = new String[7];
	public static String browser;
	public static String baseUrl;
	public static String parentWindow;
	public static String childWindow;
	public static String frameName;
	public static String email;
	public static String password;
	public static String otp;
	public static String Name;
	public static String Designation;
	public static String searchText;
	public static String countryName;
	public static String newline = System.getProperty("line.separator");
	
	@BeforeGroups("Smoke Test")
	public static void driverConfig () {
		
		browser = PropertiesRead.getBrowser();
		baseUrl = PropertiesRead.getUrl();
		report = ExtentReportManager.getReportInstance();
		driver = DriverSetup.openDriver(browser, baseUrl);
		parentWindow = driver.getWindowHandle();
		
	}
	
	@Test(priority = 0 , groups = { "Smoke Test" })
	public static void testCaseReadExcel () {
		
		try {
			
			ExcelReadWrite.excelRead();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	@Test(priority = 1 , groups = { "Smoke Test" })
	public static void enterEmail() {
		
		logger = report.createTest("Entering Email");
		email = PropertiesRead.getEmail();
		ExplicitWait.emailPage(driver);
		signUp = PageFactory.initElements(driver, SignUpPage.class);
		signUp.enteringEmail(email);
		ScreenShot.screenShotTestCase(driver);
		logger.log(Status.INFO, "Email Textbox");
		
	}
	
	@Test(priority = 2 , groups = { "Smoke Test" })
	public static void clickNext() {
		
		logger = report.createTest("Clicking Next");
		signUp.submittingEmail();
		logger.log(Status.INFO, "Next Button");
		
	}
	
	@Test(priority = 3 , groups = { "Smoke Test" })
	public static void enterPassword() {
		
		logger = report.createTest("Entering Password");
		password = PropertiesRead.getPassword();
		ExplicitWait.passwordPage(driver);
		signUp.enteringPassword(password);
		ScreenShot.screenShotTestCase(driver);
		logger.log(Status.INFO, "Password Textbox");
		
	}
	
	@Test(priority = 4 , groups = { "Smoke Test" })
	public static void clickSignIn() {
		
		logger = report.createTest("Clicking Sign in");
		signUp.submittingPassword();
		ScreenShot.screenShotTestCase(driver);
		logger.log(Status.INFO, "Sign in Button");
		
	}
	
	@Test(priority = 5 , groups = { "Smoke Test" })
	public static void verificationMethod() {
		
		logger = report.createTest("Clicking Verification Method");
		signUp.clickingOnLogInOption();
		logger.log(Status.INFO, "Verification Option");
		
	} 
	
	//Priority 6 and 7 are used to login through OTP
	
	@Test(priority = 6 , groups = { "Smoke Test" })
	public static void enterOTP() {
		
		System.out.println("Enter the OTP");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		otp = sc.next();
		logger = report.createTest("Entering OTP");
		signUp.enteringOTP(otp);
		ScreenShot.screenShotTestCase(driver);
		logger.log(Status.INFO, "OTP Textbox");
		
	}
	
	@Test(priority = 7 , groups = { "Smoke Test" })
	public static void clickVerify() {
		
		logger = report.createTest("Clicking Verify");
		signUp.submittingOTP();
		ScreenShot.screenShotTestCase(driver);
		logger.log(Status.INFO, "Verify Button");
		
	}
	
	@Test(priority = 8 , groups = { "Smoke Test" })
	public static void clickStaySignedIn() {
		
		logger = report.createTest("Clicking Stay Signed in");
		ExplicitWait.staySignin(driver);
		signUp.clickingOnStay();
		ScreenShot.screenShotTestCase(driver);
		logger.log(Status.INFO, "Yes Button");
		
	}
	
	@Test(priority = 9 , groups = { "Smoke Test" })
	public static void getUserInfo() {
		
		logger = report.createTest("Getting User Details");
		ExplicitWait.searchBoxVisiblity(driver);
		Name = signUp.gettingName();
		Designation = signUp.gettingDesignation();
		System.out.println(Name + newline + Designation);
		ExcelReadWrite.excelWrite(Name, Designation);
		logger.log(Status.INFO, "Name, Designation field");
		
	}
	
	@Test(priority = 10 , groups = { "Regression Test" })
	public static void enterSearchBox() {
		
		logger = report.createTest("Entering Searchbox");
		home = PageFactory.initElements(driver, HomePage.class);
		searchText = ExcelReadWrite.srhText;
		home.enteringSearchText(searchText);
		ScreenShot.screenShotTestCase(driver);
		logger.log(Status.INFO, "Searchbox Textbox");
		
	}
	
	@Test(priority = 11 , groups = { "Regression Test" })
	public static void clickSearchBox() {
		
		logger = report.createTest("Clicking Search icon");
		home.clickingOnSearch();
		ScreenShot.screenShotTestCase(driver);
		logger.log(Status.INFO, "Search Icon Button");
		
	}
	
	@Test(priority = 12 , groups = { "Regression Test" })
	public static void clickResult() {
		
		logger = report.createTest("Clicking Result");
		ExplicitWait.searchList(driver);
		home.clickingOnResult();
		logger.log(Status.INFO, "Result Button");
		
	}
	
	@Test(priority = 13 , groups = { "Regression Test" })
	public static void switchWindowHandle() {
		
		logger = report.createTest("Switching Window");
		allWindowHandles = driver.getWindowHandles();
		
		for (String b : allWindowHandles) {
			
			if (!b.equalsIgnoreCase(parentWindow))
				childWindow = b;

		}
		
		driver.switchTo().window(childWindow);
		ScreenShot.screenShotTestCase(driver);
		logger.log(Status.INFO, "Window Handle");
		
	}
	
	@Test(priority = 14 , groups = { "Regression Test" })
	public static void switchIFrame() {
		
		logger = report.createTest("Switching IFrame");
		frameName = ExcelReadWrite.iFrameName;
		driver.switchTo().frame(frameName);
		ScreenShot.screenShotTestCase(driver);
		logger.log(Status.INFO, "Frame Handle");
		
	}
	
	@Test(priority = 15 , groups = { "Regression Test" })
	public static void clickCountryMenu() {
		
		logger = report.createTest("Clicking Country Menu");
		gsd = PageFactory.initElements(driver, GSDPage.class);
		gsd.clickingOnMenu();
		ScreenShot.screenShotTestCase(driver);
		logger.log(Status.INFO, "Country Menu Button");
		
	}
	
	@Test(priority = 16 , groups = { "Regression Test" })
	public static void clickCountry() {
		
		logger = report.createTest("Clicking Country");
		countryName = ExcelReadWrite.cntrName;
		gsd.clickingOnCountry(driver, countryName);
		ScreenShot.screenShotTestCase(driver);
		logger.log(Status.INFO, "Country Menu Button");
		
	}
	
	@Test(priority = 17 , groups = { "Regression Test" })
	public static void getHeadersOfServices() {
		
		logger = report.createTest("Getting Headers");
		header = gsd.gettingHeader();
		logger.log(Status.INFO, "Header Texts");
		
	}
	
	@Test(priority = 18 , groups = { "Regression Test" })
	public static void getFirstServiceList() {
		
		logger = report.createTest("Getting First Service List");
		gsdList1 = gsd.gettingList1();
		logger.log(Status.INFO, "First Service List Texts");
		
	}
	
	@Test(priority = 19 , groups = { "Regression Test" })
	public static void getSecondServiceList() {
		
		logger = report.createTest("Getting Second Service List");
		gsdList2 = gsd.gettingList2();
		logger.log(Status.INFO, "Second Service List Texts");
		
	}
	
	@Test(priority = 20 , groups = { "Regression Test" })
	public static void getThirdServiceList() {
		
		logger = report.createTest("Getting Third Service List");
		gsdList3 = gsd.gettingList3();
		logger.log(Status.INFO, "Third Service List Texts");
		
	}
	
	@Test(priority = 21 , groups = { "Regression Test" })
	public static void getFourthServiceList() {
		
		logger = report.createTest("Getting Fourth Service List");
		gsdList4 = gsd.gettingList4();
		logger.log(Status.INFO, "Fourth Service List Texts");
		
	}
	
	@Test(priority = 22 , groups = { "Regression Test" })
	public static void logGSDServices() {
		
		for (int i=0; i<header.length;i++) {
			
			if(i == 0) {
				
				System.out.println(header[i]);
				System.out.println("=============================================");
				System.out.println();
				
				for(int j=0; j<gsdList1.length; j++) {
					
					if(gsdList1[j] != null)
						System.out.println(gsdList1[j]);
					
				}
				
				System.out.println("=============================================");
				System.out.println();
					
			} else if(i == 1) {
				
				System.out.println(header[i]);
				System.out.println("=============================================");
				System.out.println();
				
				for(int k=0; k<gsdList2.length; k++) {
			
					if(gsdList2[k] != null)
						System.out.println(gsdList2[k]);
					
				}
				
				System.out.println("=============================================");
				System.out.println();
					
			} else if(i == 2) {
				
				System.out.println(header[i]);
				System.out.println("=============================================");
				System.out.println();
				
				for(int l=0; l<gsdList3.length; l++) {
					
					if(gsdList3[l] != null)
						System.out.println(gsdList3[l]);
					
				}
				
				System.out.println("=============================================");
				System.out.println();
				
			} else {
				
				System.out.println(header[i]);
				System.out.println("=============================================");
				System.out.println();
				
				for(int m=0; m<gsdList4.length; m++) {
					
					if(gsdList4[m] != null)
						System.out.println(gsdList4[m]);
					
				}	
				
				System.out.println("=============================================");
				System.out.println();
				
			}
			
		}
		
		try {
			
			ExcelReadWrite.excelWrite(header, gsdList1, gsdList2, gsdList3, gsdList4);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	@AfterGroups("Regression Test")
	public static void driverClose() {
		
		report.flush();
		driver.switchTo().parentFrame();
		DriverSetup.closeDriver();
		driver.switchTo().window(parentWindow);
		DriverSetup.closeDriver();
		
	}
	
}