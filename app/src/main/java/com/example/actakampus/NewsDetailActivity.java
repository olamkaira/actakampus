package com.example.actakampus;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.content.Intent;

public class NewsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        // Toolbar ayarları
        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowTitleEnabled(false);
            }
        }

        // Intent'i kontrol et
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }

        // Intent'ten verileri al
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        String date = intent.getStringExtra("date");
        String category = intent.getStringExtra("category");
        String imageUrl = intent.getStringExtra("imageUrl");

        // UI elemanlarını bul ve içerikleri ayarla
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView contentTextView = findViewById(R.id.contentTextView);
        TextView dateTextView = findViewById(R.id.dateTextView);
        TextView categoryTextView = findViewById(R.id.categoryTextView);

        if (titleTextView != null) titleTextView.setText(title);
        if (contentTextView != null) contentTextView.setText(content);
        if (dateTextView != null) dateTextView.setText(date);
        if (categoryTextView != null) {
            categoryTextView.setText(category);
            try {
                categoryTextView.getBackground().setTint(getCategoryColor(category));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private int getCategoryColor(String category) {
        if (category == null) return getColor(R.color.primary);
        
        try {
            switch (category) {
                case "Akademik":
                    return getColor(R.color.category_academic);
                case "Sosyal":
                    return getColor(R.color.category_social);
                case "Spor":
                    return getColor(R.color.category_sports);
                case "Kültür":
                    return getColor(R.color.category_culture);
                case "Bilim":
                    return getColor(R.color.category_science);
                case "Teknoloji":
                    return getColor(R.color.category_tech);
                default:
                    return getColor(R.color.primary);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return getColor(R.color.primary);
        }
    }
} 