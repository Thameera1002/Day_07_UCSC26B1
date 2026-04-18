package com.actioncommandtest;

import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseActionTest {

    @Test
    public void contextClickTest() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.testmuai.com/selenium-playground/context-menu/");
        Thread.sleep(3000);
        WebElement contextClickBox = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.contextClick(contextClickBox).perform();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test
    public void mouseHoverTest(){
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }
}
