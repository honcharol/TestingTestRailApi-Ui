package com.ex.ui;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static WebDriver webDriver;
    PropertyReader pr = new PropertyReader();

    @BeforeClass
    public void setUp() {
        webDriver = WebDriverManagerClass.getWebDriver();
        webDriver.manage().window().setSize(new Dimension(1800, 1000));
    }

    @AfterClass
    public void shutDown() {
        webDriver.quit();
    }
}
