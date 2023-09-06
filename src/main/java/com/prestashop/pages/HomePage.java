package com.prestashop.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Selenide.$$x;

@Log4j
public class HomePage {

    @Step
    public ProductPage clickFirstPopularProduct() {
        log.info("Clicking on first popular item on Home page");
        ElementsCollection popularProductsElements = $$x("//div[@class='products row']/div");
        popularProductsElements.first().scrollTo().click();
        return new ProductPage();
    }

}
