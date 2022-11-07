package com.ex.ui.pages.milestones;

import com.ex.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMilestonesPage extends BasePage {

    private final By nameRow = By
            .xpath("//input[@id='name']");
    private final By descriptionArea = By
            .xpath("//div[@id='description_display']");
    private final By addMilestoneButton = By
            .xpath("//button[@id='accept']");
    private final By browseFiles = By
            .xpath("//div[contains(@class,'icon-markdown-image')]");
    private final By attachButton = By
            .xpath("//button[@id='attachmentNewSubmit']");

    public AddMilestonesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddMilestonesPage enterMilestoneName(String name) {
        findElementCustom(webDriver, nameRow).sendKeys(name);
        return this;
    }

    public AddMilestonesPage enterDescription(String description) {
        findElementCustom(webDriver, descriptionArea).sendKeys(description);
        return this;
    }

    public AddMilestonesPage uploadFile(String filePath) {
        String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
        WebElement elem = webDriver.findElement(By.xpath("(//input[contains(@type,'file')])[3]"));
        ((JavascriptExecutor) webDriver).executeScript(js, elem);
        elem.sendKeys(filePath);

        return this;
    }

    public AddMilestonesPage clickOnPlusToAttachFile() {
        findElementCustom(webDriver, browseFiles).click();
        return this;
    }

    public AddMilestonesPage clickAttachButton() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            findElementCustom(webDriver, attachButton).click();
        return this;
    }

    public void clickAddMilestoneButton() {
        findElementCustom(webDriver, addMilestoneButton).click();
    }
}
