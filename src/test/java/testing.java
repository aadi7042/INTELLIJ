import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.lang.*;

import org.testng.Assert;
import org.testng.annotations.*;
public class testing {
    WebDriver driver;
    @BeforeSuite
    public void setup() {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new");
        ////USE THE ABOVE TWO LINES FOR EXECUTION OF CASES WITHOUT GUI
         driver = new ChromeDriver();
        System.out.println("This is before suite : SETTING UP WEBDRIVER");
    }
    @BeforeTest
     public Void beforetest(){
        System.out.println("this is before test");
        return null;
    }
    @BeforeClass
    public void beforeclass(){
        System.out.println("this is before class");

    }
    @BeforeMethod
    public void beforemethod(){
        System.out.println("This is before method");
    }
    @Test()
    public void test1() throws InterruptedException{
        System.out.println("this is test case1");
        driver.get("https://www.Google.com");
        Thread.sleep(2000);
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Google");
    }
    @Test(dependsOnMethods = "test1")
    public void test2(){
        System.out.println("this is test case 2");
        driver.get("https://www.Youtube.com");
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"YouTube");
    }
    @AfterMethod
    public void aftermethod(){
        System.out.println("This is after method");
    }
    @AfterClass
    public void Afterclass(){
        System.out.println("this is After class");


    }
    @AfterTest
     public Void Aftertest(){
        System.out.println("this is after test");
        return null;
    }
    @AfterSuite
    public void close(){
        System.out.println("this is After suite: CLOSING WINDOWS");
        driver.close();
        driver.quit();
    }
}
