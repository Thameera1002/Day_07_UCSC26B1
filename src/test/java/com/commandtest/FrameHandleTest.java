package com.commandtest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FrameHandleTest {

    @Test
    public void singleIframeTest() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.switchTo().frame("singleframe");
        driver.findElement(By.xpath("//input")).sendKeys("Test");
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
    }
}
