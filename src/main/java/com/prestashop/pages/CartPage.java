package com.prestashop.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Selenide.$x;

@Log4j
public class CartPage {

    @Step
    public PersonalInformationCartPage clickProceedToCheckoutBtn() {
        log.info("Clicking 'Proceed to checkout' button on Card page");
        SelenideElement proceedToCheckoutBtn = $x("//a[text()='Proceed to checkout']");
        proceedToCheckoutBtn.shouldBe(Condition.visible).click();
        return new PersonalInformationCartPage();
    }

}
