package com.tobin.selenium.configuration;


public class DefaultSeleniumConfiguration implements SeleniumConfiguration {
	@Override
	public String getHostName() {
		return "localhost:8080";
	}

	@Override
	public String getHomePageUrl() {
		return "/";
	}

}
