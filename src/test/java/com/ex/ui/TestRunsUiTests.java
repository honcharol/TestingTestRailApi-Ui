package com.ex.ui;
import com.ex.ui.pages.LoginPage;
import com.ex.ui.pages.runs.AddRunsPage;
import com.ex.ui.pages.runs.OverviewRunsPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TestRunsUiTests extends BaseTest{

    @Test
    public void createTestRunWithSpecificTestCase(){
        String suiteId = "3";
        String successMassage = "Successfully added the new test run.";
        String testRunName = "Some Test Run: " + System.currentTimeMillis();

        String actualMassage = new LoginPage(webDriver, pr.prop("addTestRuns").concat(suiteId))
                .fillCredential(pr.prop("email"), pr.prop("password"))
                .clickOnLoginButton(new AddRunsPage(webDriver))
                .enterTestRunName(testRunName)
                .clickOnSelectSpecificTestCasesRadioButton()
                .clickOnChangeSelection()
                .clickOnRandomTestCases()
                .clickOnOkButton()
                .clickOnAddTestRunButton()
                .getSuccessMassage();

        assertThat(actualMassage).isEqualTo(successMassage);
    }

    @Test
    public void addResultToTestCase(){
        String projectId = "6";

        new LoginPage(webDriver, pr.prop("overviewRuns").concat(projectId))
                .fillCredential(pr.prop("email"), pr.prop("password"))
                .clickOnLoginButton(new OverviewRunsPage(webDriver))
                .clickOnRandomTestRun()
                .clickOnRandomTestCase()
                .clickAddResultButton()
                .clickOnStatusDropDown()
                .clickOnRandomStatus()
                .clickOnAddResult();

    }
}
