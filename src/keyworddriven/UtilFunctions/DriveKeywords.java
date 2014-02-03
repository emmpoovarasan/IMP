package keyworddriven.UtilFunctions;

import java.util.Iterator;
import java.util.Set;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;


@SuppressWarnings("deprecation")
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
					System.out.println(extractedSteps[i][3]+" -- "+extractedSteps[i][4]);
				}else if("store_value_cookie".equalsIgnoreCase(extractedSteps[i][4])){
					store_value_cookie(wd,extractedSteps[i][5],extractedSteps[i][6]);
					System.out.println(extractedSteps[i][3]+" -- "+extractedSteps[i][4]);
				}else if("send_keys_option".equalsIgnoreCase(extractedSteps[i][4])){
					send_keys_option(wd,extractedSteps[i][5],extractedSteps[i][6],extractedSteps[i][7]);
					System.out.println(extractedSteps[i][3]+" -- "+extractedSteps[i][4]);
				}else{
					System.out.println(extractedSteps[i][3]+" -- "+"else--"+extractedSteps[i][4]);
				}
			}
		}
	}

	private static void send_keys_option(WebDriver wd2, String locate,
			String locString, String data) {
		//use selectByValue if option value available
		if("xpath".equalsIgnoreCase(locate)){
			new Select(wd.findElement(By.xpath(locString))).selectByVisibleText(data);
		}
		if("name".equalsIgnoreCase(locate)){
			new Select(wd.findElement(By.name(locString))).selectByVisibleText(data);
		}
		if("id".equalsIgnoreCase(locate)){
			new Select(wd.findElement(By.id(locString))).selectByVisibleText(data);
		}
		if("className".equalsIgnoreCase(locate)){
			new Select(wd.findElement(By.className(locString))).selectByVisibleText(data);
		}
		if("cssSelector".equalsIgnoreCase(locate)){
			new Select(wd.findElement(By.cssSelector(locString))).selectByVisibleText(data);
		}
		
	}

	private static void store_value_cookie(WebDriver wd2, String locate, String LocString) {
		wd2.manage().deleteCookieNamed(LocString);
		Select sel;
		String value = new String();
		if("Select".equalsIgnoreCase(wd2.findElement(By.name(LocString)).getTagName())){
			sel = new Select(wd2.findElement(By.name(LocString)));
			value = sel.getFirstSelectedOption().getText();
		}else if("input".equalsIgnoreCase(wd2.findElement(By.name(LocString)).getTagName())){
			value = wd2.findElement(By.name(LocString)).getText();
		}
		Cookie c = new Cookie(LocString, value);
		
		wd2.manage().addCookie(c);
		
		// display all cookies value
		
		System.out.println("Load cookie name : "+wd2.manage().getCookieNamed(LocString));
		
		/*Set<Cookie> allCookies = wd2.manage().getCookies();
		for(Cookie loadedCookie : allCookies){
			System.out.println("Load Cookie name : "+ loadedCookie.getName() + " -- Load Cookie value : "+loadedCookie.getValue());
		}*/
		
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
            Thread.sleep(3000);
            System.out.println("After Switch window title : "+wd2.getTitle());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
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
		if("className".equalsIgnoreCase(locate)){
			wd.findElement(By.className(locString)).click();
		}
		if("cssSelector".equalsIgnoreCase(locate)){
			wd.findElement(By.cssSelector(locString)).click();
		}
		if("partialLinkText".equalsIgnoreCase(locate)){
			wd.findElement(By.partialLinkText(locString)).click();
		}
		
	}

	public static void send_keys(WebDriver wd, String locate, String locString,
			String data) {
		if("xpath".equalsIgnoreCase(locate)){
			if(wd.findElement(By.xpath(locString)).isDisplayed()==true){
				wd.findElement(By.xpath(locString)).clear();
				wd.findElement(By.xpath(locString)).sendKeys(data);
			}else{
				System.out.println("Not available for this element of "+locString);
			}
			
		}
		if("name".equalsIgnoreCase(locate)){
			if(wd.findElement(By.name(locString)).isDisplayed()==true){
				wd.findElement(By.name(locString)).clear();
				wd.findElement(By.name(locString)).sendKeys(data);	
			}else{
				System.out.println("Not available for this element of "+locString);
			}
			
			
		}
		if("id".equalsIgnoreCase(locate)){
			if(wd.findElement(By.id(locString)).isDisplayed()==true) {
				wd.findElement(By.id(locString)).clear();
				wd.findElement(By.id(locString)).sendKeys(data);	
			} else {
				System.out.println("Not available for this element of "+locString);
			}
			
		}
		if("className".equalsIgnoreCase(locate)){
			if(wd.findElement(By.className(locString)).isDisplayed()==true) {
				wd.findElement(By.className(locString)).clear();
				wd.findElement(By.className(locString)).sendKeys(data);	
			} else {
				System.out.println("Not available for this element of "+locString);
			}
			
		}
		if("cssSelector".equalsIgnoreCase(locate)){
			if(wd.findElement(By.cssSelector(locString)).isDisplayed()==true) {
				wd.findElement(By.cssSelector(locString)).clear();
				wd.findElement(By.cssSelector(locString)).sendKeys(data);	
			} else {
				System.out.println("Not available for this element of "+locString);
			}
			
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
