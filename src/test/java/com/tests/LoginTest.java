package com.tests;

import com.baseConfiges.BaseConditions;
import com.baseConfiges.CsvDataProvider;
import com.pages.Login;
import com.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseConditions {


    @Test(priority = 1, groups = { "login" })
    public void login() throws InterruptedException {

        Login login = new Login(driver, log);
        String expectedPageTitle = "MagaZilla - сравнение цен в интернет-магазинах";
        String correctProfileName = "Paolo";

        login.openLoginWindow();
        login.fillUpCredentials("Sir_Bobby@i.ua", "Aa19141983");

        ProfilePage profilePage = login.pushSignInButton();
        profilePage.waitForProfilrPageToLoad();
        String actualTitle = profilePage.getTitle();


        Assert.assertTrue(profilePage.isCorrectProfileLoaded(correctProfileName), "Page name is wrong.");
        Assert.assertTrue(expectedPageTitle.equals(actualTitle), "Page title is wrong.\nExpected: " + expectedPageTitle + "\nActual: " + actualTitle);

    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class, priority = 2,groups = { "wrongLogin", "broken"})
    public void wrongLogin(Map<String, String> testData) throws InterruptedException {
        String expectedErrorMessage = "email Sir_Bobby@i.ua1 указан неверно!";
        String textNumber = testData.get("no");
        String email = testData.get("email");
        String password = testData.get("password");
        String description =testData.get("description");
        log.info("T#1" + textNumber + " for " + description + " email: "
        + email + " pass " + password);

        Login login = new Login(driver, log);
        String expectedPageTitle = "MagaZilla - сравнение цен в интернет-магазинах";
        String correctProfileName = "Paolo";

        login.openLoginWindow();
        login.fillUpCredentials(email, password);
        login.pushSignInButton();

        String errorNessage = login.getLogInErrorMessage();
        Assert.assertTrue(errorNessage.contains(expectedErrorMessage), "Error message is wrong.\nExpected: " + expectedErrorMessage + "\nActual: " + errorNessage);

    }
}
