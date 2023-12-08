package org.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        TestCase1(driver);
        //TestCase2(driver);
        //TestCase3(driver);
        //TestCase4(driver);
        //TestCase5(driver);
        driver.quit();


    }

    static void TestCase1(WebDriver driver) {
        driver.get("https://www.Google.com");
        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);

    }

    static void TestCase2(WebDriver driver) {
        driver.get("https://www.namecheap.com");
        String getFullPageSource = driver.getPageSource();
        //System.out.println(getFullPageSource);

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