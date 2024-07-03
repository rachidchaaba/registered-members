package cucumber.steps;

import com.company.registeredmembers.model.CounterConfig;
import com.company.registeredmembers.model.DateConfig;
import com.company.registeredmembers.model.NameConfig;
import com.company.registeredmembers.model.RegisteredMember;
import com.company.registeredmembers.model.RegistrationConfig;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationStepDefs {

  private static final String REGISTRATION_ENDPOINT = "/registration";
  private static final String CONFIG_ENDPOINT = "/config";
  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

  private RegistrationConfig registrationConfig = new RegistrationConfig();
  private String generatedNumber;

  @LocalServerPort
  private int port;

  @Given("^the first name configuration is$")
  public void initFirstNameConfiguration(List<NameConfig> firstNameConfigs) {
    assertThat(firstNameConfigs).hasSize(1);
    registrationConfig.setFirstNameConfig(firstNameConfigs.get(0));
  }

  @Given("^the last name configuration is$")
  public void initLastNameConfiguration(List<NameConfig> lastNameConfigs) {
    assertThat(lastNameConfigs).hasSize(1);
    registrationConfig.setLastNameConfig(lastNameConfigs.get(0));
  }

  @Given("^the birth date configuration is$")
  public void initBirthDateConfiguration(List<DateConfig> birthDateConfigs) {
    assertThat(birthDateConfigs).hasSize(1);
    registrationConfig.setBirthDateConfig(birthDateConfigs.get(0));
  }

  @Given("^the counter configuration is$")
  public void initCounterConfiguration(List<CounterConfig> counterConfigs) {
    assertThat(counterConfigs).hasSize(1);
    registrationConfig.setCounterConfig(counterConfigs.get(0));
    setConfig();
  }

  @When("^we generate the number for the member$")
  public void generateTheMemberNumber(List<RegisteredMember> registeredMembers) {
    assertThat(registeredMembers).hasSize(1);
    generatedNumber = generateNumber(registeredMembers.get(0));
  }

  @Then("the generated number is {string}")
  public void assertThatTheGeneratedNumberIs(String expectedGeneratedNumber) {
    assertThat(generatedNumber).isEqualTo(expectedGeneratedNumber);
  }

  @DataTableType
  public NameConfig nameConfig(Map<String, String> entry) {
    return NameConfig.builder()
                     .prefix(entry.get("prefix"))
                     .suffix(entry.get("suffix"))
                     .length(parseInt(entry.get("length")))
                     .index(parseInt(entry.get("index")))
                     .build();
  }

  @DataTableType
  public DateConfig birthDateConfig(Map<String, String> entry) {
    return DateConfig.builder()
                     .prefix(entry.get("prefix"))
                     .suffix(entry.get("suffix"))
                     .pattern(entry.get("pattern"))
                     .index(parseInt(entry.get("index")))
                     .build();
  }

  @DataTableType
  public CounterConfig counterConfig(Map<String, String> entry) {
    return CounterConfig.builder()
                        .prefix(entry.get("prefix"))
                        .suffix(entry.get("suffix"))
                        .numberOfDigits(parseInt(entry.get("numberOfDigits")))
                        .index(parseInt(entry.get("index")))
                        .value(parseInt(entry.get("value")))
                        .build();
  }

  @DataTableType
  public RegisteredMember registeredMembers(Map<String, String> entry) throws ParseException {
    return RegisteredMember.builder()
                           .firstName(entry.get("firstName"))
                           .lastName(entry.get("lastName"))
                           .birthDate(DATE_FORMAT.parse(entry.get("birthDate")))
                           .build();
  }

  private Response setConfig() {
    return given()
            .contentType(ContentType.JSON)
            .body(registrationConfig)
            .port(port)
            .put(CONFIG_ENDPOINT);
  }

  private String generateNumber(RegisteredMember registeredMember) {
    return given()
            .contentType(ContentType.JSON)
            .body(registeredMember)
            .port(port)
            .post(REGISTRATION_ENDPOINT).getBody().asPrettyString();
  }
}
