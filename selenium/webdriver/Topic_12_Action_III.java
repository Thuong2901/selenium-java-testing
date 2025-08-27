package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.dnd.DragGestureEvent;
import java.awt.event.InputEvent;
import java.io.*;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.List;

public class Topic_12_Action_III {
    WebDriver driver;
    Actions actions;
    String projectPath = System.getProperty("user.dir");
    String jQueryFilePath;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        actions = new Actions(driver);
        jQueryFilePath = projectPath +"\\dragAndDrop\\dragDrop.js" ;
        jsExecutor = (JavascriptExecutor) driver;

    }
    @Test
    public void TC01_Drag_And_Drop() throws InterruptedException, IOException {

        driver.get("https://automationfc.github.io/kendo-drag-drop/");


        WebElement sourceCircle = driver.findElement(By.cssSelector("div#draggable"));
        WebElement targetCircle = driver.findElement(By.cssSelector("div#droptarget"));

        actions.dragAndDrop(sourceCircle,targetCircle).perform();

        Assert.assertEquals(Color.fromString(targetCircle.getCssValue("background-color")).asHex().toUpperCase(),"#03A9F4");
        Assert.assertEquals(targetCircle.getText(),"You did great!");


    }

    @Test
    public void TC02_Drop_And_Drag_HLML5() throws InterruptedException, IOException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        String jQueryFileContent = getContentFile(jQueryFilePath);
        String sourceCss = "div#column-a";
        String targetCss = "div#column-b";

        jQueryFileContent = jQueryFileContent + "$(\"" + sourceCss + "\").simulateDragDrop({ dropTarget: \"" + targetCss + "\"});";
        jsExecutor.executeScript(jQueryFileContent);
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a")).getText(),"B");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b")).getText(),"A");

        jsExecutor.executeScript(jQueryFileContent);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"A");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"B");



    }

    @Test
    public void TC03_Drop_And_Drag_HLML5() throws InterruptedException, AWTException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        String sourceXpath = "//div[@id='column-a']";
        String targetXpath = "//div[@id='column-b']";

        dragAndDropHTML5ByXpath(sourceXpath,targetXpath);

        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a")).getText(),"B");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b")).getText(),"A");

        dragAndDropHTML5ByXpath(sourceXpath,targetXpath);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"A");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"B");



    }

    public void dragAndDropHTML5ByXpath(String sourceLocator, String targetLocator) throws AWTException {

        WebElement source = driver.findElement(By.xpath(sourceLocator));
        WebElement target = driver.findElement(By.xpath(targetLocator));

        // Setup robot
        Robot robot = new Robot();
        robot.setAutoDelay(500);

        // Get size of elements
        Dimension sourceSize = source.getSize();
        Dimension targetSize = target.getSize();

        // Get center distance
        int xCentreSource = sourceSize.width / 2;
        int yCentreSource = sourceSize.height / 2;
        int xCentreTarget = targetSize.width / 2;
        int yCentreTarget = targetSize.height / 2;

        Point sourceLocation = source.getLocation();
        Point targetLocation = target.getLocation();

        // Make Mouse coordinate center of element
        sourceLocation.x += 20 + xCentreSource;
        sourceLocation.y += 110 + yCentreSource;
        targetLocation.x += 20 + xCentreTarget;
        targetLocation.y += 110 + yCentreTarget;

        // Move mouse to drag from location
        robot.mouseMove(sourceLocation.x, sourceLocation.y);

        // Click and drag
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x, ((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);

        // Move to final position
        robot.mouseMove(targetLocation.x, targetLocation.y);

        // Drop
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    @Test
    public void TC_04_Double_Click() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");




    }
    public String getContentFile(String filePath) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(filePath);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
        }
    }

    @AfterClass
    public void afterclass(){
        driver.quit();
    }

}
