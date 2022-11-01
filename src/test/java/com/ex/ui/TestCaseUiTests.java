package com.ex.ui;

import com.ex.ui.pages.LoginPage;
import com.ex.ui.pages.cases.AddTestCasePage;
import com.ex.ui.pages.cases.ViewSuitesPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCaseUiTests extends BaseTest {

    @Test
    public void createDefaultTestCase() {
        String testCaseSuite = String.valueOf(3);
        String testCaseName = "Some test case - " + System.currentTimeMillis();
        String testCasesTab = "//a[@id='navigation-suites'][contains(.,'Test Cases')]";

        boolean actualTestCaseName = new LoginPage(webDriver, pr.prop("addTestCaseUri").concat(testCaseSuite))
                .fillCredential(pr.prop("email"), pr.prop("password"))
                .clickOnLoginButton(new AddTestCasePage(webDriver))
                .enterTestCaseName(testCaseName)
                .clickOnAddCaseButton()
                .clickOnTab(new ViewSuitesPage(webDriver), testCasesTab)
                .verifyIfExistTestCaseInList(testCaseName);

        assertThat(actualTestCaseName).isEqualTo(true);
    }

    @Test
    public void unableToCreateTestCaseWithEmptyTitle(){
        String testCaseSuite = String.valueOf(3);
        String errorMassage = "Field Title is a required field.";

        String actualMassage = new LoginPage(webDriver, pr.prop("addTestCaseUri").concat(testCaseSuite))
                .fillCredential(pr.prop("email"), pr.prop("password"))
                .clickOnLoginButton(new AddTestCasePage(webDriver))
                .clickOnAddCaseButton()
                .verifyIfTestCasesErrorMassageIsDisplayed();

        assertThat(actualMassage).isEqualTo(errorMassage);
    }
}
