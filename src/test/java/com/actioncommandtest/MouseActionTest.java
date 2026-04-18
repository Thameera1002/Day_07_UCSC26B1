package com.actioncommandtest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class MouseActionTest {

    @Test
    public void contextClickTest(){
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.testmuai.com/selenium-playground/context-menu/");
    }
}
