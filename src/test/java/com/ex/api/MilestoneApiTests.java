package com.ex.api;

import com.ex.api.requests.MilestoneRequests;
import com.ex.api.requests.ProjectRequests;
import org.testng.annotations.Test;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

public class MilestoneApiTests {

    private final MilestoneRequests milestoneRequests = new MilestoneRequests();

    @Test
    public void createMilestone() {
        int projectId = 14;
        int dueOn = 232148632;
        String milestoneName = "New milestone " + new Timestamp(System.currentTimeMillis());

        String actualMilestoneName = milestoneRequests.createMilestoneRequest(milestoneName, dueOn, projectId).get("name").toString();
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
        int milestoneId = 5;

        String actualResult = milestoneRequests.updateMilestoneRequest(isCompleted, milestoneId);
        assertThat(actualResult).isEqualTo(String.valueOf(isCompleted));
    }
}
