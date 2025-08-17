package com.demoqa.enams;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Categories {
    WOMEN("#Women"),
    MEN("#Men"),
    KIDS("#Kids");

    String description;
}
