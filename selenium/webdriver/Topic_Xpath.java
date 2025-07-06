package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_Xpath {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new EdgeDriver();
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
    }

    @Test
    public void TC01_attribute(){
        //attribute
        driver.findElement(By.xpath("//a[@class='logo']"));
        driver.findElement(By.xpath("//a[@title='Create an Account']"));
        driver.findElement(By.xpath("//a[@class='logo']"));
        driver.findElement(By.xpath("//a[@class='logo']"));

    }

    @Test
    public void TC02_function(){
        driver.findElement(By.xpath("//a[text()='Mobile']"));
        driver.findElement(By.xpath("//a[text()='Forgot Your Password?']"));
        driver.findElement(By.xpath("//a[text()='Site Map']"));

    }

    @Test
    public void TC03_Parent_node(){
        driver.findElement(By.xpath("//div[@id='header-account']//a[text()='My Account']"));
        driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'My Account')]"));
        driver.findElement(By.xpath("//button[@class='button']//span[text()='Subscribe']"));
        driver.findElement(By.xpath("//div[@class='input-box']//input[@type='email']"));

    }

    @Test
    public void TC04_contains(){
        driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'My Account')]"));
        driver.findElement(By.xpath("//p[contains(text(),'Registration is free and easy!')]"));

    }

    @Test
    public void TC05_starts_with(){

        driver.findElement(By.xpath("//li[starts-with(text(),'Save multipl')]"));
        driver.findElement(By.xpath("//p[starts-with(text(),'If you have an account')]"));
    }

    @Test
    public void TC06_and_or(){

        driver.findElement(By.xpath("//input[@type='email' and @title='Email Address']"));
        driver.findElement(By.xpath("//input[@type='email' and @id='newsletter']"));
        driver.findElement(By.xpath("//input[@type='email' or @id='newsletter']"));
        driver.findElement(By.xpath("//input[@type='email' or @title='Email Address']"));
    }
}
