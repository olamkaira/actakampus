package com.example.actakampus;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

public class CategoryNewsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NewsAdapter adapter;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_news);

        // Toolbar ayarları
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Intent'ten kategoriyi al
        category = getIntent().getStringExtra("category");
        if (category != null && getSupportActionBar() != null) {
            getSupportActionBar().setTitle(category + " Haberleri");
        }

        // RecyclerView ayarları
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Kategoriye göre haberleri filtrele ve göster
        List<News> categoryNewsList = filterNewsByCategory(category);
        adapter = new NewsAdapter(categoryNewsList);
        recyclerView.setAdapter(adapter);
    }

    private List<News> filterNewsByCategory(String category) {
        List<News> filteredList = new ArrayList<>();
        
        if ("Akademik".equals(category)) {
            filteredList.add(new News(
                "2024 Bahar Dönemi Ders Programı",
                "2024 Bahar dönemi ders programları fakülte web sitelerinde yayınlanmıştır.",
                "20 Şubat 2024",
                "Akademik",
                "schedule_image"
            ));
            
            filteredList.add(new News(
                "Yaz Okulu Başvuruları",
                "2024 yaz okulu başvuruları 1 Haziran'da başlayacaktır.",
                "15 Şubat 2024",
                "Akademik",
                "summer_school_image"
            ));
        } else if ("Sosyal".equals(category)) {
            filteredList.add(new News(
                "Kampüs Konser Serisi",
                "Her Cuma akşamı öğrenci kulüpleri tarafından konserler düzenlenecektir.",
                "10 Şubat 2024",
                "Sosyal",
                "concert_image"
            ));
            
            filteredList.add(new News(
                "Kültür Gezisi",
                "Tarih Kulübü tarafından düzenlenen müze gezisi etkinliği.",
                "5 Şubat 2024",
                "Sosyal",
                "museum_image"
            ));
        }
        
        return filteredList;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
} 