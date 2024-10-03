import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConversionDevise {
  @When("Je convertis {double} {string} en {string}")
  public void jeConvertisEn(Double arg0, String arg2, String arg3) {
  }

  @Then("Je dois avoir {double} {string}")
  public void jeDoisAvoir(Double arg0, String arg2) {
  }
}
