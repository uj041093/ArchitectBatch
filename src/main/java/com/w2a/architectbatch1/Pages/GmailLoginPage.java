package com.w2a.architectbatch1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GmailLoginPage extends BasePage{
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(id="passwordNext")
	private WebElement passwordNext;

	@Override
	public ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(password);
	}
	
	public void EnterPassword(String pwd){
		password.sendKeys(pwd);	
		
		passwordNext.click();
	
		try {
			Thread.sleep(5000);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	
}
