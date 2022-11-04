package com.ex.ui;

import com.ex.ui.pages.LoginPage;
import com.ex.ui.pages.runs.AddRunsPage;
import com.ex.ui.pages.runs.ViewRunsPage;
import com.ex.ui.pages.runs.ViewTestsPage;
import com.ex.utils.LogicHelper;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRunsUiTests extends BaseTest {

    @Test
    public void createTestRunWithSpecificTestCase() {
        String suiteId = "3";
        String successMassage = "Successfully added the new test run.";
        String testRunName = "Some Test Run: " + System.currentTimeMillis();

        String actualMassage = new LoginPage(webDriver, pr.prop("addTestRuns").concat(suiteId))
                .fillCredential(pr.prop("email"), pr.prop("password"))
                .clickOnLoginButton(new AddRunsPage(webDriver))
                .enterTestRunName(testRunName)
                .clickOnSelectSpecificTestCasesRadioButton()
                .clickOnChangeSelection()
                .chooseRandomScopeOfTestCases()
                .clickOnOkButton()
                .clickOnAddTestRunButton()
                .getSuccessMassage();

        assertThat(actualMassage).isEqualTo(successMassage);
    }

    @Test
    public void addResultToTestCase() {
        String testRunId = "21";
        String comment = LogicHelper.randomString(10);
        String statusName = new ViewTestsPage(webDriver).getRandomTstStatus();

        String testStatus = new LoginPage(webDriver, pr.prop("viewRuns").concat(testRunId))
                .fillCredential(pr.prop("email"), pr.prop("password"))
                .clickOnLoginButton(new ViewRunsPage(webDriver))
                .clickOnRandomTestCase()
                .clickAddResultButton()
                .clickOnStatusDropDown()
                .clickOnTestStatus(statusName)
                .fillCommentToResult(comment)
                .clickOnAddResult()
                .nameOfTestStatus(comment);

        assertThat(testStatus).isEqualTo(statusName);
    }
}
