package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_10_MultipleEnv {
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    String enviromentUrl;

    @Parameters({"browser","enviromentName"})
    @BeforeClass
    public void initialBrowser( String browserName, String enviromentName){
        System.out.println("BrowserName = " + browserName);
        System.out.println("Enviroment Name = " + enviromentName);

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

        switch (browserName.toUpperCase()){
            case "Dev":
                enviromentUrl = "https://www.fahasa-dev.com";
                break;

            case "UAT":
                enviromentUrl = "https://www.fahasa-uat.com";
                break;

            case "STAGING":
                enviromentUrl = "https://www.fahasa-staging.com";
                break;

            case "PROD":
                enviromentUrl = "https://www.fahasa.com";
                break;

            default:
                throw new RuntimeException("Enviroment name is not support");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        jsExecutor = (JavascriptExecutor) driver;
        driver.get(enviromentUrl + "/customer/account/create");
    }
    @Test
    public void TC01_Fahasa() throws InterruptedException{


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
