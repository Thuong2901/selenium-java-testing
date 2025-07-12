package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_Xpath {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new EdgeDriver();

    }

    @Test
    public void TC01_attribute(){
        //attribute
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.xpath("//a[@class='logo']"));
        driver.findElement(By.xpath("//a[@title='Create an Account']"));
        driver.findElement(By.xpath("//a[@class='logo']"));
        driver.findElement(By.xpath("//a[@class='logo']"));

    }

    @Test
    public void TC02_Function(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.xpath("//a[text()='Mobile']"));
        driver.findElement(By.xpath("//a[text()='Forgot Your Password?']"));
        driver.findElement(By.xpath("//a[text()='Site Map']"));

    }

    @Test
    public void TC03_Parent_node(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.xpath("//div[@id='header-account']//a[text()='My Account']"));
        driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'My Account')]"));
        driver.findElement(By.xpath("//button[@class='button']//span[text()='Subscribe']"));
        driver.findElement(By.xpath("//div[@class='input-box']//input[@type='email']"));

    }

    @Test
    public void TC04_Contains(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'My Account')]"));
        driver.findElement(By.xpath("//p[contains(text(),'Registration is free and easy!')]"));

    }

    @Test
    public void TC05_Starts_with(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.xpath("//li[starts-with(text(),'Save multipl')]"));
        driver.findElement(By.xpath("//p[starts-with(text(),'If you have an account')]"));
    }

    @Test
    public void TC06_And_Or(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.xpath("//input[@type='email' and @title='Email Address']"));
        driver.findElement(By.xpath("//input[@type='email' and @id='newsletter']"));
        driver.findElement(By.xpath("//input[@type='email' or @id='newsletter']"));
        driver.findElement(By.xpath("//input[@type='email' or @title='Email Address']"));
    }
    @Test
    public void TC07_Axes() {
        driver.get("https://live.techpanda.org/index.php/mobile.html");
        driver.findElement(By.xpath("//a[@title='IPhone']/parent::h2/following-sibling::div[@class='actions']/button"));
        driver.findElement(By.xpath("//a[@title='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']/button"));
        driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button"));


    }

    @Test
    public void TC08(){
        driver.get("https://subscription.packtpub.com/search?query=Selenium&products=Book%20%2B%20AI%20Assistant~Book&released=Available~Early%20Access");
        driver.findElement(By.xpath("//h2[text()='Kickstarter']/parent::div/following-sibling::a[@class='button is-black w-button']"));


    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
