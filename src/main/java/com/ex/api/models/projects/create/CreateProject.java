package com.ex.api.models.projects.create;

import com.google.gson.annotations.SerializedName;

public class CreateProject {
    private String name;
    private String announcement;
    @SerializedName("suite_mode")
    private int suiteMode;
    @SerializedName("show_announcement")
    private boolean showAnnouncement;

    public int getSuiteMode() {
        return suiteMode;
    }

    public CreateProject setSuiteMode(int suiteMode) {
        this.suiteMode = suiteMode;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreateProject setName(String name) {
        this.name = name;
        return this;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public CreateProject setAnnouncement(String announcement) {
        this.announcement = announcement;
        return this;
    }

    public boolean getShowAnnouncement() {
        return showAnnouncement;
    }

    public CreateProject setShowAnnouncement(boolean showAnnouncement) {
        this.showAnnouncement = showAnnouncement;
        return this;
    }
}
