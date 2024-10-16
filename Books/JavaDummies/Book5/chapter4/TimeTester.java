package Book_5.Chapter_4;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class TimeTester {

    public static void main(String[] args) {
        System.out.println("\nLocal Time: " + LocalTime.now());
        System.out.println("\nLocal Date: " + LocalDate.now());
        System.out.println("\nLocal DateTime: " + LocalDateTime.now());
        System.out.println("\nZoned Date Time: " + ZonedDateTime.now());
        System.out.println("\nOffset Time: " + OffsetTime.now());
        System.out.println("\nMonth Day : " + MonthDay.now());
        System.out.println("\nYear Month : " + YearMonth.now());
        System.out.println("\nInstant: " + Instant.now());

        LocalDateTime dt = null;

        try {
            dt = LocalDateTime.parse("2014-12-1515:45");
        } catch (DateTimeParseException e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println(dt);

        LocalDate date = LocalDate.of(2014,Month.DECEMBER,15);
        System.out.println(date);

        for (String id : ZoneId.getAvailableZoneIds())
            System.out.println(id);

        ZoneId z = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zdate;

        zdate = ZonedDateTime.of(2014, 12, 15, 0, 0, 0, 0, z);
        System.out.println(zdate);

        ZoneOffset z2 = ZoneOffset.ofHours(-8);
        z2 = ZoneOffset.of("-08:00");
        OffsetTime time = OffsetTime.of(10, 30, 0, 0, z2);

        System.out.println(time);

        LocalDate date1 = LocalDate.now();
        int year = date1.getYear();
        int month = date1.getMonthValue();
        int day = date1.getDayOfMonth();
        System.out.println(String.format("%d, %d, %d", year, month, day));

        System.out.println(date1.getDayOfYear());
        System.out.println(date.getDayOfWeek());

        String msg1 = "Hello";
        Scanner sc = new Scanner(System.in);
        String msg2 = sc.nextLine();

        if (msg1.equals(msg2))
            System.out.println("These string are equal");

        if (LocalDate.now() == LocalDate.now() ) {
            System.out.println("All is right in the universe.");
        } else {
            System.out.println("We broke space and time. Woops.");
        }

        if (LocalDate.now().isEqual(LocalDate.now()))
            System.out.println("All is right in the universe.");

        if (LocalDate.now().getDayOfMonth() < 15)
            System.out.println("It is not yet the 15th.");

        System.out.println("Today: " + LocalDate.now());
        System.out.println("Tomorrow: " + LocalDate.now().plusDays(1));
        System.out.println("Next week: " + LocalDate.now().plusWeeks(1));
        System.out.println("Next month: " + LocalDate.now().plusMonths(1));
        System.out.println("Next year: " + LocalDate.now().plusYears(1));


        LocalDate date3 = LocalDate.parse("2024-03-24");
        System.out.println("Days Till Birthday : " + LocalDate.now().until(date3, ChronoUnit.DAYS));

        LocalDate today = LocalDate.now();
        LocalDate invDate = LocalDate.of(today.getYear(), today.getMonthValue(), 15);
        if (today.getDayOfMonth() > 15)
            invDate = invDate.plusMonths(1);

        long daysToInvoice = today.until(invDate, ChronoUnit.DAYS);
        System.out.println("Days to invoice date: " + daysToInvoice);

        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("dd MM YYYY");
        LocalDate date5 = LocalDate.now();
        System.out.println(date5.format(formatter));


    }

}
