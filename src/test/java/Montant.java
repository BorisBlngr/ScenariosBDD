public record Montant(Double valeur, String devise) {
   static Montant convertir(Double montant, String deviseCible, Double tauxDeChange) {
      if (montant < 0) return null;
      return new Montant(montant * tauxDeChange, deviseCible);
   }

   public static Montant convertir(String montant, String deviseCible) {
      return null;
   }
}
