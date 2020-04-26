package ExtentRepository;

import com.relevantcodes.extentreports.ExtentReports;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){

        SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
        dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("IST"));
        String currentDateTime = dateTimeInGMT.format(new Date());

        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            String fileSeparator = System.getProperty("file.separator");

            extent = new ExtentReports(workingDir + fileSeparator + "ExtentReports" + fileSeparator + "ExtentReportResults_"+currentDateTime+".html", true);
        }
        return extent;
    }
}
