package com.prestashop.pages;

import com.codeborne.selenide.SelenideElement;
import com.prestashop.model.User;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j
public class PersonalInformationCartPage {

    @Step
    public PersonalInformationCartPage fillInRequiredFields(User user) {
        log.info("Filling in required personal information fields");
        typeFirstName(user.getFirstName());
        typeLastName(user.getLastName());
        typeEmail(user.getEmail());
        enablePrivacyPolicyCheckbox();
        enableCustomerDataPrivacyCheckbox();
        return this;
    }

    @Step
    public AddressesPage clickContinueBtn() {
        log.info("Clicking 'Continue' button on Personal Information page");
        SelenideElement continueBtn = $x(("//button[@data-link-action='register-new-customer']"));
        continueBtn.click();
        return new AddressesPage();
    }

    private void typeFirstName(String firstName) {
        SelenideElement firstNameInputField = $(byName("firstname"));
        firstNameInputField.setValue(firstName);
    }

    private void typeLastName(String lastName) {
        SelenideElement lastNameInputField = $(byName("lastname"));
        lastNameInputField.setValue(lastName);
    }

    private void typeEmail(String email) {
        SelenideElement emailInputField = $(byName("email"));
        emailInputField.setValue(email);
    }

    private void enablePrivacyPolicyCheckbox() {
        SelenideElement privacyPolicyCheckbox = $(byName("psgdpr"));
        privacyPolicyCheckbox.scrollTo().click();
    }

    private void enableCustomerDataPrivacyCheckbox() {
        SelenideElement customerDataPrivacyCheckbox = $(byName("customer_privacy"));
        customerDataPrivacyCheckbox.scrollTo().click();
    }

}
