package org.selenium.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void load(String endPoint) {
        driver.get("https://askomdch.com/" + endPoint);
    }

    public void waitForOverlaysToDisappear(By OVERLAY) {
        List<WebElement> overlays = driver.findElements(OVERLAY);
        System.out.println("OVERLAY SIZE: " + overlays.size());
        if (overlays.size() > 0) {
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("OVERLAY INVISIBLE: ");
        } else {
            System.out.println("OVERLAY NOT FOUND");
        }
    }

    public WebElement waitForElementToBeClickable(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}
