package com.ex.api.requests;

import com.ex.api.models.projects.ProjectModels;
import com.ex.api.models.test.cases.TestCaseModels;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;


public class ProjectRequests extends Request {

    public Map<String, Object> createProjectRequest(String projectName) {
        String body = new ProjectModels()
                .createProjectWithoutSuiteMode(projectName);
        Response response = postMethod.withBasicParameters("/api/v2/add_project", 200, body);

        JSONObject jsonObject = new JSONObject(response.asString());
        return new HashMap<String, Object>() {
            {
                put("name", jsonObject.get("name"));
                put("id", jsonObject.get("id"));
            }
        };
    }

    public Map<String, Object> getProjectByIdRequest(int projectId) {
        Response response = getMethod.witPrimitiveParameters("/api/v2/get_projects", 200);

        JSONArray jsonArray = new JSONObject(response.asString()).getJSONArray("projects");
        String actualProjectName = "";
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            if (jsonObject.get("id").equals(projectId)) {
                actualProjectName = String.valueOf(jsonObject.get("name"));
            }
        }
        String finalActualProjectName = actualProjectName;
        return new HashMap<String, Object>() {
            {
                put("name", finalActualProjectName);
            }
        };
    }
}
