package com.ex.ui.pages.cases;

import com.ex.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddTestCasePage extends BasePage {

    private final By testCaseNameRow = By
            .xpath("//input[@id='title']");
    private final By addCaseButton = By
            .xpath("//button[@type='submit'][contains(.,'Add Test Case')]");


    public AddTestCasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddTestCasePage addTestCaseName(String name){
        findElementCustom(webDriver,testCaseNameRow).sendKeys(name);
        return this;
    }

    public AddTestCasePage clickOnAddCaseButton(){
        findElementCustom(webDriver, addCaseButton).click();
        return this;
    }
}
