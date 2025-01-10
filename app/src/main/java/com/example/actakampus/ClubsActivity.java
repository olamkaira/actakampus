package com.example.actakampus;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

public class ClubsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ClubsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);

        // Toolbar ayarları
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Öğrenci Kulüpleri");
        }

        // RecyclerView ayarları
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        // Örnek kulüp verilerini oluştur ve adapter'ı ayarla
        List<Club> clubs = createSampleClubs();
        adapter = new ClubsAdapter(clubs);
        recyclerView.setAdapter(adapter);
    }

    private List<Club> createSampleClubs() {
        List<Club> clubs = new ArrayList<>();
        
        clubs.add(new Club(
            "Bilgisayar ve Teknoloji Kulübü",
            "Teknoloji dünyasındaki gelişmeleri takip eden, yazılım ve donanım projeleri geliştiren öğrenci topluluğu",
            "Teknoloji",
            150
        ));
        
        clubs.add(new Club(
            "Tiyatro Kulübü",
            "Tiyatro sanatını seven ve sahne sanatlarında kendini geliştirmek isteyen öğrencilerin buluşma noktası",
            "Sanat",
            80
        ));
        
        clubs.add(new Club(
            "Doğa Sporları Kulübü",
            "Doğa yürüyüşü, kamp, dağcılık gibi outdoor aktiviteleri düzenleyen kulüp",
            "Spor",
            120
        ));
        
        clubs.add(new Club(
            "Müzik Kulübü",
            "Müzik seven, çalan ve söyleyen öğrencilerin bir araya geldiği, konserler düzenlediği kulüp",
            "Sanat",
            95
        ));
        
        clubs.add(new Club(
            "Girişimcilik Kulübü",
            "İş dünyası ve girişimcilik alanında kendini geliştirmek isteyen öğrencilerin kulübü",
            "Kariyer",
            200
        ));
        
        clubs.add(new Club(
            "Fotoğrafçılık Kulübü",
            "Fotoğraf sanatını seven ve bu alanda kendini geliştirmek isteyen öğrencilerin kulübü",
            "Sanat",
            75
        ));
        
        clubs.add(new Club(
            "Sosyal Sorumluluk Kulübü",
            "Toplumsal sorunlara çözüm üreten ve sosyal sorumluluk projeleri geliştiren kulüp",
            "Sosyal",
            180
        ));
        
        return clubs;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
} 