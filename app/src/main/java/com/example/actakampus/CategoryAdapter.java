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
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private Context context;
    private List<Category> categories;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_category_card, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        
        if (category != null) {
            holder.categoryName.setText(category.getName());
            holder.categoryIcon.setImageResource(category.getIconResId());
            
            holder.itemView.setOnClickListener(v -> {
                switch (category.getName()) {
                    case "Haberler":
                        // Ana sayfada zaten haberler var
                        break;
                    case "Yemek Menüsü":
                        context.startActivity(new Intent(context, FoodMenuActivity.class));
                        break;
                    case "Öğrenci Kulüpleri":
                        context.startActivity(new Intent(context, ClubsActivity.class));
                        break;
                    case "Etkinlikler":
                        context.startActivity(new Intent(context, EventsActivity.class));
                        break;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return categories != null ? categories.size() : 0;
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryIcon;
        TextView categoryName;

        CategoryViewHolder(View itemView) {
            super(itemView);
            categoryIcon = itemView.findViewById(R.id.categoryIcon);
            categoryName = itemView.findViewById(R.id.categoryName);
        }
    }
} 