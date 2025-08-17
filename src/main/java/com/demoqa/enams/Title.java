package com.demoqa.enams;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Title {
    MR("Mr"),
    MRS("Mrs");

    @Getter
    final
    String title;
}
