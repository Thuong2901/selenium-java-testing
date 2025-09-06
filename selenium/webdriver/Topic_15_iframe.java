package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_15_iframe {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new EdgeDriver();
    }
    @Test
    public void TC01_WordPress(){
        driver.get("https://toidicodedao.com/");

    }

    @Test
    public void TC02_FormSite() {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        driver.findElement(By.cssSelector("div[id='imageTemplateContainer']>img")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='details__form-preview-wrapper' and contains(string(),'Interactive form loaded. Try filling out below.')]")).isDisplayed());

        //Switch vao iframe
        driver.switchTo().frame(driver.findElement(By.cssSelector("div[id='formTemplateContainer']>iframe")));
        new Select(driver.findElement(By.cssSelector("select[id='RESULT_RadioButton-2']"))).selectByVisibleText("Sophomore");
        new Select(driver.findElement(By.cssSelector("select[id='RESULT_RadioButton-3']"))).selectByVisibleText("West Dorm");
        driver.findElement(By.xpath("//label[text()='Male']")).click();

        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("a[title='Get this form']")).click();

    }

    @Test
    public void TC03_HDFC() throws InterruptedException {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");

        driver.switchTo().frame("login_page");

        driver.findElement(By.cssSelector("input[class='form-control text-muted']")).sendKeys("john");
        driver.findElement(By.cssSelector("a[class='btn btn-primary login-btn']")).click();

        Thread.sleep(4000);

        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("input[id='keyboard']")).sendKeys("john");
        driver.findElement(By.cssSelector("a[id='loginBtn']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("p[class='error-msg ng-binding ng-scope']")).getText(),"Customer ID/IPIN (Password) is invalid. Please try again.");


    }


        @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
