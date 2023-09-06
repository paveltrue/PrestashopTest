package com.prestashop.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.prestashop.utils.NumberUtils;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.assertj.core.api.Assertions;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Log4j
public class OrderConfirmationPage {

    // 0 element - price, 1 - quantity, 2 - total products
    private final ElementsCollection rowOrderValues = $$x("//div[@class='order-line row']//div[@class='row']/div[2]");

    @Step
    public OrderConfirmationPage checkSuccessMessageIsDisplayed() {
        log.info("Checking order success message is displayed on the page");
        SelenideElement successMessageLabel = $x("//h3[contains(., 'Your order is confirmed')]");
        Assertions.assertThat(successMessageLabel.shouldBe(Condition.visible).isDisplayed())
                .withFailMessage("Success message 'Your order is confirmed' is not displayed on the page!")
                .isTrue();
        return this;
    }

    @Step
    public OrderConfirmationPage checkOrderHasValidTotalPrice(double expectedTotalPrice) {
        log.info("Checking order has valida total price - " + expectedTotalPrice);
        SelenideElement totalPriceField =
                $x("//tbody//span[contains(text(), 'Total')]/parent::td/following-sibling::td");
        double actualTotalPrice = NumberUtils.convertToDouble(totalPriceField.getText().replace("€", ""));
        Assertions.assertThat(actualTotalPrice)
                .withFailMessage("Total price has wrong value! Expected: [%s], Actual: [%s]",
                        expectedTotalPrice, actualTotalPrice)
                .isEqualTo(expectedTotalPrice);
        return this;
    }

    @Step
    public OrderConfirmationPage checkTotalProductsQuantity(int expectedTotalProductsQuantity) {
        log.info("Checking total products quantity is equals to - " + expectedTotalProductsQuantity);
        int actualTotalProductsQuantity = NumberUtils.convertToInt(rowOrderValues.get(0).getText());
        Assertions.assertThat(actualTotalProductsQuantity)
                .withFailMessage("Success message 'Your order is confirmed' is not displayed on the page!")
                .isEqualTo(expectedTotalProductsQuantity);
        return this;
    }

}
