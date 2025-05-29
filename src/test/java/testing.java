import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class testing {
    WebDriver driver;

    @BeforeSuite
    public void setup() {

        System.out.println("This is before suite ");
    }

    @BeforeTest
    public Void beforetest() {
        System.out.println("this is before test");
        return null;
    }

    @BeforeClass
    public void beforeclass() {
        System.out.println("this is before class : SETTING UP WEBDRIVER");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new");
        //USE THE ABOVE TWO LINES FOR EXECUTION OF CASES WITHOUT GUI- No need to watch the gui (acha h)
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforemethod() {
        System.out.println("This is before method");
    }

    @Test()
    public void test1() throws InterruptedException {
        System.out.println("this is test case1");
        driver.get("https://www.Google.com");
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Google");
    }

    @Test
    public void test2() {
        System.out.println("this is test case 2");
        driver.get("https://www.Youtube.com");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "YouTube");
    }

    @AfterMethod
    public void aftermethod() {
        System.out.println("This is after method");
    }

    @AfterClass
    public void Afterclass() {
        System.out.println("this is After class : CLOSING WINDOWS");
        driver.close();
        driver.quit();

    }
    @AfterTest
    public Void Aftertest() {
        System.out.println("this is after test");
        return null;
    }

    @AfterSuite
    public void close() {
        System.out.println("this is After suite");

    }
}
