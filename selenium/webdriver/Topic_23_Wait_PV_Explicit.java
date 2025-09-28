package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Topic_23_Wait_PV_Explicit {
    WebDriver driver;
    WebDriverWait explicitWait ;
    String uploadFilePath =System.getProperty("user.dir")+"\\UploadFiles\\";

    String catFile = "cat.jpg";
    String elephantFile = "elephant.jpg";
    String flowerFile = "flower.jpg";

    String catFilePath = uploadFilePath + catFile;
    String elephantFilePath = uploadFilePath + elephantFile;
    String flowerFilePath = uploadFilePath + flowerFile;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void TC01_Less() throws InterruptedException {

        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get("https://automationfc.github.io/dynamic-loading/");

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[id='start']>button"))).click();

        //chờ loading icon là invisible
        //1- Chờ cho step trước được hoàn thành rồi mới qua step sau (k quan tâm step sau làm gì)
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading"))));

        // Chờ cho text là visible
        //2- Sau khi step trước được bắt đầu  nó sẽ chờ cho 1 đối tượng của step sau xuất hiện không quan tâm step trước đã hoàn thành hay chưa
        Assert.assertEquals(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='finish']")))
                .getText(),"Hello World!");


    }

    @Test
    public void TC02_Ajax(){
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(30));

        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        //Chờ trong vòng 30s để Date Picker được hiển thị
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1")));

        //Wait cho text được xuất hiện trong vòng 30s
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),
                "No Selected Dates to display.")));

        //Wait cho element được phép click, sau đó click vào
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/a[text()='6']"))).click();

        //Wait cho loading icon biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(
                "div:not([style='display:none;'])>div.raDiv"))));

        //Wait cho text được cập nhật lên trang
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),
                "Saturday, September 6, 2025")));


    }

    @Test
    public void TC03_Upload() {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://gofile.io/?t=uploadFiles");

        //Chờ cho tất cả các loading icon biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(
                By.cssSelector("div.animate-spin")))));

        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")))
                .sendKeys(catFilePath+ "\n" + elephantFilePath + "\n" + flowerFilePath);

        //Chờ cho tất cả upload progressbar biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(
                By.cssSelector("div.file-progressbar")))));

        String uploadURL = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.linkSuccessCard"))).getDomProperty("href");
        driver.get(uploadURL);

        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(
                By.cssSelector("div.animate-spin")))));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'tem_open') and text()='"+ catFile+ "']")));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'tem_open') and text()='"+ elephantFile+ "']")));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'tem_open') and text()='"+ flowerFile+ "']")));

    }


        @AfterClass
    public void afterClass(){
        driver.quit();
    }


}
