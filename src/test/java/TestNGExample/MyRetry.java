package TestNGExample;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetry implements IRetryAnalyzer{
    private int retryCount = 0;
  private static final int maxRetryCount = 3;
  @Override
  public boolean retry(ITestResult result) {
    System.out.println("retry");
    System.out.println(result);
    if (retryCount < maxRetryCount) {
      retryCount++;
      return true;
    }
    return false;
  }

  
}
