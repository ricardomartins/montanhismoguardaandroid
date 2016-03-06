package pt.rikmartins.libs.calendario;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public class CalendarViewPager extends ViewPager {

    public CalendarViewPager(Context context) {
        super(context);

        init();
    }

    public CalendarViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {

    }

    public void setCurrentItem(int year, int monthOfYear) {
        int item = (year - 1970) * 12 + (monthOfYear - 1);
        super.setCurrentItem(item);
    }

    public void setDayAdapter(FragmentManager fragmentManager, DayAdapter dayAdapter) {
        MonthFragmentPagerAdapter monthFragmentPagerAdapter = new MonthFragmentPagerAdapter(fragmentManager);
        monthFragmentPagerAdapter.setDayAdapter(dayAdapter);
        setAdapter(monthFragmentPagerAdapter);
    }

    private class MonthFragmentPagerAdapter extends FragmentStatePagerAdapter {

        private DayAdapter dayAdapter;

        public MonthFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void setDayAdapter(DayAdapter dayAdapter) {
            this.dayAdapter = dayAdapter;
        }

        @Override
        public Fragment getItem(int position) {
            int year = (position / 12) + 1970;
            int monthOfYear = (position % 12) + 1;

            MonthFragment monthFragment = MonthFragment.newInstance(year, monthOfYear);
            monthFragment.setDayAdapter(dayAdapter);
            return monthFragment;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }
    }
}
