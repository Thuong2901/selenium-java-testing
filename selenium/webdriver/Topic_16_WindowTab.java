package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class Topic_16_WindowTab {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new EdgeDriver();

    }
    @Test
    public void TC01_Gitub()  {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        //lấy ra id hiện tại mà driver đang đúng ở đó
        String GithubWindowID = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInSecond(3);

        switchToWindowByID(GithubWindowID);

        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Automation Testing");
        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys(Keys.ENTER);
        sleepInSecond(3);

        String GoogleWindowID = driver.getWindowHandle();
        switchToWindowByID(GoogleWindowID);

        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        sleepInSecond(3);

        switchToWindowByTitle("Facebook");

        driver.findElement(By.cssSelector("input[id='email']")).sendKeys("thuongpt@gmail.com");
        driver.findElement(By.cssSelector("input[id='pass']")).sendKeys("123456a@");

        switchToWindowByTitle("Selenium WebDriver");

        sleepInSecond(3);

        driver.findElement(By.xpath("//a[text()='LAZADA']")).click();
        sleepInSecond(3);

        closeAllWindowWithoutParent(GithubWindowID);
    }

    @Test
    public void TC_02_TechPanda(){
        driver.get("https://live.techpanda.org/");

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[text()='IPhone']/parent::h2/" +
                "following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
        sleepInSecond(2);
        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/" +
                "following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
        sleepInSecond(2);

        driver.findElement(By.xpath("//button[@title='Compare']")).click();
        sleepInSecond(2);
        switchToWindowByTitle("Products Comparison List");

        //Click vào close button
        driver.findElement(By.xpath("//button[@title='Close Window']")).click();
        sleepInSecond(2);

        switchToWindowByTitle("Mobile");

        driver.findElement(By.cssSelector("input#search")).sendKeys("Iphone");
        sleepInSecond(2);

        driver.findElement(By.xpath("//a[text()='Clear All']")).click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(),"The comparison list was cleared.");

    }

    @Test
    public void TC_03_Cambridge() {
        driver.get("https://dictionary.cambridge.org/vi/");

        String homeWindowID = driver.getWindowHandle();
        driver.findElement(By.xpath("//header[@id='header']//span[text()='Đăng nhập']")).click();

        switchToWindowByTitle("Login");

        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("span[id*='login-form-loginID']")).getText(),"This field is required");
        Assert.assertEquals(driver.findElement(By.cssSelector("span[id*='login-form-password']")).getText(),"This field is required");

        closeAllWindowWithoutParent(homeWindowID);

        String Keyword = "Automation";
        driver.findElement(By.cssSelector("input[id='searchword']")).sendKeys("level");
        driver.findElement(By.cssSelector("input[id='searchword']")).sendKeys(Keys.ENTER);

        Assert.assertEquals(driver.findElement(By.cssSelector("//span[contains(@class,'uk')]/preceding-sibling::div[@class='di-title']/span/span")).getText(),Keyword);
    }

    @Test
    public void TC_04_Havard() {
        driver.get("https://courses.dce.harvard.edu/");

        String homePageID = driver.getWindowHandle();
        driver.findElement(By.cssSelector("a[data-action='login']")).click();
        sleepInSecond(4);

        switchToWindowByID(homePageID);

        driver.findElement(By.xpath("//h1[text()='DCE Login Portal']")).isDisplayed();

        closeAllWindowWithoutParent(homePageID);
        switchToWindowByTitle("DCE Course Search");

        Assert.assertTrue(driver.findElement(By.cssSelector("div.activescreen")).isDisplayed());

        driver.findElement(By.cssSelector("button[class*='button--cancel']")).click();
        sleepInSecond(2);

        driver.findElement(By.cssSelector("input[id='crit-keyword']")).sendKeys("Data Structures");
        new Select(driver.findElement(By.cssSelector("select#crit-srcdb"))).selectByVisibleText("Extension Fall Term 2025");
        new Select(driver.findElement(By.cssSelector("select#crit-session"))).selectByVisibleText("Any Part of Term");
        driver.findElement(By.cssSelector("button[id='search-button']")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("span.result__headline>span.result__title")).getText(),"Data Structures");


    }

    @Test
    public void TC_05_Selenium_4x() {
        //Trang user vào đăng ký tài khoản/mua hàng/thanh toán
        driver.get("https://demo.nopcommerce.com/");

        //Qua trang admin để kích hoạt tài khoản/verify đơn hàng /...
        //Tự driver sẽ swirch qua luôn, không cần dùng hàm switch ID
        driver.switchTo().newWindow(WindowType.TAB).get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");

        switchToWindowByTitle("Home page title");
        sleepInSecond(2);
    }

    private void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Duy nhất 2 tab/window
    private void switchToWindowByID(String windowID){
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs){
            if (!id.equals(windowID)){
                driver.switchTo().window(id);
                break;
            }
        }
    }

    //Cover luôn cả cách làm của switchID
    private void switchToWindowByTitle(String expectedPageTitle){
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs){
            driver.switchTo().window(id);
            sleepInSecond(1);
            if (driver.getTitle().contains(expectedPageTitle)){
                break;
            }
        }
    }

    private void closeAllWindowWithoutParent(String windowID){

        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs){
            if (!id.equals(windowID)){
                driver.switchTo().window(id);
                //Đóng tab/window của driver đang active
                driver.close();
            }
        }
        driver.switchTo().window(windowID);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
