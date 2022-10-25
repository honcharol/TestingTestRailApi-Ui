package com.ex.ui.pages.admin;

import com.ex.ui.pages.BasePage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By emailField = By.xpath("//input[@id='email']");
    private By passField = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//button[contains(.,'Login')]");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage inputEmail(String email){
        findElementCustom(webDriver, emailField).sendKeys(email);
        return this;
    }

    public LoginPage inputPassword(String password){
        findElementCustom(webDriver, passField).sendKeys(password);
        return this;
    }

    public LoginPage clickOnLoginButton(){
        findElementCustom(webDriver, loginButton).click();
        return this;
    }

    public LoginPage verifyPasswordFieldIsEmpty(){
        boolean isPasswordFiledEmpty = findElementCustom(webDriver, passField).getAttribute("value").isEmpty();
        Assertions.assertThat(isPasswordFiledEmpty).as("Password should be empty").isTrue();
        return this;
    }
}
