package test;

import java.util.Arrays;

import keyworddriven.UtilFunctions.DefinedValuesFromGetProperties;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBrowsersCompatibility {

	private WebDriver driver;
	
	@Test
	public void IEConfiguration() throws Exception{
		System.setProperty("webdriver.ie.driver",DefinedValuesFromGetProperties.getDriverName("IE32bit"));
		driver = new InternetExplorerDriver();
		TestBrowser();
	}
	@Test
	public void FFConfiguration(){
		driver = new FirefoxDriver();
		TestBrowser();
	}
	@Test
	public void GCConfiguration(){
		System.setProperty("webdriver.chrome.driver",DefinedValuesFromGetProperties.getDriverName("GoogleChrome"));
		
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		String path;
		
		if (System.getProperty("os.name").toUpperCase().contains("XP")) {
		path = "C:\\Documents and Settings\\"
		+ System.getProperty("user.name")
		+ "\\Local Settings\\Application Data\\Google\\Chrome\\User Data";
		} else {
		path = "C:\\Users\\"
		+ System.getProperty("user.name")
		+ "\\AppData\\Local\\Google\\Chrome\\User Data";
		}
		capabilities.setCapability("chrome.switches", Arrays.asList("--user-data-dir="+path));
		driver = new ChromeDriver(capabilities); 
		
		//driver = new ChromeDriver();
		TestBrowser();
	}
	
	public void TestBrowser(){
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle().toString());
		driver.close();
	}
	
}
