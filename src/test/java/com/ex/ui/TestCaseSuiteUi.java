package com.ex.ui;

import com.ex.api.methods.PostMethod;
import com.ex.api.models.test.cases.TestCaseModels;
import com.ex.ui.pages.cases.CaseViewPage;
import com.ex.ui.pages.cases.LoginPage;
import com.ex.ui.pages.cases.ViewSuitesPage;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCaseSuiteUi extends BaseTest {

    @Test
    public void verifyIfTestCaseAppeared(String testCaseName) {
//status code deleted
        String body = new TestCaseModels()
                .createTestCaseWithoutSteps(testCaseName);
        Response response = new PostMethod().withBasicParameters("/api/v2/add_case/2", body);

        JSONObject jsonObject = new JSONObject(response.asString());
        String caseId = jsonObject.get("id").toString();

        new LoginPage(webDriver, pr.prop("uriSuiteCases").concat("2"))
                .inputEmail(pr.prop("email"))
                .inputPassword(pr.prop("password"))
                .clickOnLoginButton(new ViewSuitesPage(webDriver))
                .clickOnCase(caseId)
                .assertIfCaseStepsAreDisplayed();
    }

    @Test
    public void verifyCountUpdatedSteps() {
//        CaseViewPage caseViewPage = new LoginPage(webDriver, pr.prop("uriCases").concat("14"))
//                .inputEmail(pr.prop("email"))
//                .inputPassword(pr.prop("password"))
//                .clickOnLoginButton(new CaseViewPage(webDriver));
//        int initialContSteps = caseViewPage.getCountSteps();
//
//        String body = new TestCaseModels().updateTestCaseWithSteps(3);
//        new PostMethod()
//                .withBasicParameters("/api/v2/update_case/14", 200, body);
//        webDriver.navigate().refresh();
//        assertThat(caseViewPage.getCountSteps()).isGreaterThan(initialContSteps);
    }

}
