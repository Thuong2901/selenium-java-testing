package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
import java.util.function.Function;

public class Topic_25_Wait_PVII_Fluent {
    WebDriver driver;
    WebDriverWait explicitWait ;
    FluentWait<WebDriver> fluentWait;
    FluentWait<WebElement> elementFluentWait;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        fluentWait = new FluentWait(driver);
        fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

    }


    @Test
    public void TC01()  {
        /*//Mặc định thời gian tìm element(polling /interval time) : 500ms =0.5s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Mặc định thời gian tìm element(polling /interval time) : 500ms =0.5s
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));

        //Custom thời gian tifm lại element(polling /interval time)
        //100ms tìm lại 1 lần = 1s sẽ tìm lại 10 lần
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15),Duration.ofMillis(100));
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15),Duration.ofSeconds(1));*/
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Cách 1
        /*WebElement startButton = fluentWait.until(new Function<WebDriver, WebElement >(){
            @Override
            public WebElement apply(WebDriver webDriver){
                return webDriver.findElement(By.cssSelector("div#start>button"));
            }
        });

        startButton.click();*/

        //Cách 2
        clickToElement("div#start>button");


        /*fluentWait.until(new Function<WebDriver, Boolean >(){
            @Override
            public Boolean apply(WebDriver driver){
                return driver.findElement(By.cssSelector("div#finish")).isDisplayed();
            }
        });*/

        //Cách 1
        /*String helloText = fluentWait.until(new Function<WebDriver, String >(){
            @Override
            public String apply(WebDriver webDriver){
                return webDriver.findElement(By.cssSelector("div#finish>h4")).getText();
            }
        });*/

        //cách 2
        String helloText = getElementText("div#finish>h4");

        Assert.assertEquals(helloText,"Hello World!");

    }

    @Test
    public void TC02()  {

        driver.get("https://automationfc.github.io/fluent-wait/");

        WebElement countdownElement = getElement("div[id='javascript_countdown_time']");
        elementFluentWait = new FluentWait<>(countdownElement);

        elementFluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        Assert.assertTrue(elementFluentWait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement webElement) {
                String text = webElement.getText();
                System.out.println("Text = " + text);
                return text.endsWith("00");
            }
        }));


    }
    @Test
    public void TC03_WebDriverWait() {

        driver.get("https://automationfc.github.io/fluent-wait/");

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='javascript_countdown_time' and text()='10:00:00']")));
    }


    private WebElement getElement(String cssLocator){
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);

        fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(new Function<WebDriver, WebElement>() {

            @Override
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.cssSelector(cssLocator));
            }
        });

        return null;
    }

    private void clickToElement(String cssLocator){
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);

        fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(new Function<WebDriver, WebElement>() {

            @Override
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.cssSelector(cssLocator));
            }
        }).click();

    }

    private String getElementText(String cssLocator){
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);

        return fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .until(new Function<WebDriver, WebElement>() {

            @Override
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.cssSelector(cssLocator));
            }
        }).getText();

    }

    private Boolean isElementDisplay(String cssLocator){
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);

        return fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .until(new Function<WebDriver, WebElement>() {

                    @Override
                    public WebElement apply(WebDriver driver){
                        return driver.findElement(By.cssSelector(cssLocator));
                    }
                }).isDisplayed();

    }

    private boolean waitVisible(String cssLocator){
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);

        return fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver input) {
                        return driver.findElement(By.cssSelector(cssLocator)).isDisplayed();
                    }
                });
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
