package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.By.xpath;

public class Topic_09_Custom_DropDown {
    WebDriver driver;
    Select select;
    @BeforeClass
    public void beforeClass(){

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC01_OrangeHRM() throws InterruptedException{

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //Thread.sleep(5000);
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertTrue(isLoadingIconDisplay());

        Assert.assertTrue(driver.findElement(xpath("//h6[text()='Dashboard']")).isDisplayed());
        driver.findElement(xpath("//span[text()='PIM']")).click();
        Assert.assertTrue(isLoadingIconDisplay());

        //chức năng dropdown và các hành vi tương ứng
        //chọn item là Administration trong dropdown Sub Unit
        SelectItemDropdown("Sub Unit", "Sub Unit","Administration");
        Thread.sleep(3000);

        //chọn item là Administration trong dropdown Employment Status
        SelectItemDropdown("Employment Status", "Employment Status","Full-Time Contract");
        Thread.sleep(3000);

        //chọn item là Past Employees Only trong dropdown Include
        SelectItemDropdown("Include", "Include","Past Employees Only");
        Thread.sleep(3000);

        //chọn item là Administration trong dropdown Job Title
        SelectItemDropdown("Job Title", "Job Title","Chief Financial Officer");

        //Verify dữ liệu đã chọn
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Sub Unit']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']"))
                .getText(),"Administration");

        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employment Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']"))
                .getText(),"Full-Time Contract");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Include']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']"))
                .getText(),"Past Employees Only");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Job Title']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']"))
                .getText(),"Chief Financial Officer");





    }

    @Test
    public void TC02_JQuery() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        SelectItemSelectableDropdown("//span[@id='speed-button']","//ul[@id='speed-menu']/li/div","Medium");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']/span[@class='ui-selectmenu-text']")).getText(),"Medium");

        SelectItemSelectableDropdown("//span[@id='speed-button']","//ul[@id='speed-menu']/li/div","Slower");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']/span[@class='ui-selectmenu-text']")).getText(),"Slower");

        SelectItemSelectableDropdown("//span[@id='speed-button']","//ul[@id='speed-menu']/li/div","Faster");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']/span[@class='ui-selectmenu-text']")).getText(),"Faster");

        SelectItemSelectableDropdown("//span[@id='number-button']","//ul[@id='number-menu']/li","5");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(),"5");

        SelectItemSelectableDropdown("//span[@id='salutation-button']","//ul[@id='salutation-menu']/li[@class='ui-menu-item']","Mrs.");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='salutation-button']/span[@class='ui-selectmenu-text']")).getText(),"Mrs.");

    }

    @Test
    public void TC03_ReactJS() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        SelectItemSelectableDropdown("//div[@class='ui fluid selection dropdown']","//div[@class='visible menu transition']/div/span","Jenny Hess");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ui fluid selection dropdown']")).getText(),"Stevie Feliciano");

        SelectItemSelectableDropdown("//div[@class='ui fluid selection dropdown']","//div[@class='visible menu transition']/div/span","Jenny Hess");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"Stevie Feliciano");

    }

    @Test
    public void TC04_VueJS() throws InterruptedException {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        SelectItemSelectableDropdown("//li[@class='dropdown-toggle']","//ul[@class='dropdown-menu']/li/a","Second Option");
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(),"Second Option");

        SelectItemSelectableDropdown("//li[@class='dropdown-toggle']","//ul[@class='dropdown-menu']/li/a","Third Option");
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(),"Third Option");

    }

    @Test
    public void TC05_Editable() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        SelectItemEditableDropdown("//input[@class='search']","//div[@class='visible menu transition']//span","American Samoa");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"American Samoa");

        SelectItemEditableDropdown("//input[@class='search']","//div[@class='visible menu transition']//span","Belize");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"Belize");

    }

    @Test
    public void TC06_FinPeace() throws InterruptedException {
        driver.get("https://sps.finpeace.vn/tools/sktccn");
        Thread.sleep(5000);
        SelectItemEditableDropdown("//input[@id='job_id']","//div[@id='married_status_list']/following-sibling::div[@class='rc-virtual-list']//div[@class='ant-select-item-option-content']","Chủ doanh nghiệp");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@title='Nghề nghiệp']/parent::div/following-sibling::div//span[@class='ant-select-selection-placeholder']")).getText(),"Chủ doanh nghiệp");

        SelectItemEditableDropdown("//input[@id='married_status']","//div[@id='job_id_list']/following-sibling::div[@class='rc-virtual-list']//div[@class='ant-select-item-option-content']","Kết hôn, chưa có con");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@title='Tình trạng hôn nhân']/parent::div/following-sibling::div//span[@class='ant-select-selection-placeholder']")).getText(),"Kết hôn, chưa có con");

        SelectItemEditableDropdown("//input[@id='gender']","//div[@id='gender_list']/following-sibling::div[@class='rc-virtual-list']//div[@class='ant-select-item-option-content']","Nữ");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@title='Giới tính']/parent::div/following-sibling::div//span[@class='ant-select-selection-item']")).getText(),"Nữ");
    }



    private void SelectItemEditableDropdown(String editableXpath, String childXpath, String expectedTextItem) throws InterruptedException {
        driver.findElement(By.xpath(editableXpath)).sendKeys(expectedTextItem);
        Thread.sleep(3000);
        List <WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath(childXpath)));

        for (WebElement temp : allItems){
            //String textItem = temp.getText();
            if(temp.getText().equals(expectedTextItem)){
                temp.click();
                Thread.sleep(5000);
                break;
            }
        }
    }
    private void SelectItemSelectableDropdown(String parentXpath, String childXpath, String expectedTextItem) throws InterruptedException {
        driver.findElement(By.xpath(parentXpath)).click();
        List <WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath(childXpath)));

        for (WebElement temp : allItems){
            //String textItem = temp.getText();
            if(temp.getText().equals(expectedTextItem)){
                temp.click();
                Thread.sleep(5000);
                break;
            }
        }
    }

    private void SelectItemDropdown(String parentLocator, String childLocator, String expectedTextItem) throws InterruptedException {
        //1.click vào element để dropdown xổ ra
        driver.findElement(By.xpath("//label[text()='"+parentLocator+"']"+"/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']")).click();

        //2.chờ cho các item trong dropdown đó được load ra hết

        //lưu tất cả item vào list element
        List <WebElement> allItem = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath("//label[text()='"+childLocator+"']"+ "/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span")));//chọn 1 locator đại diện cho tất cả các item bên trong
        //3.kiểm tra tất cả các item xem đâu là item cần chọn

        /*List <WebElement> allItem = driver.findElements(By.xpath("//label[text()='Job Title']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span"));*/
        //vòng lặp để duyệt qua hết các item đấy

        //4. nếu tìm thây thì click vào item đó
        for (WebElement temp : allItem){
            //get text của từng item ra
            String textItem = temp.getText();
            //kiểm tra text nào cần chọn và click
            //5.click vào r thì dropdown tự động close đi
            if(textItem.equals(expectedTextItem)){
                temp.click();
                Thread.sleep(5000);
                break;
            }
        }
    }

    private Boolean isLoadingIconDisplay() {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
                .invisibilityOfAllElements(driver.findElements(By.cssSelector("div[class='oxd-loading-spinner']"))));
    }


    @AfterClass
    public void afterclass(){
        driver.quit();
    }

}
