package com.ex.ui.pages.runs;

import com.ex.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewRunsPage extends BasePage {

    private final By successMassage = By
            .xpath("//div[@class='message message-success'][contains(.,'Successfully added')]");

    public ViewRunsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getSuccessMassage(){
        return findElementCustom(webDriver, successMassage).getText();
    }
}
