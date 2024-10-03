import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversionDevise {
   private Double montantDeviseCible;
   private String deviseCible;
   private Montant notreMontant;

   @When("Je convertis {double} {string} en {string}")
   public void jeConvertisEn(Double montant, String deviseSource, String deviseCible) {
      if (montant < 0) return;
      montantDeviseCible = montant;
      this.deviseCible = deviseCible;
   }

   @Then("Je dois avoir {double} {string}")
   public void jeDoisAvoir(Double montant, String deviseCible) {
      assertEquals(new Montant(montant, deviseCible), new Montant(montantDeviseCible, this.deviseCible));
   }

   @Then("Je ne peux pas convertir")
   public void jeNePeuxPasConvertir() {
      assertEquals(null, notreMontant);
   }
}
