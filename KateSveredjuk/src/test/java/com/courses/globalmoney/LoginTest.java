package com.courses.globalmoney;


import com.courses.globalmoney.data.UserData;
import com.courses.globalmoney.pages.CabinetPage;
import com.courses.globalmoney.pages.GMMainPage;
import com.courses.globalmoney.utils.SiteConstants;
import com.courses.globalmoney.fixtures.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.omg.CORBA.Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class LoginTest extends BaseTest {

    private GMMainPage mainPage;

    @Before
    public void setUp() {
        mainPage = new GMMainPage(driver);
        mainPage.open();
    }

    @Test
    public void testLoginWithValidCredentials() {

        UserData loginData = UserData.validData;

        mainPage.loginForm.logIn(loginData.getUserName(), loginData.getPassword());


        CabinetPage cabinetPage = new CabinetPage(driver);
        String actualUserId = cabinetPage.getUserId();
        String cabinetPageUrl = cabinetPage.getUrl();

        cabinetPage.logOut();


        Assert.assertEquals(loginData.getUserId(), actualUserId);
        Assert.assertEquals(SiteConstants.CABINET_PAGE_URL, cabinetPageUrl);

    }


    @Test
    public void testLoginWithInvalidCredentials() {

        UserData loginData = UserData.invalidData;

        String expectedMessage = "Ошибка авторизации: Server error";

        mainPage.loginForm.logIn(loginData.getUserName(), loginData.getPassword());
        String actualValidationMessage = mainPage.loginForm.erorMassege.getText();


        System.out.println(actualValidationMessage);

        Assert.assertEquals(expectedMessage, actualValidationMessage);
        Assert.assertEquals(SiteConstants.SITE_URL, mainPage.getUrl());
    }

    @Test
    public void testLoginWithEmptyCredentials() {

        UserData loginData = UserData.invalidWithoutData;

        mainPage.loginForm.logIn(loginData.getUserName(), loginData.getPassword());
        Assert.assertFalse(mainPage.loginForm.submitButton.isEnabled());
    }

}