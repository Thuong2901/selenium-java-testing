package basic;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Topic_01_Annotations {
    @BeforeClass
    public void BeforeClass(){
        System.out.println("Before Class");
    }

    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("Before Suite");
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("Before Method");
    }

    @BeforeTest
    public void BeforeTest(){
        System.out.println("Before Test");
    }
}
