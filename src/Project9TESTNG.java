import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Project9TESTNG {
    private WebDriver driver;
    private WebDriverWait wait;

    @Parameters({"username", "password"})
    @BeforeClass
    public void setup(String username, String password) {
        // write your code here
        System.setProperty("webdriver.chrome.driver", "/Applications/technostudy/Selenium/ChromeDriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://test-basqar.mersys.io");
        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();
    }
    @Test
    public void main() {
        // to select "Budget", the first child of group items
        driver.findElement(By.cssSelector(".group-items > :nth-child(6)")).click();
        // to select "Setup", the first child of  the first child of group items
        driver.findElement(By.cssSelector(".group-items > :nth-child(6) > .children > :nth-child(1)")).click();
        // to select "budget groups ", the forth child of the first child of  the first child of group items
        driver.findElement(By.cssSelector(".group-items > :nth-child(6) > .children > :nth-child(1) > .children > :nth-child(1)")).click();
        driver.findElement( By.cssSelector( "[data-icon='plus']" ) ).click();
        // driver.findElement(By.xpath("//*[@class='mat-mini-fab mat-button-base mat-accent']")).click();
        String name = "Ema4";
        driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]")).sendKeys("Ema4");

        // driver.findElement(By.xpath("mat-option-10")).click();
        driver.findElement(By.cssSelector("#mat-select-2")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-option-11\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-input-7\"]")).sendKeys("01/06/2020");
        driver.findElement(By.xpath("//*[@id=\"mat-input-8\"]")).sendKeys("01/15/2020");
        driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]")).sendKeys("Pass The Test");
        WebElement saveIcon = driver.findElement( By.cssSelector( "mat-dialog-container [data-icon=\"save\"]" ) );
        saveIcon.click();
        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "[aria-label='Budget Group successfully created']" ) ) );

        } catch( Exception e) {
            Assert.fail( "Delete failure", e );
        }

    }
//    @AfterClass
//    public void quit(){
//        driver.quit();
//    }
}