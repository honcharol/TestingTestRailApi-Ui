package com.ex.ui.pages.runs;

import com.ex.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class AddTestRunsPage extends BasePage {

    private final By testCasesList = By
            .xpath("//td[@class='checkbox']");
    private final By nameRow = By
            .xpath("//input[@id='name']");
    private final By selectTestCasesRadioButton = By
            .xpath("//input[@id='includeSpecific']");
    private final By changeSelection = By
            .xpath("//a[@href='javascript:void(0)'][contains(.,'change selection')]");
    private final By okButton = By
            .xpath("//button[@id='selectCasesSubmit']");
    private final By addTestRunButton = By
            .xpath("//button[@id='accept']");

    public AddTestRunsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddTestRunsPage enterTestRunName(String name){
        findElementCustom(webDriver, nameRow).clear();
        findElementCustom(webDriver, nameRow).sendKeys(name);
        return this;
    }

    public AddTestRunsPage clickOnSelectSpecificTestCasesRadioButton(){
        findElementCustom(webDriver, selectTestCasesRadioButton).click();
        return this;
    }

    public AddTestRunsPage clickOnChangeSelection(){
        findElementCustom(webDriver, changeSelection).click();
        return this;
    }

    public AddTestRunsPage clickOnRandomTestCase(){
        Random rnd = new Random();
        List<WebElement> listCases = findElementsCustom(webDriver,testCasesList);

        int randomTestCaseIndex = rnd.nextInt(listCases.size()-1);
        listCases.get(randomTestCaseIndex).click();
        return this;
    }

    public AddTestRunsPage clickOnOkButton(){
        findElementCustom(webDriver, okButton).click();
        return this;
    }

    public ViewRunsPage clickOnAddTestRunButton(){
        findElementCustom(webDriver, addTestRunButton).click();
        return new ViewRunsPage(webDriver);
    }
}
