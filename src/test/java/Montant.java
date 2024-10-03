public record Montant(Double valeur, String devise) {
   static Montant convertir(Double montant, String deviseCible) {
      if (montant < 0) return null;
      return new Montant(montant, deviseCible);
   }
}
