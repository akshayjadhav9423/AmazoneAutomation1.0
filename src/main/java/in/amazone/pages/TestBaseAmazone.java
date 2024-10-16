package in.amazone.pages;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseAmazone {

	protected WebDriver driver;
	protected FileReader reader;
	protected Properties p;
	public String browser;
	public String currentDir = System.getProperty("user.dir");
	public String propertyFilePath = "/src/main/resources/TestData.properties";

//	protected Utility utility;
//	public ExcelUtility excUtility;
	public String URL;
	public WebDriverWait wait;

	public FileInputStream fs;
//	public XSSFWorkbook workbook;
//	public XSSFSheet sheet;

	public void setup() throws Exception {

		reader = new FileReader(currentDir + propertyFilePath);
		p = new Properties();
		p.load(reader);
		browser = p.getProperty("browser");
		URL = p.getProperty("URL");
		// excUtility = new ExcelUtility();
	}

	public void open() throws IOException {

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setAcceptInsecureCerts(true);
			chromeOptions.addArguments("--remote-allow-origins=*");
			//chromeOptions.setCapability("ignore-certificate-errors", true);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			System.out.println("Chrome launch successfully...");

		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions fireFoxOption = new FirefoxOptions();
			fireFoxOption.setAcceptInsecureCerts(true);
			fireFoxOption.addArguments("--remote-allow-origins=*");
			fireFoxOption.setCapability("ignore-certificate-errors", true);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(fireFoxOption);
		} else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions edgeOption = new EdgeOptions();
			edgeOption.setAcceptInsecureCerts(true);
			edgeOption.addArguments("--remote-allow-origins=*");
			edgeOption.setCapability("ignore-certificate-errors", true);
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(edgeOption);
		} else {
			// If no browser is passed throw exception
			System.out.println("Incorrect Browser");
		}

		driver.get(URL);
		System.out.println("site launched successfully ");

		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
//      	driver.manage().window().setSize(new Dimension(1520,780));
	}

	public void load() {
//	utility = new Utility(driver);
//  
//    headerPage = new HeaderPage(driver);
	}

}
