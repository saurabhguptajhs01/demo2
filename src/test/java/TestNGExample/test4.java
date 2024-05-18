package TestNGExample;

import org.testng.annotations.*;

public class test4 {
    @DataProvider(name="test4")
    public Object[][] createData(){
        return new Object[][]{
            {"Saurabh",34},
            {"Vayu",2}
        };
    }
    @Test(dataProvider = "create",dataProviderClass = testDataProvider.class)
    public void a(String name, Integer age){
        System.out.println(name +" "+age);
    }    
}
