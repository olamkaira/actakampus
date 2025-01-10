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

public class ImportantDatesFragment extends Fragment {
    private RecyclerView recyclerView;
    private ImportantDatesAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_important_dates, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<ImportantDate> importantDates = createSampleDates();
        adapter = new ImportantDatesAdapter(importantDates);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<ImportantDate> createSampleDates() {
        List<ImportantDate> dates = new ArrayList<>();
        
        dates.add(new ImportantDate(
            "Bahar Dönemi Başlangıcı",
            "19 Şubat 2024",
            "2023-2024 Eğitim Yılı Bahar Dönemi derslerin başlangıç tarihi"
        ));
        
        dates.add(new ImportantDate(
            "Ara Sınav Haftası",
            "1-5 Nisan 2024",
            "Bahar Dönemi Ara Sınavları (Vize)"
        ));
        
        dates.add(new ImportantDate(
            "Bahar Şenliği",
            "10-12 Mayıs 2024",
            "Geleneksel Bahar Şenliği Etkinlikleri"
        ));
        
        dates.add(new ImportantDate(
            "Final Sınavları",
            "3-14 Haziran 2024",
            "Bahar Dönemi Final Sınavları"
        ));
        
        dates.add(new ImportantDate(
            "Mezuniyet Töreni",
            "20 Haziran 2024",
            "2023-2024 Eğitim Yılı Mezuniyet Töreni"
        ));
        
        dates.add(new ImportantDate(
            "Yaz Okulu Başlangıcı",
            "1 Temmuz 2024",
            "2023-2024 Yaz Okulu Eğitim Başlangıcı"
        ));
        
        dates.add(new ImportantDate(
            "2024-2025 Güz Dönemi Başlangıcı",
            "23 Eylül 2024",
            "Yeni Eğitim Yılı Başlangıcı"
        ));
        
        return dates;
    }
} 