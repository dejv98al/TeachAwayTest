package base;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//BaseLibrary
public class Base {
	
	public static WebDriver driver;
	public  void setUpDriver() {
		driver = new ChromeDriver();
		
	     System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
	    	//WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
	         driver.get("https://www.teachaway.com/");

		}
	public void clickByClassName(String className) {
		
		WebElement elementToClick = driver.findElement(By.className(className));

		elementToClick.click();
	}
public void clickByPartialLinkText(String text) {
		
		WebElement elementToClick =driver.findElement(By.partialLinkText(text));

		elementToClick.click();
	}
public void scrollDown() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	
}
	public void emailGeneration() {
		 Random rand = new Random(); 
         
         // Generate random integers in range 0 to 999 
         int rand_int1 = rand.nextInt(10000000);
         String email="Dejvis"+ rand_int1+"@gmail.com";
         driver.findElement(By.id("email")).sendKeys(email);
	}
	
public void clickByXpath(String xpath) {
		
		WebElement elementToClick = driver.findElement(By.xpath(xpath));

		elementToClick.click();
	}
public void clickById(String id) {
	
	WebElement elementToClick = driver.findElement(By.id(id));

	elementToClick.click();
}
public void sendKeysById(String id, String text) {
	
	WebElement elementToClick = driver.findElement(By.id(id));

	elementToClick.sendKeys(text);
}


public void checkTitleWeb(String title) {
	Assert.assertTrue(driver.getTitle().equals(title));
}
public void quitDriver() {
	 driver.close();
	 
}
public void goBack() {
	 driver.navigate().back();
}
	public void implicitWait(int seconds)
	{
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	public void waitForElement(String xpath,int s) {
		WebDriverWait wait = new WebDriverWait(driver,s);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		
	}
	public void waitForElementId(String id,int s) {
		WebDriverWait wait = new WebDriverWait(driver,s);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		
	}
	public void checkMenu() {
		//WebDriverWait wait = new WebDriverWait(driver,10);
		 String megaMenuXpath="//span[contains(@class, 'dropdown-toggle tb-megamenu-no-link')]";
       List<WebElement> menuElements = driver.findElements(By.xpath(megaMenuXpath));
       String menuRealValues="JOBS TEFL TEACHER CERTIFICATION COURSES ";
       String menuElementTexts="";
       String coursesMenuXpath="//*[@id='block-mainnavigation-2']/div/div/div/ul/li[4]/a";
      // String jobsMenuXpath="//*[@id='block-mainnavigation-2']/div/div/div/ul/li[5]/a";
       
        for(WebElement element: menuElements) {
     	   if(element.getText().length()!=0)
     		    menuElementTexts+=element.getText()+" ";
            System.out.println(element.getText());
     }
        String courses=driver.findElement(By.xpath(coursesMenuXpath)).getText();
        //String jobs=driver.findElement(By.xpath(jobsMenuXpath)).getText();
        menuElementTexts+=courses+" ";
        
        Assert.assertTrue(menuRealValues.equals(menuElementTexts));
       
       
	}
	public void assertElementTextId(String id,String text)
	{
		System.out.println(driver.findElement(By.id(id)).getText());
		Assert.assertTrue(text.equals(driver.findElement(By.id(id)).getText()));
		
		
	}	
	public void assertElementTextXpath(String xpath,String text)
	{
		
		Assert.assertTrue(text.equals(driver.findElement(By.xpath(xpath)).getText()));
		
		
	}
	
	public void checkSubMenu() {
		String TeflMenuXpath="//*[@id='block-mainnavigation-2']/div/div/div/ul/li[2]/span";
		String submenuElementsXpath="//*[@id='tb-megamenu-column-10']/div/ul/li[";
		WebDriverWait wait = new WebDriverWait(driver,10);
		Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath(TeflMenuXpath));
        action.moveToElement(we).build().perform();
        String submenu2="";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(submenuElementsXpath+"1]")));
        for(int i=1;i<=2;i++) {


     	    submenu2 += driver.findElement(By.xpath(submenuElementsXpath+i+"]")).getText()+" ";
     	    	   
     	       }
       String subMenuValues2="TEFL Courses TEFL Certification Guide ";
       
       Assert.assertTrue(subMenuValues2.equals(submenu2));
	}
}
