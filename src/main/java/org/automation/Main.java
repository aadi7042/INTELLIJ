package org.automation;
import java.util.concurrent.TimeUnit;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Main {
    public static void main(String[] args)  {

        WebDriver driver = new ChromeDriver();

        //TestCase1_Navigate(driver);
        //Windowhandling(driver);
        //TestCase3(driver);
        //TestCase4(driver);
        //TestCase5(driver);
        driver.quit();

    }

    static void TestCase1_Navigate(WebDriver driver) {
        driver.navigate().to("https://www.amazon.com");
        driver.navigate().to("https://www.Google.com");
        driver.navigate().back();
        driver.navigate().refresh();
        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);

    }

    static void Windowhandling(WebDriver driver) {
        driver.get("https://www.w3schools.com/tags/tag_a.asp");
        String getwindowhandle1 = driver.getWindowHandle();
        System.out.println(getwindowhandle1);
        driver.findElement(By.cssSelector("div.w3-main.w3-light-grey:nth-child(10) div.w3-row.w3-white:nth-child(1) div.w3-col.l10.m12:nth-child(1) div.w3-example:nth-child(5) > a.w3-btn.w3-margin-bottom:nth-child(4)")).click();
        Set<String> s1 =driver.getWindowHandles();
        for(String s: s1)
        {
            System.out.println(s);
            driver.switchTo().window(getwindowhandle1);
        }

    }

    static void TestCase3(WebDriver driver) {
        driver.get("https://www.namecheap.com");
        String getFullPageSource = driver.getPageSource();
        if(driver.getPageSource().contains("Search for your domain name"))
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");

        }


    }

    static void TestCase4(WebDriver driver) {
        driver.get("https://www.namecheap.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("domain-search-input")).sendKeys("sdet.to");
        driver.findElement(By.id("search-domain-btn")).click();

    }

    static void TestCase5(WebDriver driver) {
        driver.get("https://www.namecheap.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("domain-search-input")).sendKeys("sdet.to");
        driver.findElement(By.id("search-domain-btn")).click();
    }
}