package com.ex.ui.pages.cases;

import com.ex.ui.pages.BasePage;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCaseMethods extends BasePage {
    private final By stepsLocator = By
            .xpath("//span[@class='field-title-inner'][contains(.,'Steps')]");
    private final By stepsListLocator = By
            .xpath("//tr[@class='not-shared ']");
    private final By testsCasesList = By
            .xpath("//a[@rel='keep-get']/span[@class='title' ]");
    private final By testCasesTab = By
            .xpath("//li[@class='header-menu-item header-menu-item-selected'][contains(.,'Test Cases')]");
    private final By errorMassage = By
            .xpath("//div[@class='message message-error'][contains(.,'Field Title is a required field.')]");

    public TestCaseMethods(WebDriver webDriver) {
        super(webDriver);
    }

    public void assertIfCaseStepsAreDisplayed() {
        assertThat(stepsLocator.toString().equals("Steps"));
    }

    public String verifyIfTestCasesErrorMassageIsDisplayed(){
        return findElementCustom(webDriver, errorMassage).getText();
    }

    public boolean verifyByNameIfExistTestCase(String name){
        findElementCustom(webDriver, testCasesTab).click();
        boolean ifExistName = false;
        List<WebElement> webElement = findElementsCustom(webDriver, testsCasesList);
        for(WebElement w: webElement){
            if(w.getText().contains(name)){
                ifExistName = true;
            }
        }return ifExistName;
    }

    public int getCountSteps() {
        int stepsQuantity = 0;
        try {
            stepsQuantity = findElementsCustom(webDriver, stepsListLocator).size();
        } catch (Exception e) {
            e.getMessage();
        }
        return stepsQuantity;
    }

    public TestCaseMethods getStepsApi(Response getResponse) {
        int stepsQuantity = 0;
        JSONObject jsonObject = new JSONObject(getResponse.asString());
        String stepsListJson;
        List<String> stringList;

        boolean stepsQuantityInWeb = true;
        try {
            jsonObject.get("custom_steps_separated");
        } catch (Exception e) {
            stepsQuantityInWeb = false;
        }
        if (stepsQuantityInWeb) {
            stepsListJson = jsonObject.get("custom_steps_separated").toString();
            stringList = Arrays.asList(stepsListJson.split("},"));
            stepsQuantity = stringList.size();
        } else stepsQuantity = 0;

        return this;
    }


    public TestCaseMethods assertStepAddedToCaseApi(Response postResponse, int countStep) {
        JSONObject jsonObject = new JSONObject(postResponse.asString());
        String stepsListJson = jsonObject.get("custom_steps_separated").toString();
        List<String> stringList = Arrays.asList(stepsListJson.split("},"));

        boolean a = stringList.size() > countStep;
        assertThat(a).isEqualTo(true);
        return this;
    }

}
