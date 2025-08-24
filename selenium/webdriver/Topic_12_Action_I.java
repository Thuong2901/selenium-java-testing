package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_12_Action_I {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();

        FirefoxOptions option = new FirefoxOptions();
        option.addPreference("dom.webnotifications.enabled",false);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        actions = new Actions(driver);

    }
    @Test
    public void TC01_Hover() throws InterruptedException{

        driver.get("https://automationfc.github.io/jquery-tooltip/");
        actions.moveToElement(driver.findElement(By.cssSelector("input[id='age']"))).perform();
        // cách 1
        // Thread.sleep(3000);
        //cách 2
        actions.pause(Duration.ofSeconds(3)).perform();

        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='We ask for your age only for statistical purposes.']")).getText(),"We ask for your age only for statistical purposes.");


    }

    @Test
    public void TC02_HoverFahasa() throws InterruptedException{
        driver.get("https://www.fahasa.com/");

        Thread.sleep(10000);
        //Hover icon menu
        actions.moveToElement(driver.findElement(By.cssSelector("span[class='icon_menu']"))).perform();
        actions.pause(Duration.ofSeconds(3)).perform();

        //Hover vào Sách giáo khoa
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Sách Giáo Khoa 2025']"))).perform();
        actions.pause(Duration.ofSeconds(3)).perform();

        driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//a[text()='Luyện Thi Môn Toán']")).click();
        //actions.click(driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//a[text()='Luyện Thi Môn Toán']"))).perform();

        Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Toán']")).isDisplayed());

    }

    @AfterClass
    public void afterclass(){
        driver.quit();
    }

}
