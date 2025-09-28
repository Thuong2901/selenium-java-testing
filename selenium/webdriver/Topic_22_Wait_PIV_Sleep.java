package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Topic_22_Wait_PIV_Sleep {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void TC01_Less() throws InterruptedException {
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div[id='start']>button")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div#loading")).isDisplayed());

        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='finish']")).getText(),"Hello World!");


    }

    @Test
    public void TC02_Equal() throws InterruptedException {
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div[id='start']>button")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div[id='loading']")).isDisplayed());

        Thread.sleep(5000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='finish']")).getText(),"Hello World!");


    }

    @Test
    public void TC03_More() throws InterruptedException {
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div[id='start']>button")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div#loading")).isDisplayed());

        Thread.sleep(Duration.ofSeconds(10));

        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='finish']")).getText(),"Hello World!");


    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }


}
