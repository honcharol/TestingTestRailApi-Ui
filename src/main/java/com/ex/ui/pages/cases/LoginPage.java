package com.ex.ui.pages.cases;

import com.ex.ui.pages.BasePage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By emailField = By.xpath("//input[@id='name']");
    private By passField = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//button[@id='button_primary']");

    public LoginPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public LoginPage inputEmail(String email){
        findElementCustom(webDriver, emailField).sendKeys(email);
        return this;
    }

    public LoginPage inputPassword(String password){
        findElementCustom(webDriver, passField).sendKeys(password);
        return this;
    }
    
    public <T> T clickOnLoginButton(T type) {
        findElementCustom(webDriver, loginButton).click();
        return type;
    }

}
