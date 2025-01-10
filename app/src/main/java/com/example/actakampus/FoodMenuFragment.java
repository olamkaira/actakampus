package com.example.actakampus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class FoodMenuFragment extends Fragment {
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private FoodMenuPagerAdapter pagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_menu, container, false);
        
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);
        
        pagerAdapter = new FoodMenuPagerAdapter(requireActivity());
        viewPager.setAdapter(pagerAdapter);
        
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Pazartesi");
                    break;
                case 1:
                    tab.setText("Salı");
                    break;
                case 2:
                    tab.setText("Çarşamba");
                    break;
                case 3:
                    tab.setText("Perşembe");
                    break;
                case 4:
                    tab.setText("Cuma");
                    break;
            }
        }).attach();
        
        return view;
    }
} 