package com.tobin.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tobin.selenium.configuration.SeleniumConfiguration;
import com.tobin.selenium.webdriver.WebDriverFacade;

@Component
public class WebSite {
	@Autowired WebDriverFacade webDriverFacade;
	@Autowired SeleniumConfiguration seleniumConfiguration;
	
	public WebDriverFacade getWebDriverFacade() {
		return webDriverFacade;
	}
	public void setWebDriverFacade(WebDriverFacade webDriverFacade) {
		this.webDriverFacade = webDriverFacade;
	}
		
	public SeleniumConfiguration getSeleniumConfiguration() {
		return seleniumConfiguration;
	}
	public void setSeleniumConfiguration(SeleniumConfiguration seleniumConfiguration) {
		this.seleniumConfiguration = seleniumConfiguration;
	}
	
	public <T extends PageObject> T open( String address, WebDriver webDriver, Class<T> pageClass ) {
		webDriver.navigate().to(address);
		T obj = pageObjectInstance(webDriver, pageClass);
		obj.setWebDriver(webDriver);
		return obj;
	}

	private <T extends PageObject> T pageObjectInstance(WebDriver webDriver, Class<T> pageClass) {
		return PageFactory.initElements( webDriver, pageClass);
	}
	
	public HomePage openHomePage() {
		WebDriver webDriver = getWebDriverFacade().createWebDriverInstance();
		String address = "http://" + getSeleniumConfiguration().getHostName() + getSeleniumConfiguration().getHomePageUrl();
		HomePage homePage = open( address, webDriver, HomePage.class );
		return homePage;
	}
}
