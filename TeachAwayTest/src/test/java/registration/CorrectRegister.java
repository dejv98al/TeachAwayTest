package registration;

import org.testng.annotations.Test;

import base.Base;

public class CorrectRegister {
Base test=new Base();
	 @Test(priority=0)
	  public void setUpDriver() {
		  test.setUpDriver();
		  
	
	  }
	//User clicks to Register
     @Test(priority=1)
     public void UserFillsTheFormToRegister() {
    	 String name="Dejvis";
    	 String lastname="Muka";
    	 String password="Dejvis12345";
		  test.clickById("register");
		  test.sendKeysById("first_name", name);
		  test.sendKeysById("last_name",lastname);
		  test.emailGeneration();
		  test.sendKeysById("password",password);	  
		  test.clickByPartialLinkText("Decline");
		  test.scrollDown();
		  test.waitForElementId("create_account_action",20);
		  test.clickByXpath("//*[@id='create_account_action']/div");
		  		

     }
	@Test(priority=2)
	public void assertWindowTitle() {
		String title="Teach Away | Registration";
		String welcome="Welcome, Dejvis!";
		test.checkTitleWeb(title);
		test.waitForElementId("welcome-firstName", 20);
		test.assertElementTextId("welcome-firstName",welcome);
	  }
     
	 @Test(priority=3)
	 public void userFillsWelcomeForm() {
		 String jobXpath="/html/body/div[2]/div[2]/div[1]/form/div[1]/div[1]/div[2]/button";
		 String jobCategory="//*[@id=\"welcome-job-category\"]/ul/li[1]";
		 String start="get-started";
		 String teachingCertificate="//*[@aria-label=\"Yes button\"]";
		 String teachingLicense="//*[@id=\"teaching-license\"]/div[2]/div[2]";
		 
		 test.waitForElement(jobXpath, 20);
		 test.clickByXpath(jobXpath);
		 test.implicitWait(3);
		 test.clickByXpath(jobCategory);
		 test.clickByXpath(teachingCertificate);
		 test.clickByXpath(teachingLicense);
		 test.clickById(start);
		 
	 }
	 @Test(priority=4)
	 public void userFillsInteresForm() {
		 String next="next-to-about";
		 String school="//*[@id=\"schoolContactDirectly\"]/div[2]/div[1]";
		 String onlineTeaching="//*[@id=\"interesedOnlineTeaching\"]/div[2]/div[1]";
		 String TEFL="//*[@id=\"interesedTEFL\"]/div[2]/div[1]";
		 String certification="//*[@id='interesedTeacherCertification']/div[2]/div[1]";
		 test.waitForElement(school, 20);
		 test.clickByXpath(school);
		 test.clickByXpath(onlineTeaching);
		 test.clickByXpath(TEFL);
		 test.clickByXpath(certification);
		 test.clickById(next);
				 
	 }
	 @Test(priority=5)
	 public void userFillsPersonalInformation() {
		 test.waitForElementId("country", 20);
		 String countryAlbania="//*[@id=\"__next\"]/div[2]/div[2]/div[2]/form/div[1]/div[2]/ul/li[1]";
		 String citizenshipCanada="//*[@id=\"__next\"]/div[2]/div[2]/div[2]/form/div[2]/div[2]/ul/li[2]/div";
		 String language="//*[@id=\"languages\"]/ul/li[1]";
		 String dayOfBirth="//*[@id=\"dayOfBirth\"]/ul/li[2]";
		 String monthOfBirth="//*[@id=\"monthOfBirth\"]/ul/li[2]";
		 String yearOfBirth="//*[@id=\"yearOfBirth\"]/ul/li[20]";
		 String genderXpath="/html/body/div[2]/div[2]/div[2]/div[2]/form/div[5]/div[2]/button";
		 String genderMale="//*[@id=\"gender\"]/ul/li[1]";
		 String phone="123456789";
		 String check="checkbox";
		 String next="next-step";
		 test.clickById("country");
		 test.clickByXpath(countryAlbania);
		 test.clickById("citizenship");
		 test.waitForElement(citizenshipCanada,20);
		 test.clickByXpath(citizenshipCanada);
		 test.clickById("languages");
		 test.clickByXpath(language);
		 test.clickById("gender");
		 test.clickById("monthOfBirth");
		 test.clickByXpath(monthOfBirth);
		 test.clickById("dayOfBirth");
		 test.clickByXpath(dayOfBirth);
		 test.clickById("yearOfBirth");
		 test.waitForElement(yearOfBirth,20);
		 test.clickByXpath(yearOfBirth);
		 test.scrollDown();
		 test.waitForElementId("gender", 15);
		 test.clickByXpath(genderXpath);
		 test.clickByXpath(genderMale);
		 test.sendKeysById("phoneNumber",phone);
		 test.clickById(check);
		 test.clickById(next);
		 
	 }
	 @Test(priority=6)
	 public void education() {
		 String noEducation="//*[@for='noEducation']";
		 String elementXpath="//*[@id=\"__next\"]/div[2]/div[2]/form/div[1]/div/h3";
		 String text="It's never too late to go back to school";
		 String next="next-step";
		 test.waitForElement(noEducation, 20);
		 test.clickByXpath(noEducation);
		 test.waitForElement(elementXpath, 20);
		 test.assertElementTextXpath(elementXpath,text);
		 test.clickById(next);
		 
		 
	 }
	 @Test(priority=7)
	 public void experience() {
		 String noExperience="//*[@for='checkbox-no-experience']";
		 String textXpath="//*[@id=\"__next\"]/div[2]/div[2]/form/div[2]/div/h4";
		 String text="You've come to the right place";
		 String next="complete-next";
		 test.waitForElement(noExperience, 20);
		 test.clickByXpath(noExperience);
		 test.assertElementTextXpath(textXpath,text);
		 test.clickById(next);
		 
	 }
	 @Test(priority=8)
	 public void userClicksTeacherProfile() {
		 String profile="teacher-profile";
		 test.waitForElementId(profile, 20);
		 test.clickById(profile);
	 }
	 @Test(priority=9)
	 public void quitDriver() {
	 	test.quitDriver();
	 }
	
}
