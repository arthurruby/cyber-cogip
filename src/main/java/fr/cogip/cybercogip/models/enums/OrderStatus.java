package fr.cogip.cybercogip.models.enums;

public enum OrderStatus {
    CANCELED("Canceled"),
    PENDING("Pending"),
    PAID("Paid"),
    REALIZED("Realized");

    private final String label;

    public String getLabel() {
        return this.label;
    }

    OrderStatus(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.getLabel();
    }
}
