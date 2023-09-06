package com.prestashop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

@Log4j
public class ShippingPage {

    @Step
    public ShippingPage selectShippingMethod(boolean isDeliveryNeeded) {
        if (isDeliveryNeeded) {
            log.info("Enabling 'Delivery' checkbox");
            SelenideElement deliveryCheckbox = $(byId("delivery_option_2"));
            actions().click(deliveryCheckbox).perform();
        } else {
            log.info("Enabling 'Pick up in Store' checkbox");
            SelenideElement pickUpInStoreCheckbox = $(byId("delivery_option_1"));
            actions().click(pickUpInStoreCheckbox).perform();
        }
        return this;
    }

    @Step
    public PaymentPage clickContinueBtn() {
        log.info("Click 'Continue' button on Shipping Page");
        SelenideElement continueBtn = $(byName("confirmDeliveryOption"));
        continueBtn.click();
        return new PaymentPage();
    }

}
