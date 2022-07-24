package steps;

import enums.Day;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static enums.Day.TODAY;
import static enums.Day.TOMORROW;
import static enums.Day.YESTERDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Class with steps for EconomicCalendar.
 *
 * @author Anastasiia_Kovalenkoø
 */
public class EconomicCalendarSteps {
    public void checkThatDateIsCorrect(String actualDate, Day day) {
        LocalDate date;
        String expectedDate;
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (day.equals(YESTERDAY)) {
            date = LocalDate.now().minusDays(1L);
            expectedDate = date.format(formatters);
            expectedDate = expectedDate + " - " + expectedDate;
        } else if (day.equals(TODAY)) {
            date = LocalDate.now();
            expectedDate = date.format(formatters);
            expectedDate = expectedDate + " - " + expectedDate;
        } else if (day.equals(TOMORROW)) {
            date = LocalDate.now().plusDays(1L);
            expectedDate = date.format(formatters);
            expectedDate = expectedDate + " - " + expectedDate;
        } else {
            date = LocalDate.now().with(SUNDAY);
            expectedDate = date.format(formatters);
            LocalDate lastDate = LocalDate.now().with(SATURDAY);
            expectedDate = expectedDate + " - " + lastDate.format(formatters);
        }
        assertEquals(expectedDate, actualDate);
    }
}
