package com.ex.ui.pages.cases;

import com.ex.ui.pages.BasePage;
import org.json.JSONObject;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class CaseViewPage extends BasePage {
//    int stepsQuantity = 0;
    private By stepsLocator = By.xpath("//span[@class='field-title-inner'][contains(.,'Steps')]");
    private By stepsListLocator = By.xpath("//tr[@class='not-shared ']");

    public CaseViewPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CaseViewPage assertIfCaseStepsAreDisplayed (){
        assertThat(stepsLocator.toString().equals("Steps"));
        return this;
    }

    public int getCountSteps() {
        int stepsQuantity = 0;
        try {
            stepsQuantity = findElementsCustom(webDriver, stepsListLocator).size();
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
        return stepsQuantity;
    }

    public CaseViewPage getStepsApi(Response getResponse) {
        int stepsQuantity = 0;
        JSONObject jsonObject = new JSONObject(getResponse.asString());
        String stepsListJson;
        List<String> stringList ;

        boolean stepsQuantityInWeb = true;
        try {
           jsonObject.get("custom_steps_separated");
        } catch (Exception e) {
            stepsQuantityInWeb = false;
        }
        if(stepsQuantityInWeb){
            stepsListJson = jsonObject.get("custom_steps_separated").toString();
            stringList = Arrays.asList(stepsListJson.split("},"));
            stepsQuantity = stringList.size();
        }else stepsQuantity =0;

        return this;
    }


    public CaseViewPage assertStepAddedToCaseApi(Response postResponse, int countStep){
        JSONObject jsonObject = new JSONObject(postResponse.asString());
        String stepsListJson = jsonObject.get("custom_steps_separated").toString();
        List<String> stringList = Arrays.asList(stepsListJson.split("},"));

        boolean a = false;
        if(stringList.size()> countStep){
            a = true;
        }
        assertThat(a).isEqualTo(true);
        return this;
    }

}
