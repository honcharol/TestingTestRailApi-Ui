package com.ex.ui.pages.cases;

import com.ex.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewSuitesPage extends BasePage {
    private int caseId;

    public ViewSuitesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public TestCaseMethods clickOnCase(String caseId){
        By selectedCase =
                By.xpath("//tr[contains(@id,'row-" + caseId +"')]//td/a/span[@class='title']");
        findElementCustom(webDriver, selectedCase).click();
        return new TestCaseMethods(webDriver);
    }
}
