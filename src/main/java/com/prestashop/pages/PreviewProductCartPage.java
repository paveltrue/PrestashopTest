package com.prestashop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Selenide.$x;

@Log4j
public class PreviewProductCartPage {

    @Step
    public CartPage clickProceedToCheckoutBtn() {
        log.info("Clicking 'Proceed to checkout' button on Preview Product Card page");
        SelenideElement proceedToCheckoutBtn = $x("//div[@class='cart-content-btn']/a");
        proceedToCheckoutBtn.click();
        return new CartPage();
    }

}
