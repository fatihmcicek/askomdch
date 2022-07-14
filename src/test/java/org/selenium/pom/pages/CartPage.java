package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {
    private final By PRODUCT_NAME = By.cssSelector("td[class='product-name'] a");
    private final By CHECKOUT_BUTTON = By.cssSelector(".checkout-button");
    private final By QUANTITY_TEXT = By.xpath("//*[@class='input-text qty text']");
    private final By UPDATE_CART_BUTTON = By.cssSelector("button[value='Update cart']");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
        return driver.findElement(PRODUCT_NAME).getText();
    }

    public CartPage changeProductQuantity(String chgQuantity){
        driver.findElement(QUANTITY_TEXT).clear();
        driver.findElement(QUANTITY_TEXT).sendKeys(chgQuantity);
        return this;
    }

    public CartPage updateCart(){
        driver.findElement(UPDATE_CART_BUTTON).click();
        return this;
    }

    public CheckoutPage clickCheckoutPage(){
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutPage(driver);
    }


}
