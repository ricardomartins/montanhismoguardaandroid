package pt.rikmartins.libs.calendario;

import android.support.annotation.NonNull;

import org.joda.time.LocalDate;

public class Utils {
    @NonNull
    static LocalDate firstDayOfAdjustedWeek(int weekStart, LocalDate day) {
        int jodaWeekDay = day.getDayOfWeek();
        int adjustedWeekDay = Utils.jodaWeekDayToAdjusted(weekStart, jodaWeekDay);

        return day.minusDays(adjustedWeekDay);
    }

    @NonNull
    static LocalDate lastDayOfAdjustedWeek(int weekStart, LocalDate day) {
        int jodaWeekDay = day.getDayOfWeek();
        int adjustedWeekDay = Utils.jodaWeekDayToAdjusted(weekStart, jodaWeekDay);

        return day.plusDays(6 - adjustedWeekDay);
    }

    static int jodaWeekDayToAdjusted(int weekStart, int jodaWeekDay) {
        int adjustedWeekDay = jodaWeekDay - weekStart;
        if (adjustedWeekDay < 0)
            adjustedWeekDay += 7;
        return adjustedWeekDay;
    }

    static int adjustedWeekDayToJoda(int weekStart, int adjustedWeekDay) {
        int jodaWeekDay = adjustedWeekDay + weekStart;
        if (jodaWeekDay > 7)
            jodaWeekDay -= 7;
        return jodaWeekDay;
    }

}
