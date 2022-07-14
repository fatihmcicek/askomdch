package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends BaseTest {

    @Test
    public void dummyTest() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\Software\\Selenium\\chromedriver.exe");

        driver.get("https://askomdch.com/");

        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.clickStoreMenuLink();
        Thread.sleep(3000);
        storePage.search("Blue");
        Thread.sleep(3000);

        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        Thread.sleep(3000);

        storePage.clickAddToCartButton("Blue Shoes");
        Thread.sleep(3000);

        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
        cartPage.changeProductQuantity("2");
        cartPage.updateCart();
        Thread.sleep(3000);

        CheckoutPage checkoutPage = cartPage.clickCheckoutPage();
        Thread.sleep(3000);

        checkoutPage.hereToLogin();
        Thread.sleep(3000);
        checkoutPage.enterUserName("demouser");
        Thread.sleep(3000);

        checkoutPage.enterPassword("demopassword");
        Thread.sleep(3000);

        checkoutPage.clickLogginButton();

        Thread.sleep(3000);

        checkoutPage.
                enterFirstName("First Name").
                enterLastName("Last Name").
                enterCompanyName("Company Name").
                enterAddress1("Billing Address 1").
                enterAddress2("Billing Address 2").
                enterCityField("City Field").
                enterPostCode("34925").
                enterPhoneField("123456789").
                enterEmailField("test@gmail.com");
        Thread.sleep(3000);

        checkoutPage.clickPlaceOrder();
        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");


    }
}
