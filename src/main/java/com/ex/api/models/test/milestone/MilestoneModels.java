package com.ex.api.models.test.milestone;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MilestoneModels {

    public String createMilestone(String milestoneName, int dueOn){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(new CreateMilestone()
                .setName(milestoneName)
                .setDueOn(dueOn));

    }

    public String updateMilestone(boolean bool) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(new UpdateMilestone()
                .setCompleted(bool));
    }
}
