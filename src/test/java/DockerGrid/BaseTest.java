package DockerGrid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.input.Input;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
    public static String remote_url = "http://localhost:4444";
    public final static int TIMEOUT = 5;
    
    @BeforeSuite
    public void dockerStart() throws IOException, InterruptedException{
        String command = "powershell.exe docker-compose up";
        Process powerShellProcess = Runtime.getRuntime().exec(command);
        powerShellProcess.getOutputStream().close();
        Thread.sleep(60000);
        /*String line;
        System.out.println("Standard Output");
        BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
        */
        /*while((line = stdout.readLine()) != null){
            System.out.println(line);
        }
        stdout.close();*/
        /*
        System.out.println("Standard error");
        System.out.println("Standard Error:");
        BufferedReader stderr = new BufferedReader(new InputStreamReader(
            powerShellProcess.getErrorStream()));
        while ((line = stderr.readLine()) != null) {
        System.out.println(line);
        }
        stderr.close();*/
        System.out.println("Done");
    }
    
    @AfterSuite
    public void dockerEnd() throws IOException{
        String command = "powershell.exe docker-compose down";
        Process powerShellProcess = Runtime.getRuntime().exec(command);
        powerShellProcess.getOutputStream().close();
    }
    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) throws Exception {
        FirefoxOptions optionsF;
        ChromeOptions optionsC;
        if(browser.equals("firefox")){
            optionsF = new FirefoxOptions();
            optionsF.addArguments("--start-maximized");
            driver.set(new RemoteWebDriver(new URL(remote_url), optionsF));
            System.out.println("Browser Started : Firefox");
        }else if(browser.equals("chrome")){
            optionsC = new ChromeOptions();
            optionsC.addArguments("--start-maximized");
            driver.set(new RemoteWebDriver(new URL(remote_url), optionsC));
            System.out.println("Browser Started : Chrome");
        }
        
        driver.get().get("https://opensource-demo.orangehrmlive.com/");
        //driver.get().manage().timeouts().implicitlyWait(3000,Duration.ofSeconds(TIMEOUT));
        Thread.sleep(30000);
        }
 
 
    public WebDriver getDriver() {
        return driver.get();
    }
 
    @AfterMethod
    public  void closeBrowser() {
        driver.get().quit();
        driver.remove();
    } 
}
