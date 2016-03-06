package pt.rikmartins.libs.calendario;

public interface CalendarConfig {
    CalendarConfig getCopyOfConfig();

    DayAdapter getDayAdapter();
}
