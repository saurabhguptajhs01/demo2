package TestNGExample;

import org.testng.annotations.DataProvider;

public class testDataProvider {
    @DataProvider(name="create")
    public static Object[][] createData(){
        return new Object[][]{
            {"S1",35},
            {"V1",2}
        };
    }
}
