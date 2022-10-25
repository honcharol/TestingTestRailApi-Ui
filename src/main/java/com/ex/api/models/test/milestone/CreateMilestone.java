package com.ex.api.models.test.milestone;

import com.google.gson.annotations.SerializedName;

public class CreateMilestone {
    private String name;
    @SerializedName("due_on")
    private int dueOn = 0;

    public String getName() {
        return name;
    }

    public CreateMilestone setName(String name) {
        this.name = name;
        return this;
    }

    public int getDueOn() {
        return dueOn;
    }

    public CreateMilestone setDueOn(int dueOn) {
        this.dueOn = dueOn;
        return this;
    }
}
