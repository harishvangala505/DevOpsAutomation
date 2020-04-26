
import ObjectRepository.DatePickerObjects;
import org.testng.annotations.Test;

public class DatePicker extends DatePickerObjects {



    static String day = "23";
    static String month = "Aug";
    static String year = "2025";


    @Test
    public void DatePicker() throws Throwable{


            launchApplication("https://jqueryui.com/resources/demos/datepicker/dropdown-month-year.html");

            click(dateField, "Date field");

            selectByVisibleText(monthSelect, month, "Moth dropdown");

            selectByVisibleText(yearSelect, year, "Year dropdown");

            click(day(day), "Day");

            String selectedDate = getValue(dateField, "Date field");
            System.out.println("selectedDate: " + selectedDate);
            //closeDriver();

    }


}
