package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_09_MultipleBrowser {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @Parameters({"browser"})
    @BeforeClass
    public void initialBrowser( String browserName){

        switch (browserName.toUpperCase()){
            case "FIREFOX":
                driver = new FirefoxDriver();
                break;

            case "EGDE":
                driver = new EdgeDriver();
                break;

            case "CHROME":
                driver = new ChromeDriver();
                break;

            default:
                throw new RuntimeException("Browser name is not support");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        jsExecutor = (JavascriptExecutor) driver;
    }
    @Test
    public void TC01_Fahasa() throws InterruptedException{

        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li[class='popup-login-tab-item popup-login-tab-login']")).click();

        By loginButton = By.cssSelector("button[class='fhs-btn-login']");
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());


        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(),"#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("0372682548");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("Abcd@123");
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(),"#C92127");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
