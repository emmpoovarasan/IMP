package keyworddriven.UtilFunctions;

import junit.framework.Assert;
import keyworddriven.Logs.GetLogger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class DriveKeywords {
	static WebDriver wd;
	public static void doDriveKeywords(String[][] extractedSteps){
		System.out.println("Testing doDriveKeywords ");
		for(int i = 1; i< extractedSteps.length; i++){
			if(extractedSteps[i][0].equalsIgnoreCase("Y")){
				if("open_browser".equalsIgnoreCase(extractedSteps[i][4])){
					wd = open_browser(extractedSteps[i][7]);
					System.out.println(extractedSteps[i][3]+" -- "+extractedSteps[i][4]);
					//GetLogger.fileLogger(extractedSteps[i][3]+" -- "+extractedSteps[i][4]);
					
				}else if("navigate_to".equalsIgnoreCase(extractedSteps[i][4])){
					System.out.println(extractedSteps[i][3]+" -- "+extractedSteps[i][4]);
					navigate_to(wd,extractedSteps[i][7]);
					System.out.println(extractedSteps[i][3]+" -- "+extractedSteps[i][4]);
					
				}else if("refresh".equalsIgnoreCase(extractedSteps[i][4])){
					refresh(wd);
					System.out.println(extractedSteps[i][3]+" -- "+extractedSteps[i][4]);
					
				}else if("send_keys".equalsIgnoreCase(extractedSteps[i][4])){
					send_keys(wd,extractedSteps[i][5],extractedSteps[i][6],extractedSteps[i][7]);
					System.out.println(extractedSteps[i][3]+" -- "+extractedSteps[i][4]);
					
				}else if("click_element".equalsIgnoreCase(extractedSteps[i][4])){
					click_element(wd,extractedSteps[i][5],extractedSteps[i][6]);
					System.out.println(extractedSteps[i][3]+" -- "+extractedSteps[i][4]);
					
				}else if("verify_element".equalsIgnoreCase(extractedSteps[i][4])){
					verify_element(wd,extractedSteps[i][5],extractedSteps[i][6],extractedSteps[i][8]);
					System.out.println(extractedSteps[i][3]+" -- "+extractedSteps[i][4]);
					
				}else if("close_browser".equalsIgnoreCase(extractedSteps[i][4])){
					close_browser(wd);
					System.out.println(extractedSteps[i][3]+" -- "+extractedSteps[i][4]);
				}else{
					System.out.println(extractedSteps[i][3]+" -- "+"else--"+extractedSteps[i][4]);
				}
			}
		}
	}

	public static void close_browser(WebDriver wd) {
		wd.close();
		wd.quit();
	}

	public static void verify_element(WebDriver wd, String locate,
			String LocString, String ExpectedResult) {
		
		if("id".equalsIgnoreCase(locate)){
			String ActualOutput = wd.findElement(By.id(LocString)).getText();
			try {
				Assert.assertEquals(ExpectedResult, ActualOutput);
				System.out.println("Expected Output: "+ExpectedResult+" | Actual Output: "+ActualOutput);
				/*if("Invalid password".equalsIgnoreCase(ActualOutput)){
					org.junit.Assert.assertEquals("Invalid password", ActualOutput);
					System.out.println("Expected Output: Invalid password | Actual Output: "+ActualOutput);
				}else if("Please enter your email and password".equalsIgnoreCase(ActualOutput)){
					org.junit.Assert.assertEquals("Please enter your email and password", ActualOutput);
					System.out.println("Expected Output: Please enter your email and password | Actual Output: "+ActualOutput);
				}else if("Wrong email or password".equalsIgnoreCase(ActualOutput)){
					org.junit.Assert.assertEquals("Wrong email or password", ActualOutput);
					System.out.println("Expected Output: Wrong email or password | Actual Output: "+ActualOutput);
				}else{
					System.out.println("Actual Output: "+ActualOutput);
				}*/
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if("xpath".equalsIgnoreCase(locate)){
			String ActualResult= wd.findElement(By.xpath(LocString)).getText();
			try {
				Assert.assertEquals(ExpectedResult, ActualResult);
				//org.junit.Assert.assertEquals("Profile Completeness", wd.findElement(By.xpath(LocString)).getText());
				System.out.println("Expected Output: "+ExpectedResult+" | Actual Output: "+ActualResult);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if("cssSelector".equalsIgnoreCase(locate)){
			//System.out.println("Executed cssSelector : "+locate);
			String actualOutput = null;
			actualOutput = wd.findElement(By.cssSelector(LocString)).getText();
			try {
				
				Assert.assertEquals(ExpectedResult, actualOutput);
				System.out.println("Expected Output: "+ExpectedResult+" | Actual Output: "+actualOutput);
				/*if("Create an account".equalsIgnoreCase(actualOutput)){
					Assert.assertEquals("Create an account", actualOutput);
					System.out.println("Expected : Create an account --- Actual : "+actualOutput);	
				}
				if("Try EasyMedMobile.com for free during 30 days (1/2)".equalsIgnoreCase(actualOutput)){
					Assert.assertEquals("Try EasyMedMobile.com for free during 30 days (1/2)", actualOutput);
					System.out.println("Expected : Create an account --- Actual : "+actualOutput);	
				}*/
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
		}
		
	}

	public static void click_element(WebDriver wd, String locate,
			String locString) {
		System.out.println("Click element string "+locString);
		if("name".equalsIgnoreCase(locate)){
			wd.findElement(By.name(locString)).click();
			
		}
		if("linkText".equalsIgnoreCase(locate)){
			wd.findElement(By.linkText(locString)).click();
		}
		if("id".equalsIgnoreCase(locate)){
			wd.findElement(By.id(locString)).click();
		}
		
	}

	public static void send_keys(WebDriver wd, String locate, String locString,
			String data) {
		if("xpath".equalsIgnoreCase(locate)){
			wd.findElement(By.xpath(locString)).clear();
			wd.findElement(By.xpath(locString)).sendKeys(data);
		}
		if("name".equalsIgnoreCase(locate)){
			wd.findElement(By.name(locString)).clear();
			wd.findElement(By.name(locString)).sendKeys(data);
			
		}
		if("id".equalsIgnoreCase(locate)){
			wd.findElement(By.id(locString)).clear();
			wd.findElement(By.id(locString)).sendKeys(data);
		}
		
	}

	public static void refresh(WebDriver wd) {
		wd.navigate().refresh();
		
	}

	public static void navigate_to(WebDriver wd, String url) {
		System.out.println("Tested : "+url);
		wd.get(url);
		
	}

	public static WebDriver open_browser(String browserType) {
		WebDriver wd1 = null;
		//System.out.println(browserType);
		if(browserType.equalsIgnoreCase("FireFox")){
			wd1 = new FirefoxDriver();
		}
		if(browserType.equalsIgnoreCase("IE")){
			wd1 = new InternetExplorerDriver();
		}
		if(browserType.equalsIgnoreCase("chrome")){
			wd1 = new ChromeDriver();
		}
		
		return wd1;
	}
}
