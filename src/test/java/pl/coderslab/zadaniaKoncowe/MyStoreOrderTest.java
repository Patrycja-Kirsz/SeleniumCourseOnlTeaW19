package pl.coderslab.zadaniaKoncowe;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;


public class MyStoreOrderTest {
    private WebDriver driver;


    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }
    @Test
    public void Order() {
        this.driver.get("https://mystore-testlab.coderslab.pl/index.php");
        driver.findElement(By.cssSelector("span.hidden-sm-down")).click();
        driver.findElement(By.name("email")).sendKeys("jan@nowak.pl");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.id("submit-login")).click();
        driver.findElement(By.id("category-3")).click();
        driver.findElements(By.xpath("//h2[@class = 'h3 product-title']")).get(1).click();
        Select dropdown = new Select(driver.findElement(By.id("group_1")));
        dropdown.selectByIndex(1);
        WebElement quantity = driver.findElement(By.id("quantity_wanted"));
        quantity.clear();
        quantity.sendKeys("5");
        driver.findElement(By.cssSelector("button.btn.btn-primary.add-to-cart")).click();
        driver.findElements(By.cssSelector("i.material-icons.rtl-no-flip")).get(1).click();
        driver.findElements(By.cssSelector("a.btn.btn-primary")).get(0).click();
        driver.findElement(By.name("confirm-addresses")).click();
        driver.findElement(By.name("confirmDeliveryOption")).click();
        driver.findElement(By.id("payment-option-1")).click();
        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
        driver.findElement(By.cssSelector("button.btn.btn-primary.center-block")).click();
        WebElement productNameConfirmation = driver.findElement(By.cssSelector("div.col-sm-4.col-xs-9.details"));
        String successText = productNameConfirmation.getText();
        Assertions.assertEquals("Hummingbird printed sweater - Size : M",successText);
        WebElement quantityConfirmation = driver.findElement(By.className("col-xs-2"));
        String successQuantity = quantityConfirmation.getText();
        Assertions.assertEquals("5",successQuantity);




    }
    @AfterEach
    public void takeScreenshot() throws IOException {
       TakesScreenshot screenshot = (TakesScreenshot) driver;
       File Screenshot = screenshot.getScreenshotAs(OutputType.FILE);
       Files.copy(Screenshot.toPath(), Paths.get("C:", "test-evidence", "screenshot.png"));

   }




    }



