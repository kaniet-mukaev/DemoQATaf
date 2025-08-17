package com.demoqa.enams;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Brands {
    POLO ("Polo"),
    H_M("H&M"),
    MADAME("Madame"),
    MAST_HARBOUR("Mast & Harbour"),
    BABYHUG("Babyhug"),
    ALLEN_SOLLY_JUNIOR("Allen Solly Junior"),
    KOOKIE_KIDS("Kookie Kids"),
    BIBA("Biba");

    String name;
}
