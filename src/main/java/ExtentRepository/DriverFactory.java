package ExtentRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class DriverFactory {


    public static WebDriver createInstance(String browser) {



        if (browser.equals("chrome")) {

            WebDriver driver = new ChromeDriver(getChromeOptions());

            try {

            /*
                DesiredCapabilities cap = DesiredCapabilities.chrome();
                cap.setBrowserName("chrome");
                String Node = "http://10.250.63.5:4444/wd/hub";
                driver = new RemoteWebDriver(new URL(Node), cap);

                driver.manage().deleteAllCookies();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);*/
            }

            catch (Exception e) {
                e.printStackTrace();
            }
            return driver;
        }
        return null;
    }

    public static void killBrowserInstance(String browser) throws InterruptedException {
        try {


            if (browser.equals("chrome")) {

                if (OsUtils.isWindows()) {
                    Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
                }
                else {
                    Runtime.getRuntime().exec("killall \"chromedriver\"");
                    Runtime.getRuntime().exec("killall \"Google Chrome\"");
                }
            }

            Thread.sleep(1000);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ChromeOptions getChromeOptions() {
        if (OsUtils.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        }
        else {
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
        }

        String downLoadPath = System.getProperty("user.dir") + File.separator + "DownloadedFiles";

        HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory",downLoadPath);
        chromePrefs.put("profile.default_content_settings.popups", 0);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");

        options.addArguments("disable-infobars");
        options.setExperimentalOption("prefs", chromePrefs);
        //options.setHeadless(true);   //     or    options.addArguments("--headless");    enable this line to run the script without opening the web browser
        options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);

        return options;
    }



}
