package com.commandtest;

import com.reporter.ExtentReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleCommandTest {

    @BeforeClass
    public void beforeClass(){
        ExtentReporter.initReport();
    }

    @Test
    public void openTabbedWindow(){
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        ExtentReporter.createTest("openTabbedWindow");
        driver.get("https://demo.automationtesting.in/Windows.html");
        ExtentReporter.logInfo("Title :"+driver.getTitle());
        driver.findElement(By.xpath("//a[text()='Open New Tabbed Windows ']")).click();
        ExtentReporter.logPass("Clicked on : //a[text()='Open New Tabbed Windows ']");
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//button[contains(text(),'click')]")).click();
        ExtentReporter.logPass("Clicked on : //button[contains(text(),'click')]");
        Set<String> getAllWindows = driver.getWindowHandles();
        for (String window :
                getAllWindows) {
            if(!window.equalsIgnoreCase(parentWindow)){
                driver.switchTo().window(window);
                ExtentReporter.logPass("Switched to the window : "+window);
                break;
            }
        }
        ExtentReporter.logInfo("Title :"+driver.getTitle());

    }

    @AfterClass
    public void afterClass(){
        ExtentReporter.flushReport();
    }
}
