package com.w2a.architectbatch1.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.w2a.architectbatch1.TestUtils.DriverManager;
import com.w2a.architectbatch1.baseSetup.TestSetUp;

public class BasePage1<T> extends TestSetUp {
	
	T page =null;
	
	public WebDriver driver;
	public int AJAX_PAGE_TIMEOUT=30;
	public int PAGE_LOAD_TIMEOUT=30;
	
	public T openPage(Class<T> clazz) {
		
		
		
		AjaxElementLocatorFactory ajaxElmLocator = new AjaxElementLocatorFactory(DriverManager.getDriver(), AJAX_PAGE_TIMEOUT);
		
		page=PageFactory.initElements(DriverManager.getDriver(), clazz);
		
		PageFactory.initElements(ajaxElmLocator, page);
		
		
		return page;
	}
	

}
