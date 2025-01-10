package com.example.actakampus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FoodMenuDayFragment extends Fragment {
    private static final String ARG_DAY = "day";
    private int dayOfWeek;
    private RecyclerView recyclerView;
    private FoodMenuAdapter adapter;

    public static FoodMenuDayFragment newInstance(int day) {
        FoodMenuDayFragment fragment = new FoodMenuDayFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_DAY, day);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dayOfWeek = getArguments().getInt(ARG_DAY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_menu_day, container, false);
        
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        adapter = new FoodMenuAdapter(getContext(), createSampleMenu());
        recyclerView.setAdapter(adapter);
        
        return view;
    }

    private List<FoodMenuItem> createSampleMenu() {
        List<FoodMenuItem> menu = new ArrayList<>();
        
        switch (dayOfWeek) {
            case 0: // Pazartesi
                menu.add(new FoodMenuItem("Mercimek Çorbası", "Çorba", "150 kcal"));
                menu.add(new FoodMenuItem("Karnıyarık", "Ana Yemek", "320 kcal"));
                menu.add(new FoodMenuItem("Pilav", "Yan Yemek", "220 kcal"));
                menu.add(new FoodMenuItem("Ayran", "İçecek", "60 kcal"));
                break;
            case 1: // Salı
                menu.add(new FoodMenuItem("Ezogelin Çorbası", "Çorba", "140 kcal"));
                menu.add(new FoodMenuItem("Tavuk Sote", "Ana Yemek", "280 kcal"));
                menu.add(new FoodMenuItem("Bulgur Pilavı", "Yan Yemek", "200 kcal"));
                menu.add(new FoodMenuItem("Cacık", "Yan Yemek", "90 kcal"));
                break;
            case 2: // Çarşamba
                menu.add(new FoodMenuItem("Domates Çorbası", "Çorba", "120 kcal"));
                menu.add(new FoodMenuItem("İzmir Köfte", "Ana Yemek", "350 kcal"));
                menu.add(new FoodMenuItem("Makarna", "Yan Yemek", "240 kcal"));
                menu.add(new FoodMenuItem("Salata", "Yan Yemek", "50 kcal"));
                break;
            case 3: // Perşembe
                menu.add(new FoodMenuItem("Yayla Çorbası", "Çorba", "130 kcal"));
                menu.add(new FoodMenuItem("Etli Nohut", "Ana Yemek", "310 kcal"));
                menu.add(new FoodMenuItem("Pirinç Pilavı", "Yan Yemek", "220 kcal"));
                menu.add(new FoodMenuItem("Turşu", "Yan Yemek", "30 kcal"));
                break;
            case 4: // Cuma
                menu.add(new FoodMenuItem("Tarhana Çorbası", "Çorba", "140 kcal"));
                menu.add(new FoodMenuItem("Balık", "Ana Yemek", "250 kcal"));
                menu.add(new FoodMenuItem("Patates Salatası", "Yan Yemek", "180 kcal"));
                menu.add(new FoodMenuItem("Komposto", "İçecek", "100 kcal"));
                break;
        }
        
        return menu;
    }
} 