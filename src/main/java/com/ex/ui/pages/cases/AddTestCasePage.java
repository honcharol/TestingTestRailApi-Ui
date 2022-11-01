package com.ex.ui.pages.cases;

import com.ex.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTestCasePage extends BasePage {

    private final By testCaseNameRow = By
            .xpath("//input[@id='title']");
    private final By addCaseButton = By
            .xpath("//button[@type='submit'][contains(.,'Add Test Case')]");
    private final By errorMassage = By
            .xpath("//div[@class='message message-error'][contains(.,'Field Title is a required field.')]");


    public AddTestCasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddTestCasePage enterTestCaseName(String name) {
        findElementCustom(webDriver, testCaseNameRow).sendKeys(name);
        return this;
    }

    public AddTestCasePage clickOnAddCaseButton() {
        findElementCustom(webDriver, addCaseButton).click();
        return this;
    }

    public String verifyIfTestCasesErrorMassageIsDisplayed(){
        return findElementCustom(webDriver, errorMassage).getText();
    }
}
