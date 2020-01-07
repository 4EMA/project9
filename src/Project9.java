import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Project9 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Applications/technostudy/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://test-basqar.mersys.io");
        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();
        driver.findElement(By.cssSelector(".group-items > :nth-child(6)")).click();
        driver.findElement(By.cssSelector(".group-items > :nth-child(6) > .children > :nth-child(1)")).click();
        driver.findElement(By.cssSelector(".group-items > :nth-child(6) > .children > :nth-child(1) .children > :nth-child(1)")).click();
        driver.findElement(By.cssSelector("[data-icon='plus']")).click();
        String descriptionName = "Ema4";
        WebElement description = driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]"));
        description.sendKeys(descriptionName);
        driver.findElement(By.cssSelector("#mat-select-2")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-option-11\"]/span")).click();
        String startdateName = "01/06/2020";
       driver.findElement(By.xpath("//*[@id=\"mat-input-7\"]")).sendKeys(startdateName);

        String enddateName = "01/15/2020";
        driver.findElement(By.xpath("//*[@id=\"mat-input-8\"]")).sendKeys(enddateName);
        String comment = "Pass The Test";

        driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]")).sendKeys(comment);
        driver.findElement(By.xpath("//div[@class='mat-tab-label mat-ripple ng-star-inserted']")).click();
        driver.findElement(By.xpath("//input[@class='mat-input-element mat-form-field-autofill-control cdk-text-" +
                "field-autofill-monitored ng-untouched ng-pristine ng-invalid']")).sendKeys("1");
        driver.findElement(By.xpath("//ms-decimal-field//input")).sendKeys("4444");
        driver.findElement(By.xpath("//button[@class='mat-raised-button mat-button-base mat-basic ng-star-inserted']")).click();        WebElement saveIcon = driver.findElement( By.cssSelector( "mat-dialog-container [data-icon=\"save\"]" ) );
            saveIcon.click();

            try {
                wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "[aria-label='Budget Group successfully created']" ) ) );
                System.out.println("Creation success!");
            } catch( Exception e) {
                System.out.println("Creation failure!");
            }
            String text = driver.findElement(By.xpath("//td[text()='Ema4']")).getText();
             System.out.println(text);
             if (descriptionName.equals(text)){
                 System.out.println("Success");
             }
        System.out.println(text);
             String text2 = driver.findElement(By.xpath("//td[text()='01/06/2020']")).getText();
       // System.out.println(text2);
        if (startdateName.equals(text2)){
            System.out.println("Success");
        }else{
            System.out.println("fail");
        }
        String text1 = driver.findElement(By.xpath("//td[text()='01/15/2020']")).getText();

        if (enddateName.equals(text1)){
            System.out.println("Success");
        }else{
            System.out.println("fail");
        }
        System.out.println(text1);
        String text3 = driver.findElement(By.xpath("//td[text()='Pass The Test']")).getText();


        }

        }







