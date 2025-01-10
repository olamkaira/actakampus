package com.example.actakampus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FoodMenuAdapter extends RecyclerView.Adapter<FoodMenuAdapter.ViewHolder> {
    private Context context;
    private List<FoodMenuItem> menuItems;

    public FoodMenuAdapter(Context context, List<FoodMenuItem> menuItems) {
        this.context = context;
        this.menuItems = menuItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodMenuItem item = menuItems.get(position);
        holder.foodName.setText(item.getName());
        holder.foodCategory.setText(item.getCategory());
        holder.foodCalories.setText(item.getCalories());
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView foodName;
        TextView foodCategory;
        TextView foodCalories;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.foodName);
            foodCategory = itemView.findViewById(R.id.foodCategory);
            foodCalories = itemView.findViewById(R.id.foodCalories);
        }
    }
} 