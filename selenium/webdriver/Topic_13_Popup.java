package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.Test;

import javax.sound.sampled.Line;
import java.time.Duration;
import java.util.List;

public class Topic_13_Popup {
    WebDriver driver;
    int shortTimeout = 3;
    int longTimeout = 15;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
        driver.manage().window().maximize();
    }
    @Test
    public void TC01_In_HTML() throws InterruptedException {

        driver.get("https://www.kmplayer.com/home");
        By popup = By.cssSelector("div[class='pop-container']");
        Thread.sleep(8000);

        //Nếu popup có hiển thị thì close đi
        //Nếu popup không hiển thị thì click vào FAQ

        if (driver.findElement(popup).isDisplayed()){
            System.out.println("==========Hiển thị popup==========");
            driver.findElement(By.cssSelector("div.close")).click();
            Thread.sleep(2000);

        }

        System.out.println("==========Không hiển thị popup==========");

        //Không còn hiển thị trước khi click vào FAQ
        Assert.assertFalse(driver.findElement(popup).isDisplayed());

        driver.findElement(By.xpath("//a[text()='FAQ']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='KMPlayer FAQ']")).isDisplayed());


    }

    @Test
    public void TC02_Not_In_HTML() throws InterruptedException {

        driver.get("https://tienganhcomaiphuong.vn/");
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        By popup = By.cssSelector("div.MuiPaper-root");
        driver.findElement(By.cssSelector("input[placeholder='Tài khoản đăng nhập']")).sendKeys("username");
        driver.findElement(By.cssSelector("input[placeholder='Mật khẩu']")).sendKeys("password");
        driver.findElement(By.xpath("//form//button[text()='Đăng nhập']")).click();

        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='notistack-snackbar']")).getText(),"Bạn đã nhập sai tài khoản hoặc mật khẩu!");

        driver.findElement(By.cssSelector("button[class*='close-btn']")).click();
        Thread.sleep(2000);

        //Verify popup không hiển thị
        //isDisplay() không kiểm tra cho 1 element không có trong html được

        //Khi xử lý các element k tồn tại trong html thì nên set lại time của implicit về 1 con số ngắn hơn
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertEquals(driver.findElements(popup).size(),0);
        //set trả về time ban đầu
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC03_Tiki() throws InterruptedException {

        driver.get("https://tiki.vn/");

        //là 1 popup dạng Random
        By bundlePopup = By.cssSelector("div#VIP_BUNDLE");

        //Nếu popup có hiển thị thì close đi => Click vào Đăng nhập/Đăng ký
        //Nếu popup không hiển thị thì Click vào Đăng nhập/Đăng ký
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(shortTimeout));
        List<WebElement> bundlePopupElements = driver.findElements(bundlePopup);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));

        if (bundlePopupElements.size()>0 && bundlePopupElements.get(0).isDisplayed()){
            System.out.println("======Hiển thị========");
            //Close đi
            driver.findElement(By.cssSelector("img[alt='close-icon']")).click();
            Thread.sleep(1500);
        }
        System.out.println("======Không hiển thị========");

        //Click vào đăng nhập/đăng ký
        driver.findElement(By.xpath("//span[text()='Tài khoản']")).click();
        Thread.sleep(1500);

        //Là 1 popup dạng fix cứng
        By loginPopup = By.cssSelector("div[class*='ReactModal__Content']");
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.cssSelector("p[class='login-with-email']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Email không được để trống']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Mật khẩu không được để trống']")).isDisplayed());

        driver.findElement(By.cssSelector("button>img.close-img")).click();

        //Verify nó đang hiển thị
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(shortTimeout));
        Assert.assertEquals(driver.findElements(loginPopup).size(),0);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
