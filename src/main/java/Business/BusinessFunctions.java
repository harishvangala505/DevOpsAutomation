package Business;

import ExtentRepository.DriverManager;
import ExtentRepository.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class BusinessFunctions {

    public static WebDriver driver = null;


    public static void launchApplication(String appURL){
      /*  String chromePath = System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();*/


        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get(appURL);
        waitForPageLoad();
        ExtentTestManager.getTest().log(LogStatus.PASS, "Launched URL" + appURL);

    }

    public static void waitForPageLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(pageLoadCondition);
    }

    public static void waitForVisibleOfElementLocated(By xPath, String locatorName){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xPath));
            ExtentTestManager.getTest().log(LogStatus.PASS,  "'"+locatorName+"' is visible");
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL,  "'"+locatorName+"' is not visible");
        }
    }

    public static void waitForInVisibleOfElementLocated(By xPath, String locatorName){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(xPath));
            ExtentTestManager.getTest().log(LogStatus.PASS,  "'"+locatorName+"' is invisible");
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL,  "'"+locatorName+"' is still visible");
        }
    }

    public void switchToiFrame(By xPath){
        driver.switchTo().frame(getElement(xPath));
    }


    public static WebElement getElement(By path){
        WebElement element = null;
        try {
            element =  driver.findElement(path);
        }catch (Exception e){

        }
        return element;
    }


}
