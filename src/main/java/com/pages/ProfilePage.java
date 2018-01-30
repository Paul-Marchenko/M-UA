package com.pages;

import com.baseConfiges.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class ProfilePage extends BasePageObject<ProfilePage> {
    private By nameProfile = By.xpath("//*[@class='info-nick']");
    private By mainLabel = By.xpath("//*[@class='t-logo']");

    public ProfilePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void waitForProfilrPageToLoad() {
        waitForVisibilityOf(mainLabel);
    }
    public boolean isCorrectProfileLoaded(String correctProfileName){
        if (getText(nameProfile).equals(correctProfileName)){
            return true;
        }
        return false;
    }
}
