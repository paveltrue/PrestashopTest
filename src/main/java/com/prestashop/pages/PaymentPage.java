package com.prestashop.pages;

import com.codeborne.selenide.SelenideElement;
import com.prestashop.model.Order;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j
public class PaymentPage {

    @Step
    public PaymentPage selectPaymentMethod(Order.PaymentMethod paymentMethod) {
        log.info("Selecting payment method - " + paymentMethod);
        String checkboxId = switch (paymentMethod) {
            case BY_BANK_WIRE -> "payment-option-1";
            case BY_CASH_ON_DELIVERY -> "payment-option-2";
            case BY_CHECK -> "payment-option-3";
        };
        SelenideElement paymentMethodCheckbox = $(byId(checkboxId));
        paymentMethodCheckbox.click();
        return this;
    }

    @Step
    public PaymentPage enableTermsOfServiceCheckbox() {
        log.info("Enabling 'Terms of Service' checkbox");
        SelenideElement termsOfServiceCheckbox = $(byId("conditions_to_approve[terms-and-conditions]"));
        termsOfServiceCheckbox.click();
        return this;
    }

    @Step
    public OrderConfirmationPage clickPlaceOrderBtn() {
        log.info("Clicking 'Place Order' button");
        SelenideElement placeOrderBtn = $x("//div[@id='payment-confirmation']//button");
        placeOrderBtn.click();
        return new OrderConfirmationPage();
    }

}
