package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.sound.sampled.Line;
import java.util.List;

public class Topic_14_Shadow_DOM {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new EdgeDriver();
    }
    @Test
    public void TC01_HomePage(){
        driver.get("https://shop.polymer-project.org/");

        WebElement shopAppShadowHost = driver.findElement(By.cssSelector("shop-app"));
        SearchContext shopAppShadowRoot = shopAppShadowHost.getShadowRoot();

        WebElement shopHomeShadowHost = shopAppShadowRoot.findElement(By.cssSelector("iron-pages>shop-home"));
        SearchContext shopHomeShadowRoot = shopHomeShadowHost.getShadowRoot();

        shopHomeShadowRoot.findElement(By.cssSelector("a[href*='mens_outerwear']~shop-button"));



    }

    @Test
    public void TC02_Nested(){
        driver.get("https://automationfc.github.io/shadow-dom/");

        //driver đang thao tác với DOM bên ngoài chưa vao Shadow Dom
        Assert.assertEquals(driver.findElement(By.xpath("//a")).getText(),"scroll.html");
        Assert.assertEquals(driver.findElements(By.xpath("//a")).size(),1);

        WebElement firstShadowHost = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext firstShadowRoot = firstShadowHost.getShadowRoot();

        //Đang thao tác với shadow Dom đầu tiên
        Assert.assertEquals(firstShadowRoot.findElement(By.cssSelector("span#shadow_content>span")).getText(),"some text");
        Assert.assertEquals(firstShadowRoot.findElements(By.cssSelector("a")).size(),1);
        Assert.assertEquals(firstShadowRoot.findElement(By.cssSelector("a")).getText(),"nested scroll.html");

        //switch qua
        WebElement secondShadowHost = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext secondShadowRoot = secondShadowHost.getShadowRoot();

        //Đang thao tác với shadow Dom thứ 2
        Assert.assertEquals(secondShadowRoot.findElement(By.cssSelector("div[id='nested_shadow_content']>div")).getText(),"nested text");
    }

    @Test
    public void TC03_Books() throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");
        Thread.sleep(3000);

        WebElement bookappShadowHost = driver.findElement(By.cssSelector("book-app"));
        SearchContext bookShadowRoot = bookappShadowHost.getShadowRoot();

        bookShadowRoot.findElement(By.cssSelector("book-input-decorator>input#input")).sendKeys("Harry Potter");

        WebElement bookDecoratorHost = bookShadowRoot.findElement(By.cssSelector("book-input-decorator"));
        SearchContext bookDecoratorShadowRoot = bookDecoratorHost.getShadowRoot();

        bookDecoratorShadowRoot.findElement(By.cssSelector("div.icon")).click();

        Thread.sleep(5000);

        bookappShadowHost = driver.findElement(By.cssSelector("book-app"));
        bookShadowRoot = bookappShadowHost.getShadowRoot();

        WebElement bookExploreShadowHost = bookShadowRoot.findElement(By.cssSelector("book-explore"));
        SearchContext bookExploreShadowRoot = bookExploreShadowHost.getShadowRoot();

        List<WebElement> listBookItems = bookExploreShadowRoot.findElements(By.cssSelector("sector>ul.books>li>book-item"));

        for (WebElement bookitem :listBookItems){
            SearchContext bookItemShadowRoot = bookitem.getShadowRoot();
            System.out.println(bookItemShadowRoot.findElement(By.cssSelector("div.title-container>h2.title")).getText());
        }
    }

        @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
