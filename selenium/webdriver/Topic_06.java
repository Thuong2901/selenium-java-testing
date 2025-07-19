package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_06 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver=new FirefoxDriver();
    }

    @Test
    public void TC01_Browser(){
        //truy cập trang web
        driver.get("https://live.techpanda.org/");

        driver.findElement(By.cssSelector("")).sendKeys("");

        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/login/");
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/create/");

        driver.getPageSource();
        Assert.assertTrue(driver.getPageSource().contains("Computer"));

        driver.getTitle();
        //trả id của tab/window sổ hiện tại
        driver.getWindowHandle();
        //trả về tất cả các tab/window
        driver.getWindowHandles();

        // mở rộng cửa sổ
        driver.manage().window().maximize();
        // thu nhỏ cửa sổ về dưới taskbar
        driver.manage().window().minimize();

        //full màn hình
        driver.manage().window().fullscreen();

        //set kích thước trình duyệt
        driver.manage().window().setSize(new Dimension(1920 ,1930));

        //lấy ra kicích thước của Browser bằng bao nhiêu
        driver.manage().window().getSize();

        driver.manage().window().setPosition(new Point(1,5));

        //lấy toạn độ của browser
        driver.manage().window().getPosition();
        //set cho việc tìm kiếm element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
        driver.manage().timeouts().getImplicitWaitTimeout();

        // áp dụng cho javascript Executor
        driver.manage().timeouts().scriptTimeout(Duration.ofMillis(400));
        driver.manage().timeouts().getScriptTimeout();

        // lấy cookie theo tên/xóa/lấy toàn bộ
        driver.manage().getCookies();

        driver.navigate().to("https://live.techpanda.org/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        //Alert

        //Window Tab

        //Frame /iFrame
        driver.switchTo().alert();
        driver.switchTo().window("");
        driver.switchTo().frame("");

    }

    @Test
    public void TC02_Element(){
        driver.get("https://live.techpanda.org/");
        //clickbutton
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.cssSelector("")).clear();
        driver.findElement(By.cssSelector("")).sendKeys("");
        driver.findElement(By.cssSelector("")).findElement(By.cssSelector(""));

        //Kiểm tra element enable /disable
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isEnabled());

        //Kiểm tra 1 element hiển thị hay không hiển thị
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isDisplayed());

        //Kiểm tra 1 element là được chọn hay chưa
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isSelected());

        //Lấy dữ liệu dang text của ca element : link/message/error/header..
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getText(),"Hello ");
        //lỗi thời -> thay thế bằng getDomAttribute
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getAttribute(""),"Hello ");
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getDomAttribute("class"),"input-text required-entry");

        //lấy giá trị thuộc tính DOM
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getDomProperty("value"),"Hello ");

        //lấy ra giá trị css
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getCssValue("back-ground-color"),"rgh()51,153,204");
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getCssValue("font-size"),"20px");
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getAccessibleName(),"");
        Dimension loginbuttonSize =driver.findElement(By.cssSelector("")).getSize();
        loginbuttonSize.getHeight();
        loginbuttonSize.getWidth();

        //lấy ra vị trí của element so với màn hình
        Point loginButtonLocation = driver.findElement(By.cssSelector("")).getLocation();
        loginButtonLocation.getX();
        loginButtonLocation.getY();

        Rectangle loginButtonRect = driver.findElement(By.cssSelector("")).getRect();
        loginButtonLocation.getY();

        driver.findElement(By.cssSelector("")).getTagName();

        //Handle shadow DOM
        driver.findElement(By.cssSelector("")).getShadowRoot();
        driver.findElement(By.cssSelector("")).submit();







    }
}

