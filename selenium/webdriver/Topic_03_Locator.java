package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Locator {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
    }
    @Test
    public void TC01_ID() {
        driver.findElement(By.id("email"));
        driver.findElement(By.id("search"));
    }

    @Test
    public void TC02_Class(){
    driver.findElement(By.className("validate-password"));
    driver.findElement(By.className("validate-email"));
    driver.findElement(By.className("email"));

    }

    @Test
    public void TC03_Name(){
    driver.findElement(By.name("login[username]"));
    driver.findElement(By.name("login[password]"));
    driver.findElement(By.name("send"));
    }

    @Test
    public void TC04_TagName(){
        //Tìm ra bao nhiêu thẻ html giống nhau
    int inputNumber = driver.findElements(By.tagName("input")).size();
        System.out.println(inputNumber);
    }

    @Test
    public void TC05_LinkText(){
        driver.findElement(By.linkText("MY ACCOUNT"));
        driver.findElement(By.linkText("ORDERS AND RETURNS"));
        driver.findElement(By.linkText("CUSTOMER SERVICE"));

    }
    @Test
    public void TC06_PartialLinkText(){
        driver.findElement(By.partialLinkText("ACCOUNT"));
        driver.findElement(By.partialLinkText("AND RETURNS"));
        driver.findElement(By.partialLinkText("SERVICE"));

    }
    @Test
    public void TC07_Css(){
    // CSS với ID
        driver.findElement(By.cssSelector("input[id='email']"));
        driver.findElement(By.cssSelector("#email"));
        driver.findElement(By.cssSelector("input#email"));

        //css với class
        driver.findElement(By.cssSelector("div[class='account-login']"));
        driver.findElement(By.cssSelector(".account-login"));
        driver.findElement(By.cssSelector("div.account-login"));
        driver.findElement(By.cssSelector("div[class='buttons-set']"));
        driver.findElement(By.cssSelector("div[class='content fieldset']"));

        //Css với name
        driver.findElement(By.cssSelector("input[name='login[username]']"));
        driver.findElement(By.cssSelector("input[name='login[password]']"));
        //Css với Tagname
        driver.findElement(By.cssSelector("input"));
        //Css với link
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/customer/account/']"));
        //Css với Partiallink
        driver.findElement(By.cssSelector("a[href*='/customer/account/']"));
    }
    @Test
    public void TC08_Xpath(){
        //Xpath với id
        driver.findElement(By.xpath("//input[@id='email']"));

        //Xpath với class
        driver.findElement(By.xpath("//div[@class='account-login']"));
       //Xpath với name
        driver.findElement(By.xpath("//input[@name='login[username]']"));
        driver.findElement(By.xpath("//input[@name='login[password]']"));

        //Xpath với Tagname
        driver.findElement(By.xpath("//input"));
        //Xpath với link
        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/customer/account/']"));
        driver.findElement(By.xpath("//a[text()='My Account']"));

        //Xpath với Partiallink
        driver.findElement(By.xpath("//a[contains(@href,'customer/account')]"));
        driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
    }
    @AfterClass
    public void afterclass(){
        driver.quit();
    }
}

