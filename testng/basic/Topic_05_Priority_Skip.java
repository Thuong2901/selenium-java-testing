package basic;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_05_Priority_Skip {
    @Test
    public void TC_01_Register(){
        System.out.println("Register new account");
    }

    @Test (description = "Testcase login")
    public void TC_02_Login(){
        System.out.println("Login to System");
    }

    @Test (enabled = false)
    public void TC_03_Order(){
        System.out.println("Order product");
    }

    @Test
    public void TC_04_Ship(){
        System.out.println("Ship product");
    }

}