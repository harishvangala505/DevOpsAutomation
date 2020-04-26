import ObjectRepository.AutoCompleteObjects;
import org.testng.annotations.Test;

public class AutoComplete extends AutoCompleteObjects {

    String birdName = "Wood Warbler";
    String appURL = "https://jqueryui.com/autocomplete/#remote";
    @Test
    public void AutoComplete() throws Throwable{

        launchApplication(appURL);

        switchToiFrame(autoCompleteIFrame);

        setTextValue(birdsTextField, birdName, "Bird Name");

        waitForVisibleOfElementLocated(loading, "Loading Image");

        waitForInVisibleOfElementLocated(loading, "Loading Image");
        Thread.sleep(1500);
        click(bird(birdName), "Bird Name");
        Thread.sleep(1500);
        verifyTextContains(logText,  birdName, "Log Text");
        Thread.sleep(3000);
    }

}
