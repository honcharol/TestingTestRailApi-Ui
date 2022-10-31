package com.ex.ui;

import com.ex.ui.pages.LoginPage;
import com.ex.ui.pages.cases.AddTestCasePage;
import com.ex.ui.pages.cases.TestCaseMethods;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCaseUiTests extends BaseTest {

    @Test
    public void createTestCaseWithoutSteps() {
        String testCaseSuite = String.valueOf(3);
        String testCaseName = "Some test case - " + System.currentTimeMillis();
        new LoginPage(webDriver, pr.prop("addTestCaseUri").concat(testCaseSuite))
                .fillCredential(pr.prop("email"), pr.prop("password"))
                .clickOnLoginButton(new AddTestCasePage(webDriver))
                .addTestCaseName(testCaseName)
                .clickOnAddCaseButton();
        boolean actualTestCaseName = new TestCaseMethods(webDriver)
                .verifyByNameIfExistTestCase(testCaseName);

        assertThat(actualTestCaseName).isEqualTo(true);
    }

    @Test
    public void unableToCreateTestCaseWithEmptyTitle(){
        String testCaseSuite = String.valueOf(3);
        String errorMassage = "Field Title is a required field.";
        new LoginPage(webDriver, pr.prop("addTestCaseUri").concat(testCaseSuite))
                .fillCredential(pr.prop("email"), pr.prop("password"))
                .clickOnLoginButton(new AddTestCasePage(webDriver))
                .clickOnAddCaseButton();

        String actualMassage = new TestCaseMethods(webDriver)
                .verifyIfTestCasesErrorMassageIsDisplayed();
        assertThat(actualMassage).isEqualTo(errorMassage);
    }
}
