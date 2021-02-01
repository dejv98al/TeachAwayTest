package loginFeature;

import org.testng.annotations.*;

import base.*;



public class IncorrectEmail {
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
	  public void IncorrectLogin() {
	String email="mukaaddevi@gmail.com";
	String password="8BCn@J7a3.QzUQM";
	        test.clickById("login");
	        test.clickById("hs-eu-decline-button");
	        test.sendKeysById("username", email);
	        test.sendKeysById("password", password);
	        test.clickById("login_action");
	        
	        
	  }
	  @Test(priority=3)
	  public void getError() {
		  String xpath="//*[@id='__next']/div[2]/div[2]/div[1]/div";
		  String text="Sorry, unrecognized e-mail or password. Please try again.";
		  
		  test.waitForElement(xpath,3);
		  test.assertElementTextXpath(xpath, text);
		 /* String elementText=test.getTextXpath(xpath);
		  System.out.print("Teksti"+elementText);
		  Assert.assertTrue(text.equals(elementText));
		  */
	  }
	 
	  @Test(priority=4)
	  public void quitDriver() {
	  	test.quitDriver();
	  }
	  
}
