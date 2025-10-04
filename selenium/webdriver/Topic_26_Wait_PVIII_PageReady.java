package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Topic_26_Wait_PVIII_PageReady {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void TC01(){
        driver.get("https://admin-demo.nopcommerce.com/login");

        driver.findElement(By.cssSelector("input.email")).clear();
        driver.findElement(By.cssSelector("input.email")).sendKeys("admin@yourstore.com");

        driver.findElement(By.cssSelector("input.password")).clear();
        driver.findElement(By.cssSelector("input.password")).sendKeys("admin");

        driver.findElement(By.cssSelector("button.login-button")).click();

        Assert.assertTrue(isAjaxBusyIconInvisible());

        driver.findElement(By.xpath("//li[@class='nav-item has-treeview']/a[@class='nav-link']/p[contains(string(),'Sales')]")).click();
        driver.findElement(By.xpath("//ul[@class='nav nav-treeview']/li[@class='nav-item']//p[contains(string(),' Orders')]")).click();

        Assert.assertTrue(isAjaxBusyIconInvisible());

        Assert.assertEquals(driver.findElement(By.cssSelector("div.content-header>h1")).getText(),"Orders");

    }

    public boolean isAjaxBusyLoadingInvisble(){
        WebDriverWait expicitWait = new WebDriverWait(driver,Duration.ofSeconds(30));
        return expicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ajaxBusy")));

    }

    private boolean isAjaxBusyIconInvisible(){
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        return fluentWait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return !driver.findElement(By.cssSelector("div#ajaxBusy")).isDisplayed();
            }
        });
    }

    // WebDriverWait
    public boolean isPageLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Điều kiện 1
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };

        // Điều kiện 2
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    // Fluent Wait
    public boolean isPageLoadSuccess() {
        FluentWait<WebDriver> fluentWait = new FluentWait(driver);
        fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(JavascriptException.class);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Điều kiện 1
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };

        // Điều kiện 2
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return fluentWait.until(jQueryLoad) && fluentWait.until(jsLoad);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
