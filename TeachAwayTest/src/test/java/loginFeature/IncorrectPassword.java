package loginFeature;



import org.testng.annotations.*;

import base.*;

public class IncorrectPassword {
	Base test=new Base();
	  @Test(priority=1)
	  public void setUpDriver1() {
		  test.setUpDriver();
		  

	  }
	  @Test(priority=2)
	  public void eleminateCookies1() {
	  	test.implicitWait(20);	
	  	test.clickByClassName("ub-emb-close");
	  }
	  @Test(priority=3)
	  public void IncorrectLogin() {
	String email="mukaddevi@gmail.com";
	String password="Test19999";
	        test.clickById("login");
	        test.clickById("hs-eu-decline-button");
	        test.sendKeysById("username", email);
	        test.sendKeysById("password", password);
	        test.clickById("login_action");
	        
	        
	  }
	  @Test(priority=4)
	  public void getError() {
		  String xpath="//*[@id='__next']/div[2]/div[2]/div[1]/div";
		  String text="Sorry, unrecognized e-mail or password. Please try again.";
		  
		  test.waitForElement(xpath,3);
		  
		  test.assertElementTextXpath(xpath, text);
	  }
	 
	  @Test (priority=5)
	  public void quitDriver() {
	  	test.quitDriver();
	  }
	  
}

