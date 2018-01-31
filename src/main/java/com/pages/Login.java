package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class Login extends MainPage {
    private By EntryWindow =By.xpath("//*[@id=\"mui_user_login_row\"]/span/em");
    private By emailField = By.xpath("//*[@name='l_']");
    private By paswordField = By.xpath("//*[@name='pw_']");
    private By signInButton = By.xpath("//*[@value='Войти']");
    private By errorMessageForEmail = By.xpath("//div[contains(text(),'email ')]");
    private By errorMessageForPassword = By.xpath("//*[.='Пароль указан неверно!'])");


    public Login(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void fillUpCredentials(String email, String password){
        waitForVisibilityOf(emailField);
        type(email,emailField);
        type(password,paswordField);

    }
    public void openLoginWindow(){
        openElement(EntryWindow);
    }
    public ProfilePage pushSignInButton(){
        clickButton(signInButton);
        return new ProfilePage(driver,log);
    }

    /*public String getLogInErrorMessage() {
        waitForVisibilityOf(errorMessageForEmail, 10);
        return getText(errorMessageForEmail);
    }*/

    public String getErrorMessageForEmail() {

        return errorMessage(errorMessageForEmail);
    }
    public String getErrorMessageForPassword() {

        return errorMessage(errorMessageForPassword);
    }
}
