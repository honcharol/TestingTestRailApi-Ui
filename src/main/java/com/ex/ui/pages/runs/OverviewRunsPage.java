package com.ex.ui.pages.runs;

import com.ex.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class OverviewRunsPage extends BasePage {

    private final By testRunList = By
            .xpath("//div[@class='summary-title text-ppp']/a");

    public OverviewRunsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ViewRunsPage clickOnRandomTestRun() {
        Random rnd = new Random();
        List<WebElement> webElements = findElementsCustom(webDriver, testRunList);
        int index = rnd.nextInt(webElements.size());
        webElements.get(index).click();
        return new ViewRunsPage(webDriver);
    }
}
