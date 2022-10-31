package com.ex.api.requests;

import com.ex.api.models.test.cases.TestCaseModels;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.*;

public class TestCaseRequests extends Request{

    public int updateTestCaseAddStepsRequest(ArrayList<Map<String, String>> list, int caseId) {
        String body = new TestCaseModels()
                .updateTestCaseWithSteps(list);
        postMethod
                .withBasicParameters("/api/v2/update_case/" + caseId, body);

        int stepsQuantity = 0;
        JSONObject jsonObject = new JSONObject(body);
        List<String> stringList;

        try {
            jsonObject.get("custom_steps_separated");
            stringList = Arrays.asList(jsonObject.get("custom_steps_separated").toString().split("},"));
            stepsQuantity = stringList.size();
        } catch (Exception e) {
            e.getMessage();
        }
        return stepsQuantity;
    }

    public Map<String, Object> createTestCaseRequest(String testCaseName, int sectionId) {
        String body = new TestCaseModels()
                .createTestCaseWithoutSteps(testCaseName);
        Response response = postMethod
                .withBasicParameters("/api/v2/add_case/" + sectionId, body);

        JSONObject jsonObject = new JSONObject(response.asString());
        Map<String,Object>objectMap = new HashMap<>();
        if(response.getStatusCode() == 200){
            objectMap.put("name", jsonObject.get("title"));
        }else {
            objectMap.put("statusCode", response.getStatusCode());
        }
        return objectMap;
    }
}
