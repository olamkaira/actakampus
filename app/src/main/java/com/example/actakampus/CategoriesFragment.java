package com.example.actakampus;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;

public class CategoriesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        String[] categories = {"Akademik", "Sosyal", "Spor", "Kültür", "Bilim", "Teknoloji"};
        LinearLayout categoriesContainer = view.findViewById(R.id.categoriesContainer);

        for (String category : categories) {
            CardView categoryCard = (CardView) inflater.inflate(R.layout.item_category, categoriesContainer, false);
            TextView categoryText = categoryCard.findViewById(R.id.categoryText);
            categoryText.setText(category);
            
            categoryCard.setOnClickListener(v -> {
                Intent intent = new Intent(getActivity(), CategoryNewsActivity.class);
                intent.putExtra("category", category);
                startActivity(intent);
            });
            
            categoriesContainer.addView(categoryCard);
        }

        return view;
    }
} 