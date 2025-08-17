package com.demoqa.enams;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SubCategories {
    DRESS_W("Dress"),TOPS_W("Tops"),SAREE_W("Saree"),
    TSHIRTS_M("Tshirts"),JEANS_M("Jeans"),
    DRESS_K("Dress"),TOPS_SHIRTS("Tops & Shirts");

    String name;
}
