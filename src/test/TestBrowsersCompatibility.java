package test;

import keyworddriven.UtilFunctions.DefinedValuesFromGetProperties;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBrowsersCompatibility {

	private WebDriver _driver;
	
	@Test
	public void IEConfiguration() throws Exception{
		System.setProperty("webdriver.ie.driver",DefinedValuesFromGetProperties.getDriverName("IE32bit"));
		_driver = new InternetExplorerDriver();
		TestBrowser();
	}
	@Test
	public void FFConfiguration(){
		_driver = new FirefoxDriver();
		TestBrowser();
	}
	@Test
	public void GCConfiguration(){
		System.setProperty("webdriver.chrome.driver",DefinedValuesFromGetProperties.getDriverName("GoogleChrome"));
		_driver = new ChromeDriver();
		TestBrowser();
	}
	
	public void TestBrowser(){
		_driver.get("http://www.google.com");
		System.out.println(_driver.getTitle().toString());
	}
}
