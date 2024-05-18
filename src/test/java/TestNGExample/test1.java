package TestNGExample;
import org.testng.annotations.*;

public class test1 {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){
        System.out.println("BeforeSuite");  
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest(){
        System.out.println("BeforeTest");  
    }

    @BeforeGroups(alwaysRun = true, groups = {"A"})
    public void beforeGroupsA(){
        System.out.println("BeforeGroupA");  
    }

    @BeforeGroups(alwaysRun = true, groups = {"B"})
    public void beforeGroupsB(){
        System.out.println("BeforeGroupB");  
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        System.out.println("BeforeClass");  
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        System.out.println("BeforeMethod");  
    }

    @Test(groups={ "A" }, enabled = true, successPercentage = 90,timeOut = 0)
    public void a(){
        System.out.println("a");
    }

    @Test(groups={"B"}, successPercentage = 5)
    public void b(){
        System.out.println("b");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        System.out.println("AfterMethod");  
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        System.out.println("AfterClass");  
    }

    @AfterGroups(alwaysRun = true)
    public void afterGroups(){
        System.out.println("AfterGroups");  
    }

    @AfterTest(alwaysRun = true)
    public void afterTest(){
        System.out.println("AfterTest");  
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        System.out.println("AfterSuite");  
    }
}
