package com.baseConfiges;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.logging.Logger;

public class BaseConditions {
    protected WebDriver driver;
    protected Logger log;

    @BeforeClass(alwaysRun = true)
    protected  void setUpClass(ITestContext ctx){
        String testName = ctx.getCurrentXmlTest().getName();
        log = Logger.getLogger(testName);
    }


    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    protected void setUp(String browser) {
        log.info("Method set up");
        driver =BrowserFactory.getDriver(browser, log);

    }

    /*@BeforeTest
    public void showMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
    }*/
    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        driver.quit();
    }
}
