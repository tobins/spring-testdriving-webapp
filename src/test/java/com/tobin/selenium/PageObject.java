package com.tobin.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public abstract class PageObject {
	private WebDriver webDriver;
	
	@FindBy(how = How.XPATH, using = "//title")
	private WebElement title;

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public WebElement getTitle() {
		return title;
	}
	
	public void close() {
		if( webDriver != null ) {
			webDriver.close();
		}
	}
	
	public void quit() {
		if( webDriver != null ) {
			webDriver.quit();
		}		
	}
}
