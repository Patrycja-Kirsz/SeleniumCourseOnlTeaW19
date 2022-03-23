package pl.coderslab.zadaniaKoncowe;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyStoreNewAddressSteps {

    private WebDriver driver;


    @Given("^Page (.*) is opened$")
    public void pageOpenedInBrowser(String pageUrl) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get(pageUrl);
        driver.manage().window().maximize();


    }

    @When("^Sign in on the front page is clicked$")
    public void shouldSignIn() {
        WebElement signIn = driver.findElement(By.cssSelector("span.hidden-sm-down"));
        signIn.click();

    }

    @And("^The user has logged in by using e-mail address and password$")
    public void shouldLoggIn() {
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("jan@nowak.pl");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("password");
        WebElement submit = driver.findElement(By.id("submit-login"));
        submit.click();
    }

    @And("^The field Addresses is clicked$")
    public void shouldClickAddresses() {
        WebElement addresses = driver.findElement(By.id("addresses-link"));
        addresses.click();

    }

    @And("^Create new address is clicked$")
    public void shouldClickNewAddress() {
     
        WebElement newAddress = driver.findElements(By.xpath("//i[@class = 'material-icons']")).get(3);
        newAddress.click();

    }

    @And("^Address information: (.*), (.*), (.*), (.*), (.*) are filled out$")
    public void shouldAddData(String alias, String address, String city, String postalCode, String phone) {
        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.clear();
        aliasInput.sendKeys(alias);
        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.clear();
        addressInput.sendKeys(address);
        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.clear();
        cityInput.sendKeys(city);
        WebElement postalCodeInput = driver.findElement(By.name("postcode"));
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);
        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.clear();
        phoneInput.sendKeys(phone);
        WebElement saveInput = driver.findElement(By.cssSelector("button.btn.btn-primary.float-xs-right"));
        saveInput.click();
    }

    @Then("^Added address information should be (.*), (.*), (.*), (.*), (.*)$")
    public void AccountCreated(String alias, String address, String city, String postalCode, String phone) {
          

        WebElement addressInformation = driver.findElements(By.xpath("//div[@class = 'address-body']")).get(1);
        addressInformation.getText();
        String successInfo = addressInformation.getText();
        assertEquals(alias + "\n" + "Jan Nowak\n" + address + "\n" + city + "\n" + postalCode + "\n" + "United Kingdom\n" + phone, successInfo);
    }

    @BeforeEach
    public void beforeEach() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));


    }


}


