package com.demoqa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CartItem {
    private String name;
    private int price;
    private int quantity;
    private int total;
}