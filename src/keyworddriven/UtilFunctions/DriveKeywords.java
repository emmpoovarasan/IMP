package keyworddriven.UtilFunctions;

import java.util.Iterator;
import java.util.Set;

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
					//System.out.println(extractedSteps[i][3]+" -- "+extractedSteps[i][4]);
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
				}else if("switch_window".equalsIgnoreCase(extractedSteps[i][4])){
					switch_window(wd);
				}else{
					System.out.println(extractedSteps[i][3]+" -- "+"else--"+extractedSteps[i][4]);
				}
			}
		}
	}

	public static void switch_window(WebDriver wd2) {
		Set<String> windowId = wd2.getWindowHandles();    // get  window id of current window
        Iterator<String> itererator = windowId.iterator();   
        //String mainWinID = itererator.next();
        //String  newAdwinID = itererator.next();
        String  newAdwinID = new String();
        while (itererator.hasNext()) {
			newAdwinID = itererator.next();
		}
        try {
            wd2.switchTo().window(newAdwinID);
            System.out.println(wd2.getTitle());
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       /* wd2.switchTo().window(mainWinID);
        System.out.println(wd2.getTitle());
        Thread.sleep(2000);*/

		
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if("xpath".equalsIgnoreCase(locate)){
			String ActualResult= wd.findElement(By.xpath(LocString)).getText();
			try {
				Assert.assertEquals(ExpectedResult, ActualResult);
				System.out.println("Expected Output: "+ExpectedResult+" | Actual Output: "+ActualResult);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if("cssSelector".equalsIgnoreCase(locate)){

			String actualOutput = null;
			actualOutput = wd.findElement(By.cssSelector(LocString)).getText();
			try {
				
				Assert.assertEquals(ExpectedResult, actualOutput);
				System.out.println("Expected Output: "+ExpectedResult+" | Actual Output: "+actualOutput);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		if("linkText".equalsIgnoreCase(locate)){
			String actualOutput = null;
			actualOutput = wd.findElement(By.linkText(LocString)).getText();
			try {
				Assert.assertEquals(ExpectedResult, actualOutput);
				System.out.println("Expected Output: "+ExpectedResult+" | Actual Output: "+actualOutput);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		if("className".equalsIgnoreCase(locate)){
			String ActualOutput = wd.findElement(By.className(LocString)).getText();
			try {
				Assert.assertEquals(ExpectedResult, ActualOutput);
				System.out.println("Expected Output: "+ExpectedResult+" | Actual Output: "+ActualOutput);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if("name".equalsIgnoreCase(locate)){
			String ActualOutput = wd.findElement(By.name(LocString)).getText();
			try {
				Assert.assertEquals(ExpectedResult, ActualOutput);
				System.out.println("Expected Output: "+ExpectedResult+" | Actual Output: "+ActualOutput);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if("partialLinkText".equalsIgnoreCase(locate)){
			String ActualOutput = wd.findElement(By.partialLinkText(LocString)).getText();
			try {
				Assert.assertEquals(ExpectedResult, ActualOutput);
				System.out.println("Expected Output: "+ExpectedResult+" | Actual Output: "+ActualOutput);
			} catch (Exception e) {
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
		if("xpath".equalsIgnoreCase(locate)){
			wd.findElement(By.xpath(locString)).click();
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
		//System.out.println("Tested : "+url);
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
