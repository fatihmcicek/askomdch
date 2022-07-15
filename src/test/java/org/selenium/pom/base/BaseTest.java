package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void startDriver(String browser) {
        driver = new DriverManager().initializeDriver(browser);
    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
