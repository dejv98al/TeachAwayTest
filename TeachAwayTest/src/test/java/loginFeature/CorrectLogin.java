package loginFeature;

import org.testng.annotations.Test;
import base.*;


public class CorrectLogin {
	Base test=new Base();
	 @Test(priority=0)
  public void setUpDriver() {
	  test.setUpDriver();
	  

  }
  @Test(priority=1)
  public void eleminateCookies() {
  	test.implicitWait(20);	
  	test.clickByClassName("ub-emb-close");
  }
  @Test(priority=2)
  public void correctLogin() {
String email="mukaddevi@gmail.com";
String password="8BCn@J7a3.QzUQM";
        test.clickById("login");
        test.sendKeysById("username", email);
        test.sendKeysById("password", password);
        test.clickById("login_action");
        
        
  }
 

  @Test(priority=3)
  public void logOut()
  {
	  String miniMenuId="mini-menu";
	  String logOutXpath="//*[@id='mini-menu']/ul/li[2]/ul/li[7]/a";
	  test.waitForElementId(miniMenuId,20);
	  
	  test.clickById(miniMenuId);
	  test.waitForElement(logOutXpath, 20);
	  test.clickByXpath(logOutXpath);
	 
  }
  @Test(priority=4)
  public void quitDriver() {
  	test.quitDriver();
  }
}
