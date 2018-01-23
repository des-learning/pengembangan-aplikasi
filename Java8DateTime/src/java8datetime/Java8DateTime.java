/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 *
 * @author david
 */
public class Java8DateTime {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
	    LocalDate today = LocalDate.now();
	    LocalTime now =  LocalTime.now();
	    LocalDateTime rightNow = LocalDateTime.now();

	    // locale
	    Locale localeID = new Locale("id", "ID");

	    System.out.println("Today: " + today);
	    System.out.println("Now: " + now);
	    System.out.println("Right now: " + rightNow);

	    // what day
        System.out.println(rightNow.getDayOfWeek());
        System.out.println(rightNow.getDayOfWeek().getDisplayName(TextStyle.FULL, localeID));

        // 3 days after sunday
        System.out.println(DayOfWeek.SUNDAY.plus(3));

        // what month
        System.out.println(rightNow.getMonth());
        System.out.println(rightNow.getMonth().getDisplayName(TextStyle.FULL, localeID));

        // how many days
        YearMonth yearMonth = YearMonth.from(rightNow);
        System.out.println(yearMonth + " has " + YearMonth.from(rightNow).lengthOfMonth() + " days");

        // last 3 months
        System.out.println(yearMonth.minus(3, ChronoUnit.MONTHS));
        System.out.println(yearMonth.minusMonths(3));

        LocalDate birthday = LocalDate.of(1998, 7, 8);
        // age in years
        System.out.println("Age in years: " + ChronoUnit.YEARS.between(birthday, today));
        System.out.println("Age in months: " + ChronoUnit.MONTHS.between(birthday, today));
        System.out.println("Age in days: " + ChronoUnit.DAYS.between(birthday, today));

        // date period
        Period age = Period.between(birthday, today);
        System.out.println(String.format("Age: %d years %d months %d days", age.getYears(), age.getMonths(), age.getDays()));

        // how many days until weekend (saturday)
        LocalDate nextSaturday = today.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println("Day(s) to next saturday: " + Period.between(today, nextSaturday).getDays());

	    // all of time zone id
	    //ZoneId.getAvailableZoneIds().forEach(System.out::println);

        ZoneId zone = ZoneId.of("Pacific/Kiritimati");
        ZonedDateTime kiritimatiTime = ZonedDateTime.now(zone);
        System.out.println("Kiritimati now: " + kiritimatiTime);

        // convert local date time to zoned date time
        System.out.println(rightNow.atZone(zone));
	}
	
}
