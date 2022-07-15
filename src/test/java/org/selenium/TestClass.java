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

        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("billingAddress.json", BillingAddress.class);
        Product product = new Product(1215);
        User user = new User("demouser", "demopassword");

        HomePage homePage = new HomePage(driver).
                load();
        StorePage storePage = homePage.navigateStoreMenuLink();
        storePage.isLoaded();
        storePage.search(searchFor);
        Thread.sleep(2000);
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

        storePage.clickAddToCartButton(product.getName());
        CartPage cartPage = storePage.clickViewCart();
        cartPage.isLoaded();

        Assert.assertEquals(cartPage.getProductName(), product.getName());
        cartPage.changeProductQuantity("2");
        cartPage.updateCart();
        Thread.sleep(2000);
        CheckoutPage checkoutPage = cartPage.clickCheckoutPage();

        checkoutPage.hereToLogin();
        checkoutPage.login(user);

        checkoutPage.setBillingAddress(billingAddress);
        checkoutPage.selectDirectBankTransfer();
        checkoutPage.clickPlaceOrder();
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }
}
