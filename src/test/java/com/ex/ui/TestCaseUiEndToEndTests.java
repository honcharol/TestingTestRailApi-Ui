package com.ex.ui;

import com.ex.api.methods.PostMethod;
import com.ex.api.models.test.cases.TestCaseModels;
import com.ex.ui.pages.LoginPage;
import com.ex.ui.pages.cases.ViewCasesPage;
import com.ex.ui.pages.cases.ViewSuitesPage;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCaseUiEndToEndTests extends BaseTest {

    @Test
    public void verifyIfTestCaseAppeared() {
        String sectionId = "2";
        String testCaseName = "New test case: " + new Timestamp(System.currentTimeMillis());

        String body = new TestCaseModels().createTestCaseWithoutSteps(testCaseName);
        Response response = new PostMethod().withBasicParameters("/api/v2/add_case/" + sectionId, body);

        JSONObject jsonObject = new JSONObject(response.asString());
        String suiteId = jsonObject.get("suite_id").toString();
        String caseId = jsonObject.get("id").toString();

        String actualTestCaseName = new LoginPage(webDriver, pr.prop("viewSuiteCases").concat(suiteId))
                .fillCredential(pr.prop("email"), pr.prop("password"))
                .clickOnLoginButton(new ViewSuitesPage(webDriver))
                .getActualName(caseId);

        assertThat(actualTestCaseName).isEqualTo(testCaseName);
    }

    @Test
    public void checkIfTheNumberOfStepsHasIncreased() {
        String testCaseId = "14";
        int stepsQuantity = 4;

        int initialCountSteps = new LoginPage(webDriver, pr.prop("viewTestCases").concat(testCaseId))
                .fillCredential(pr.prop("email"), pr.prop("password"))
                .clickOnLoginButton(new ViewCasesPage(webDriver))
                .getStepQuantity();

        ArrayList<Map<String, String>> list = new ArrayList<>();
        for (int i = 0; i < stepsQuantity; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("content", "Step " + (i + 1));
            map.put("additionalInfo", "Additional info " + (i + 1));
            map.put("expected", "Expected result " + (i + 1));
            list.add(map);
        }

        String body = new TestCaseModels().updateTestCaseWithSteps(list);
        new PostMethod()
                .withBasicParameters("/api/v2/update_case/" + testCaseId, body);

        webDriver.navigate().refresh();
        int actualStepsQuantity = new ViewCasesPage(webDriver).getStepQuantity();
        assertThat(actualStepsQuantity).isGreaterThan(initialCountSteps);
    }

}
