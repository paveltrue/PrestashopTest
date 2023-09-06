package com.prestashop.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Order {

    @Builder.Default
    private User user = User.generateRandomUser();
    @Builder.Default
    private DeliveryAddress deliveryAddress = DeliveryAddress.builder().build();
    @Builder.Default
    private boolean isDeliveryNeeded = false;
    @Builder.Default
    private PaymentMethod paymentMethod = PaymentMethod.BY_BANK_WIRE;
    private List<ProductItem> productItems;

    public enum PaymentMethod {

        BY_BANK_WIRE, BY_CASH_ON_DELIVERY, BY_CHECK

    }

}
