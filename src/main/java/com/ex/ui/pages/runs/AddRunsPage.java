package com.ex.ui.pages.runs;

import com.ex.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class AddRunsPage extends BasePage {

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

    public AddRunsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddRunsPage enterTestRunName(String name) {
        findElementCustom(webDriver, nameRow).clear();
        findElementCustom(webDriver, nameRow).sendKeys(name);
        return this;
    }

    public AddRunsPage clickOnSelectSpecificTestCasesRadioButton() {
        findElementCustom(webDriver, selectTestCasesRadioButton).click();
        return this;
    }

    public AddRunsPage clickOnChangeSelection() {
        findElementCustom(webDriver, changeSelection).click();
        return this;
    }

    public AddRunsPage chooseRandomScopeOfTestCases() {
        Random rnd = new Random();
        List<WebElement> listCases = findElementsCustom(webDriver, testCasesList);

        int randomNumberOfCases = rnd.nextInt(2 + 1) + 2;
        for (int i = 0; i < randomNumberOfCases; i++) {
            int index = rnd.nextInt(listCases.size());
            listCases.get(index).click();
            listCases.remove(index);
        }
        return this;
    }

    public AddRunsPage clickOnOkButton() {
        findElementCustom(webDriver, okButton).click();
        return this;
    }

    public ViewRunsPage clickOnAddTestRunButton() {
        findElementCustom(webDriver, addTestRunButton).click();
        return new ViewRunsPage(webDriver);
    }
}
