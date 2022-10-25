package com.ex.api.models.projects.get;

import java.util.ArrayList;
import java.util.List;

public class GetProject {
    List<Project> projects = new ArrayList<>();

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
