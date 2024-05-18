package TestNGExample;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class TmpSuiteListener implements ISuiteListener{
    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Finishing");
    }

    @Override
    public void onStart(ISuite suite) {
        System.out.println("Starting");
    }
}
