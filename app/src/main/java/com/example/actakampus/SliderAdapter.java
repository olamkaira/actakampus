package com.example.actakampus;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {
    private Context context;
    private List<News> sliderItems;

    public SliderAdapter(Context context) {
        this.context = context;
        this.sliderItems = new ArrayList<>();
    }

    public void setSliderItems(List<News> items) {
        this.sliderItems = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_slider_news, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        News news = sliderItems.get(position);
        
        if (news != null) {
            holder.titleText.setText(news.getTitle());
            holder.categoryText.setText(news.getCategory());
            
            // Kategori rengini ayarla
            try {
                int categoryColor = getCategoryColor(news.getCategory());
                holder.categoryText.getBackground().setTint(categoryColor);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            // Resmi ayarla (şimdilik sabit bir resim)
            holder.newsImage.setImageResource(R.drawable.news_placeholder);
            
            // Tıklama olayı
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra("title", news.getTitle());
                intent.putExtra("content", news.getContent());
                intent.putExtra("date", news.getDate());
                intent.putExtra("category", news.getCategory());
                intent.putExtra("imageUrl", news.getImageUrl());
                context.startActivity(intent);
            });
        }
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    static class SliderViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImage;
        TextView titleText;
        TextView categoryText;

        SliderViewHolder(View itemView) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.newsImage);
            titleText = itemView.findViewById(R.id.titleText);
            categoryText = itemView.findViewById(R.id.categoryText);
        }
    }

    private int getCategoryColor(String category) {
        if (category == null) return context.getColor(R.color.primary);
        
        try {
            switch (category) {
                case "Akademik":
                    return context.getColor(R.color.category_academic);
                case "Sosyal":
                    return context.getColor(R.color.category_social);
                case "Spor":
                    return context.getColor(R.color.category_sports);
                case "Kültür":
                    return context.getColor(R.color.category_culture);
                case "Bilim":
                    return context.getColor(R.color.category_science);
                case "Teknoloji":
                    return context.getColor(R.color.category_tech);
                default:
                    return context.getColor(R.color.primary);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return context.getColor(R.color.primary);
        }
    }
} 