package com.ex.ui.pages.cases;

import com.ex.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditTestCasePage extends BasePage {

    private final By addStepButton = By
            .xpath("//span[@class='pull-right']/a[@class='addStep']");
    private final By saveTestCaseButton = By
            .xpath("//button[@id='accept'][contains(.,'Save Test Case')]");

    public EditTestCasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public EditTestCasePage clickOnAddStep() {
        findElementCustom(webDriver, addStepButton).click();
        return this;
    }

    public ViewCasesPage clickOnSaveTestCaseButton() {
        scrollToElement(webDriver, findElementCustom(webDriver, saveTestCaseButton));
        waitForElementToBeClickable(webDriver, saveTestCaseButton).click();
        return new ViewCasesPage(webDriver);
    }
}
