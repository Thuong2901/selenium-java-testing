package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Exe_Login {
    WebDriver driver;
    @BeforeClass
    public void beforeclass(){
        driver= new FirefoxDriver();
    }
    @Test
    public void TC01_Empty_Email_Pass(){
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("");
        driver.findElement(By.cssSelector("button#send2")).click();
    }
    @Test
    public void TC02_Invalid_Email(){
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("123434234@12312.123123");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email"))
                .getText(),"Please enter a valid email address. For example johndoe@domain.com.");

    }
    @Test
    public void TC03_Invalid_Pass(){
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).clear();
        driver.findElement(By.cssSelector("input#pass")).clear();
        driver.findElement(By.cssSelector("input#email")).sendKeys("thuongpt@gmail.com.vn");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("1234");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");

    }
    @Test
    public void TC04_Incorrect_Email_Pass() throws InterruptedException {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).clear();
        driver.findElement(By.cssSelector("input#pass")).clear();
        driver.findElement(By.cssSelector("input#email")).sendKeys("thuongpt@gmail.com.vn");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#send2")).click();
        Thread.sleep(10000);
        Assert.assertEquals(driver.findElement(By.cssSelector("li[class='error-msg']")).getText(),"Invalid login or password.");

    }
}
