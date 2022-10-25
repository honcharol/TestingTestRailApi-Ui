package com.ex.api.models.test.cases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestCaseModels {
    public String createTestCaseWithoutSteps(String name) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(new CreateTestCase()
                .setTitle(name)
                .setTypeId(1)
                .setPriorityId(3)
                .setEstimate("3m")
                .setRefs("RF-1, RF-2"));
    }


    public String updateTestCaseWithSteps(ArrayList<Map<String, String>> arrayLists) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<CustomStepsSeparated> customStepsSeparated = new ArrayList<>();

        for (Map<String, String> map : arrayLists) {
            customStepsSeparated.add(new CustomStepsSeparated()
                    .setContent(map.get("content"))
                    .setAdditionalInfo(map.get("additionalInfo"))
                    .setExpected(map.get("expected")));
        }

        return gson.toJson(new CreateTestCase()
                .setTypeId(1)
                .setPriorityId(3)
                .setCustomStepsSeparated(customStepsSeparated));
    }
}
