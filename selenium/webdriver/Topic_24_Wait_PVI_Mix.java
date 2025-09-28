package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Topic_24_Wait_PVI_Mix {
    WebDriver driver;
    WebDriverWait explicitWait ;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void TC01_Element_Found() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com");
        System.out.println("Start time :"  + getDateTimeNow());
        driver.findElement(By.cssSelector("input[id='small-searchterms']"));
        System.out.println("End time :"  + getDateTimeNow());

        System.out.println("Start time :"  + getDateTimeNow());
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='small-searchterms']")));
        System.out.println("End time :"  + getDateTimeNow());

    }

    @Test
    public void TC02_Element_Not_Found_Only_Implicit(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com");
        System.out.println("Start time :"  + getDateTimeNow());
        try {
            driver.findElement(By.cssSelector("input[id='small']"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("End time :"  + getDateTimeNow());
        }

    }

    @Test
    public void TC03_Element_Not_Found_Only_Explicit() {
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com");

        System.out.println("Start time :"  + getDateTimeNow());
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='small']")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("End time :"  + getDateTimeNow());
        }

    }

    @Test
    public void TC04_Element_Not_Found_Only_Combine() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));

        driver.get("https://demo.nopcommerce.com");

        System.out.println("Start time :"  + getDateTimeNow());
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='small']")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("End time :"  + getDateTimeNow());
        }

    }

    @Test
    public void TC05_Element_Not_Found_Only_Combine() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));

        driver.get("https://demo.nopcommerce.com");

        System.out.println("Start time :"  + getDateTimeNow());
        try {
            explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input[id='small']"))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("End time :"  + getDateTimeNow());
        }

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    private String getDateTimeNow(){
        return new Date().toString();
    }


}
