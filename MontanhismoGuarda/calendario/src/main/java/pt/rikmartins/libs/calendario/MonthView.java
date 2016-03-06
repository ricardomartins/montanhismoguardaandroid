package pt.rikmartins.libs.calendario;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.joda.time.LocalDate;


public class MonthView extends LinearLayout implements Configurable<MonthView.MonthViewConfig> {
    private Context mContext = null;
    private AttributeSet mAttrs = null;
    private int mDefStyleAttr = 0;
    private int mDefStyleRes = 0;

    private MonthViewConfig config;

    public MonthView(Context context) {
        super(context);
        mContext = context;

        init();
    }

    public MonthView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mAttrs = attrs;

        init();
    }

    public MonthView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mAttrs = attrs;
        mDefStyleAttr = defStyleAttr;

        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MonthView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
        mAttrs = attrs;
        mDefStyleAttr = defStyleAttr;
        mDefStyleRes = defStyleRes;

        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        setConfig(new MonthViewDefaultConfig());
    }

    private boolean isAssembled = false;

    private void assemble() {
        DayAdapter dayAdapter = config.getDayAdapter();
        if (dayAdapter == null) {
            if (isInEditMode()) dayAdapter = new DayAdapterStub();
            else return;
        }
        if (isAssembled) removeAllViews();

        LayoutParams weekViewLayoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f);
        LocalDate lastDay = getLastDayShown();

        int i = 0;
        LocalDate d = getFirstDayShown();

        WeekLabelsView weekLabelsView = getWeekLabelsView();
        weekLabelsView.setConfig(new AbstractWeekView.WeekViewDefaultConfig()
                .withDayAdapter(dayAdapter).withFirstDay(d).withFirstDayOrdinal(i));
        addView(weekLabelsView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        do {
            WeekView wv = getNewWeekView();
            wv.setConfig(new WeekView.WeekViewDefaultConfig().withFirstDay(d).withFirstDayOrdinal(i)
                    .withDayAdapter(dayAdapter));
            addView(wv, weekViewLayoutParams);

            d = d.plusDays(7);
            i += 7;
        } while (d.compareTo(lastDay) <= 0);

        isAssembled = true;
    }

    public LocalDate getFirstDayShown() {
        return Utils.firstDayOfAdjustedWeek(config.getWeekStart(), getFirstDayOfMonth());
    }

    public LocalDate getLastDayShown() {
        return getFirstDayShown().plusDays(7 * 6 - 1); // TODO: Create constants (at least 6 and 7*6)
    }

    private int trimmedWeekCount() {
        int firstWeekDayCount = 7 - Utils.jodaWeekDayToAdjusted(config.getWeekStart(), getFirstDayOfMonth().getDayOfWeek());
        int lastWeekDayCount = Utils.jodaWeekDayToAdjusted(config.getWeekStart(), getLastDayOfMonth().getDayOfWeek()) + 1;
        int monthDayCount = getLastDayOfMonth().dayOfMonth().getMaximumValue();

        return (monthDayCount - firstWeekDayCount - lastWeekDayCount) / 7 + 2;
    }

    public LocalDate getFirstDayOfMonth() {
        return new LocalDate(config.getYear(), config.getMonthOfYear(), 1);
    }

    public LocalDate getLastDayOfMonth() {
        return getFirstDayOfMonth().dayOfMonth().withMaximumValue();
    }

    private WeekView getNewWeekView() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
            return new WeekView(mContext, mAttrs, mDefStyleAttr);
        else
            return new WeekView(mContext, mAttrs, mDefStyleAttr, mDefStyleRes);
    }

    private WeekLabelsView getWeekLabelsView() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
            return new WeekLabelsView(mContext, mAttrs, mDefStyleAttr);
        else
            return new WeekLabelsView(mContext, mAttrs, mDefStyleAttr, mDefStyleRes);
    }

    @Override
    public void setConfig(MonthViewConfig monthViewConfig) {
        this.config = monthViewConfig;
        assemble();
    }

    @Override
    public final MonthViewConfig getCopyOfConfig() {
        MonthViewConfig copyOfConfig = config.getCopyOfConfig();
        if (copyOfConfig == config) {
            // To prevent exposure of the internal config object
            // TODO: Throw appropriate exception
        }
        return copyOfConfig;
    }

    private class DayAdapterStub implements DayAdapter {

        @Override
        public Object getItem(LocalDate day) {
            return null;
        }

        @Override
        public View getView(int position, LocalDate day) {
            TextView textView = new TextView(getContext());
            textView.setText(String.valueOf(day.getDayOfMonth()));
            return textView;
        }

        @Override
        public View getWeekDayLabelView(int position, LocalDate day) {
            TextView textView = new TextView(getContext());
            textView.setText(String.valueOf(day.getDayOfWeek()));
            return textView;
        }
    }

    public static class MonthViewDefaultConfig implements MonthViewConfig {

        private int year;
        private int monthOfYear;
        private int weekStart; // Joda Time aligned: 1=Monday, 2=Tuesday... 7=Sunday
        private DayAdapter dayAdapter;

        public MonthViewDefaultConfig() {
            LocalDate ld = LocalDate.now();
            this.year = ld.getYear();
            this.monthOfYear = ld.getMonthOfYear();
            this.weekStart = 1; // Monday
            this.dayAdapter = null;
        }

        public MonthViewDefaultConfig withMonth(int year, int monthOfYear) {
            this.year = year;
            this.monthOfYear = monthOfYear;
            return this;
        }

        public MonthViewDefaultConfig withMonth(LocalDate date) {
            return withMonth(date.getYear(), date.getMonthOfYear());
        }

        public MonthViewDefaultConfig withMonthOfYear(int monthOfYear) {
            return withMonth(this.year, monthOfYear);
        }

        public MonthViewDefaultConfig withYear(int year) {
            return withMonth(year, this.monthOfYear);
        }

        public MonthViewDefaultConfig withWeekStart(int weekStart) {
            this.weekStart = weekStart;
            return this;
        }

        public MonthViewDefaultConfig withDayAdapter(DayAdapter dayAdapter) {
            this.dayAdapter = dayAdapter;
            return this;
        }

        @Override
        public int getYear() {
            return year;
        }

        @Override
        public int getMonthOfYear() {
            return monthOfYear;
        }

        @Override
        public int getWeekStart() {
            return weekStart;
        }

        @Override
        public DayAdapter getDayAdapter() {
            return dayAdapter;
        }

        @Override
        public MonthViewDefaultConfig getCopyOfConfig() {
            return new MonthViewDefaultConfig().withMonth(this.getYear(), this.getMonthOfYear())
                    .withWeekStart(this.getWeekStart()).withDayAdapter(this.getDayAdapter());
        }
    }

    public interface MonthViewConfig extends CalendarConfig {
        int getYear();

        int getMonthOfYear();

        int getWeekStart();

        MonthViewConfig getCopyOfConfig();
    }
}
