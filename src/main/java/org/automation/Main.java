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
        radio_checkbox(driver);
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

    static void radio_checkbox(WebDriver driver) {
        driver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");
        Boolean displayed= driver.findElement(By.xpath("//h3[contains(text(),'Check box and Radio buttons')]")).isDisplayed();
        System.out.println("displayed= "+displayed);
        Boolean enabled = driver.findElement(By.xpath("//h3[contains(text(),'Check box and Radio buttons')]")).isEnabled();
        System.out.println("enabled= "+enabled);
        Boolean selected= driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/input[2]")).isSelected();
        System.out.println("selected= "+selected +" ,performing select on radio");
        driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/input[2]")).click();
        boolean selected2=driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/input[2]")).isSelected();
        System.out.println("selected= "+selected2);
        //you  can use same method for checkbox as well


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