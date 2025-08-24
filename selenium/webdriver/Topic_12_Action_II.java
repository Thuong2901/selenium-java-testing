package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Action_II {
    WebDriver driver;
    Actions actions;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        actions = new Actions(driver);
        jsExecutor = (JavascriptExecutor) driver;

    }
    @Test
    public void TC01_Click_And_Hover_Block() throws InterruptedException{

        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allItems = driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(allItems.size(),30);

        //Chọn từ 1-12
        actions.clickAndHold(allItems.getFirst()).moveToElement(allItems.get(11)).release().perform();

        //Verify đã chọn
        Assert.assertEquals(driver.findElements(By.cssSelector("ol#selectable>li.ui-selected")).size(),12);

    }

    @Test
    public void TC02_Click_And_Hover_Random() throws InterruptedException{
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allItems = driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(allItems.size(),30);

        //Nhấn Ctrl xuống (chưa nhả ra)
        actions.keyDown(Keys.CONTROL).perform();

        //Chọn 4,6,9,13,16,17,25,27,29,30
        actions.click(allItems.get(3))
                .click(allItems.get(5))
                .click(allItems.get(8))
                .click(allItems.get(12))
                .click(allItems.get(15))
                .click(allItems.get(16))
                .click(allItems.get(24))
                .click(allItems.get(26))
                .perform();

        //Nhả phím ctrl ra
        actions.keyUp(Keys.CONTROL).perform();

        Assert.assertEquals(driver.findElements(By.cssSelector("ol#selectable>li.ui-selected")).size(),8);


    }

    @Test
    public void TC_03_Double_Click(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        System.out.println(driver);
        if (driver.toString().contains("firefox")) {
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);",
                    driver.findElement(By.cssSelector("button[ondblclick='doubleClickMe()']")));
            actions.pause(Duration.ofSeconds(3)).perform();
        }

        actions.doubleClick(driver.findElement(By.cssSelector("button[ondblclick='doubleClickMe()']"))).perform();
        actions.pause(Duration.ofSeconds(2)).perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(),"Hello Automation Guys!");
    }

    @Test
    public void TC_04_Double_Click() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        //Quit context menu chưa hiển thị
        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());

        //Clik chuột phải
        actions.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
        actions.pause(Duration.ofSeconds(3)).perform();

        //Quit context menu hiển thị
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());

        //Hover vào menu Quit
        actions.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();
        actions.pause(Duration.ofSeconds(3)).perform();

        //Quit menu có thêm trạng thái hover
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-visible.context-menu-hover")).isDisplayed());

        //Click chuột vào Quit
        driver.findElement(By.xpath("//span[text()='Quit']")).click();

        //Accept Alert
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent()).accept();

        Thread.sleep(2000);
        //Quit context menu chưa hiển thị
        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());


    }

    @AfterClass
    public void afterclass(){
        driver.quit();
    }

}
