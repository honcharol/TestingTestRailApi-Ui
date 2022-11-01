package com.ex.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By emailField = By.xpath("//input[@id='name']");
    private By passField = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//button[@id='button_primary']");

    public LoginPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

   public LoginPage fillCredential(String email, String password){
       findElementCustom(webDriver, emailField).sendKeys(email);
       findElementCustom(webDriver, passField).sendKeys(password);
       return this;
   }
    
    public <T> T clickOnLoginButton(T type) {
        findElementCustom(webDriver, loginButton).click();
        return type;
    }

}
