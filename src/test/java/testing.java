import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
         driver = new ChromeDriver();
        System.out.println("This is before suite : SETTING UP WEBDRIVER");
    }
    @BeforeClass
    public void beforeclass(){
        driver = new ChromeDriver();

    }
    @BeforeMethod
    public void beforemethod(){
        System.out.println("This is before method");
    }
    @Test
    public void test1(){
        System.out.println("this is test case1");
        driver.get("https://www.amazon.com");
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Amazon.com. Spend less. Smile more.");
    }
    @Test()
    public void test2(){
        System.out.println("this is test case 2");
        driver.get("https://www.amazon.com");
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Amazon.com. Spend less. Smile more.");
    }
    @AfterMethod
    public void aftermethod(){
        System.out.println("This is after method");
    }
    @AfterClass
    public void Afterclass(){
        System.out.println("this is After class");

    }
    @AfterSuite
    public void close(){
        System.out.println("this is After suite: CLOSING WINDOWS");
        driver.close();
        driver.quit();
    }
}
