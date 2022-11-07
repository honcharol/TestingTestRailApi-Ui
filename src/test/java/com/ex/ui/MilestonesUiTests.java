package com.ex.ui;

import com.ex.ui.pages.LoginPage;
import com.ex.ui.pages.milestones.AddMilestonesPage;
import com.ex.utils.LogicHelper;
import org.testng.annotations.Test;

public class MilestonesUiTests extends BaseTest{

    @Test
    public void createMilestoneWithAttachedFile(){
        PropertyReader pr = new PropertyReader();
        String projectId = "6";
        String milestoneName = "This is new MILE " + System.currentTimeMillis();
        String description = LogicHelper.randomString(15);

        new LoginPage(webDriver, pr.prop("addMilestones").concat(projectId))
                .fillCredential(pr.prop("email"), pr.prop("password"))
                .clickOnLoginButton(new AddMilestonesPage(webDriver))
                .enterMilestoneName(milestoneName)
                .enterDescription(description)
                .clickAttachFile()
                .addNewFile()
                .chooseFile()
                .clickAttachButton()
                .clickAddMilestoneButton();
    }
}
