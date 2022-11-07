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
            .xpath("//div[@id='entityAttachmentListEmptyIcon']");
    private final By addNewButton = By
            .xpath("//a[@id='libraryAddAttachment']");
    private final By attachButton = By
            .xpath("//button[@id='attachmentNewSubmit']");

    public AddMilestonesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddMilestonesPage enterMilestoneName(String name){
        findElementCustom(webDriver, nameRow).sendKeys(name);
        return this;
    }

    public AddMilestonesPage enterDescription(String description){
        findElementCustom(webDriver, descriptionArea).sendKeys(description);
        return this;
    }

    public AddMilestonesPage clickAttachFile(){
        findElementCustom(webDriver, browseFiles).click();
        return this;
    }

    public AddMilestonesPage addNewFile(){
        String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
        WebElement elem = webDriver.findElement(By.xpath("(//input[contains(@type,'file')])[3]"));
        ((JavascriptExecutor) webDriver).executeScript(js, elem);
        elem.sendKeys("/home/oleh/Pictures/7049a6e74d678ab6f3a3ccd11117d3f7.jpg");
        return this;
    }

    public AddMilestonesPage chooseFile(){

        return this;
    }

    public AddMilestonesPage clickAttachButton(){
        findElementCustom(webDriver, attachButton).click();
        return this;
    }

    public void clickAddMilestoneButton(){
        findElementCustom(webDriver, addMilestoneButton).click();
    }
}
