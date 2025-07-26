package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Exe_Browser {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver=new FirefoxDriver();
    }

    @Test
    public void TC01_Url(){
        //truy cập trang web
        driver.get("https://live.techpanda.org/");
        //clickbutton
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        //lấy ra
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/create/");

    }

    @Test
    public void TC02_Title(){
        driver.get("https://live.techpanda.org/");
        //clickbutton
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        //lấy ra
        Assert.assertEquals(driver.getTitle(),"Customer Login");

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");


    }

    @Test
    public void TC03_Navigate(){
        driver.get("https://live.techpanda.org/");
        //clickbutton
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/create/");
        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/login/");
        driver.navigate().forward();
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }

    @Test
    public void TC04_getPageSource(){
        driver.get("https://live.techpanda.org/");
        //clickbutton
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
    }

    @AfterClass
    public void afterclass(){
        driver.quit();
    }
}
