package Business;

import ExtentRepository.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


import java.util.List;


public class Actions extends BusinessFunctions{

    public static WebElement getElement(By path, String locatorName){
        WebElement element = null;
        try {
            element =  driver.findElement(path);
            ExtentTestManager.getTest().log(LogStatus.PASS, "Get element " + locatorName);
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to locate element " + locatorName);
            e.printStackTrace();
            throw e;
        }
        return element;
    }

    public static List<WebElement> getElements(By path, String locatorName){

        List<WebElement> list = null;
        try {
            list = driver.findElements(path);
            ExtentTestManager.getTest().log(LogStatus.PASS, "Find elements in " + locatorName);
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed find elements in " + locatorName);
            e.printStackTrace();
            throw e;
        }
        return list;
    }
    
    public static String getText(By path, String locatorName){
        String text = null;
        try {
            text = getElement(path, locatorName).getText();
            ExtentTestManager.getTest().log(LogStatus.PASS, "Read text from " + locatorName);
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to read text from " + locatorName);
            e.printStackTrace();
            throw e;
        }

        return text;
    }

    public static String setText(By path, String text, String locatorName){
        String getText = null;
        try {
            getElement(path, locatorName).sendKeys(text);
            getText = getElement(path, locatorName).getText();
            if(text.equals(getText))
                ExtentTestManager.getTest().log(LogStatus.PASS, "Entered '"+text+"' in " + locatorName);
            else
                ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to entered '"+text+"' in " + locatorName);
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to entered '"+text+"' in " + locatorName);
            e.printStackTrace();
            throw e;
        }

        return text;
    }

    public static String setTextValue(By path, String text, String locatorName){
        String getText = null;
        try {
            getElement(path, locatorName).sendKeys(text);
            getText = getElement(path, locatorName).getAttribute("value");
            if(text.equals(getText))
                ExtentTestManager.getTest().log(LogStatus.PASS, "Entered '"+text+"' in " + locatorName);
            else
                ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to entered '"+text+" ---> "+getText+"' in " + locatorName);
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to entered '"+text+"' in " + locatorName);
            e.printStackTrace();
            throw e;
        }

        return text;
    }

    public static String getValue(By path, String locatorName){
        String value = null;
        try {
            value = getElement(path, locatorName).getAttribute("value");
            ExtentTestManager.getTest().log(LogStatus.PASS, "Read value attribute " + locatorName);
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to read value attribute " + locatorName);
            e.printStackTrace();
            throw e;
        }
        return value;
    }
    
    public static void selectByIndex(By path, int index, String locatorName) throws Exception{
        try {
            Select select = new Select(getElement(path, locatorName));
            select.selectByIndex(index);
            String selectedOption = select.getFirstSelectedOption().getText();
            String value = select.getOptions().get(index).getText();
            if (!value.equals(selectedOption))
                ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to select '"+index+"' index from " + locatorName);
            else
                ExtentTestManager.getTest().log(LogStatus.PASS, "Selected '"+index+"' index from " + locatorName);
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to select '"+index+"' index from " + locatorName);
            e.printStackTrace();
            throw e;
        }
    }
    public static void selectByValue(By path, String value, String locatorName){
        try{
        Select select = new Select(getElement(path, locatorName));
        select.selectByValue(value);
        ExtentTestManager.getTest().log(LogStatus.PASS, "Select '"+value+"' value from " + locatorName);
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to select '"+value+"' value from " + locatorName);
            e.printStackTrace();
            throw e;
        }
    }

    public static void selectByVisibleText(By path, String text, String locatorName) throws Exception{
        try{
        Select select = new Select(getElement(path, locatorName));
        select.selectByVisibleText(text);
        String selectedOption = new Select(getElement(path, locatorName)).getFirstSelectedOption().getText();
        if(!text.equals(selectedOption))
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to select '"+text+"' text from " + locatorName);
        else
            ExtentTestManager.getTest().log(LogStatus.PASS, "Selected '"+text+"' text from " + locatorName);
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to select '"+text+"' text from " + locatorName);
            e.printStackTrace();
            throw e;
        }
    }

    public static void click(By path, String locatorName){
        try {
            getElement(path, locatorName).click();
            ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked on " + locatorName);
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to click ("+path+") " + locatorName);
            e.printStackTrace();
            throw e;
        }
    }

    public static void acceptAlert(String locatorName){
        try {
            driver.switchTo().alert().accept();
            ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked Accept on " + locatorName);
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to click Accept on " + locatorName);
            e.printStackTrace();
            throw e;
        }
    }

    public static void alertDismiss(String locatorName){
        try {
            driver.switchTo().alert().dismiss();
            ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked Dismiss on " + locatorName);
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to click Dismiss on " + locatorName);
            e.printStackTrace();
            throw e;
        }
    }

    public static void setTextOnAlert(String text, String locatorName){
        try {
            Alert alert = driver.switchTo().alert();
            //alert.sendKeys(Keys.chord(Keys.CONTROL, Keys.BACK_SPACE));
            alert.sendKeys(text);
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to entered '"+text+"' on " + locatorName);
            e.printStackTrace();
            throw e;
        }
    }

    public static String verifyTextContains(By path, String text, String locatorName){
        String getText = null;
        try {
            getText = getElement(path, locatorName).getText();
            System.out.println("verifyTextContains() getText: "+getText);
            if(getText.contains(text))
                ExtentTestManager.getTest().log(LogStatus.PASS, "Contains '"+text+"' in " + locatorName);
            else
                ExtentTestManager.getTest().log(LogStatus.FAIL, "Not fount '"+text+"' in " + locatorName);
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Not found '"+text+"' in " + locatorName);
            e.printStackTrace();
            throw e;
        }

        return text;
    }


}
