package com.example.actakampus;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

public class EventsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EventsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        // Toolbar ayarları
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Etkinlikler");
        }

        // RecyclerView ayarları
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        // Örnek etkinlik verilerini oluştur ve adapter'ı ayarla
        List<Event> events = createSampleEvents();
        adapter = new EventsAdapter(events);
        recyclerView.setAdapter(adapter);
    }

    private List<Event> createSampleEvents() {
        List<Event> events = new ArrayList<>();
        
        events.add(new Event(
            "Teknoloji Festivali 2024",
            "Üniversitemizin düzenlediği teknoloji festivalinde robotik yarışmalar, yapay zeka sunumları ve teknoloji şirketleriyle buluşma fırsatı",
            "15-20 Nisan 2024",
            "Kongre Merkezi",
            "Teknoloji"
        ));
        
        events.add(new Event(
            "Kariyer Günleri",
            "Sektör lideri şirketlerle tanışma ve iş/staj imkanları hakkında bilgi alma fırsatı",
            "1-2 Mart 2024",
            "Merkez Kampüs",
            "Kariyer"
        ));
        
        events.add(new Event(
            "Bahar Şenliği Konseri",
            "Ünlü sanatçıların katılımıyla gerçekleşecek büyük bahar şenliği konseri",
            "10 Mayıs 2024",
            "Stadyum",
            "Sosyal"
        ));
        
        events.add(new Event(
            "Bilim Sempozyumu",
            "Akademisyenler ve öğrencilerin bilimsel çalışmalarını sunacağı ulusal sempozyum",
            "25-26 Mart 2024",
            "Fen Fakültesi",
            "Akademik"
        ));
        
        events.add(new Event(
            "Spor Turnuvaları",
            "Futbol, basketbol ve voleybol branşlarında fakülteler arası spor turnuvaları",
            "1-30 Nisan 2024",
            "Spor Kompleksi",
            "Spor"
        ));
        
        events.add(new Event(
            "Tiyatro Gösterisi",
            "Tiyatro kulübünün hazırladığı 'Bir Yaz Gecesi Rüyası' oyunu",
            "5 Mart 2024",
            "Kültür Merkezi",
            "Sanat"
        ));
        
        return events;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
} 