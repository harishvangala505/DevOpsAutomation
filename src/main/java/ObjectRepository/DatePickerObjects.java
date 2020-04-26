package ObjectRepository;

import Business.Actions;
import Business.BusinessFunctions;
import org.openqa.selenium.By;

public class DatePickerObjects extends Actions {



    private static By getXpath(String path){
        return By.xpath(path);
    }
    private static By getXpath(String path, String replaceText){
        return By.xpath(path.replaceAll("replaceMe", replaceText));
    }

    public static By dateField = By.id("datepicker");
    public static By monthSelect = By.className("ui-datepicker-month");
    public static By yearSelect = By.className("ui-datepicker-year");
    private static String dayPath = "//table[@class=\"ui-datepicker-calendar\"]//tr/td//a[text()='replaceMe']";

    public static By day(String day){
        return getXpath(dayPath, day);
    }


}
