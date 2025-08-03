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

public class Topic_09_DropDown {
    WebDriver driver;
    Select select;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC01_DefaultDropDown() throws InterruptedException{

        driver.get("https://www.facebook.com/r.php?entry_point=login");
        select = new Select(driver.findElement(By.cssSelector("select[id='month']")));

        //Làm sao chọn 1 tháng bất kỳ trong month
        select.selectByIndex(3); //chọn tháng 4
        Thread.sleep(2000);
        select.selectByValue("8");
        Thread.sleep(2000);
        select.selectByVisibleText("Oct");
        Thread.sleep(2000);
        select.selectByContainsVisibleText("Ap"); //lấy 1 phần

        //chọn r làm sao biết đã chọn thành công
        //Assert.assertEquals(select.getFirstSelectedOption().getText(),"Apr");
        //kiểm tra có bao nhiêu item
        //select.getOptions().size(); //lấy ra tất cả số lượng item
        //kiểm tra xem có đúng số item k
        Assert.assertEquals(select.getOptions().size(),12);

        //kieemr tra có cho phép chọn nhiều k
        Assert.assertFalse(select.isMultiple());
        Thread.sleep(5000);

        select = new Select(driver.findElement(By.cssSelector("select[id='year']")));
        select.selectByIndex(20);
        Thread.sleep(2000);
        select.selectByVisibleText("1997");

    }

    @Test
    public void TC02_Rode() throws InterruptedException{

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
