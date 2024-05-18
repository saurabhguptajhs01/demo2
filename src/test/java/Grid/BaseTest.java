package Grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    WebDriver driver;
   @Test
   public void a() throws MalformedURLException, InterruptedException{
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setCapability("browserName", "chrome");
    chromeOptions.setCapability("platformName", "Windows");
    // Showing a test name instead of the session id in the Grid UI
    chromeOptions.setCapability("se:name", "My simple test"); 
    // Other type of metadata can be seen in the Grid UI by clicking on the 
    // session info or via GraphQL
    chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value"); 
    WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.5:4444/"), chromeOptions);
    driver.get("http://www.google.com");
    Thread.sleep(30000);
    driver.quit();
   } 
   @Test
   public void b() throws MalformedURLException, InterruptedException{
    WebDriverManager.edgedriver().setup();
    driver = new EdgeDriver();
    EdgeOptions chromeOptions = new EdgeOptions();
    chromeOptions.setCapability("browserName", "edge");
    chromeOptions.setCapability("platformName", "Windows");
    // Showing a test name instead of the session id in the Grid UI
    chromeOptions.setCapability("se:name", "My simple test"); 
    // Other type of metadata can be seen in the Grid UI by clicking on the 
    // session info or via GraphQL
    chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value"); 
    WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.5:4444/"), chromeOptions);
    driver.get("http://www.google.com");
    Thread.sleep(30000);
    driver.quit();
   } 
}
