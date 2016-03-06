package pt.rikmartins.libs.calendario;

import android.view.View;

import org.joda.time.LocalDate;

public interface DayAdapter { // TODO
    Object getItem(LocalDate day);

    View getView(int position, LocalDate day);

    View getWeekDayLabelView(int position, LocalDate day);
}
