package com.ex.api.requests;

import com.ex.api.models.test.milestone.MilestoneModels;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MilestoneRequests extends Request{

    public String updateMilestoneRequest(Map<String,Object>map){
        String body = new MilestoneModels().updateMilestone(map);
        Response response = postMethod
                .withBasicParameters("/api/v2/update_milestone/"+ map.get("milestoneId"), body);
        JSONObject jsonObject = new JSONObject(response.asString());

        return jsonObject.get("is_completed").toString();
    }

    public String getMilestonesRequest(int projId, int mileId){
        Response response = getMethod
                .witPrimitiveParameters("/api/v2/get_milestones/"+ projId, 200);
        JSONObject jsonObject = new JSONObject(response.asString());
        JSONArray jsonArray = jsonObject.getJSONArray("milestones");
        String actualName ="";
        for (Object obj: jsonArray){
            JSONObject jsonObject1 = (JSONObject) obj;
            if(jsonObject1.get("id").equals(mileId)){
                actualName = jsonObject1.get("name").toString();
            }
        }
        return actualName;
    }

    public Map<String, Object> createMilestoneRequest(Map<String, Object> map){
        String body = new MilestoneModels().createMilestone(map);
        Response response = postMethod
                .withBasicParameters("/api/v2/add_milestone/"+ map.get("projId"), body);

        JSONObject jsonObject = new JSONObject(response.asString());
        Map<String,Object>objectMap = new HashMap<>();
        if(response.getStatusCode() == 200){
            objectMap.put("name", jsonObject.get("name"));
        }else {
            objectMap.put("statusCode", response.getStatusCode());
        }
        return objectMap;
    }
}
