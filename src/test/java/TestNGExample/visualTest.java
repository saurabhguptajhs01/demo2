package TestNGExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class visualTest {
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
    @AfterTest
    public void teardown(){
        driver.close();
        driver.quit();
    }
}
