package com.ex.ui.pages;

import com.ex.ui.pages.WebHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends WebHelpers {
     protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public BasePage(WebDriver webDriver, String url) {
        webDriver.get(url);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }


    <T> T clickButton(T type, String buttonName, String locator){
        findElementCustom(webDriver, By.xpath(String.format(locator, buttonName))).click();
        return type;
    }

}
