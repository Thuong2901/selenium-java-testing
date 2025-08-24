package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_10_Button_Checkbox_RadioButton {
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    Select select;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        jsExecutor = (JavascriptExecutor) driver;
    }
    @Test
    public void TC01_Fahasa() throws InterruptedException{

        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li[class='popup-login-tab-item popup-login-tab-login']")).click();

        By loginButton = By.cssSelector("button[class='fhs-btn-login']");
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());

        //in ra màu
        //cách 1
        /*String loginButtonColorRGBA = driver.findElement(loginButton).getCssValue("background-color");
        System.out.println(loginButtonColorRGBA);

        Color loginButtonColor = Color.fromString(loginButtonColorRGBA);
        String loginButtonColorHexa = loginButtonColor.asHex();
        Assert.assertEquals(loginButtonColorHexa,"#000000");*/

        //cách 2
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(),"#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("0372682548");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("Abcd@123");
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(),"#C92127");
    }

    @Test
    public void TC02_Rode() throws InterruptedException{

        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
        By leatherTrimCheckbox = By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input");
        By TowbarCheckbox = By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input");

        //click chọn
        if (!driver.findElement(dualZoneCheckbox).isSelected()){
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.id("demo-runner")));
            driver.findElement(dualZoneCheckbox).click();
        }
        //kiểm tra
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());

        //Disable + Selected
        Assert.assertFalse(driver.findElement(leatherTrimCheckbox).isEnabled());
        Assert.assertTrue(driver.findElement(leatherTrimCheckbox).isSelected());

        //Disable + De-Selected
        Assert.assertFalse(driver.findElement(TowbarCheckbox).isEnabled());
        Assert.assertFalse(driver.findElement(TowbarCheckbox).isSelected());

        driver.findElement(dualZoneCheckbox).click();
        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        By petrol = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        driver.findElement(petrol).click();

        //click bỏ chọn
        if (!driver.findElement(petrol).isSelected()) {
            driver.findElement(petrol).click();
        }

        Assert.assertTrue(driver.findElement(petrol).isSelected());

        if (!driver.findElement(TowbarCheckbox).isSelected()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("div.docs-example-viewer-body")));
            driver.findElement(TowbarCheckbox).click();
        }

        Assert.assertTrue(driver.findElement(TowbarCheckbox).isSelected());

        if (driver.findElement(leatherTrimCheckbox).isSelected()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("div.docs-example-viewer-body")));
            driver.findElement(leatherTrimCheckbox).click();
        }

        Assert.assertFalse(driver.findElement(leatherTrimCheckbox).isSelected());

        if (driver.findElement(TowbarCheckbox).isSelected()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("div.docs-example-viewer-body")));
            driver.findElement(TowbarCheckbox).click();
        }

        Assert.assertFalse(driver.findElement(TowbarCheckbox).isSelected());

    }

    @Test
    public void TC_03_checkboxAll() {
        driver.get("https://automationfc.github.io/multiple-fields/");

        List<WebElement> everhadCheckbox = driver.findElements(By.xpath(
                "//label[contains(text(),'Have you ever had')]/following-sibling::div//input[@type='checkbox']"));

        for (WebElement checkbox : everhadCheckbox) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
            Assert.assertTrue(checkbox.isSelected());
        }

        for (WebElement checkbox : everhadCheckbox) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
            Assert.assertFalse(checkbox.isSelected());
        }
        for (WebElement checkbox : everhadCheckbox) {
            if (!checkbox.isSelected() && checkbox.getDomAttribute("value").equals("Heart Attack")) {
                checkbox.click();
                break;
            }

            Assert.assertFalse(driver.findElement(By.xpath("//label[text()=' Heart Attack ']/preceding-sibling::input")).isSelected());
        }


    }

    @Test
    public void TC_04_ubuntuCustomCheckboxRadio() throws InterruptedException {
        driver.get("https://login.ubuntu.com/");
        By newUserRadio = By.cssSelector("input#id_new_user");
        By acceptToCheckbox = By.cssSelector("input#id_accept_tos");

        jsExecutor.executeScript("arguments[0].click();", driver.findElement(newUserRadio));
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(newUserRadio).isSelected());

        jsExecutor.executeScript("arguments[0].click();", driver.findElement(acceptToCheckbox));
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(acceptToCheckbox).isSelected());

    }

    @Test
    public void TC_05_googleCustomCheckboxRadio() throws InterruptedException {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");

        By canthoRadio = By.cssSelector("div[data-value='Cần Thơ']");
        By quangninhRadio = By.cssSelector("div[data-value='Quảng Ninh']");

        driver.findElement(canthoRadio).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(canthoRadio).getDomAttribute("aria-checked"),"true");

        driver.findElement(quangninhRadio).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(quangninhRadio).getDomAttribute("aria-checked"),"true");
    }


    @AfterClass
    public void afterclass(){
        driver.quit();
    }

}
