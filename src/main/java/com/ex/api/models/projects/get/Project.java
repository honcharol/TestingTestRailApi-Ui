package com.ex.api.models.projects.get;

public class Project {
    private int id;
    private String name;
    private String announcement;
    private boolean show_announcement;
    private boolean is_completed;
    private int completed_on;
    private int suite_mode;
    private int default_role_id;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public boolean isShow_announcement() {
        return show_announcement;
    }

    public void setShow_announcement(boolean show_announcement) {
        this.show_announcement = show_announcement;
    }

    public boolean isIs_completed() {
        return is_completed;
    }

    public void setIs_completed(boolean is_completed) {
        this.is_completed = is_completed;
    }

    public int getCompleted_on() {
        return completed_on;
    }

    public void setCompleted_on(int completed_on) {
        this.completed_on = completed_on;
    }

    public int getSuite_mode() {
        return suite_mode;
    }

    public void setSuite_mode(int suite_mode) {
        this.suite_mode = suite_mode;
    }

    public int getDefault_role_id() {
        return default_role_id;
    }

    public void setDefault_role_id(int default_role_id) {
        this.default_role_id = default_role_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
