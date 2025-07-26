package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Exe_Element {
    WebDriver driver;

    @BeforeClass
    public void beforeclass(){
        driver= new FirefoxDriver();
    }

    @Test
    public void TC01_Displayed_Enable_Selected(){
        driver.get("https://www.fahasa.com/customer/account/create");

        //Element isDisplay: có thể nhìn thấy và có kích thước cụ thể
        Assert.assertTrue(driver.findElement(By.cssSelector("input#register_phone")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#register_password")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("button.fhs-btn-register")).isDisplayed());

        //Element isDisplayed: không thể nhìn thấy
        Assert.assertFalse(driver.findElement(By.cssSelector("input#login_username")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("input#login_password")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("button.fhs-btn-login")).isDisplayed());

        //Element Enable: có thể thao tác được (k bị read-only = disable)
        Assert.assertTrue(driver.findElement(By.cssSelector("input#register_phone")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("input#register_password")).isEnabled());


        driver.get("https://live.techpanda.org/index.php/customer/account/create/");

        //Element Selected
        Assert.assertTrue(driver.findElement(By.cssSelector("input#is_subscribed")).isEnabled());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#is_subscribed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("input#is_subscribed")).isSelected());

    }


    @Test
    public void TC02_MailChimp() throws InterruptedException {
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.cssSelector("input#email")).sendKeys("thuongpt@gmail.com.vn");

        //lower case
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("thuongpt");
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("button[id='create-account-enabled']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());

        //Upper case
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("THUONGPT");
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("button[id='create-account-enabled']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());

        //number
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("1234567");
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("button[id='create-account-enabled']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        //character
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("@#$%");
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("button[id='create-account-enabled']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        //Pass
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("Thuong123@");
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("button[id='create-account-enabled']")).click();

        Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());


    }


    @AfterClass
    public void afterClass(){
        driver.quit();

    }

}
