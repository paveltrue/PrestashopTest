package com.prestashop.pages;

import com.codeborne.selenide.SelenideElement;
import com.prestashop.model.DeliveryAddress;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

@Log4j
public class AddressesPage {

    @Step
    public AddressesPage fillInRequiredFields(DeliveryAddress address) {
        log.info("Filling in required address fields");
        typeAddress(address.getAddress());
        typePostalCode(address.getPostalCode());
        typeCity(address.getCity());
        selectCountry(address.getCountry());
        selectState(address.getState());
        return this;
    }

    @Step
    public ShippingPage clickContinueBtn() {
        log.info("Clicking 'Continue' button on address page");
        SelenideElement continueBtn = $(byName("confirm-addresses"));
        continueBtn.click();
        return new ShippingPage();
    }

    private void typeAddress(String address) {
        SelenideElement addressInputField = $(byId("field-address1"));
        addressInputField.setValue(address);
    }

    private void typePostalCode(String postalCode) {
        SelenideElement postalCodeInputField = $(byId("field-postcode"));
        postalCodeInputField.setValue(postalCode);
    }

    private void typeCity(String city) {
        SelenideElement cityInputField = $(byId("field-city"));
        cityInputField.setValue(city);
    }

    private void selectCountry(String country) {
        SelenideElement countrySelector = $(byId("field-id_country"));
        countrySelector.selectOptionContainingText(country);
    }

    private void selectState(String state) {
        SelenideElement stateSelector = $(byId("field-id_state"));
        stateSelector.selectOptionContainingText(state);
    }

}
