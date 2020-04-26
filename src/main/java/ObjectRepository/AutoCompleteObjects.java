package ObjectRepository;

import Business.Actions;
import Business.BusinessFunctions;
import org.openqa.selenium.By;

public class AutoCompleteObjects extends Actions {

    public static By birdsTextField = By.xpath("//input[@id='birds' and @class='ui-autocomplete-input']");
    public static By loading = By.xpath("//input[@id='birds' and @class='ui-autocomplete-input ui-autocomplete-loading']");

    public static By bird(String birdName){
        return By.xpath("//ul[@id='ui-id-1']//li/div[text()='"+birdName+"']");
    }
    public static By logText = By.xpath("//div[@id='log']/div");
    public static By autoCompleteIFrame = By.className("demo-frame");

}
