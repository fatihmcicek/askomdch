package org.selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {

    @Test
    public void dummyTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Software\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id='menu-item-1227']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='woocommerce-product-search-field-0']")).sendKeys("Blue");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@value='Search']")).click();
        Thread.sleep(1000);
        String text = driver.findElement(By.xpath("//*[@class='woocommerce-products-header__title page-title']")).getText();
        Assert.assertEquals(text, "Search results: “Blue”");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='added_to_cart wc-forward']")).click();
        Thread.sleep(1000);
        String productName = driver.findElement(By.cssSelector("td[class='product-name'] a")).getText();
        Assert.assertEquals(productName, "Blue Shoes");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='input-text qty text']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='input-text qty text']")).sendKeys("2");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[value='Update cart']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward")).click();
        Thread.sleep(1000);

        // Login Section
        driver.findElement(By.xpath("//*[@class='showlogin']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("demouser");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("demopassword");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[value='Login']")).click();
        Thread.sleep(1000);

        // Billing Details
        driver.findElement(By.id("billing_first_name")).clear();
        driver.findElement(By.id("billing_first_name")).sendKeys("First Name");
        driver.findElement(By.id("billing_last_name")).clear();
        driver.findElement(By.id("billing_last_name")).sendKeys("Last Name");
        driver.findElement(By.id("billing_company")).clear();
        driver.findElement(By.id("billing_company")).sendKeys("Company Name");
        Select select = new Select(driver.findElement(By.id("billing_country")));
        select.selectByVisibleText("United States (US)");
        driver.findElement(By.id("billing_address_1")).clear();
        driver.findElement(By.id("billing_address_1")).sendKeys("Address Line");
        driver.findElement(By.id("billing_address_2")).clear();
        driver.findElement(By.id("billing_address_2")).sendKeys("Address Line 2");
        driver.findElement(By.id("billing_city")).clear();
        driver.findElement(By.id("billing_city")).sendKeys("Town / City");
        Select select2 = new Select(driver.findElement(By.id("billing_state")));
        select2.selectByVisibleText("Florida");
        driver.findElement(By.id("billing_postcode")).clear();
        driver.findElement(By.id("billing_postcode")).sendKeys("34925");
        driver.findElement(By.id("billing_phone")).clear();
        driver.findElement(By.id("billing_phone")).sendKeys("123456789");
        driver.findElement(By.id("billing_email")).clear();
        driver.findElement(By.id("billing_email")).sendKeys("test@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.id("place_order")).click();
        Thread.sleep(3000);
        String checkoutText =  driver.findElement(By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received")).getText();
        System.out.println(checkoutText);
        Assert.assertEquals(checkoutText,"Thank you. Your order has been received.");
    }
}
