package pt.rikmartins.libs.calendario;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import org.joda.time.LocalDate;

public class WeekView extends AbstractWeekView {
    public WeekView(Context context) {
        super(context);
    }

    public WeekView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WeekView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public WeekView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected View getDayView(DayAdapter adapter, int position, LocalDate day) {
        return adapter.getView(position, day);
    }
}
