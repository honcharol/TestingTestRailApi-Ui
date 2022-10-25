package com.ex.ui;

import com.ex.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest  {
    protected static WebDriver webDriver;
    PropertyReader pr = new PropertyReader();

    @BeforeClass
    public void setUp(){
        webDriver = WebDriverManagerClass.getWebDriver();
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public void shutDown(){
        webDriver.quit();
    }
}
