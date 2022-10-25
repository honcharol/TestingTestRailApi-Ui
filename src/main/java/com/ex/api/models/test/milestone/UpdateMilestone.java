package com.ex.api.models.test.milestone;

import com.google.gson.annotations.SerializedName;

public class UpdateMilestone {
    @SerializedName("is_completed")
    private boolean isCompleted;

    public boolean isCompleted() {
        return isCompleted;
    }

    public UpdateMilestone setCompleted(boolean completed) {
        isCompleted = completed;
        return this;
    }
}
