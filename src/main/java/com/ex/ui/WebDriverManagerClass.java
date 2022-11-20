package com.ex.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class WebDriverManagerClass {
    private static WebDriver webDriver;

    private WebDriverManagerClass(String browser) {
        setWebDriver(browser);
    }

    private void setWebDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                webDriver = WebDriverManager.chromedriver().create();
                break;
            case "ff":
                webDriver = WebDriverManager.firefoxdriver().create();
                break;
            case "chrome_standAlone":
                webDriver = standAlone("http://localhost:4444/wd/hub");
                break;
                case "chrome_selenoid":
                webDriver = selenoidChrome("http://localhost:4444/wd/hub");
                break;
            default:
                throw new RuntimeException("Incorrect browser name");
        }
    }

    public static WebDriver getWebDriver() {
        String browser = "chrome";
        if (webDriver == null) {
            new WebDriverManagerClass(browser);
        }
        return webDriver;
    }

    private static RemoteWebDriver standAlone(String serverUrl) {
        ChromeOptions chromeOptions = new ChromeOptions();
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(serverUrl), chromeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private static RemoteWebDriver selenoidChrome(String serverUrl) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("enableVNC", true);
        chromeOptions.setCapability("enableVideo", false);
        chromeOptions.setCapability("browserVersion", "107.0");
        chromeOptions.setCapability("selenoid:options", new HashMap<String, Object>() {
            {
                put("sessionTimeout", "2m");
            }
        });
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(serverUrl), chromeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
