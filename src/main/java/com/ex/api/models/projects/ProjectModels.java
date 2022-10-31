package com.ex.api.models.projects;

import com.ex.api.models.projects.create.CreateProject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Timestamp;

public class ProjectModels {
    public String createProjectWithoutSuiteMode(String name){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(new CreateProject()
        .setName(name)
        .setAnnouncement("announcement for testing")
        .setSuiteMode(1)
        .setShowAnnouncement(true));
    }
}
