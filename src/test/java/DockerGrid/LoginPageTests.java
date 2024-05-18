package DockerGrid;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginPageTests extends BaseTest{
    By userName = By.name("username");
    By passWord = By.name("password");
    By loginBtn = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    By errorMessage = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p");
    By blankUsername = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span");
    
    @Test
    public void invalidCredentials() {
 
        getDriver().findElement(userName).sendKeys("1234");
        getDriver().findElement(passWord).sendKeys("12342");
        getDriver().findElement(loginBtn).click();
        String actualErrorMessage = getDriver().findElement(errorMessage).getText();
        System.out.println("Actual ErrorMessage :" + actualErrorMessage);
        assertEquals(actualErrorMessage,"Invalid credentials");
    }
 
    @Test
    public void blankUsername() {
 
        getDriver().findElement(userName).sendKeys("");
        getDriver().findElement(passWord).sendKeys("12342");
        getDriver().findElement(loginBtn).click();
        String actualErrorMessage = getDriver().findElement(blankUsername).getText();
        System.out.println("Actual ErrorMessage :" + actualErrorMessage);
        assertEquals(actualErrorMessage,"Required");
 
    }
}
