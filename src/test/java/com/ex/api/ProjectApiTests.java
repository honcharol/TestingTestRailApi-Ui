package com.ex.api;

import com.ex.api.models.projects.get.Project;
import com.ex.api.models.projects.get.GetProject;
import com.ex.api.methods.GetMethod;
import com.ex.api.requests.ProjectRequests;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;


public class ProjectApiTests {
    private final ProjectRequests projectRequests = new ProjectRequests();

    @Test
    public void createNewProjectWithModel() {
        String expectedName = "Some name for testing" + new Timestamp(System.currentTimeMillis());
        String actualName = projectRequests.createProjectRequest(expectedName).get("name").toString();
        assertThat(actualName).isEqualTo(expectedName);
    }

    @Test
    public void getProjectById() {
        int projectId = 16;
        String actualName = projectRequests.getProjectByIdRequest(projectId).get("name").toString();
        assertThat(actualName).isEqualTo("project 2");
    }

// this is the same project as project above ("getProjectById()")
    @Test
    public void getAllProjectsWithModel() {
        Response response = new GetMethod().witPrimitiveParameters("/api/v2/get_projects", 200);

        Gson gson = new Gson();
        GetProject getProjectsModel = gson.fromJson(response.asString(), GetProject.class);
        String actualProjectName = "";
        for(Project project : getProjectsModel.getProjects()){
            if (project.getId() == 2){
                actualProjectName = project.getName();
            }
        }
                                                                                  //example 2
        AtomicReference<String> actualProjectName1 = new AtomicReference<>("");
        getProjectsModel.getProjects().forEach(project -> {
            if (project.getId() == 2){
                actualProjectName1.set(project.getName());
            }
        });
                                                                                  //example 2
                                                                                              //example 3
        Map<String, String> map = new HashMap<String, String>(){
            {
                put("sfrgh","34455");
                put("sfddgfrgh","3446755");
                put("sfrnjhgh","34998455");
            }
        };
        map.forEach((k, v)-> {
            System.out.println(k);
            System.out.println(v);
        });
                                                                                             //example 3
        assertThat(actualProjectName).as("").isEqualTo("SomeProj_2");
        System.out.println();
    }



}
