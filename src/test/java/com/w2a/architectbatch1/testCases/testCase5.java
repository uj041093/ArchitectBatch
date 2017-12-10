package com.w2a.architectbatch1.testCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.architectbatch1.TestUtils.TestUtils;
import com.w2a.architectbatch1.baseSetup.TestSetUp;

public class testCase5 extends TestSetUp {
	
	@Test(dataProviderClass=TestUtils.class,dataProvider="dm")
	public void tc_06(Hashtable<String,String> data) {
		
		System.out.println("The tc_06 credentials are \t\t"+data.get("Username")+"\t\t\t\t"+data.get("Password"));
		System.out.println(data);
		
	}

}
