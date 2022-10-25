package com.ex.api.requests;

import com.ex.api.models.test.cases.TestCaseModels;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.*;

public class TestCaseRequests extends Request{

    public int updateTestCaseAddStepsRequest(ArrayList<Map<String, String>> list, int caseId) {
        String body = new TestCaseModels()
                .updateTestCaseWithSteps(list);
        Response response = postMethod
                .withBasicParameters("/api/v2/update_case/" + caseId, 200, body);

        int stepsQuantity = 0;
        JSONObject jsonObject = new JSONObject(response.asString());
        String stepsListJson;
        List<String> stringList;

        boolean stepsQuantityInWeb = true;
        try {
            jsonObject.get("custom_steps_separated");
        } catch (Exception e) {
            stepsQuantityInWeb = false;
        }
        if (stepsQuantityInWeb) {
            stepsListJson = jsonObject.get("custom_steps_separated").toString();
            stringList = Arrays.asList(stepsListJson.split("},"));
            stepsQuantity = stringList.size();
        } else stepsQuantity = 0;
        return stepsQuantity;
    }

    public Map<String, Object> createTestCaseRequest(String testCaseName, int sectionId) {
        String body = new TestCaseModels()
                .createTestCaseWithoutSteps(testCaseName);
        Response response = postMethod
                .withBasicParameters("/api/v2/add_case/" + sectionId, 200, body);

        JSONObject jsonObject = new JSONObject(response.asString());
        return new HashMap<String, Object>() {
            {
                put("name", jsonObject.get("title"));
            }
        };
    }
}
