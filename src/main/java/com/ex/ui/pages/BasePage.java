package com.ex.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends WebHelpers {

    private final String tab = "//a[@id='navigation-%s']";
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public BasePage(WebDriver webDriver, String url) {
        webDriver.get(url);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public <T> T clickOnTab(T type, String tabName) {
        findElementCustom(webDriver, By.xpath(String.format(tab, tabName))).click();
        return type;
    }

}
