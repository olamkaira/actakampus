package com.example.actakampus;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FoodMenuPagerAdapter extends FragmentStateAdapter {
    private static final int PAGE_COUNT = 5;

    public FoodMenuPagerAdapter(FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return FoodMenuDayFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return PAGE_COUNT;
    }
} 