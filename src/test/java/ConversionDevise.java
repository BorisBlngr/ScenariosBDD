import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversionDevise {
   private Montant notreMontant;
   private Double tauxDeChange = 1.0;
   private int nombreDeDecimales;

   @When("Je convertis {double} {string} en {string}")
   public void jeConvertisEn(Double montant, String deviseSource, String deviseCible) {
      notreMontant = Montant.convertir(montant, new DeviseCible(deviseCible, nombreDeDecimales), this.tauxDeChange);
   }

   @Then("Je dois avoir {double} {string}")
   public void jeDoisAvoir(Double montant, String deviseCible) {
      assertEquals(new Montant(montant, deviseCible), this.notreMontant);
   }

   @Then("Je ne peux pas convertir")
   public void jeNePeuxPasConvertir() {
      assertEquals(null, notreMontant);
   }

   @When("Je convertis {string} {string} en {string}")
   public void jeConvertisEn(String montant, String deviseSource, String deviseCible) {
      notreMontant = Montant.convertir(montant, deviseCible);
   }

   @Given("Le taux de change de {string} à {string} est de {double}")
   public void leTauxDeChangeDeAEstDe(String deviseSource, String deviseCible, Double tauxDeChange) {
      this.tauxDeChange = tauxDeChange;
   }

   @And("{string} doit être tronqué à l'unité")
   public void doitEtreTronqueALUnite(String deviseCible) {
      this.nombreDeDecimales = 0;
   }

   @And("{string} doit être avec {int} décimales")
   public void doitEtreAvecDecimales(String deviseCible, int nombreDeDecimales) {
      this.nombreDeDecimales = nombreDeDecimales;
   }
}
