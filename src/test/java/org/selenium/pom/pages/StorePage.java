package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {
    private final By SEARCH_FIELD = By.xpath("//*[@id='woocommerce-product-search-field-0']");
    private final By SEARCH_FIELD_BUTTON = By.xpath("//*[@value='Search']");
    private final By TITLE = By.xpath("//*[@class='woocommerce-products-header__title page-title']");
    private final By VIEW_CART_LINK = By.xpath("//*[@class='added_to_cart wc-forward']");


    public StorePage(WebDriver driver) {
        super(driver);
    }

    private StorePage enterTextInSearchFıeld(String text){
        driver.findElement(SEARCH_FIELD).sendKeys(text);
        return this;
    }

    private StorePage clickSearchButton(){
        driver.findElement(SEARCH_FIELD_BUTTON).click();
        return this;
    }

    public StorePage search(String text) {
        enterTextInSearchFıeld(text).clickSearchButton();
        return this;
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    private By getAddToCartButtonElement(String productName){
        return By.cssSelector("a[aria-label='Add “" +  productName + "” to your cart']");
    }

    public StorePage clickAddToCartButton(String productName) {
        By addToCartButton = getAddToCartButtonElement(productName);
        driver.findElement(addToCartButton).click();
        return this;
    }

    public CartPage clickViewCart(){
        driver.findElement(VIEW_CART_LINK).click();
        return new CartPage(driver);
    }

}
