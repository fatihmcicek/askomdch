package org.selenium.pom.objects;

public class BillingAddress {

    private String firstName;
    private String lastName;
    private String companyName;
    private String country;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postCode;
    private String phone;
    private String email;


    public BillingAddress() {

    }

    public BillingAddress(String firstName, String lastName,
                          String companyName, String addressLine1,
                          String addressLine2, String city,
                          String postCode, String phone,
                          String email, String country, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.country = country;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.postCode = postCode;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
    }

    public BillingAddress setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public BillingAddress setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public BillingAddress setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getAddressLine1() {
        return addressLine1;
    }

    public BillingAddress setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public BillingAddress setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public String getCity() {
        return city;
    }

    public BillingAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public BillingAddress setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public BillingAddress setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BillingAddress setEmail(String email) {
        this.email = email;
        return this;
    }
}
