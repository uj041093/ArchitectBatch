package com.w2a.architectbatch1.testCases;

import org.testng.annotations.Test;

import com.w2a.architectbatch1.Pages.GmailLandingPage;
import com.w2a.architectbatch1.Pages.GmailLoginPage;
import com.w2a.architectbatch1.baseSetup.TestSetUp;

public class TC03 extends TestSetUp{
	
	@Test
	public void TC03() {
		GmailLandingPage gmailLandingPage = new GmailLandingPage().open();
		GmailLoginPage gmailLoginPage = gmailLandingPage.enterTheUserID();
		gmailLoginPage.EnterPassword();
	}

}
