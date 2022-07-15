package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestClass extends BaseTest {

    @Test
    public void dummyTest() throws InterruptedException, IOException {
        //System.setProperty("webdriver.chrome.driver", "C:\\Software\\Selenium\\chromedriver.exe");
        //driver.get("https://askomdch.com/");

        BillingAddress billingAddress = JacksonUtils.deserializeJson("billingAddress.json", BillingAddress.class);
        Product product = new Product(1215);
        User user = new User("demouser","demopassword");

        HomePage homePage = new HomePage(driver).load();
        StorePage storePage = homePage.navigateStoreMenuLink();
        Thread.sleep(1000);
        storePage.search("Blue");
        Thread.sleep(1000);
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        Thread.sleep(1000);

        storePage.clickAddToCartButton(product.getName());
        Thread.sleep(1000);
        CartPage cartPage = storePage.clickViewCart();
        Thread.sleep(1000);

        Assert.assertEquals(cartPage.getProductName(), product.getName());
        cartPage.changeProductQuantity("2");
        cartPage.updateCart();
        Thread.sleep(3000);
        CheckoutPage checkoutPage = cartPage.clickCheckoutPage();
        Thread.sleep(3000);

        // ----------Login Section
        checkoutPage.hereToLogin();
        Thread.sleep(1000);
        checkoutPage.login(user);

        checkoutPage.setBillingAddress(billingAddress);
        Thread.sleep(3000);
        checkoutPage.clickPlaceOrder();
        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }
}
