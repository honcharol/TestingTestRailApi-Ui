package com.ex.api.models.test.plan;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestPlanModels {

    public String createTestPlanModel(Map<String, Object> map) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Entries> entriesList = new ArrayList<>();
        entriesList.add(new Entries()
                .setSuiteId((Integer) map.get("suiteId"))
                .setName((String) map.get("testRunName"))
                .setAssignedToId((Integer) map.get("assignedToId"))
                .setIncludeAll((Boolean) map.get("includeAll"))
                .setCaseIds((int[]) map.get("casesIds")));

        return gson.toJson(new CreateTestPlan()
                .setName((String) map.get("planName"))
                .setEntries(entriesList));

    }
}
