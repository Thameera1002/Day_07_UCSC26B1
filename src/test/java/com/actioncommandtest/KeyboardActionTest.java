package com.actioncommandtest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class KeyboardActionTest {

    @Test
    public void copyAndPastTest() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys("Autotest User 1");
        driver.findElement(By.id("userEmail")).sendKeys("autotestmail@gmail.com");
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("ABCD EFGH IJKL MOP");
        Thread.sleep(3000);
        currentAddress.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        Thread.sleep(3000);
        currentAddress.sendKeys(Keys.chord(Keys.CONTROL,"c"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        currentAddress.sendKeys(Keys.TAB);
        Thread.sleep(3000);
        permanentAddress.sendKeys(Keys.chord(Keys.CONTROL,"v"));
        Thread.sleep(3000);
    }
}
