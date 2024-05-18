package TestNGExample;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class test6 {
    public static WebDriver driver;

    @BeforeTest
    public WebDriver setup(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
    @Test(threadPoolSize = 3, invocationCount = 10)
    public void a() throws InterruptedException{
        driver.get("https://www.instagram.com/");
        System.out.println("a:"+driver.hashCode());
    }
    @Test
    public void b() throws InterruptedException{
        driver.get("https://www.facebook.com/");
        System.out.println("b:"+driver.hashCode());
    }
    @AfterTest
    public void teardown(){
        driver.close();
        driver.quit();
    }
}
