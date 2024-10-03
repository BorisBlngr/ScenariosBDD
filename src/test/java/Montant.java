import java.math.BigDecimal;

public record Montant(Double valeur, String devise) {
   static Montant convertir(Double montant, String deviseCible, Double tauxDeChange) {
      if (montant < 0) return null;
      double doubleValue = multiply(montant, tauxDeChange);
      return new Montant(doubleValue, deviseCible);
   }

   private static double multiply(Double montant, Double tauxDeChange) {
      BigDecimal montantEnBigDecimal = BigDecimal.valueOf(montant);
      BigDecimal tauxDeChangeEnBigDecimal = BigDecimal.valueOf(tauxDeChange);
      BigDecimal multiply = montantEnBigDecimal.multiply(tauxDeChangeEnBigDecimal);
      return multiply.doubleValue();
   }

   public static Montant convertir(String montant, String deviseCible) {
      return null;
   }
}
