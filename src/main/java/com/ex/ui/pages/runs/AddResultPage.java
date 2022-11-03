package com.ex.ui.pages.runs;

import com.ex.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class AddResultPage extends BasePage {

    private final By statusDropDown = By
            .xpath("//span[contains(.,'Passed')]");
    private final By statusList = By
            .xpath("//li[contains(@id,'addResultStatus_chzn_o')]");
    private final By addResultButton = By
            .xpath("//button[@id='addResultSubmit']/span[@class='addResult']");

    public AddResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddResultPage clickOnStatusDropDown() {
        waitForElementToBeClickable(webDriver, statusDropDown).click();
        return this;
    }

    public AddResultPage clickOnRandomStatus() {
        Random rnd = new Random();
        List<WebElement> webElements = findElementsCustom(webDriver, statusList);
        int index = rnd.nextInt(webElements.size());
        webElements.get(index).click();
        return this;
    }

    public ViewTestsPage clickOnAddResult() {
        findElementCustom(webDriver, addResultButton).click();
        return new ViewTestsPage(webDriver);
    }
}
