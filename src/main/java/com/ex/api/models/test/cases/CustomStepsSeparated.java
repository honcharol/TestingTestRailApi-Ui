package com.ex.api.models.test.cases;

import com.google.gson.annotations.SerializedName;

public class CustomStepsSeparated {
    private String content;
    private String expected;
    @SerializedName("additional_info")
    private String additionalInfo;
    @SerializedName("shared_step_id")
    private int sharedStepId;


    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public CustomStepsSeparated setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CustomStepsSeparated setContent(String content) {
        this.content = content;
        return this;
    }

    public String getExpected() {
        return expected;
    }

    public CustomStepsSeparated setExpected(String expected) {
        this.expected = expected;
        return this;
    }

    public int getSharedStepId() {
        return sharedStepId;
    }

    public CustomStepsSeparated setSharedStepId(int sharedStepId) {
        this.sharedStepId = sharedStepId;
        return this;
    }
}
