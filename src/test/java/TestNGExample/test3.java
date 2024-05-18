package TestNGExample;

import org.testng.annotations.*;

public class test3 {
    @Parameters({"first-name", "last-name"})
    @Test
    public void a(@Optional("Saurabh") String firstName, @Optional("Omar") String lastName){
        System.out.println(firstName+" "+lastName);
    }
}
