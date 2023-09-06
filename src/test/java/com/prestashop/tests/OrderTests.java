package com.prestashop.tests;

import com.prestashop.model.Order;
import com.prestashop.model.ProductItem;
import com.prestashop.pages.AddressesPage;
import com.prestashop.pages.CartPage;
import com.prestashop.pages.HomePage;
import com.prestashop.pages.OrderConfirmationPage;
import com.prestashop.pages.PaymentPage;
import com.prestashop.pages.PersonalInformationCartPage;
import com.prestashop.pages.PreviewProductCartPage;
import com.prestashop.pages.ProductPage;
import com.prestashop.pages.ShippingPage;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class OrderTests extends BaseTest {

    @Description("Checking the ability to buy the same product item not logged in user")
    @Test(dataProvider = "orderTestData")
    public void buySameItems(Order order) {
        ProductItem productItem = order.getProductItems().get(0);
        ProductPage productPage = new HomePage().clickFirstPopularProduct();
        productItem.setPrice(productPage.getProductPrice());
        PreviewProductCartPage previewProductCartPage = productPage
                .changeQuantity(productItem.getQuantity())
                .clickAddToCardBtn();
        CartPage cartPage = previewProductCartPage.clickProceedToCheckoutBtn();
        PersonalInformationCartPage informationCartPage = cartPage.clickProceedToCheckoutBtn();
        AddressesPage addressesPage = informationCartPage
                .fillInRequiredFields(order.getUser())
                .clickContinueBtn();
        ShippingPage shippingPage = addressesPage
                .fillInRequiredFields(order.getDeliveryAddress())
                .clickContinueBtn();
        PaymentPage paymentPage = shippingPage.selectShippingMethod(order.isDeliveryNeeded())
                .clickContinueBtn();
        OrderConfirmationPage confirmationPage = paymentPage
                .selectPaymentMethod(order.getPaymentMethod())
                .enableTermsOfServiceCheckbox()
                .clickPlaceOrderBtn();
        confirmationPage
                .checkSuccessMessageIsDisplayed()
                .checkTotalProductsQuantity(productItem.getQuantity())
                .checkOrderHasValidTotalPrice(productItem.getPrice() * productItem.getQuantity());
    }

    @DataProvider
    private Object[][] orderTestData() {
        return new Object[][]{
                {generateOrder(1)},
                {generateOrder(2)},
                {generateOrder(5)},
                {generateOrder(8)},
                {generateOrder(25)},
        };
    }

    private Order generateOrder(int amountItems) {
        List<ProductItem> productList = Collections.singletonList(ProductItem.builder().quantity(amountItems).build());
        return Order.builder().productItems(productList).build();
    }

}
