package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_09_Custom_DropDown {
    WebDriver driver;
    Select select;
    @BeforeClass
    public void beforeClass(){

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC01() throws InterruptedException{

        driver.get("https://rode.com/en/support/where-to-buy");
        select = new Select(driver.findElement(By.cssSelector("select[id='country']")));
        Assert.assertFalse(select.isMultiple());
        select.selectByContainsVisibleText("Vietnam");
        driver.findElement(By.cssSelector("input[id='map_search_query']")).sendKeys("HO CHI MINH");
        driver.findElement(By.xpath("//button[text()='Search']")).click();
        Assert.assertEquals(driver.findElements(By
                .xpath("//h3[text()='Dealers']/following-sibling::div/div")).size(), 16);

        List<WebElement> dealers = driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div/div//h4"));

        for (WebElement element: dealers){
            System.out.println(element.getText());
        }



    }

    @AfterClass
    public void afterclass(){
        driver.quit();
    }

}
