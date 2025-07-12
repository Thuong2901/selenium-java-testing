package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_Css {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new EdgeDriver();
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
    }
    @Test
    public void TC01(){
        driver.findElement(By.cssSelector("[id='search']"));
        driver.findElement(By.cssSelector("[id='email']"));
        driver.findElement(By.cssSelector("#pass"));
        driver.findElement(By.cssSelector("#email"));
        driver.findElement(By.cssSelector("div[id='header-account'] a[title='My Account']"));
        driver.findElement(By.cssSelector("input[id='email'],[id='pass']"));
        driver.findElement(By.cssSelector("input[id='email'][id='email']"));
        driver.findElement(By.cssSelector("input:not([id='email'])"));
        driver.findElement(By.cssSelector("input:not([type='search'])"));
        driver.findElement(By.cssSelector("a[class *='button']"));
        driver.findElement(By.cssSelector("a[class ^='remember']"));
        driver.findElement(By.cssSelector("a[class $='button']"));

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
