package com.tobin.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends PageObject {
	@FindBy(how = How.XPATH, using = "//h2")
	private WebElement h2;

	public WebElement getH2() {
		return h2;
	}	
}
