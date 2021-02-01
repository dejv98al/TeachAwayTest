package megaMenu;


import base.Base;
import org.testng.annotations.*;


public class Menu {
	//public WebDriver driver;
 
	
	  Base test=new Base();
	  
	  @BeforeTest 
 public void launchBrowser() {
	  
	test.setUpDriver();
		  
	  }

@Test(priority=1)
public void eleminateCookies() {
	test.implicitWait(20);	
	test.clickByClassName("ub-emb-close");
}
@Test(priority=2)
public void checkMegaMenu() {
	test.checkMenu();
}

@Test(priority=3)
public void checkTeflMenu() {
	test.checkSubMenu();
	
}
@Test(priority=4)
public void checkSubMenuTeflCertifications() {
	String xpath="//*[@id=\"tb-megamenu-column-10\"]/div/ul/li[1]";
	String title="Online TEFL certification | Teach Away";
	test.clickByXpath(xpath);
    test.checkTitleWeb(title);
    test.goBack();
}
@Test(priority=5)
public void checkCoursesMenu() {
	String xpath="//*[@id=\"block-mainnavigation-2\"]/div/div/div/ul/li[4]/a";
	String title="Courses and Certifications | Teach Away";
	test.clickByXpath(xpath);
    test.checkTitleWeb(title);
    test.goBack();
}
/*
@Test(priority=6)
public void checkJobsMenu() {
	String xpath="//*[@id=\"block-mainnavigation-2\"]/div/div/div/ul/li[5]/a";
	String title="Hire Teachers – Teacher Recruitment Made Easy | Teach Away";
	test.clickByXpath(xpath);
    test.checkTitleWeb(title);
    test.goBack();
}
*/
@Test(priority=7)
public void quitDriver() {
	test.quitDriver();
}


}
	 