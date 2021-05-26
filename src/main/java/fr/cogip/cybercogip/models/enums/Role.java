package fr.cogip.cybercogip.models.enums;

public enum Role {
    SALES("Sales"),
    MANAGEMENT("Management"),
    ACCOUNTING("Accounting"),
    ADMIN("Administration");

    private final String label;

    Role(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return this.getLabel();
    }
}
