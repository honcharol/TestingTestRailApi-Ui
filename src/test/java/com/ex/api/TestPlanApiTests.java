package com.ex.api;

import com.ex.api.requests.TestPlanRequests;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TestPlanApiTests {

    private final TestPlanRequests testPlanRequests = new TestPlanRequests();

    @Test
    public void createTestPlan() {
        int assignedTo = 1;
        int projectId = 10;
        int suiteId = 4;
        String testRunName = "Custom run Name";
        String expectedName = "New test plan " + new Timestamp(System.currentTimeMillis());
        int[] casesIds = {15, 19, 20};

        Map<String, Object> map = new HashMap<>();
        map.put("projectId", projectId);
        map.put("planName", expectedName);
        map.put("testRunName", testRunName);
        map.put("suiteId", suiteId);
        map.put("casesIds", casesIds);
        map.put("assignedToId", assignedTo);
        map.put("includeAll", false);


        String actualName = testPlanRequests.createTestPlanRequest(map).get("name").toString();
        assertThat(actualName).isEqualTo(expectedName);
    }

    @Test
    public void getTestPlan() {
        int testPlanId = 16;
        int projectId = 10;
        String expectedTestPlanName = "System test";
        String actualTestPlanName = testPlanRequests.getTestPlanRequest(projectId, testPlanId);
        assertThat(actualTestPlanName).isEqualTo(expectedTestPlanName);
    }

    @Test
    public void deleteTestPlan() {
        int projectId = 10;
        String testPlanName = "New test plan 2022-10-22 22:55:07.817";
        int statusCode = testPlanRequests.deleteTestPlanRequest(testPlanName, projectId);
        assertThat(statusCode).isEqualTo(200);
    }
}
