package com.prestashop.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductItem {

    private String name;
    private int quantity;
    private double price;

}
