package com.ex.ui;

import com.ex.ui.pages.LoginPage;
import com.ex.ui.pages.cases.AddCasePage;
import com.ex.ui.pages.cases.EditCasesPage;
import com.ex.ui.pages.cases.ViewCasesPage;
import com.ex.ui.pages.cases.ViewSuitesPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCaseUiTests extends BaseTest {

    @Test
    public void updateTestCaseByAddingSteps(){
        String testCaseId = "18";
        String sectionId = "1";

        int existingStepQuantity =
                new LoginPage(webDriver, pr.prop("editTestCase").concat(testCaseId+"/"+sectionId))
                .fillCredential(pr.prop("email"), pr.prop("password"))
                .clickOnLoginButton(new ViewCasesPage(webDriver))
                .getStepQuantity();
        int newStepQuantity =
                new EditCasesPage(webDriver)
                .clickOnAddStep()
                .clickOnSaveTestCaseButton()
                .getStepQuantity();

        assertThat(newStepQuantity).isGreaterThan(existingStepQuantity);
    }

    @Test
    public void createDefaultTestCase() {
        String testCaseSuite = "1";
        String testCaseName = "Some test case - " + System.currentTimeMillis();
        String tabName = "suites";

        boolean actualTestCaseName = new LoginPage(webDriver, pr.prop("addTestCase").concat(testCaseSuite))
                .fillCredential(pr.prop("email"), pr.prop("password"))
                .clickOnLoginButton(new AddCasePage(webDriver))
                .enterTestCaseName(testCaseName)
                .clickOnAddCaseButton()
                .clickOnTab(new ViewSuitesPage(webDriver), tabName)
                .verifyIfExistTestCaseInList(testCaseName);

        assertThat(actualTestCaseName).as("case not appeared in the list").isEqualTo(true);
    }

    @Test
    public void unableToCreateTestCaseWithEmptyTitle(){
        String testCaseSuite = "3";
        String errorMassage = "Field Title is a required field.";

        String actualMassage = new LoginPage(webDriver, pr.prop("addTestCase").concat(testCaseSuite))
                .fillCredential(pr.prop("email"), pr.prop("password"))
                .clickOnLoginButton(new AddCasePage(webDriver))
                .clickOnAddCaseButton()
                .verifyIfTestCasesErrorMassageIsDisplayed();

        assertThat(actualMassage).isEqualTo(errorMassage);
    }
}
