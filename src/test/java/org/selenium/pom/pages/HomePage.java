package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {
    private final By STORE_MENU_LINK = By.xpath("//*[@id='menu-item-1227']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage load(){
        load("/");
        wait.until(ExpectedConditions.titleContains("AskOmDch"));
        return this;
    }

    public StorePage navigateStoreMenuLink(){
        driver.findElement(STORE_MENU_LINK).click();
        return new StorePage(driver);
    }

}
