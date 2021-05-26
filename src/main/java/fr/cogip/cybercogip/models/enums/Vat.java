package fr.cogip.cybercogip.models.enums;

import java.math.BigDecimal;

public enum Vat {
    REGULAR("Regular VAT rate of 20%", new BigDecimal("20.00")),
    INTERMEDIATE("Intermediate VAT rate of 10%", new BigDecimal("10.00")),
    REDUCED("Reduced VAT rate of 5,5%", new BigDecimal("5.50")),
    SPECIAL("Special VAT rate of 2.1%", new BigDecimal("2.10"));

    private final String label;
    private final BigDecimal value;

    Vat(String label, BigDecimal value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return this.label;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.getLabel();
    }
}
