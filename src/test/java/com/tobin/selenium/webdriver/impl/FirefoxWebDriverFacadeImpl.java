package com.tobin.selenium.webdriver.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

import com.tobin.selenium.webdriver.WebDriverFacade;

@Component
public class FirefoxWebDriverFacadeImpl extends WebDriverFacade {
	@Override
	public WebDriver createWebDriverInstance() {
		return new FirefoxDriver();
	}
}
