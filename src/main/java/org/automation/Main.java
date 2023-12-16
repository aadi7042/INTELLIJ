package org.automation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.lang.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        TestCase1_Navigate(driver);
        Windowhandling(driver);
        radio_checkbox(driver);
        select_class(driver);
        Actions_Class(driver);
        driver.quit();

    }

    static void TestCase1_Navigate(WebDriver driver) throws InterruptedException {
        driver.navigate().to("https://www.amazon.com");
        driver.navigate().to("https://www.Google.com");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().refresh();
        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);

    }

    static void Windowhandling(WebDriver driver) {
        driver.get("https://www.w3schools.com/tags/tag_a.asp");
        String getwindowhandle1 = driver.getWindowHandle();
        System.out.println(getwindowhandle1);
        driver.findElement(By.cssSelector("div.w3-main.w3-light-grey:nth-child(10) div.w3-row.w3-white:nth-child(1) div.w3-col.l10.m12:nth-child(1) div.w3-example:nth-child(5) > a.w3-btn.w3-margin-bottom:nth-child(4)")).click();
        Set<String> s1 = driver.getWindowHandles();
        for (String s : s1) {
            System.out.println(s);
            driver.switchTo().window(getwindowhandle1);
        }

    }

    static void radio_checkbox(WebDriver driver) {
        driver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");
        boolean displayed = driver.findElement(By.xpath("//h3[contains(text(),'Check box and Radio buttons')]")).isDisplayed();
        System.out.println("displayed= " + displayed);
        boolean enabled = driver.findElement(By.xpath("//h3[contains(text(),'Check box and Radio buttons')]")).isEnabled();
        System.out.println("enabled= " + enabled);
        boolean selected = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/input[2]")).isSelected();
        System.out.println("selected= " + selected + " ,performing select on radio");
        driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/input[2]")).click();
        boolean selected2 = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/input[2]")).isSelected();
        System.out.println("selected= " + selected2);
        //you  can use same method for checkbox as well


    }

    static void select_class(WebDriver driver) {
        driver.get("https://www.Amazon.com");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(element);
        select.selectByVisibleText("Baby");
        select.selectByVisibleText("Books");


    }

    static void Actions_Class(WebDriver driver) throws InterruptedException {
        driver.get("https://www.Youtube.com");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("paint the town red");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div.style-scope.ytd-app:nth-child(7) div.style-scope.ytd-app:nth-child(1) ytd-masthead.masthead-finish div.style-scope.ytd-masthead:nth-child(5) div.style-scope.ytd-masthead:nth-child(2) ytd-searchbox.style-scope.ytd-masthead:nth-child(1) button.style-scope.ytd-searchbox:nth-child(2) yt-icon.style-scope.ytd-searchbox:nth-child(1) yt-icon-shape.style-scope.yt-icon icon-shape.yt-spec-icon-shape > div:nth-child(1)")).click();
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//body/ytd-app[1]/div[1]/ytd-page-manager[1]/ytd-search[1]/div[1]/ytd-two-column-search-results-renderer[1]/div[1]/ytd-section-list-renderer[1]/div[2]/ytd-item-section-renderer[1]/div[3]/ytd-video-renderer[1]/div[1]/div[1]/div[1]/div[1]/h3[1]/a[1]/yt-formatted-string[1]"));
        System.out.println(element.getLocation().getX() + " ");
        System.out.println(element.getLocation().getY());
        actions.keyDown(element, Keys.ENTER).build().perform();
        Thread.sleep(30000);


    }


}