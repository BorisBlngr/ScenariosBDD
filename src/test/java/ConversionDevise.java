import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversionDevise {
   private Double montantDuWhen;
   private String devise;

   @When("Je convertis {double} {string} en {string}")
   public void jeConvertisEn(Double montant, String deviseSource, String deviseCible) {
      montantDuWhen = montant;
      this.devise = deviseCible;
   }

   @Then("Je dois avoir {double} {string}")
   public void jeDoisAvoir(Double montant, String deviseCible) {
      assertEquals(montantDuWhen, montant);
      assertEquals(devise, deviseCible);
   }
}
