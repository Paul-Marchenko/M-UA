package com.baseConfiges;

import com.pages.MainPage;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.logging.Logger;

public class BrowserFactory {
    public static WebDriver getDriver(String browser, Logger log) {
        WebDriver driver = null;
        log.info("Starting" + browser);
        MainPage mainPage = null;
        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                mainPage = new MainPage(driver, log);
                mainPage.openMainPage();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
                mainPage = new MainPage(driver, log);
                mainPage.openMainPage();
                break;
            default:
                driver = new FirefoxDriver();
                mainPage = new MainPage(driver, log);
                mainPage.openMainPage();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
}
