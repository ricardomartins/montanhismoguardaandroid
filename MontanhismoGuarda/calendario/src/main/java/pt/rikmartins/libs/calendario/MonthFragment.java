package pt.rikmartins.libs.calendario;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MonthFragment extends Fragment {
    private static final String ARG_YEAR = "year";
    private static final String ARG_MONTH_OF_YEAR = "monthOfYear";

    private int year;
    private int monthOfYear;

    private MonthView monthView;
    private DayAdapter dayAdapter;

    public MonthFragment() {}

    public static MonthFragment newInstance(int year, int monthOfYear) {
        MonthFragment fragment = new MonthFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_YEAR, year);
        args.putInt(ARG_MONTH_OF_YEAR, monthOfYear);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            year = getArguments().getInt(ARG_YEAR);
            monthOfYear = getArguments().getInt(ARG_MONTH_OF_YEAR);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        monthView = new MonthView(getActivity());
        setDayAdapter(this.dayAdapter);
        return monthView;
    }

    public void setDayAdapter(DayAdapter dayAdapter) {
        this.dayAdapter = dayAdapter;
        if (monthView != null)
            monthView.setConfig(new MonthView.MonthViewDefaultConfig().withDayAdapter(dayAdapter)
                    .withMonth(year, monthOfYear));
    }
}
