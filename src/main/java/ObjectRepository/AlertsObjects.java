package ObjectRepository;

import Business.Actions;
import Business.Prop;
import ExtentRepository.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AlertsObjects extends Actions {

    static Prop prop = Prop.getPropInstance();

    public static String appURL = prop.getProperty("alertAppURL"); //"https://www.seleniumeasy.com/test/javascript-alert-box-demo.html";

    public static By sampleAlert = By.xpath("//button[@class='btn btn-default' and text()='Click me!']");
    public static By confirmationAlert = By.xpath("//button[@class='btn btn-default btn-lg' and text()='Click me!']");
    public static By promptAlert = By.xpath("//button[@class='btn btn-default btn-lg' and text()='Click for Prompt Box']");
    public static By promptText = By.id("prompt-demo");


    public static String appURL2 = prop.getProperty("alertAppURL2");   //"https://www.hyrtutorials.com/p/alertsdemo.html";

    public static By sampleAlert2 = By.id("alertBox");
    public static By confirmationAlert2 = By.id("confirmBox");
    public static By promptAlert2 = By.id("promptBox");
    public static By promptText2 = By.id("output");

    public static String promptAlertLabel = prop.getProperty("promptAlert");
    public static String name = prop.getProperty("name");

}
