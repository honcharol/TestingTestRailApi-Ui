package com.ex.api.models.projects.create;

import com.google.gson.annotations.SerializedName;

public class CreateProject {
    private String name;
    private String announcement;
    @SerializedName("show_announcement")
    private boolean showAnnouncement;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public boolean getShowAnnouncement() {
        return showAnnouncement;
    }

    public void setShowAnnouncement(boolean showAnnouncement) {
        this.showAnnouncement = showAnnouncement;
    }
}
