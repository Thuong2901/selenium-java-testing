package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Topic_08_TextBox_TextAre {
    WebDriver driver;
    String firstname,lastname,fullname,emailAddress,password;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        firstname ="David";
        lastname= "Muir";
        fullname = firstname + " " + lastname;
        emailAddress ="David" + new Random().nextInt(9999)+ "@gmail.com";
        password = "12345a@";

    }
    @Test
    public void TC01_TechPanda() throws InterruptedException {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstname);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastname);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);
        driver.findElement(By.cssSelector("button[title='Register']")).click();

        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.cssSelector("li[class='success-msg']")).getText(),"Thank you for registering with Main Website Store.");
        String contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullname));
        Assert.assertTrue(contactInfo.contains(emailAddress));
        driver.findElement(By.xpath("//h3[text()='Contact Information']/following-sibling::a")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname")).getDomAttribute("value"),firstname);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#lastname")).getDomAttribute("value"),lastname);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#email")).getDomAttribute("value"),emailAddress);

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.cssSelector("img#product-collection-image-2")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();

        driver.findElement(By.xpath("//input[@value='4']")).click();
        driver.findElement(By.cssSelector("div[class='input-box'] textarea")).sendKeys("1");
        driver.findElement(By.cssSelector("input#summary_field")).sendKeys("2");
        driver.findElement(By.cssSelector("input#nickname_field")).sendKeys(fullname);
        driver.findElement(By.xpath("//button[@title='Submit Review']")).click();

        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Your review has been accepted for moderation.']")).getText(),"Your review has been accepted for moderation.");
    }

    @Test
    public void TC02_(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.findElement(By.cssSelector("a[class='oxd-main-menu-item']")).click();
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("");
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getText(),"");
    }
}
