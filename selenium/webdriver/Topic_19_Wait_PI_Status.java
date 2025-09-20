package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.time.Duration;
import java.util.Date;

public class Topic_19_Wait_PI_Status {
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));

    }

    @Test
    public void TC01_Visible(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.cssSelector("button#send2")).click();

        //Điều kiện 1 - Element hiển thị ở trên UI và có trong DOM/câyHTML
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='advice-required-entry-email']")));

    }

    @Test
    public void TC02_Invisible_In_HTML() throws InterruptedException {
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.cssSelector("button#send2")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input[title='Email Address']")).sendKeys("thuongpt@gmail.com");
        driver.findElement(By.cssSelector("button#send2")).click();

        //Điều kiện 2 Element không hiển thị ở trên UI và có trong DOM/HTML

        System.out.println("Start wait:" + getDateTimeNow());
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id='advice-required-entry-email']")));
        System.out.println("End wait:" + getDateTimeNow());
    }

    @Test
    public void TC03_Invsible_Not_In_HTML(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.cssSelector("input[title='Email Address']")).sendKeys("thuongpt@gmail.com");
        driver.findElement(By.cssSelector("button#send2")).click();

        //Điều kiện 3 Element không hiển thị ở trên UI và không có trong DOM/HTML

        System.out.println("Start wait:" + getDateTimeNow());
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id='advice-required-entry-email']")));
        System.out.println("End wait:" + getDateTimeNow());

    }

    @Test
    public void TC04_Presence() {
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.cssSelector("button#send2")).click();

        //Điều kiện 1 - Element hiển thị ở trên UI và có trong DOM/câyHTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='advice-required-entry-email']")));

        driver.findElement(By.cssSelector("input[title='Email Address']")).sendKeys("thuongpt@gmail.com");
        driver.findElement(By.cssSelector("button#send2")).click();

        //Điều kiện 2 Element không hiển thị ở trên UI và có trong DOM/HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='advice-required-entry-email']")));

    }
    @Test
    public void TC05_Staless() {
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.cssSelector("button#send2")).click();

        //Element đã xuất hiện 1 thời điểm trc đó
        WebElement emailErrorMessage = driver.findElement(By.cssSelector("div[id='advice-required-entry-email']"));

        driver.navigate().refresh();
        //Điều kiện 3 Element không hiển thị ở trên UI và không có trong DOM/HTML
        //Tại thời điểm này mình mong đợi n k còn xuất hiện nữa
        explicitWait.until(ExpectedConditions.stalenessOf(emailErrorMessage));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id='advice-required-entry-email']")));

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    private String getDateTimeNow(){
        return new Date().toString();
    }

}
