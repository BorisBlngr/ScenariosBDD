import java.math.BigDecimal;
import java.math.MathContext;

public record Montant(Double valeur, String devise) {
   static Montant convertir(Double montant, DeviseCible deviseCible, Double tauxDeChange) {
      if (montant < 0) return null;
      double doubleValue = multiply(montant, tauxDeChange);
      if (deviseCible.nombreDeDecimales() == 0) {
         doubleValue = Math.floor(doubleValue);
      }
      return new Montant(doubleValue, deviseCible.nom());
   }

   private static double multiply(Double montant, Double tauxDeChange) {
      BigDecimal multiply = multiplyUniquement(montant, tauxDeChange);
      return precision(multiply);
   }

   private static double precision(BigDecimal multiply) {
      // faire precision ici a +
      return multiply.doubleValue();
   }

   private static BigDecimal multiplyUniquement(Double montant, Double tauxDeChange) {
      BigDecimal montantEnBigDecimal = BigDecimal.valueOf(montant);
      BigDecimal tauxDeChangeEnBigDecimal = BigDecimal.valueOf(tauxDeChange);
      BigDecimal multiply = montantEnBigDecimal.multiply(tauxDeChangeEnBigDecimal);
      return multiply;
   }

   public static Montant convertir(String montant, String deviseCible) {
      return null;
   }
}
