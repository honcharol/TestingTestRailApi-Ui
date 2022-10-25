package com.ex.ui.pages.admin;

import com.ex.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainePage extends BasePage {
    private By myAccountLink = By.xpath("//a[@class='gk-header-top-menu-link'][contains(.,'My Account')]");
    private By acceptCookiesLocator = By.xpath("//div[@id='cookiescript_accept']");

    public MainePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public MainePage acceptCookies (){
        findElementCustom(webDriver, acceptCookiesLocator).click();
        return this;
    }

    public LoginPage clickOnMyAccountLink (){
        findElementCustom(webDriver, myAccountLink).click();
        return new LoginPage(webDriver);
    }

}
