package com.example.actakampus;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CalendarFragment extends Fragment {
    private TextView selectedDateEvents;
    private Map<String, List<CalendarEvent>> eventMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        CalendarView calendarView = view.findViewById(R.id.calendarView);
        selectedDateEvents = view.findViewById(R.id.selectedDateEvents);

        // Örnek etkinlikleri yükle
        loadEvents();

        calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {
            String date = String.format(Locale.getDefault(), "%02d/%02d/%d", dayOfMonth, month + 1, year);
            updateEvents(date);
        });

        // Bugünün tarihini göster
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        updateEvents(sdf.format(new Date()));

        return view;
    }

    private void loadEvents() {
        eventMap = new HashMap<>();
        
        // Akademik etkinlikler (Mavi)
        addEvent("19/02/2024", "Bahar Dönemi Başlangıcı", "Akademik", "#2196F3");
        addEvent("01/04/2024", "Ara Sınav Haftası Başlangıcı", "Akademik", "#2196F3");
        addEvent("05/04/2024", "Ara Sınav Haftası Bitiş", "Akademik", "#2196F3");
        addEvent("03/06/2024", "Final Sınavları Başlangıcı", "Akademik", "#2196F3");
        addEvent("14/06/2024", "Final Sınavları Bitiş", "Akademik", "#2196F3");
        
        // Sosyal etkinlikler (Yeşil)
        addEvent("15/05/2024", "Bahar Şenliği", "Sosyal", "#4CAF50");
        addEvent("15/06/2024", "Mezuniyet Töreni", "Sosyal", "#4CAF50");
        
        // Spor etkinlikleri (Turuncu)
        addEvent("10/05/2024", "Spor Şenliği Başlangıcı", "Spor", "#FF9800");
        addEvent("15/05/2024", "Spor Şenliği Final Maçları", "Spor", "#FF9800");
    }

    private void addEvent(String date, String title, String category, String color) {
        List<CalendarEvent> events = eventMap.getOrDefault(date, new ArrayList<>());
        events.add(new CalendarEvent(title, category, color));
        eventMap.put(date, events);
    }

    private void updateEvents(String date) {
        StringBuilder eventsText = new StringBuilder();
        eventsText.append("Seçilen Tarih: ").append(date).append("\n\n");

        List<CalendarEvent> events = eventMap.get(date);
        if (events != null && !events.isEmpty()) {
            for (CalendarEvent event : events) {
                eventsText.append(String.format("<font color='%s'>● </font>", event.color));
                eventsText.append(event.title).append(" (").append(event.category).append(")\n");
            }
        } else {
            eventsText.append("Bu tarihte planlanmış etkinlik bulunmamaktadır.");
        }

        selectedDateEvents.setText(android.text.Html.fromHtml(eventsText.toString()));
    }

    private static class CalendarEvent {
        String title;
        String category;
        String color;

        CalendarEvent(String title, String category, String color) {
            this.title = title;
            this.category = category;
            this.color = color;
        }
    }
} 