package com.ex.ui.pages.cases;

import com.ex.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ViewSuitesPage extends BasePage {

    private final By testsCasesList = By
            .xpath("//a[@rel='keep-get']/span[@class='title' ]");

    public ViewSuitesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getActualName(String caseId) {
        By selectedCase =
                By.xpath("//tr[contains(@id,'row-" + caseId + "')]//td/a/span[@class='title']");
        return findElementCustom(webDriver, selectedCase).getText();
    }

    public boolean verifyIfExistTestCaseInList(String name) {
        boolean ifExistName = false;
        List<WebElement> webElement = findElementsCustom(webDriver, testsCasesList);
        for (WebElement w : webElement) {
            if (w.getText().contains(name)) {
                ifExistName = true;
            }
        }
        return ifExistName;
    }
}
