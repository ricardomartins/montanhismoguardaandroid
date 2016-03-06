package pt.rikmartins.libs.calendario;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.joda.time.LocalDate;

public abstract class AbstractWeekView extends LinearLayout implements Configurable<AbstractWeekView.WeekViewConfig> {

    private WeekViewConfig config;

    public AbstractWeekView(Context context) {
        super(context);

        init();
    }

    public AbstractWeekView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public AbstractWeekView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AbstractWeekView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init();
    }

    private void init() {
        setOrientation(HORIZONTAL);
        setConfig(new WeekViewDefaultConfig());
    }

    private boolean isAssembled = false;

    protected abstract View getDayView(DayAdapter adapter, int position, LocalDate day);

    private void assemble() {
        if (config.getDayAdapter() == null) return;
        if (isAssembled) removeAllViews();

        LayoutParams dayViewLayoutParams = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f);
        DayAdapter adapter = config.getDayAdapter();
        LocalDate lastDay = config.getLastDay();

        int i = config.getFirstDayOrdinal();
        LocalDate d = config.getFirstDay();
        do {
            View dayView = getDayView(adapter, i, d);
            addView(dayView, dayViewLayoutParams);

            d = d.plusDays(1);
            i++;
        } while (d.compareTo(lastDay) <= 0);

        isAssembled = true;
    }

    @Override
    public WeekViewConfig getCopyOfConfig() {
        WeekViewConfig copyOfConfig = config.getCopyOfConfig();
        if (copyOfConfig == config) {
            // To prevent exposure of the internal config object
            // TODO: Throw appropriate exception
        }
        return copyOfConfig;
    }

    @Override
    public void setConfig(WeekViewConfig weekViewConfig) {
        this.config = weekViewConfig;
        assemble();
    }

    public static class WeekViewDefaultConfig implements WeekViewConfig {

        private LocalDate firstDay;
        private LocalDate lastDay;
        private DayAdapter dayAdapter;
        private int firstDayOrdinal;

        public WeekViewDefaultConfig() {
            withSampleDay(LocalDate.now());
            this.dayAdapter = null;
            this.firstDayOrdinal = 0;
        }

        public WeekViewDefaultConfig withFirstDay(LocalDate firstDay) {
            this.firstDay = firstDay;
            this.lastDay = firstDay.plusDays(6);

            return this;
        }

        public WeekViewDefaultConfig withSampleDay(LocalDate sampleDay) {
            LocalDate.Property ldp = sampleDay.dayOfWeek();
            this.firstDay = ldp.withMinimumValue();
            this.lastDay = ldp.withMaximumValue();

            return this;
        }

        public WeekViewDefaultConfig withDayAdapter(DayAdapter dayAdapter) {
            this.dayAdapter = dayAdapter;

            return this;
        }

        public WeekViewDefaultConfig withFirstDayOrdinal(int firstDayOrdinal) {
            this.firstDayOrdinal = firstDayOrdinal;

            return this;
        }

        @Override
        public LocalDate getFirstDay() {
            return this.firstDay;
        }

        @Override
        public LocalDate getLastDay() {
            return this.lastDay;
        }

        @Override
        public DayAdapter getDayAdapter() {
            return this.dayAdapter;
        }

        @Override
        public int getFirstDayOrdinal() {
            return this.firstDayOrdinal;
        }

        @Override
        public WeekViewDefaultConfig getCopyOfConfig() {
            return new WeekViewDefaultConfig().withFirstDayOrdinal(this.getFirstDayOrdinal())
                    .withFirstDay(this.getFirstDay()).withDayAdapter(this.getDayAdapter());
        }
    }

    public interface WeekViewConfig extends CalendarConfig {
        LocalDate getFirstDay();

        LocalDate getLastDay();

        int getFirstDayOrdinal();

        @Override
        WeekViewConfig getCopyOfConfig();
    }
}
