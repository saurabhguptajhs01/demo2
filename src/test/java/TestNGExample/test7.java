package TestNGExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestNGExample.SampleVisualiser.class})
public class test7 {
    public static WebDriver driver;

    @BeforeTest
    public WebDriver setup(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    @Test
    public void c() throws InterruptedException{
        driver.get("https://www.google.com/");
        System.out.println("c:"+driver.hashCode());
    }
    @Test
    public void d() throws InterruptedException{
        driver.get("https://www.microsoft.com/");
        System.out.println("d:"+driver.hashCode());
    }
    @Test
    public void e() throws InterruptedException{
       Assert.fail();
    }
    @AfterTest
    public void teardown(){
        driver.close();
        driver.quit();
    }
}
