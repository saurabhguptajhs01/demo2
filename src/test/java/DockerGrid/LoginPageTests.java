package DockerGrid;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.TmsLink;
import io.qameta.allure.Step;
import static io.qameta.allure.SeverityLevel.*;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;

public class LoginPageTests extends BaseTest{
    By userName = By.name("username");
    By passWord = By.name("password");
    By loginBtn = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    By errorMessage = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p");
    By blankUsername = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span");
    
    @Test
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("Saurabh Gupta")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    @Step("Step-1")
    public void invalidCredentials() throws Exception {
        
        TakesScreenshot scrShot =((TakesScreenshot)getDriver());
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String path = Paths.get("").toAbsolutePath().toString();
        System.out.println("Working Directory = " + path);
        File DestFile=new File(path+"\\target\\img.png");
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
        Allure.attachment("data.txt", "This is attachment");
        try (InputStream is = Files.newInputStream(Paths.get(path+"\\target\\img.png"))){
            Allure.attachment("image.png", is);
        }

        getDriver().findElement(userName).sendKeys("1234");
        getDriver().findElement(passWord).sendKeys("12342");
        getDriver().findElement(loginBtn).click();
        String actualErrorMessage = getDriver().findElement(errorMessage).getText();
        System.out.println("Actual ErrorMessage :" + actualErrorMessage);
        assertEquals(actualErrorMessage,"Invalid credentials");


        
    }
 
    @Test
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("Saurabh Gupta")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    @Step("Step-2")
    public void blankUsername() {
 
        getDriver().findElement(userName).sendKeys("");
        getDriver().findElement(passWord).sendKeys("12342");
        getDriver().findElement(loginBtn).click();
        String actualErrorMessage = getDriver().findElement(blankUsername).getText();
        System.out.println("Actual ErrorMessage :" + actualErrorMessage);
        assertEquals(actualErrorMessage,"Required");
 
    }
}
