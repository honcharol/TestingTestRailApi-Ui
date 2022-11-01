package com.ex.ui.pages.cases;

import com.ex.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ViewCasesPage extends BasePage {

    private final By testCaseStepList = By.xpath("//span[@class='step-index-inner']");

    public ViewCasesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public int getStepQuantity(){
        int stepsQuantity = 0;
        List<WebElement> stepList;
        try {
            stepList = findElementsCustom(webDriver, testCaseStepList);
            stepsQuantity = stepList.size();
        } catch (Exception e) {
            e.getMessage();
        }
        return stepsQuantity;
    }
}
