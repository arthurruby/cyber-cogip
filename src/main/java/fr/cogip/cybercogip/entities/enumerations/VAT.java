package fr.cogip.cybercogip.entities.enumerations;

import java.math.BigDecimal;

enum vat {
  REGULAR(new BigDecimal("0.20"), "Taux normal - 20  %") {
    @Override
    public String toString() {
      return "TVA normale, 20%";
    }
  },
  INTERMEDIATE(new BigDecimal("0.10"), "Taux intermediaire - 10%") {

    @Override
    public String toString() {
      return "TVA intermediaire, 10%";
    }
  },
  REDUCED(new BigDecimal("0.055"), "Taux réduit - 5.5%") {

    @Override
    public String toString() {
      return "TVA réduite, 5.5%";
    }
  },
  SPECIAL(new BigDecimal("0.021"), "Taux particulier - 2.1%") {

    @Override
    public String toString() {
      return "TVA particulère, 2.1%";
    }
  };

  private final BigDecimal rate;
  private final String label;

  private vat(BigDecimal rate, String label) {
    this.rate = rate;
    this.label = label;
  }

}
