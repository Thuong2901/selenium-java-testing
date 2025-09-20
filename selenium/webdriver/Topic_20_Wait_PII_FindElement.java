package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Topic_20_Wait_PII_FindElement {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void TC01_Find_Element(){
        driver.get("https://demo.nopcommerce.com/login");

        //1-Nếu tìm element có duy nhất 1 cái
        //Không cần chờ hết tổng thời gian là 10s
        //Chuyển qua action tiếp theo luôn

        System.out.println("Start wait:" + getDateTimeNow());
        driver.findElement(By.cssSelector("input#small-searchterms"));
        System.out.println("End wait:" + getDateTimeNow());

        //2- Nếu tìm element mà có nhiều hơn 1 cái
        //Không cần chờ hết tổng thời gian là 10s
        //Nó luôn lấy element đầu tiên để thao tác
        System.out.println("Start wait:" + getDateTimeNow());
        driver.findElement(By.cssSelector("input[type=email]"));
        System.out.println("End wait:" + getDateTimeNow());

        // 3 - Nếu như tìm element mà ko thấy
        // Sẽ cố gắng tìm đi tìm lại cứ mỗi nửa giây 1 lần
        // Nếu giữa chừng tìm thấy thì ko cần chờ hết thời gian còn lại
        // Nếu hết time mà ko tìm thấy thì show ra exception: NoSuchElement và đánh fail testcase tại vị trí code đó
        // Ko có chạy tiếp step tiếp theo/ còn lại nữa
        System.out.println("Start wait:" + getDateTimeNow());
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        System.out.println("End wait:" + getDateTimeNow());



    }

    @Test
    public void TC02_FindElements(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        List<WebElement> elementList = null;

        //1-Nếu tìm element có duy nhất 1 cái
        System.out.println("Start wait:" + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input#small-searchterms"));
        System.out.println("Tổng số lượng element trong list: "+ elementList.size());
        System.out.println("End wait:" + getDateTimeNow());

        //2- Nếu tìm element mà có nhiều hơn 1 cái
        System.out.println("Start wait:" + getDateTimeNow());
        elementList = driver.findElements(By.xpath("//a[@href]"));
        System.out.println("End wait:" + getDateTimeNow());
        System.out.println("Tổng số lượng element trong list: "+ elementList.size());
        for (WebElement element: elementList){
            System.out.println(element.getDomProperty("href"));
        }

        // 3 - Nếu như tìm element mà ko thấy
        System.out.println("Start wait:" + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input#FirstName"));
        System.out.println("Tổng số lượng element trong list: "+ elementList.size());
        System.out.println("End wait:" + getDateTimeNow());

        // Chờ hết timeout
        // Hết timeout ko tìm thấy thì ko đánh fail testcase
        // Sẽ trả về 1 List rỗng = 0

    }

    @Test
    public void TC03_Enique_Element(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.xpath("//a[@title='My Account']")).click();

    }

    @AfterClass
    public void afterClass(){
        //driver.quit();
    }
    private String getDateTimeNow(){
        return new Date().toString();
    }

}
