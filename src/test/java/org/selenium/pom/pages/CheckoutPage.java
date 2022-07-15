package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.User;

public class CheckoutPage extends BasePage {
    private final By FIRST_NAME = By.id("billing_first_name");
    private final By LAST_NAME = By.id("billing_last_name");
    private final By COMPANY_NAME = By.id("billing_company");
    private final By COUNTRY = By.id("billing_country");
    private final By BILLING_ADDRESS_1 = By.id("billing_address_1");
    private final By BILLING_ADDRESS_2 = By.id("billing_address_2");
    private final By CITY = By.id("billing_city");
    private final By STATE = By.id("billing_state");
    private final By POST_CODE = By.id("billing_postcode");
    private final By PHONE = By.id("billing_phone");
    private final By EMAIL = By.id("billing_email");
    private final By PLACE_ORDER = By.id("place_order");
    private final By SUCCESS_NOTICE = By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received");

    private final By CLICK_LOGIN = By.xpath("//*[@class='showlogin']");
    private final By ENTER_USERNAME = By.xpath("//*[@id='username']");
    private final By ENTER_PASSWORD = By.xpath("//*[@id='password']");
    private final By CLICK_LOGIN_BUTTON = By.cssSelector("button[value='Login']");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // Login Section

    public CheckoutPage hereToLogin() {
        driver.findElement(CLICK_LOGIN).click();
        return this;
    }

    public CheckoutPage enterUserName(String userName) {
        driver.findElement(ENTER_USERNAME).clear();
        driver.findElement(ENTER_USERNAME).sendKeys(userName);
        return this;
    }

    private CheckoutPage enterPassword(String password) {
        driver.findElement(ENTER_PASSWORD).clear();
        driver.findElement(ENTER_PASSWORD).sendKeys(password);
        return this;
    }

    private CheckoutPage clickLogginButton() {
        driver.findElement(CLICK_LOGIN_BUTTON).click();
        return this;
    }

    public CheckoutPage login(User user){
        return enterUserName(user.getUsername()).
                enterPassword(user.getPassword()).
                clickLogginButton();
    }

    // -- Billing Details
    public CheckoutPage enterFirstName(String firstName) {
        driver.findElement(FIRST_NAME).clear();
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        driver.findElement(LAST_NAME).clear();
        driver.findElement(LAST_NAME).sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterCompanyName(String companyName) {
        driver.findElement(COMPANY_NAME).clear();
        driver.findElement(COMPANY_NAME).sendKeys(companyName);
        return this;
    }

//    public CheckoutPage selectCountry(){
//        driver.findElement(COUNTRY);
//        return this;
//    }

    public CheckoutPage enterAddress1(String address1) {
        driver.findElement(BILLING_ADDRESS_1).clear();
        driver.findElement(BILLING_ADDRESS_1).sendKeys(address1);
        return this;
    }

    public CheckoutPage enterAddress2(String address2) {
        driver.findElement(BILLING_ADDRESS_2).clear();
        driver.findElement(BILLING_ADDRESS_2).sendKeys(address2);
        return this;
    }

    public CheckoutPage enterCityField(String city) {
        driver.findElement(CITY).clear();
        driver.findElement(CITY).sendKeys(city);
        return this;
    }

//    public CheckoutPage stateFıeld(String state){
//        driver.findElement(STATE).sendKeys(state);
//        return this;
//    }

    public CheckoutPage enterPostCode(String postalCode) {
        driver.findElement(POST_CODE).clear();
        driver.findElement(POST_CODE).sendKeys(postalCode);
        return this;
    }

    public CheckoutPage enterPhoneField(String phone) {
        driver.findElement(PHONE).clear();
        driver.findElement(PHONE).sendKeys(phone);
        return this;
    }

    public CheckoutPage enterEmailField(String email) {
        driver.findElement(EMAIL).clear();
        driver.findElement(EMAIL).sendKeys(email);
        return this;
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress) {
        return enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                enterCompanyName(billingAddress.getCompanyName()).
                enterAddress1(billingAddress.getAddressLine1()).
                enterAddress2(billingAddress.getAddressLine2()).
                enterCityField(billingAddress.getCity()).
                enterPostCode(billingAddress.getPostCode()).
                enterPhoneField(billingAddress.getPhone()).
                enterEmailField(billingAddress.getEmail());
    }

    public CheckoutPage clickPlaceOrder() {
        driver.findElement(PLACE_ORDER).click();
        return this;
    }

    public String getNotice() {
        return driver.findElement(SUCCESS_NOTICE).getText();
    }

}
