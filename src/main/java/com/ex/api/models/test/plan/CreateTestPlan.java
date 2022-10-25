package com.ex.api.models.test.plan;

import java.util.ArrayList;
import java.util.List;

public class CreateTestPlan {
    private String name;
    public List<Entries> entries = new ArrayList<>();


    public String getName() {
        return name;
    }

    public CreateTestPlan setName(String name) {
        this.name = name;
        return this;
    }

    public List<Entries> getEntries() {
        return entries;
    }

    public CreateTestPlan setEntries(List<Entries> entries) {
        this.entries = entries;
        return this;
    }
}
