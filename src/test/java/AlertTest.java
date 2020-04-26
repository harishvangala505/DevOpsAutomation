
import ObjectRepository.AlertsObjects;
import org.testng.annotations.Test;

class AlertsTest extends AlertsObjects {

    @Test
    public void AlertsTest() throws Throwable{

        launchApplication(appURL);

        click(promptAlert, promptAlertLabel);

        setTextOnAlert(name, promptAlertLabel);

        acceptAlert(promptAlertLabel);

        verifyTextContains(promptText, name, promptAlertLabel);


        /*
        Thread.sleep(1000);
        click(promptAlert, "Prompt Alert");
        alertDismiss("Prompt Alert Box");


        click(sampleAlert, "Sample Alert Box");
        Thread.sleep(1000);
        acceptAlert("Sample Alert Box");
        Thread.sleep(1000);

        click(confirmationAlert, "Confirmation Alert");
        Thread.sleep(1000);
        acceptAlert("Confirmation Alert Box");

        Thread.sleep(1000);
        click(confirmationAlert, "Confirmation Alert");
        Thread.sleep(1000);
        alertDismiss("Confirmation Alert Box");
*/


    }


}
