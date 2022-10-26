package com.ex.api;

import com.ex.api.requests.MilestoneRequests;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MilestoneApiTests {

    private final MilestoneRequests milestoneRequests = new MilestoneRequests();

    @Test
    public void unableCreateMilestoneWithWrongProjectId(){
        int projectId = 100;
        int dueOn = 232148632;
        String milestoneName = "New milestone " + new Timestamp(System.currentTimeMillis());

        Map<String, Object> map = new HashMap<>();
        map.put("projId", projectId);
        map.put("dueOn", dueOn);
        map.put("milestoneName", milestoneName);

        int actualStatusCode = (int) milestoneRequests.createMilestoneRequest(map).get("statusCode");
        assertThat(actualStatusCode).isNotEqualTo(200);
    }

    @Test
    public void createMilestone() {
        int projectId = 14;
        int dueOn = 232148632;
        String milestoneName = "New milestone " + new Timestamp(System.currentTimeMillis());

        Map<String, Object> map = new HashMap<>();
        map.put("projId", projectId);
        map.put("dueOn", dueOn);
        map.put("milestoneName", milestoneName);

        String actualMilestoneName = milestoneRequests.createMilestoneRequest(map).get("name").toString();
        assertThat(milestoneName).isEqualTo(actualMilestoneName);
    }

    @Test
    public void getMilestone() {
        int projectId = 14;
        int milestoneId = 6;
        String expectedName = "New milestone 2022-10-23 17:31:00.127";

        String actualName = milestoneRequests.getMilestonesRequest(projectId, milestoneId);
        assertThat(actualName).isEqualTo(expectedName);
    }

    @Test
    public void updateMilestone() {
        boolean isCompleted = true;
        int milestoneId = 9;

        Map<String, Object> map = new HashMap<>();
        map.put("isCompleted", isCompleted);
        map.put("milestoneId", milestoneId);

        String actualResult = milestoneRequests.updateMilestoneRequest(map);
        assertThat(actualResult).isEqualTo(String.valueOf(isCompleted));
    }
}
