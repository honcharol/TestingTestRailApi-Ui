package com.ex.ui.pages.runs;

import com.ex.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ViewRunsPage extends BasePage {

    private final By successMassage = By
            .xpath("//div[@class='message message-success'][contains(.,'Successfully added')]");
    private final By testCasesList = By
            .xpath("//tr[contains(@id,'row-')]/td[@class='id']/a[@class='link-noline']");

    public ViewRunsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getSuccessMassage() {
        return findElementCustom(webDriver, successMassage).getText();
    }

    public ViewTestsPage clickOnRandomTestCase() {
        Random rnd = new Random();
        List<WebElement> webElements = findElementsCustom(webDriver, testCasesList);
        int index = rnd.nextInt(webElements.size());
        webElements.get(index).click();

        return new ViewTestsPage(webDriver);
    }
}
