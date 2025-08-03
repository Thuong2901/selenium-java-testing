package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

import static org.openqa.selenium.By.xpath;

public class Topic_08_TextBox_TextAre {
    WebDriver driver;
    String firstname,lastname,fullname,emailAddress,password,employeeID,number,comment;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        firstname ="David3";
        lastname= "Muir3";
        fullname = firstname + " " + lastname;
        emailAddress ="David" + new Random().nextInt(9999)+ "@gmail.com";
        password = "123456a@";
        number= "123345543222";
        comment="comment";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

    }
    @Test
    public void TC01_TechPanda() throws InterruptedException {
        driver.get("https://live.techpanda.org/");
        driver.findElement(xpath("//div[@class='footer']//a[@title='My Account']")).click();

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstname);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastname);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);
        driver.findElement(By.cssSelector("button[title='Register']")).click();

        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.cssSelector("li[class='success-msg']")).getText(),"Thank you for registering with Main Website Store.");
        String contactInfo = driver.findElement(xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullname));
        Assert.assertTrue(contactInfo.contains(emailAddress));
        driver.findElement(xpath("//h3[text()='Contact Information']/following-sibling::a")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname")).getDomAttribute("value"),firstname);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#lastname")).getDomAttribute("value"),lastname);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#email")).getDomAttribute("value"),emailAddress);

        driver.findElement(xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.cssSelector("img#product-collection-image-2")).click();
        driver.findElement(xpath("//a[text()='Add Your Review']")).click();

        driver.findElement(xpath("//input[@value='4']")).click();
        driver.findElement(By.cssSelector("div[class='input-box'] textarea")).sendKeys("1");
        driver.findElement(By.cssSelector("input#summary_field")).sendKeys("2");
        driver.findElement(By.cssSelector("input#nickname_field")).sendKeys(fullname);
        driver.findElement(xpath("//button[@title='Submit Review']")).click();

        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(xpath("//span[text()='Your review has been accepted for moderation.']")).getText(),"Your review has been accepted for moderation.");
    }

    @Test
    public void TC02_OrangeHrmlive() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //Thread.sleep(5000);
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        //Chờ load xong các icon
        Assert.assertTrue(isLoadingIconDisplay());
        //hoặc dùng câu lệnh này
        /*Assert.assertTrue(new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions
                .invisibilityOfAllElements(driver.findElements(By.cssSelector("div[class='oxd-loading-spinner']")))));*/

        Assert.assertTrue(driver.findElement(xpath("//h6[text()='Dashboard']")).isDisplayed());
        driver.findElement(xpath("//span[text()='PIM']")).click();
        Assert.assertTrue(isLoadingIconDisplay());

        driver.findElement(xpath("//a[text()='Add Employee']")).click();
        Assert.assertTrue(isLoadingIconDisplay());
        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(firstname);
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(lastname);
        employeeID =driver.findElement(xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getDomProperty("value");
        System.out.println(employeeID);

        driver.findElement(By.cssSelector("span[class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
        Thread.sleep(2000);

        driver.findElement(xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys(emailAddress);
        driver.findElement(xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys(password);

        driver.findElement(xpath("//button[contains(string(),'Save')]"));

        Thread.sleep(5000);
        Assert.assertTrue(isLoadingIconDisplay());
        //Verify message success
        Assert.assertTrue(driver.findElement(xpath("//p[text()='Successfully Saved']")).isDisplayed());
        Assert.assertTrue(isLoadingIconDisplay());
        Assert.assertTrue(isLoadingIconDisplay());


        Assert.assertEquals(driver.findElement(By.cssSelector("input[name ='firstName']")).getDomProperty("value"),firstname);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name ='lastName']")).getDomProperty("value"),lastname);
        Assert.assertEquals(driver.findElement(xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getDomProperty("value"),employeeID);

        driver.findElement(xpath("//a[text()='Immigration']")).click();
        Assert.assertTrue(isLoadingIconDisplay());
        driver.findElement(xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button[contains(string(),Add)]")).click();

        driver.findElement(xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(number);
        driver.findElement(By.cssSelector("textarea[placeholder='Type Comments here']")).sendKeys(comment);
        driver.findElement(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
        Assert.assertTrue(isLoadingIconDisplay());
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(xpath("//p[text()='Successfully Saved']")).isDisplayed());

        Assert.assertTrue(isLoadingIconDisplay());
        Assert.assertTrue(isLoadingIconDisplay());

        driver.findElement(By.cssSelector("[class='oxd-icon bi-pencil-fill']"));
        Assert.assertTrue(isLoadingIconDisplay());
        Assert.assertEquals(driver.findElement(xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getDomProperty("value"),number);
        Assert.assertEquals(driver.findElement(By.cssSelector("textarea[placeholder='Type Comments here']")).getDomProperty("value"),comment);

        driver.findElement(xpath("//p[contains(string(),'Asanov Asanovich')]")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.cssSelector("input[name='username']")).clear();
        driver.findElement(By.cssSelector("input[name='password']")).clear();

        driver.findElement(By.cssSelector("input[name='fullname']")).sendKeys(fullname);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertTrue(isLoadingIconDisappear());

        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());
        driver.findElement(By.xpath("//span[text()='My Info']")).click();

        Assert.assertTrue(isLoadingIconDisappear());
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Personal Details']")).isDisplayed());

        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getDomProperty("value"),firstname);
        Assert.assertTrue(driver.findElement(By.cssSelector("input[name='firstName']")).isEnabled());
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getDomProperty("value"),lastname);
        Assert.assertTrue(driver.findElement(By.cssSelector("input[name='lastName']")).isEnabled());
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input"))
                .getDomProperty("value"),employeeID);
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).isEnabled());


        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Assert.assertTrue(isLoadingIconDisappear());
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']")).isDisplayed());
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-pencil-fill']/parent::button")).click();

        Assert.assertTrue(isLoadingIconDisappear());
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Edit Immigration']")).isDisplayed());

        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getDomProperty("value"),number);
        Assert.assertEquals(driver.findElement(By.cssSelector("textarea[placeholder='Type Comments here']")).getDomProperty("value"),comment);
    }

    private boolean isLoadingIconDisappear() {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .invisibilityOfAllElements(driver.findElement(By.cssSelector("div.oxd-loading-spinner"))));
    }

    private Boolean isLoadingIconDisplay() {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
                .invisibilityOfAllElements(driver.findElements(By.cssSelector("div[class='oxd-loading-spinner']"))));
    }

}
