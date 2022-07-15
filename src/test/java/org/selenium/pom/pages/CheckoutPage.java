package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    private final By OVERLAY = By.cssSelector(".blockUI.blockOverlay");

    private final By DIRECT_BANK_TRANSFER_RADION_BUTTON = By.id("payment_method_bacs");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage hereToLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CLICK_LOGIN)).click();
        return this;
    }

    public CheckoutPage enterUserName(String userName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ENTER_USERNAME)).sendKeys(userName);
        return this;
    }

    private CheckoutPage enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ENTER_PASSWORD)).sendKeys(password);
        return this;
    }

    private CheckoutPage clickLogginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CLICK_LOGIN_BUTTON)).click();
        return this;
    }

    public CheckoutPage login(User user) {
        return enterUserName(user.getUsername()).
                enterPassword(user.getPassword()).
                clickLogginButton();
    }

    // -- Billing Details
    public CheckoutPage enterFirstName(String firstName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME));
        e.clear();
        e.click();
        e.sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(LAST_NAME));
        e.clear();
        e.sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterCompanyName(String companyName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(COMPANY_NAME));
        e.clear();
        e.sendKeys(companyName);
        return this;
    }

    public CheckoutPage selectCountry(String countrName) {
        Select select = new Select(driver.findElement(COUNTRY));
        select.selectByVisibleText(countrName);
        return this;
    }

    public CheckoutPage enterAddress1(String address1) {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(BILLING_ADDRESS_1));
        e.clear();
        e.sendKeys(address1);
        return this;
    }

    public CheckoutPage enterAddress2(String address2) {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(BILLING_ADDRESS_2));
        e.clear();
        e.sendKeys(address2);
        return this;
    }

    public CheckoutPage enterCityField(String city) {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(CITY));
        e.clear();
        e.sendKeys(city);
        return this;
    }

    public CheckoutPage selectState(String stateName) {
        Select select = new Select(driver.findElement(STATE));
        select.selectByVisibleText(stateName);
        return this;
    }

    public CheckoutPage enterPostCode(String postalCode) {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(POST_CODE));
        e.clear();
        e.sendKeys(postalCode);
        return this;
    }

    public CheckoutPage enterPhoneField(String phone) {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(PHONE));
        e.clear();
        e.sendKeys(phone);
        return this;
    }

    public CheckoutPage enterEmailField(String email) {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL));
        e.clear();
        e.sendKeys(email);
        return this;
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress) {
        return enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                enterCompanyName(billingAddress.getCompanyName()).
                selectCountry(billingAddress.getCountry()).
                enterAddress1(billingAddress.getAddressLine1()).
                enterAddress2(billingAddress.getAddressLine2()).
                enterCityField(billingAddress.getCity()).
                selectState(billingAddress.getState()).
                enterPostCode(billingAddress.getPostCode()).
                enterPhoneField(billingAddress.getPhone()).
                enterEmailField(billingAddress.getEmail());
    }

    public CheckoutPage clickPlaceOrder() {
        waitForOverlaysToDisappear(OVERLAY);
        driver.findElement(PLACE_ORDER).click();
        return this;
    }

    public String getNotice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_NOTICE)).getText();
    }

    public CheckoutPage selectDirectBankTransfer(){
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(DIRECT_BANK_TRANSFER_RADION_BUTTON));
        if(!e.isSelected()){
            e.click();
        }
        return this;
    }
}
