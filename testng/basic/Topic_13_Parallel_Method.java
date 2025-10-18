package basic;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Topic_13_Parallel_Method {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = new FirefoxDriver();
        driver.get("https://www.nopcommerce.com/en");

    }
    @Test
    public void TC_01_Register(){
        System.out.println("Register new account");
        Assert.assertTrue(false);
    }

    @Test (dependsOnMethods = "TC_01_Register")
    public void TC_02_Login(){
        System.out.println("Login to System");
    }

    @Test (enabled = false)
    public void TC_03_Order(){
        System.out.println("Order product");
    }

    @Test
    public void TC_04_Ship(){
        System.out.println("Ship product");
    }

    @AfterMethod
    public void afterMethod(){
        if (null != driver) {
            driver.quit();
        }

    }

}