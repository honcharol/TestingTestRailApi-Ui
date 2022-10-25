package com.ex.api.models.test.cases;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CreateTestCase {
    private String title;
    @SerializedName("type_id")
    private int typeId;
    @SerializedName("priority_id")
    private int priorityId;
    private String estimate;
    private String refs;
    @SerializedName("custom_steps_separated")
    private List<CustomStepsSeparated> customStepsSeparated = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public CreateTestCase setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getTypeId() {
        return typeId;
    }

    public CreateTestCase setTypeId(int typeId) {
        this.typeId = typeId;
        return this;
    }

    public int getPriorityId() {
        return priorityId;
    }

    public CreateTestCase setPriorityId(int priorityId) {
        this.priorityId = priorityId;
        return this;
    }

    public String getEstimate() {
        return estimate;
    }

    public CreateTestCase setEstimate(String estimate) {
        this.estimate = estimate;
        return this;
    }

    public String getRefs() {
        return refs;
    }

    public CreateTestCase setRefs(String refs) {
        this.refs = refs;
        return this;
    }

    public List<CustomStepsSeparated> getCustomStepsSeparated() {
        return customStepsSeparated;
    }

    public CreateTestCase setCustomStepsSeparated(List<CustomStepsSeparated> customStepsSeparated) {
        this.customStepsSeparated = customStepsSeparated;
        return this;
    }
}
