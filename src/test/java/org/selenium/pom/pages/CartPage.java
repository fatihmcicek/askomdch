package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {
    private final By PRODUCT_NAME = By.cssSelector("td[class='product-name'] a");
    private final By CHECKOUT_BUTTON = By.cssSelector(".checkout-button");
    private final By QUANTITY_TEXT = By.xpath("//*[@class='input-text qty text']");
    private final By UPDATE_CART_BUTTON = By.cssSelector("button[value='Update cart']");

    private final By CART_HEADING = By.cssSelector(".has-text-align-center");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isLoaded() {
        return wait.until(ExpectedConditions.textToBe(CART_HEADING, "Cart"));
    }

    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_NAME)).getText();
    }

    public CartPage changeProductQuantity(String chgQuantity) {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(QUANTITY_TEXT));
        e.clear();
        e.sendKeys(chgQuantity);
        return this;
    }

    public CartPage updateCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(UPDATE_CART_BUTTON)).click();
        return this;
    }

    public CheckoutPage clickCheckoutPage() {
        wait.until(ExpectedConditions.elementToBeClickable(CHECKOUT_BUTTON)).click();
        return new CheckoutPage(driver);
    }
}
