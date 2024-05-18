package TestNGExample;

import org.testng.annotations.*;

public class test2 {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite2(){
        System.out.println("beforeSuite2");
    }

    @BeforeGroups(alwaysRun = true)
    public void beforeGroup2(){
        System.out.println("beforeGroup2");
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest2(){
        System.out.println("beforeTest2");
    }

    @Test(groups = {"A"})
    public void a2(){
        System.out.println("a2");
    }
    @Test(groups = {"B"})
    public void b2(){
        System.out.println("b2");
    }
    @AfterTest(alwaysRun = true)
    public void afterTest2(){
        System.out.println("afterTest2");
    }
    @AfterGroups(alwaysRun = true)
    public void afterGroup2(){
        System.out.println("afterGroup2");
    }
    @AfterSuite(alwaysRun = true)
    public void afterSuite2(){
        System.out.println("afterSuite2");
    }
}
