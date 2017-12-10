package com.w2a.architectbatch1.testCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.architectbatch1.Pages.GmailLandingPage;
import com.w2a.architectbatch1.Pages.GmailLoginPage;
import com.w2a.architectbatch1.TestUtils.TestUtils;
import com.w2a.architectbatch1.baseSetup.TestSetUp;

public class TC03 extends TestSetUp{
	
	@Test(dataProviderClass=TestUtils.class,dataProvider="dm")
	public void TC03(Hashtable<String,String> data) {
		GmailLandingPage gmailLandingPage = new GmailLandingPage().open();
		GmailLoginPage gmailLoginPage = gmailLandingPage.enterTheUserID(data.get("userID"));
		gmailLoginPage.EnterPassword(data.get("Password"));
	}

}
