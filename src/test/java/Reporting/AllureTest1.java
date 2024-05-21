package Reporting;

import io.qameta.allure.Allure;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllureTest1 {
    @Test
    public void testAuthentication() {
        Allure.description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.");
        Allure.label("severity", "critical");
        Allure.label("owner", "John Doe");
        Allure.link("Website", "https://dev.example.com/");
        Allure.issue("AUTH-123", "https://example.com/issues/AUTH-123");
        Allure.tms("TMS-456", "https://example.com/tms/TMS-456");

        Allure.attachment("data.txt", "This is attachment");
        System.out.println(Paths.get("E:\\Edureka\\Code\\SelfPython\\Selenium\\demo2\\target"));
        try (InputStream is = Files.newInputStream(Paths.get("E:\\Edureka\\Code\\SelfPython\\Selenium\\demo2\\target\\img.png"))){
            System.out.println("try");
            Allure.attachment("img.png", is); 
            Allure.attachment("img.png", is); 
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
