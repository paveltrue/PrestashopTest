package com.prestashop.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SetValueMethod;
import com.codeborne.selenide.SetValueOptions;
import com.prestashop.utils.NumberUtils;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j
public class ProductPage {

    @Step
    public ProductPage changeQuantity(int desiredQuantity) {
        log.info("Changing product Quantity to " + desiredQuantity);
        SelenideElement quantityInputField = $(byId("quantity_wanted"));
        quantityInputField.setValue(SetValueOptions
                .withText(String.valueOf(desiredQuantity))
                .usingMethod(SetValueMethod.JS));
        return this;
    }

    @Step
    public PreviewProductCartPage clickAddToCardBtn() {
        log.info("Clicking 'Add to Card' button on Product Page");
        SelenideElement addToCardBtn = $x("//button[@data-button-action='add-to-cart']");
        addToCardBtn.click();
        return new PreviewProductCartPage();
    }

    @Step
    public double getProductPrice() {
        log.info("Getting product price on Product Page");
        SelenideElement productPriceElement = $x("//span[@class='current-price-value']");
        return NumberUtils.convertToDouble(productPriceElement.attr("content"));
    }

}
