package com.ex.ui;

import com.ex.ui.pages.admin.MainePage;
import org.testng.annotations.Test;

public class TestRailSuite extends BaseTest {

//    @Test                                            
//    public void testLoginForm(){
//        webDriver.get("https://www.gurock.com/testrail/");
//        findElementCustom(webDriver, By.xpath("//a[@class='gk-header-top-menu-link'][contains(.,'My Account')]")).click();
//
//        findElementCustom(webDriver, By.xpath("//input[@id='email']")).sendKeys("some@mail.com");
//
//        By passField = By.xpath("//input[@id='password']") ;
//        findElementCustom(webDriver, passField).sendKeys("somePassword");
//
//        findElementCustom(webDriver, By.xpath("//button[contains(.,'Login')]")).click();
//
//        boolean isPasswordFiledEmpty = findElementCustom(webDriver, passField).getAttribute("value").isEmpty();
//        Assertions.assertThat(isPasswordFiledEmpty).as("Password should be empty").isTrue();
//    }

    @Test
    public void testLoginForm() {
        new MainePage(webDriver, "https://www.gurock.com/testrail/")
                .acceptCookies()
                .clickOnMyAccountLink()
                .inputEmail("dffefv2@fgr.com")
                .inputPassword("sdf4gvcww")
                .clickOnLoginButton()
                .verifyPasswordFieldIsEmpty();
        System.out.println();
    }
}
