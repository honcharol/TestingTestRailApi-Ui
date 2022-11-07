package com.ex.api;

import com.ex.api.requests.TestCaseRequests;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCaseApiTests {

    private final TestCaseRequests testCaseRequests = new TestCaseRequests();

    @Test
    public void unableCreateTestCaseWithWrongName(){
        int sectionId = 9;
        String expectedCaseName = "";

        int actualStatusCode = (int) testCaseRequests
                .createTestCaseRequest(expectedCaseName, sectionId).get("statusCode");
        assertThat(actualStatusCode).isNotEqualTo(200);
    }

    @Test
    public void createNewTestCaseWithoutSteps() {
        int sectionId = 2;

        String expectedCaseName = "New test case" + new Timestamp(System.currentTimeMillis());

        String actualCaseName = testCaseRequests
                .createTestCaseRequest(expectedCaseName, sectionId).get("name").toString();
        assertThat(actualCaseName).isEqualTo(expectedCaseName);
    }

    @Test
    public void updateTestCaseAddSteps() {
        int expectedStepsQuantity = 3;
        int testCaseId = 21;

        ArrayList<Map<String, String>> list = new ArrayList<>();
        for (int i=0; i<expectedStepsQuantity; i++){
            Map<String, String> map = new HashMap<>();
            map.put("content","Step " + (i+1));
            map.put("additionalInfo","Additional info " + (i+1));
            map.put("expected","Expected result " + (i+1));
            list.add(map);
        }
        int actualStepQuantity = testCaseRequests.updateTestCaseAddStepsRequest(list, testCaseId);
        assertThat(actualStepQuantity).isEqualTo(expectedStepsQuantity);
    }


    @Test
    public void updateTestCaseAdddSteps() {

//        CaseViewPage lp = new CaseViewPage(webDriver).getStepsApi(new GetMethod()
//                .witPrimitiveParameters("/api/v2/get_case/14", 200));
//
//        String body = new TestCaseModels().CreateTestCaseWithSteps();
//        Response postResponse = new PostMethod()
//                .withBasicParameters("/api/v2/update_case/14", 200, body);
//
//        lp.assertStepAddedToCaseApi(postResponse, 1);
    }

    @Test
    public void ffgh() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Additional info");
        list1.add("Expected Result 1");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Additional info 2");
        list2.add("Expected Result 2");

        Map<String, ArrayList<String>> map = new HashMap<>();
        map.put("Step 1", list1);
        map.put("Step 2", list2);

        System.out.println();
    }
}
