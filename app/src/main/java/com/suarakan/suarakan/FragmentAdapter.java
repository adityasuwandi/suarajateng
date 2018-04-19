package com.suarakan.suarakan;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {

    private Context context;

    public FragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return OverviewFragment.newInstance();
        } else if (position == 1) {
            return TimelineFragment.newInstance();
        } else if (position == 2) {
            return KandidatFragment.newInstance();
        } else {
            return InfoFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Overview";
            case 1:
                return "Timeline";
            case 2:
                return "Kandidat";
            case 3:
                return "Info";
            default:
                return null;
        }
    }
}
