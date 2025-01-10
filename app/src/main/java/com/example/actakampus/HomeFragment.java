package com.example.actakampus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private NewsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<News> newsList = createSampleNews();
        adapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<News> createSampleNews() {
        List<News> newsList = new ArrayList<>();
        
        newsList.add(new News(
            "Erasmus Başvuruları Başlıyor",
            "2024-2025 akademik yılı Erasmus+ öğrenim ve staj hareketliliği başvuruları başladı. Detaylı bilgi için Uluslararası İlişkiler Ofisi'ni ziyaret edebilirsiniz.",
            "15 Şubat 2024",
            "Akademik",
            "erasmus_image"
        ));
        
        newsList.add(new News(
            "Kütüphane Çalışma Saatleri Güncellendi",
            "Final sınavları döneminde kütüphane 7/24 hizmet verecektir. Öğrencilerimiz kütüphane kaynaklarından ve çalışma alanlarından kesintisiz faydalanabilecekler.",
            "10 Şubat 2024",
            "Duyuru",
            "library_image"
        ));
        
        newsList.add(new News(
            "Kariyer Merkezi Etkinliği",
            "CV hazırlama ve mülakat teknikleri konusunda uzman konuşmacıların katılacağı workshop etkinliği düzenlenecektir. Son sınıf öğrencilerimizin katılımı tavsiye edilir.",
            "5 Şubat 2024",
            "Kariyer",
            "career_image"
        ));
        
        newsList.add(new News(
            "Bahar Şenliği 2024",
            "Geleneksel bahar şenliğimiz bu yıl 10-12 Mayıs tarihleri arasında gerçekleştirilecek. Konserler, spor müsabakaları ve çeşitli etkinliklerle dolu program yakında açıklanacak.",
            "1 Şubat 2024",
            "Sosyal",
            "festival_image"
        ));
        
        newsList.add(new News(
            "Teknoloji Kulübü Yapay Zeka Semineri",
            "Yapay zeka ve makine öğrenmesi alanında çalışan sektör profesyonelleri deneyimlerini paylaşacak. Tüm bölümlerden öğrencilerimiz katılabilir.",
            "28 Ocak 2024",
            "Teknoloji",
            "ai_seminar_image"
        ));
        
        return newsList;
    }
} 