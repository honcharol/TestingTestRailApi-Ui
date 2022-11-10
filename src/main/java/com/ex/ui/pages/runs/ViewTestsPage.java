package com.ex.ui.pages.runs;

import com.ex.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ViewTestsPage extends BasePage {

    private final By statusDropDown = By
            .xpath("//div[@id='addResultStatus_chzn']/a/div/b");
    private final By statusList = By
            .xpath("//li[contains(@id,'addResultStatus_chzn_o')]");
    private final By addResultButton2 = By
            .xpath("//button[@id='addResultSubmit']/span[@class='addResult']");
    private final By commentTextArea = By
            .xpath("//div[@id='addResultComment_display']");
    private final By addResultButton = By
            .xpath("//a[@id='addResult'][contains(@class,'button-left')]");
    private final String testStatus =
            "//p[contains(text(),'%s')]//ancestor::div[contains(@id,'testChange')]//span[@class='status']";

    public ViewTestsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ViewTestsPage clickAddResultButton() {
        findElementCustom(webDriver, addResultButton).click();
        return this;
    }

    public ViewTestsPage clickOnStatusDropDown() {
        waitForElementToBeClickable(webDriver, statusDropDown).click();
        return this;
    }

    public String getRandomTstStatus() {
        Random rnd = new Random();
        List<String> statusList = new ArrayList<>();
        statusList.add("Passed");
        statusList.add("Blocked");
        statusList.add("Retest");
        statusList.add("Failed");
        return statusList.get(rnd.nextInt(statusList.size()));
    }

    public ViewTestsPage clickOnTestStatus(String statusName) {
        List<WebElement> webElements = findElementsCustom(webDriver, statusList);
        for (WebElement w : webElements) {
            if (w.getText().equals(statusName)) {
                w.click();
            }
        }
        return this;
    }

    public ViewTestsPage fillCommentToResult(String comment) {
        findElementCustom(webDriver, commentTextArea).sendKeys(comment);
        return this;
    }

    public ViewTestsPage clickOnAddResult() {
        findElementCustom(webDriver, addResultButton2).click();
        return new ViewTestsPage(webDriver);
    }

    public String nameOfTestStatus(String comment) {
        return findElementCustom(webDriver, By.xpath(String.format(testStatus, comment))).getText();
    }

}
