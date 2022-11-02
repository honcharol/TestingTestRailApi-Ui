package com.ex.ui;
import com.ex.ui.pages.LoginPage;
import com.ex.ui.pages.runs.AddTestRunsPage;
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
                .clickOnLoginButton(new AddTestRunsPage(webDriver))
                .enterTestRunName(testRunName)
                .clickOnSelectSpecificTestCasesRadioButton()
                .clickOnChangeSelection()
                .clickOnRandomTestCase()
                .clickOnOkButton()
                .clickOnAddTestRunButton()
                .getSuccessMassage();

        assertThat(actualMassage).isEqualTo(successMassage);
    }
}
