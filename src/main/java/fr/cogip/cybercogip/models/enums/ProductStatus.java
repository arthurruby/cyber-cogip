package fr.cogip.cybercogip.models.enums;

public enum ProductStatus {
    AVAILABLE("Available"),
    OUTOFSTOCK("Out of stock"),
    DISCONTINUED("Discontinued");

    private final String label;

    public String getLabel() {
        return this.label;
    }

    ProductStatus(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.getLabel();
    }
}
