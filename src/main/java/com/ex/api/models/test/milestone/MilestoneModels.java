package com.ex.api.models.test.milestone;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public class MilestoneModels {

    public String createMilestone(Map<String, Object> map ){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(new CreateMilestone()
                .setName((String) map.get("milestoneName"))
                .setDueOn((Integer) map.get("dueOn")));

    }

    public String updateMilestone(Map<String, Object> map) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(new CreateMilestone()
                .setCompleted((Boolean) map.get("isCompleted")));
    }
}
