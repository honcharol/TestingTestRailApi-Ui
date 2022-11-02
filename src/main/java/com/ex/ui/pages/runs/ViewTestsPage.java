package com.ex.ui.pages.runs;

import com.ex.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewTestsPage extends BasePage {

    private final By addResultButton = By
            .xpath("//a[@id='addResult'][contains(@class,'button-left')]");

    public ViewTestsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddResultPage clickAddResultButton(){
        findElementCustom(webDriver, addResultButton).click();
        return new AddResultPage(webDriver);
    }

}
