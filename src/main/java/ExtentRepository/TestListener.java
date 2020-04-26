package ExtentRepository;


import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

    private synchronized static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public synchronized void onStart(ITestContext iTestContext) {
        System.out.println("onStart method " + iTestContext.getName());
    }

    public synchronized void onFinish(ITestContext iTestContext) {
        System.out.println("onFinish method " + iTestContext.getName());

        //Do tear-down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();

        try {
            DriverFactory.killBrowserInstance(iTestContext.getCurrentXmlTest().getLocalParameters().get("browser"));
        }
        catch (InterruptedException ie) {
            ie.printStackTrace(System.out);
        }
    }

    public synchronized void onTestStart(ITestResult iTestResult) {

        //Start operation for extentreports.
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");

        DriverManager.removeDriver();
        DriverManager.setDriver(DriverFactory.createInstance(iTestResult.getTestContext().getCurrentXmlTest().getLocalParameters().get("browser")));

        //iTestResult.getTestContext().setAttribute("WebDriver", DriverManager.getDriver());
    }

    public synchronized void onTestSuccess(ITestResult iTestResult) {

        //Extentreports log operation for passed tests.
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");

        if (null != DriverManager.getDriver()) {
            DriverManager.getDriver().quit();
        }
    }

    public synchronized void onTestFailure(ITestResult iTestResult) {


               //Take base64Screenshot screenshot.
        String base64Screenshot = null;
        if (null != DriverManager.getDriver()) {
            base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
            DriverManager.getDriver().quit();
        }
        //Extentreports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().getRunStatus();
        ExtentTestManager.getTest().log(LogStatus.FAIL,String.valueOf(ExtentTestManager.getTest().getRunStatus()), ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));

    }

    public synchronized void onTestSkipped(ITestResult iTestResult) {
        System.out.println("onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");

        //Extentreports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");

        if (null != DriverManager.getDriver()) {
            DriverManager.getDriver().quit();
        }
    }

    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));

        if (null != DriverManager.getDriver()) {
            DriverManager.getDriver().quit();
        }
    }
}
