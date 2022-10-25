package com.ex.api.models.projects;

import com.ex.api.models.projects.create.CreateProject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Timestamp;

public class ProjectModels {
    public String createProjectWithoutSuiteMode(String name){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        CreateProject createProject = new CreateProject();
        createProject.setName(name);
        createProject.setAnnouncement("announcement for testing");
        createProject.setShowAnnouncement(true);
        return gson.toJson(createProject);
    }
}
