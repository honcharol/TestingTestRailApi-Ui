package com.ex.api.requests;

import com.ex.api.models.test.plan.TestPlanModels;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestPlanRequests extends Request {

    public Map<String, Object> createTestPlanRequest(Map<String, Object> map) {
        String body = new TestPlanModels().createTestPlanModel(map);
        Response response = postMethod
                .withBasicParameters("/api/v2/add_plan/" + map.get("projectId"), 200, body);

        JSONObject jsonObject = new JSONObject(response.asString());
        return new HashMap<String, Object>() {
            {
                put("name", jsonObject.get("name"));
            }
        };
    }

    public int deleteTestPlanRequest(String planName, int projId) {
        Response response = getMethod.witPrimitiveParameters("/api/v2/get_plans/" + projId, 200);
        JSONObject jsonObject = new JSONObject(response.asString());
        int planId = 0;
        JSONArray jsonArray = jsonObject.getJSONArray("plans");
        for (Object object : jsonArray) {
            if (((JSONObject) object).get("name").equals(planName)) {
                planId = Integer.parseInt(((JSONObject) object).get("id").toString());
            }
        }
        return deleteMethod.withBasicParameters("/api/v2/delete_plan/" + planId).statusCode();
    }

    public String getTestPlanRequest(int projId, int testPlanId) {
        Response response = getMethod.witPrimitiveParameters("/api/v2/get_plans/" + projId, 200);
        JSONObject jsonObject = new JSONObject(response.asString());
        JSONArray jsonArray = jsonObject.getJSONArray("plans");
        String actualName = "";
        for (Object object : jsonArray) {
            if (((JSONObject) object).get("id").equals(testPlanId)) {
                actualName = ((JSONObject) object).get("name").toString();
            }
        }
        return actualName;
    }
}
