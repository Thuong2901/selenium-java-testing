package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Topic_21_Wait_PIII_Implicit {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void TC01_No_Set(){
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.cssSelector("div[id='start']>button")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div#loading")).isDisplayed());

        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='finish']")).getText(),"Hello World!");

    }

    @Test
    public void TC02_Less(){
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.cssSelector("div[id='start']>button")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div#loading")).isDisplayed());

        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='finish']")).getText(),"Hello World!");


    }

    @Test
    public void TC03_Equal(){
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div[id='start']>button")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div[id='loading']")).isDisplayed());

        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='finish']")).getText(),"Hello World!");


    }

    @Test
    public void TC04_More(){
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("div[id='start']>button")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div#loading")).isDisplayed());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='finish']")).getText(),"Hello World!");


    }

    @AfterClass
    public void afterClass(){
        //driver.quit();
    }
    private String getDateTimeNow(){
        return new Date().toString();
    }

}
