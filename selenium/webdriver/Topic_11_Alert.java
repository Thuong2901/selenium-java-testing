package webdriver;

import com.sun.net.httpserver.Headers;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class Topic_11_Alert {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @Test
    public void TC01_AcceptAlert() throws InterruptedException{

        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        //chờ alert đc presence
        //presence:có xuất hiện trong HTML(k bắt buộc hiển thị trên UI)
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());

        //hoặc viết như sau (k khai báo biến bên dưới nữa)
        //Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());

        //thao tác với alert
        //khai báo biến để gọi hàm alert dùng nhiều lần
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Alert");

        //accept Alert
        alert.accept();

        Assert.assertEquals(driver.findElement(By.cssSelector("p[id='result']")).getText(),"You clicked an alert successfully");



    }

    @Test
    public void TC02_ConfirmAlert() throws InterruptedException{
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.dismiss();

        Assert.assertEquals(driver.findElement(By.cssSelector("p[id='result']")).getText(),"You clicked: Cancel");



    }

    @Test
    public void TC_03_PromptAlert() {

        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS prompt");
        alert.sendKeys("hello");
        alert.accept();

        Assert.assertEquals(driver.findElement(By.cssSelector("p[id='result']")).getText(),"You entered: hello");



    }

    @Test
    public void TC_04_Alert() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//button[text()='Search']")).click();

        Thread.sleep(2000);

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(),"Please enter some search keyword");
        driver.switchTo().alert().accept();

        driver.findElement(By.cssSelector("input[id='small-searchterms']")).sendKeys("galaxy");
        driver.findElement(By.xpath("//button[text()='Search']")).click();

    }

    @Test
    public void TC_05_AuthenticationAlert() throws InterruptedException {
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        //http://username:pass@

        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='example']>p")).getText(),"Congratulations! You must have the proper credentials.");


    }

    @Test
    public void TC_06_AuthenticationAlert(){
        driver.get("http://the-internet.herokuapp.com/");

        //lấy url
        String url = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getDomProperty("href");
        String username = "admin";
        String pass = "admin";
        String[] urlArr = url.split("//");
        url = urlArr[0] +"//"+ username + ":" + pass + "@" + urlArr[1];
        driver.get(url);
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='example']>")).getText(),"Congratulations! You must have the proper credentials.");


    }

    /*@Test
    public void TC_07_(){
        driver.get("http://the-internet.herokuapp.com/");
        // Get DevTool object
        DevTools devTools = ((HasDevTools) driver).getDevTools();

        // Start new session
        devTools.createSession();

        // Enable the Network domain of devtools
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Encode username/ password
        Map<String, Object> headers = new HashMap<String, Object>();
        String basicAuthen = "Basic " + new String(new Base64().encode(String.format("%s:%s", "admin", "admin").getBytes()));
        headers.put("Authorization", basicAuthen);

        // Set to Header
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        driver.get("https://the-internet.herokuapp.com/basic_auth");

        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='example']>")).getText(),"Congratulations! You must have the proper credentials.");
    }*/



    @AfterClass
    public void afterclass(){
        driver.quit();
    }

}
