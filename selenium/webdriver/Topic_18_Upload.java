package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_18_Upload {
    WebDriver driver;
    String uploadFilePath =System.getProperty("user.dir")+"\\UploadFiles\\";

    String catFile = "cat.jpg";
    String elephantFile = "elephant.jpg";
    String flowerFile = "flower.jpg";
    String skyFile = "sky.jpg";
    String fileOther = "elephant.webp";
    String fileOther1 = "image.gif";

    String catFilePath = uploadFilePath + catFile;
    String elephantFilePath = uploadFilePath + elephantFile;
    String flowerFilePath = uploadFilePath + flowerFile;
    String skyFilePath = uploadFilePath + skyFile;
    String OtherFilePath = uploadFilePath + fileOther;
    String Other1FilePath = uploadFilePath + fileOther1;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC01_Single_File() throws InterruptedException {

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadFileBy = By.cssSelector("input[type='file']");

        //Load file
        driver.findElement(uploadFileBy).sendKeys(catFilePath);
        driver.findElement(uploadFileBy).sendKeys(elephantFilePath);
        driver.findElement(uploadFileBy).sendKeys(flowerFilePath);


        //Verify file loaded
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ catFile +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ elephantFile +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ flowerFile +"']")).isDisplayed());

        //Upload file
        List<WebElement> startUploadButtons = driver.findElements(By.cssSelector("table button.start"));
        for (WebElement startButton : startUploadButtons){
            startButton.click();
            Thread.sleep(1000);
        }

        //Verify file upload
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ catFile +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ elephantFile +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+flowerFile + "']")).isDisplayed());

    }

    @Test
    public void TC_02_Multiple_File() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadFileBy = By.cssSelector("input[type='file']");

        //Load file
        driver.findElement(uploadFileBy).sendKeys(catFilePath+ "\n" + elephantFilePath + "\n"
                + flowerFilePath +"\n" + skyFilePath + "\n" + OtherFilePath +"\n" + Other1FilePath );


        //Verify file loaded
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ catFile +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ elephantFile +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ flowerFile +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ skyFile +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ fileOther + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ fileOther1 + "']")).isDisplayed());


        //Upload file
        List<WebElement> startUploadButtons = driver.findElements(By.cssSelector("table button.start"));
        for (WebElement startButton : startUploadButtons){
            startButton.click();
            Thread.sleep(1000);
        }

        //Verify file upload
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ catFile +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ elephantFile +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+flowerFile + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+skyFile + "']")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='name' and text()='elephant.webp']/following-sibling::strong")).getText(),"File type not allowed");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='name' and text()='image.gif']/following-sibling::strong")).getText(),"File is too large");

    }

    @Test
    public void TC_03_CreateAccount() {
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
