package com.w2a.architectbatch1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GmailLandingPage extends BasePage{
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement loginID;
	
	@FindBy(id="identifierNext")
	private WebElement nextButton;
	
	public GmailLandingPage open() {
		return (GmailLandingPage) openPage(GmailLandingPage.class);
	}
	
	public GmailLoginPage enterTheUserID() {
		
		loginID.sendKeys("preraktheevil@gmail.com");
		nextButton.click();
		return (GmailLoginPage) openPage(GmailLoginPage.class);
		
	}

	@Override
	public ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(loginID);
	}
}
