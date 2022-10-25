package com.ex.api.models.test.plan;

import com.google.gson.annotations.SerializedName;

public class Entries {
    private String name;
    @SerializedName("suite_id")
    private int suiteId;
    @SerializedName("assignedto_id")
    private int assignedToId;
    @SerializedName("include_all")
    private boolean includeAll;
    @SerializedName("case_ids")
    private int[] caseIds;


    public String getName() {
        return name;
    }

    public Entries setName(String name) {
        this.name = name;
        return this;
    }

    public int getSuiteId() {
        return suiteId;
    }

    public Entries setSuiteId(int suiteId) {
        this.suiteId = suiteId;
        return this;
    }

    public int getAssignedToId() {
        return assignedToId;
    }

    public Entries setAssignedToId(int assignedToId) {
        this.assignedToId = assignedToId;
        return this;
    }

    public boolean isIncludeAll() {
        return includeAll;
    }

    public Entries setIncludeAll(boolean includeAll) {
        this.includeAll = includeAll;
        return this;
    }

    public int[] getCaseIds() {
        return caseIds;
    }

    public Entries setCaseIds(int[] caseIds) {
        this.caseIds = caseIds;
        return this;
    }
}
