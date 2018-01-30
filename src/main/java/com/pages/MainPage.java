package com.pages;

import com.baseConfiges.BasePageObject;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class MainPage extends BasePageObject <MainPage> {
    private static final String URL="http://m.ua/";

    public MainPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openMainPage(){
        getPage(URL);
    }
}
