package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_05_Register {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
    }
    @Test
    public void TC01_Empty() throws InterruptedException {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("button[class='btn_pink_sm fs16']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label[id='txtFirstname-error']")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.cssSelector("label[id='txtEmail-error']")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.cssSelector("label[id='txtCEmail-error']")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.cssSelector("label[id='txtPassword-error']")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.cssSelector("label[id='txtCPassword-error']")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.cssSelector("label[id='txtPhone-error']")).getText(),"Vui lòng nhập số điện thoại.");
        Thread.sleep(10000);

    }

    @Test
    public void TC02_Invalid_Email() throws InterruptedException {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("pham thuong");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("123444");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("123444");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0372682548");
        driver.findElement(By.cssSelector("button[class='btn_pink_sm fs16']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label[id='txtEmail-error']")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.cssSelector("label[id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");
        Thread.sleep(10000);
    }
    @Test
    public void TC03_Invalid_ConfirmEmail() throws InterruptedException {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("pham thuong");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("thuongpt@gmail.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("123444");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0372682548");
        driver.findElement(By.cssSelector("button[class='btn_pink_sm fs16']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label[id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");
        Thread.sleep(10000);
    }

    @Test
    public void TC04_Invalid_Password() throws InterruptedException {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("pham thuong");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("thuongpt@gmail.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("thuongpt@gmail.com");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("1234");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("1234");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0372682548");
        driver.findElement(By.cssSelector("button[class='btn_pink_sm fs16']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label[id='txtPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.cssSelector("label[id='txtCPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Thread.sleep(10000);
    }

    @Test
    public void TC04_Invalid_ConfirmPassword() throws InterruptedException {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("pham thuong");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("thuongpt@gmail.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("thuongpt@gmail.com");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123465");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0372682548");
        driver.findElement(By.cssSelector("button[class='btn_pink_sm fs16']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label[id='txtCPassword-error']")).getText(),"Mật khẩu bạn nhập không khớp");
        Thread.sleep(10000);
    }

    @Test
    public void TC04_Invalid_Phone() throws InterruptedException {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("pham thuong");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("thuongpt@gmail.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("thuongpt@gmail.com");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("037268254891");
        driver.findElement(By.cssSelector("button[class='btn_pink_sm fs16']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label[id='txtPhone-error']")).getText(),"Số điện thoại phải từ 10-11 số.");
        driver.findElement(By.cssSelector("input#txtPhone")).clear();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("123456");
        Assert.assertEquals(driver.findElement(By.cssSelector("label[id='txtPhone-error']"))
                .getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");

    }
}
