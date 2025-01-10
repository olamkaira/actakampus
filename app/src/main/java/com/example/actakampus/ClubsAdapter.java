package com.example.actakampus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ClubsAdapter extends RecyclerView.Adapter<ClubsAdapter.ViewHolder> {
    private List<Club> clubs;

    public ClubsAdapter(List<Club> clubs) {
        this.clubs = clubs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_club, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Club club = clubs.get(position);
        holder.nameTextView.setText(club.getName());
        holder.descriptionTextView.setText(club.getDescription());
        holder.categoryTextView.setText(club.getCategory());
        holder.memberCountTextView.setText(club.getMemberCount() + " Üye");
    }

    @Override
    public int getItemCount() {
        return clubs.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView descriptionTextView;
        TextView categoryTextView;
        TextView memberCountTextView;

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            categoryTextView = itemView.findViewById(R.id.categoryTextView);
            memberCountTextView = itemView.findViewById(R.id.memberCountTextView);
        }
    }
} 